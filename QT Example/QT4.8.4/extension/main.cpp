#include<QApplication>
#include"extension.h"

int main(int argc,char *argv[])
{
    QApplication app(argc,argv);
    Extension exten;
    exten.show();
    return app.exec();
}
