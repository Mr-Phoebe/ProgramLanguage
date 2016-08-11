#ifndef CHARTDIALOG_H
#define CHARTDIALOG_H

#include "ui_chartdialog.h"

class ChartDialog : public QDialog, private Ui::ChartDialog
{
    Q_OBJECT

public:
    explicit ChartDialog(QWidget *parent = 0);
};

#endif // CHARTDIALOG_H
