#ifndef GSMWEBPAGE_H
#define GSMWEBPAGE_H
#include "gsmwebwiget.h"
#include <QWebPage>
#include <QWebFrame>


class GSMWebPage:public QWebPage
{
    Q_OBJECT
public:
    GSMWebPage(QString data,QObject * parent = 0);
    ~GSMWebPage();
protected:
    QObject * createPlugin(const QString &classid, const QUrl &url, const QStringList &paramNames, const QStringList &paramValues){
        return new GSMWebWiget(this,data);
    }

private:
    QString data;
};

#endif // GSMWEBPAGE_H
