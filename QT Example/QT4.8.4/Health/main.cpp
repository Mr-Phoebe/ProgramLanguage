#include "mainwindow.h"
#include <QApplication>
#include <QTextCodec>
#include "connection.h"

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    QTextCodec::setCodecForTr(QTextCodec::codecForName("UTF-8"));
    if (!createConnection())
        return 1;

    MainWindow w;
    w.show();

    return a.exec();
}
