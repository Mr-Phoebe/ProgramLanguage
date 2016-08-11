#ifndef CONTROL_H
#define CONTROL_H

#include <QDialog>
#include <QMessageBox>
#include "datain.h"
#include "dataout.h"
#include "distance.h"
#include "point.h"
#include "chartdialog.h"
#include <QWebView>
#include "gsmwebpage.h"

namespace Ui {
class Control;
}

class Control : public QDialog
{
    Q_OBJECT

public:
    explicit Control(QWidget *parent = 0);
    ~Control();

private slots:
    void data_in();
    void data_out();
    void page1();
    void page2();
    void page3();
    void queryBTS();
    void page4();
    void queryCell();
    void bulkInsert();
    void page5();
    void reCalculateDatas();
    void page6();
    void printNeighbor();
    void page7();
    void findNeighbor();
    void findCellInfo();

    void page13();
    void page14();
    void page15();
    void page16();
    void page17();
    void page18();

    void on_teleAmountButton_clicked();

    void on_congestRatioButton_clicked();

    void on_hafAmountRatioButton_clicked();

    void on_teleAmountButton_2_clicked();

    void on_congestRatioButton_2_clicked();

    void on_pushButton_19_clicked();

    void on_pushButton_20_clicked();

    void on_pushButton_21_clicked();

    void action22();
    void action23();

private:
    Ui::Control *ui;
    Dataout *out;
    DataIn *in;
    void addBTSname();
    void addCellID();
    bool checkDurationValid();
    bool checkDurationValid_2();
    bool checkDurationValid_3();
    bool checkDurationValid_4();
    void initTime();
};

#endif // CONTROL_H
