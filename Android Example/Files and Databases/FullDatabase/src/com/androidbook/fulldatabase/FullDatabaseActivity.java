package com.androidbook.fulldatabase;

import java.sql.Date;
import java.util.Arrays;
import java.util.Locale;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.util.Log;

public class FullDatabaseActivity extends Activity {

	private static final String DEBUG_TAG = "FullDatabase Log";

	private static final String DATABASE_NAME = "test.db";

	// TABLE (COLUMN) NAMES
	private static final String TABLE_BOOK = "tbl_books";
	private static final String TABLE_AUTHOR = "tbl_authors";

	// SQL CREATE AND DROP TABLE STATEMENTS
	private static final String CREATE_AUTHOR_TABLE = "CREATE TABLE tbl_authors (id INTEGER PRIMARY KEY AUTOINCREMENT , firstname TEXT, lastname TEXT);";
	private static final String CREATE_BOOK_TABLE = "CREATE TABLE tbl_books (id INTEGER PRIMARY KEY AUTOINCREMENT , title TEXT, dateadded DATE,  authorid INTEGER NOT NULL CONSTRAINT authorid REFERENCES tbl_authors(id) ON DELETE CASCADE);";
	private static final String DROP_AUTHOR_TABLE = "DROP TABLE tbl_authors;";
	private static final String DROP_BOOK_TABLE = "DROP TABLE tbl_books;";

	// Using triggers to enforce foreign key constraint, because Sqlite doesnt enforce them
	private static final String CREATE_TRIGGER_ADD = "CREATE TRIGGER fk_insert_book BEFORE INSERT ON tbl_books FOR EACH ROW BEGIN  SELECT RAISE(ROLLBACK, 'insert on table \"tbl_books\" violates foreign key constraint \"fk_authorid\"') WHERE  (SELECT id FROM tbl_authors WHERE id = NEW.authorid) IS NULL; END;";
	private static final String CREATE_TRIGGER_UPDATE = "CREATE TRIGGER fk_update_book BEFORE UPDATE ON tbl_books FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table \"tbl_books\" violates foreign key constraint \"fk_authorid\"') WHERE  (SELECT id FROM tbl_authors WHERE id = NEW.authorid) IS NULL; END;";
	private static final String CREATE_TRIGGER_DELETE = "CREATE TRIGGER fk_delete_author BEFORE DELETE ON tbl_authors FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table \"tbl_authors\" violates foreign key constraint \"fk_authorid\"') WHERE (SELECT authorid FROM tbl_books WHERE authorid = OLD.id) IS NOT NULL; END;";

