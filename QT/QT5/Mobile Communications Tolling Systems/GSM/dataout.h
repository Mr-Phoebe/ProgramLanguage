#ifndef DATAOUT_H
#define DATAOUT_H

#include <QDialog>
#include <QAxObject>
#include <QSqlQuery>

#include <qdebug.h>
#include <iostream>
#include <fstream>
#include <iomanip>
#include <string.h>

namespace Ui {
class Dataout;
}

class Dataout : public QDialog
{
    Q_OBJECT

public:
    explicit Dataout(int flag,QString where,QWidget *parent = 0);
    ~Dataout();
    void data_out(QString, bool);

private:
    Ui::Dataout *ui;
    int flags;
    QString Where;
private slots:
    void out_queryResult();
    void testtest();
};

#endif // DATAOUT_H
