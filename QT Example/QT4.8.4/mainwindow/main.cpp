#include <QApplication>

#include "mainwindow.h"

int main(int argc, char *argv[])
{
    QApplication app(argc,argv);
    MainWindow *mainwindow = new MainWindow();
    mainwindow->show();
    return app.exec();
}
