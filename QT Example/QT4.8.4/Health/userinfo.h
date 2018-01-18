#ifndef USERINFO_H
#define USERINFO_H

#include <QtSql>
#include <QString>
#include <QVector>
#include <QDate>

class UserInfo
{
public:
    explicit UserInfo(QString nn,int ss);
    ~UserInfo();

    double CalculateBMI(double ww,double hh);
    double CalculateFat(double cc,double ww);

    void DeleteUserData();

    QString name;
    int sex;
    QVector<double> weight;
    QVector<double> height;
    QVector<double> circle;
    QVector<QDate> testtime;
};

#endif // USERINFO_H
