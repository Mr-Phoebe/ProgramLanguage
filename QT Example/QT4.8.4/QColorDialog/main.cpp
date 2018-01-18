#include <QApplication>
#include "colordlg.h"

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    ColorDlg w;
    w.show();
    return a.exec();
}
