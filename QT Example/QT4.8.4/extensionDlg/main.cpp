#include <QApplication>
#include "extensiondlg.h"

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    ExtensionDlg w;
    w.show();
    
    return a.exec();
}
