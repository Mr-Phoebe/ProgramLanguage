#include "userinfo.h"

UserInfo::UserInfo(QString nn,int ss)
{
    this->name = nn;
    this->sex = ss;
    this->circle.clear();
    this->height.clear();
    this->weight.clear();
    this->testtime.clear();

    QSqlQuery query;
    QString sql = QString("select name,weight,height,circle,testtime from history "
                  "where name = '%1'").arg(this->name);
    query.exec(sql);

    while(query.next())
    {
        this->weight.push_back( query.value(1).toDouble() );
        this->height.push_back( query.value(2).toDouble() );
        this->circle.push_back( query.value(3).toDouble() );
        this->testtime.push_back( query.value(4).toDate() );
    }

}

UserInfo::~UserInfo()
{

}

double UserInfo::CalculateBMI(double ww, double hh)
{
    return ww/(hh*hh);
}

double UserInfo::CalculateFat(double cc, double ww)
{
    if(this->sex == 0)
    {
        double a = cc*0.74;
        double b = ww*0.082+44.74;
        return (a-b)/ww;
    }
    else
    {
        double a = cc*0.74;
        double b = ww*0.082+34.89;
        return (a-b)/ww;
    }
}

void UserInfo::DeleteUserData()
{
    QSqlQuery query;
    QString sql = QString("delete from history where name = '%1'").arg(this->name);
    query.exec(sql);
    sql = QString("delete from user where name = '%1'").arg(this->name);
    query.exec(sql);
}
