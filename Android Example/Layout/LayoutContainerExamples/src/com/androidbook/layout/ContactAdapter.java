package com.androidbook.layout;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ContactAdapter extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] requestedColumns = {
				Contacts.Phones._ID,
				Contacts.Phones.NAME,
				Contacts.Phones.NUMBER,
		};
		Cursor names = managedQuery(
				Contacts.Phones.CONTENT_URI,
				requestedColumns, null, null, null);
		startManagingCursor(names);
		setContentView(R.layout.contact);
		ListAdapter adapter = new SimpleCursorAdapter(
				this, R.layout.contact_item_simple,
				names, new String[] {
					Contacts.Phones.NAME
				}, new int[] {
					R.id.contact_item_simple_text
				});
		setListAdapter(adapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.ListActivity#onListItemClick(android.widget.ListView,
	 * android.view.View, int, long)
	 */
	@Override
	protected void onListItemClick(ListView l, View v,
			int position, long id) {

		Cursor phone = (Cursor) l
				.getItemAtPosition(position);

		TextView tv = ((TextView) v);
		String name = phone.getString(phone
				.getColumnIndex(Contacts.Phones.NAME));
		String num = phone
				.getString(phone
						.getColumnIndex(Contacts.Phones.NUMBER));

		String displayed = tv.getText().toString();
		if (displayed.compareTo(name) == 0) {
			tv.setText(num);
		} else {
			tv.setText(name);
		}
		Log.d(Layout.DEBUG_TAG, "Cursor pos: "
				+ phone.getPosition() + "== list pos: "
				+ position);
		Log
				.d(
						Layout.DEBUG_TAG,
						"Cursor id: "
								+ phone
										.getString(phone
												.getColumnIndex(Contacts.Phones._ID))
								+ "== list id: " + id);
	}

}
