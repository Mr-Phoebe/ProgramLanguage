#include <QApplication>
#include "qbuiltindlg.h"

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    QBuiltinDlg w;
    w.show();
    
    return a.exec();
}
