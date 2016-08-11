#include "opendb.h"
#include <QSqlError>
#include <QDebug>

OpenDB::OpenDB()
{
    DB = createDB();
    DBtest = "bbbb";
}

OpenDB::~OpenDB()
{

}

QSqlDatabase OpenDB::createDB()
{
    QSqlDatabase db = QSqlDatabase::addDatabase("QODBC");
//    QString dsn = "DRIVER={SQL SERVER};SERVER=192.168.10.22\\sqlexpress;DATABASE=sqlscada";
//    db.setDatabaseName("GSMdsn");
    db.setDatabaseName(QString("DRIVER={SQL SERVER};"
                               "SERVER=STILES;"
                               "DATABASE=GSM;"
                               "UID=shihui;"
                               "PWD=shihui;"));
//    db.setUserName("shihui");
//    db.setPassword("shihui");

    if(!db.open())
    {
        qDebug()<<db.lastError().databaseText();
        qDebug("ERROR:没打开咯"/*,qPrintable(db.lastError().text())*/);
        return db;
    }
    qDebug("打开了");
    return db;
}

QSqlDatabase OpenDB::getDB()
{
    return DB;
}
