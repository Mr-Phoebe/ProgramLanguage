#ifndef DATAIN_H
#define DATAIN_H

#include <QDialog>
#include <QAxObject>
#include <QSqlQuery>

#include "opendb.h"

namespace Ui {
class DataIn;
}

class DataIn : public QDialog
{
    Q_OBJECT

public:
    explicit DataIn(QWidget *parent = 0);
    ~DataIn();
    void data_in(int);

private:
    void MS();
    void MSC();
    void BSC();
    void BTS();
    void Cell();
    void Freq();
    void Tianxian();
    void Neighbor();
    void Datas();
    void Locate();

    Ui::DataIn *ui;
};

#endif // DATAIN_H
