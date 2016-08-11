#include "mainwindow.h"
#include <QApplication>

#include "opendb.h"
OpenDB* odb=new OpenDB();

int main(int argc, char *argv[])
{
//    odb->DBtest="ahahahaha";
    QApplication a(argc, argv);
    MainWindow w;
    w.show();

    return a.exec();
}
//#include <QApplication>

//#include <QSqlDatabase>

//#include <QStringList>

//#include <QDebug>

//int main(int argc, char* argv[])

//{

//     QApplication app(argc, argv);

//     qDebug() << "Available drivers:";

//     QStringList drivers = QSqlDatabase::drivers();

//     foreach(QString driver, drivers)  //列出Qt5所有支持的数据库类型

//          qDebug() << "\t" << driver;

//     QSqlDatabase db = QSqlDatabase::addDatabase("QODBC");

//     qDebug() << "ODBC driver valid?" << db.isValid();  //true为支持

//}
