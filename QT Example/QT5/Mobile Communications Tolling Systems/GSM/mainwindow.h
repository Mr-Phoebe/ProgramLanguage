#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include "opendb.h"
#include "control.h"
#include "registing.h"

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

private slots:
    void toDataIn();
    void goRegist();
    void goSignin();

private:
    Ui::MainWindow *ui;
    QSqlDatabase db;
    void createDB();
};

#endif // MAINWINDOW_H
