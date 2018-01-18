#include "gsmwebpage.h"

GSMWebPage::GSMWebPage(QString data, QObject * parent):QWebPage(parent),data(data)
{
    settings()->setAttribute(QWebSettings::PluginsEnabled,true);
}

GSMWebPage::~GSMWebPage()
{

}