	// Our database instance
	private SQLiteDatabase mDatabase;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// The bulk of our example is here
		runDatabaseExample();

	}

	public void runDatabaseExample() {

		Log.i(DEBUG_TAG, "Begin Simple Database Example");

		if (Arrays.binarySearch(databaseList(), DATABASE_NAME) >= 0) {
			// Delete the old database file, if it exists
			deleteDatabase(DATABASE_NAME);
		}

		// create a new database
		mDatabase = openOrCreateDatabase(DATABASE_NAME,
				SQLiteDatabase.CREATE_IF_NECESSARY, null);

		// SET SOME DATABASE CONFIGURATION INFO
		mDatabase.setLocale(Locale.getDefault()); // Set the locale
		mDatabase.setLockingEnabled(true); // SQLiteDatabase is made thread-safe by using locks around critical sections.
		mDatabase.setVersion(1); // Sets the database version.

		// Log some information about our database
		Log.i(DEBUG_TAG, "Created database: " + mDatabase.getPath());
		Log.i(DEBUG_TAG, "Database Version: " + mDatabase.getVersion());
		Log.i(DEBUG_TAG, "Database Page Size: " + mDatabase.getPageSize());
		Log.i(DEBUG_TAG, "Database Max Size: " + mDatabase.getMaximumSize());

		Log.i(DEBUG_TAG, "Database Open?  " + mDatabase.isOpen());
		Log.i(DEBUG_TAG, "Database readonly?  " + mDatabase.isReadOnly());
		Log.i(DEBUG_TAG, "Database Locked by current thread?  "
				+ mDatabase.isDbLockedByCurrentThread());

		// CREATE TABLES
		Log.i(DEBUG_TAG, "Create the tbl_authors table using execSQL()");
		mDatabase.execSQL(CREATE_AUTHOR_TABLE);

		Log.i(DEBUG_TAG,
				"Create the tbl_books table using SQLiteStatement.execute()");
		SQLiteStatement sqlSelect = mDatabase
				.compileStatement(CREATE_BOOK_TABLE);
		sqlSelect.execute();

		// Create some SQL triggers to enforce our foreign key constraints
		Log.i(DEBUG_TAG, "Create some triggers");
		mDatabase.execSQL(CREATE_TRIGGER_ADD);
		mDatabase.execSQL(CREATE_TRIGGER_UPDATE);
		mDatabase.execSQL(CREATE_TRIGGER_DELETE);

		// Add some records (within a transaction)
		addSomeBooks();
		Log.i(DEBUG_TAG, "Database Transaction?  " + mDatabase.inTransaction());
		Log.i(DEBUG_TAG, "Database Locked by current thread?  "
				+ mDatabase.isDbLockedByCurrentThread());

		// LET'S DO SOME QUERIES

		// SIMPLE QUERY: select * from tbl_books
		Log.i(DEBUG_TAG, "SQL QUERY EQUIVALENT: select * from tbl_books");
		Cursor c = mDatabase.query(TABLE_BOOK, null, null, null, null, null,
				null);
		LogCursorInfo(c);
		c.close();

		// SIMPLE QUERY: SELECT title, id  FROM tbl_books ORDER BY title ASC;
		Log.i(DEBUG_TAG, "SQL QUERY EQUIVALENT: SELECT title, id  FROM tbl_books ORDER BY title ASC;");					
		String asColumnsToReturn2[] = { "title", "id" };
		String strSortOrder2 = "title ASC";
		c = mDatabase.query("tbl_books", asColumnsToReturn2, null, null, null, null,strSortOrder2);
		LogCursorInfo(c);
		c.close();	

		// JOIN QUERY USING SQLiteQueryBuilder: select title, author first name, author last name, and ids (Join two tables)
		Log.i(DEBUG_TAG, "SQL QUERY EQUIVALENT: SELECT tbl_books.title, tbl_books.id, tbl_authors.firstname, tbl_authors.lastname, tbl_books.authorid FROM tbl_books INNER JOIN tbl_authors on tbl_books.authorid=tbl_authors.id ORDER BY title ASC;");
		SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		queryBuilder.setTables(TABLE_BOOK + ", " + TABLE_AUTHOR);							// Tables to join
		queryBuilder.appendWhere(TABLE_BOOK + ".authorid" + "=" + TABLE_AUTHOR	+ ".id");	// how to join
		String asColumnsToReturn[] = {
				TABLE_BOOK + ".title",
				TABLE_BOOK + ".id",
				TABLE_AUTHOR + ".firstname",
				TABLE_AUTHOR + ".lastname",
				TABLE_BOOK + ".authorid" 
		};
		String strSortOrder = "title ASC";
		c = queryBuilder.query(mDatabase, asColumnsToReturn, null, null, null, null,strSortOrder);
		LogCursorInfo(c);
		c.close();	

		// QUERY Again as above, but this time filter results to just titles that contain the string "Prince"
		Log.i(DEBUG_TAG, "SQL QUERY EQUIVALENT: SELECT tbl_books.title, tbl_books.id, tbl_authors.firstname, tbl_authors.lastname, tbl_books.authorid FROM tbl_books INNER JOIN tbl_authors on tbl_books.authorid=tbl_authors.id  WHERE title LIKE '%Prince%' ORDER BY title ASC;");
		SQLiteQueryBuilder queryBuilder2 = new SQLiteQueryBuilder();
		queryBuilder2.setTables(TABLE_BOOK + ", " + TABLE_AUTHOR);							// Tables to join
		queryBuilder2.appendWhere("("+TABLE_BOOK + ".authorid" + "=" + TABLE_AUTHOR	+ ".id" + ")");	// how to join
		queryBuilder2.appendWhere(" AND (" + TABLE_BOOK + ".title" + " LIKE '%Prince%'" + ")");	// WHERE clauses are AND'ed together, so now we are getting all titles with 'of'
		c = queryBuilder2.query(mDatabase, asColumnsToReturn, null, null, null, null,strSortOrder);
		LogCursorInfo(c);
		c.close();
		
		// Tip: Unions with QueryBuilder are overly complicated for simple unions, just use raw queries with args.
		// Note: the Query args will all be surrounded with '' so you need to put the % inside the arg instead of in the query string 
		Log.i(DEBUG_TAG, "SQL QUERY EQUIVALENT: SELECT title AS Name, 'tbl_books' AS OriginalTable from tbl_books WHERE Name LIKE '%ow%' UNION SELECT (firstname||' '|| lastname) AS Name, 'tbl_authors' AS OriginalTable from tbl_authors WHERE Name LIKE '%ow%' ORDER BY Name ASC;");
		String sqlUnionExample = "SELECT title AS Name, 'tbl_books' AS OriginalTable from tbl_books WHERE Name LIKE ? UNION SELECT (firstname||' '|| lastname) AS Name, 'tbl_authors' AS OriginalTable from tbl_authors WHERE Name LIKE ? ORDER BY Name ASC;";
		c = mDatabase.rawQuery(sqlUnionExample, new String[]{ "%ow%", "%ow%"});
		LogCursorInfo(c);
		c.close();
		
		// SIMPLE QUERY: select * from tbl_books WHERE id=9;
		Log.i(DEBUG_TAG, "SQL QUERY EQUIVALENT: select * from tbl_books WHERE id=9");
		c = mDatabase.query(TABLE_BOOK, null, "id=?", new String[]{"9"}, null, null,null);
		LogCursorInfo(c);
		c.close();
		
		// LET's DO AN UPDATE
		Log.i(DEBUG_TAG, "Update Le Petit Prince Book to new title 'The Little Prince' (Book Record Id 9)");
		updateBookTitle("The Little Prince", 9);	// Change Book #9 to the English title from the French Version
		
		// SIMPLE QUERY: select * from tbl_books WHERE id=9
		Log.i(DEBUG_TAG, "SQL QUERY EQUIVALENT: select * from tbl_books WHERE id=9");
		c = mDatabase.query(TABLE_BOOK, null, "id=?", new String[]{ "9"}, null, null,null);
		LogCursorInfo(c);
		c.close();
		
		// LET'S DO SOME DELETES
		
		// Deletes fail if they violate the database constraints we imposed in the CREATE TABLE (triggers)
		try
		{
			Log.i(DEBUG_TAG, "Try to delete Stephen Colbert (Author Record Id 2)");
			deleteAuthor(2);	// try to delete Colbert. This will FAIL because he's got books (constraint violation)
		}
		catch(SQLiteConstraintException e)
		{
			Log.i(DEBUG_TAG, "Delete Failed, threw SQLiteConstraintException: "+  e.getMessage() + "  ***FYI: Error Code 19 is Constraint Violated. Colbert still has books!");
		}
		
		// DELETES DONE IN THE RIGHT ORDER TO AVOID CONSTRAINT VIOLATIONS WILL SUCCEED
		Log.i(DEBUG_TAG, "Try to delete Stephen Colbert's Book (Book Record Id 8)");
		deleteBook(8);	// Delete Colbert's book
		Log.i(DEBUG_TAG, "Try to delete Stephen Colbert Again (Author Record Id 2)");
		deleteAuthor(2); // Delete Colbert
		
		Log.i(DEBUG_TAG, "Deleting All books by J.K. Rowling (Author Record Id 1)");
		deleteBooksByAuthor(1);
		
		// SIMPLE QUERY: select * from tbl_books
		Log.i(DEBUG_TAG, "SQL QUERY EQUIVALENT: select * from tbl_books");
		c = mDatabase.query(TABLE_BOOK, null, null, null, null, null,null);
		LogCursorInfo(c);
		c.close();
		
		// Drop our tables
		Log.i(DEBUG_TAG, "Dropping tables, ditch the data");
		mDatabase.execSQL(DROP_BOOK_TABLE);
		mDatabase.execSQL(DROP_AUTHOR_TABLE);

		// Drop our triggers
		Log.i(DEBUG_TAG, "Drop triggers");
		mDatabase.execSQL("DROP TRIGGER IF EXISTS fk_insert_book;");
		mDatabase.execSQL("DROP TRIGGER IF EXISTS fk_update_book;");
		mDatabase.execSQL("DROP TRIGGER IF EXISTS fk_delete_author;");

		// Close the database
		Log.i(DEBUG_TAG, "Close the database");
		mDatabase.close();
		Log.i(DEBUG_TAG, "Database Open?  " + mDatabase.isOpen());

		// Delete the database file itself
		Log.i(DEBUG_TAG, "Delete the database");
		deleteDatabase(DATABASE_NAME);

		Log.i(DEBUG_TAG, "End Database Example");
	}

	// This function iterates a Cursor and prints its contents
	// Note: Sqlite databases are not strongly typed, so you can pull everything out as a string, or you can use the
	// appropriate get call to enforce type safety. 
	// In this case, we are just logging so we treat all columns as strings using getString() method
	public void LogCursorInfo(Cursor c) {
		Log.i(DEBUG_TAG, "*** Cursor Begin *** " + " Results:" + c.getCount() + " Columns: " + c.getColumnCount());

		// Print column names
		String rowHeaders = "|| ";
		for (int i = 0; i < c.getColumnCount(); i++) {

			rowHeaders = rowHeaders.concat(c.getColumnName(i) + " || ");
		}
		Log.i(DEBUG_TAG, "COLUMNS " + rowHeaders);

		// Print records
		c.moveToFirst();
		while (c.isAfterLast() == false) {
			String rowResults = "|| ";
			for (int i = 0; i < c.getColumnCount(); i++) {
				rowResults = rowResults.concat(c.getString(i) + " || ");
			}
			Log.i(DEBUG_TAG, "Row " + c.getPosition() + ": " + rowResults);

			c.moveToNext();
		}
		Log.i(DEBUG_TAG, "*** Cursor End ***");
	}

	// This function adds some data to our database
	// We use a transaction here. The transaction is not required, but it can be helpful 
	// if you want to be able to rollback changes if something goes wrong in the middle of a bunch
	// of database changes. 
	// For example, there's no point in adding Books if their Author record failed to insert properly
	public void addSomeBooks() {
		Log.i(DEBUG_TAG, "Database Transaction Start");
		mDatabase.beginTransaction();
		try {
			// Log some transaction diagnostics
			Log.i(DEBUG_TAG, "Database Transaction?  "
					+ mDatabase.inTransaction());
			Log.i(DEBUG_TAG, "Database Locked by current thread?  "
					+ mDatabase.isDbLockedByCurrentThread());

			// ADD SOME VALUES
			Date today = new Date(java.lang.System.currentTimeMillis());

			Author author = new Author("J.K.", "Rowling");
			addAuthor(author); // FYI - this sets the ID appropriately, which is then used by the addBook calls

			addBook(new Book("Harry Potter and the Sorcerer's Stone", today,
					author));
			addBook(new Book("Harry Potter and the Chamber of Secrets", today,
					author));
			addBook(new Book("Harry Potter and the Prisoner of Azkaban", today,
					author));
			addBook(new Book("Harry Potter and the Goblet of Fire", today,
					author));
			addBook(new Book("Harry Potter and the Order of the Phoenix",
					today, author));
			addBook(new Book("Harry Potter and the Half-Blood Prince", today,
					author));
			addBook(new Book("Harry Potter and the Deathly Hallows", today,
					author));
			
			Author author2 = new Author("Stephen", "Colbert");
			addAuthor(author2); 

			addBook(new Book("I Am America (And So Can You!)", today,
					author2));
				
			Author author3 = new Author("Antoine", "de Saint-Exupery");
			addAuthor(author3); 

			addBook(new Book("Le Petit Prince", today,
					author3));

			mDatabase.setTransactionSuccessful();
		} catch (Exception e) {
			// Transaction failed. Failed! Do something here.
			// For example, if you got an exception for a readonly db, 
			// you could open the database for write and retry the transaction. 
			// It's up to you. We just log that we had a problem. We do not 
			// commit our changes, but roll them back, by NOT calling setTransactionSuccessful().
			Log.i(DEBUG_TAG,"Transaction failed. Exception: " + e.getMessage());
		} finally {
			mDatabase.endTransaction();
		}
		Log.i(DEBUG_TAG, "Database Transaction End");
	}

	// Add a book to the book table
	public void addBook(Book newBook) {
		ContentValues values = new ContentValues();
		values.put("title", newBook.mTitle);
		values.put("dateadded", newBook.mDateAdded.toLocaleString());
		values.put("authorid", newBook.mAuthor.mAuthorId);
		newBook.mBookId = mDatabase.insertOrThrow(TABLE_BOOK, null, values);
		Log.i(DEBUG_TAG, "Added Book:  " + newBook.mTitle + "(ID=" + newBook.mBookId + ")");
	}

	// Add an author to the author table
	public void addAuthor(Author newAuthor) {
		ContentValues values = new ContentValues();
		values.put("firstname", newAuthor.mFirstName);
		values.put("lastname", newAuthor.mLastName);
		newAuthor.mAuthorId = mDatabase.insertOrThrow(TABLE_AUTHOR, null,
				values);
		Log.i(DEBUG_TAG, "Added Author:  " + newAuthor.mFirstName + " " + newAuthor.mLastName + "(ID=" + newAuthor.mAuthorId + ")");
	}

	// Update a record in the book table with a new title
	public void updateBookTitle(String newtitle, Integer bookId) {
		ContentValues values = new ContentValues();
		values.put("title", newtitle);
		mDatabase.update(TABLE_BOOK, values, "id=?", new String[] { bookId.toString() });
	}

	// Delete a single book by its id
	public void deleteBook(Integer bookId) {
		mDatabase.delete(TABLE_BOOK, "id=?", new String[] { bookId.toString() });
		Log.i(DEBUG_TAG, "Deleted Book Id:  " + bookId.toString());
	}

	// Delete all books by an author by authorid
	public void deleteBooksByAuthor(Integer authorID) {
		int numBooksDeleted = mDatabase.delete(TABLE_BOOK, "authorid=?", new String[] { authorID.toString() });
		Log.i(DEBUG_TAG, "Deleted " + numBooksDeleted + " books with Author Id:  " + authorID.toString());
	}
	
	// Delete a single author by its id
	public void deleteAuthor(Integer authorId) {
		mDatabase.delete(TABLE_AUTHOR, "id=?", new String[] { authorId.toString() });
		Log.i(DEBUG_TAG, "Deleted Author Id:  " + authorId.toString());
	}

	// Helper class to encapsulate Author information programmatically
	class Author {
		String mFirstName;
		String mLastName;
		long mAuthorId;

		public Author(String firstName, String lastName) {
			mFirstName = firstName;
			mLastName = lastName;
			mAuthorId = -1;

		}
	}

	// Helper class to encapsulate Book information programmatically
	class Book {
		String mTitle;
		Date mDateAdded;
		long mBookId;
		Author mAuthor;

		public Book(String title, Date dateAdded, Author author) {
			mTitle = title;
			mDateAdded = dateAdded;
			mAuthor = author;
			mBookId = -1;

		}
	}

}