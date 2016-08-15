#include <QtGui/QApplication>
#include <QTextCodec>
#include "connection.h"
#include "widget.h"

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);
    QTextCodec::setCodecForTr(QTextCodec::codecForName("UTF-8"));
    if (!createConnection())
        return 1;

    Widget w;
    w.show();

    return app.exec();
}
