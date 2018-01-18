#ifndef GSMWEBWIGET_H
#define GSMWEBWIGET_H

#include <QWidget>
#include <QWebPage>
#include <QDebug>


class GSMWebWiget:public QWidget
{
    Q_OBJECT
public:
    GSMWebWiget(QWebPage * page,QString data);
    ~GSMWebWiget();
private:
    QWebPage * page;
    QString data;

public slots:
    QString get_data(){
        QString title = "***小区话务数据统计折线图";
        QString data_name = "小时级话务量";
        QString xAxis_name = "时间";
        QString xAxis_data = "071208,071209,071210,071211,071212,071213,071214";
        QString yAxis_name = "小时级话务量";
        QString yAxis_data = "200,300,500,1000,0,293,494";
        //return title + ";" + data_name + ";" + xAxis_name + ";" + xAxis_data + ";" + yAxis_name + ";" + yAxis_data;
        return data;
    }
};

#endif // GSMWEBWIGET_H
