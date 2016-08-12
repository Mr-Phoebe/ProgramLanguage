#ifndef EXTENSIONDLG_H
#define EXTENSIONDLG_H

#include <QMainWindow>
#include <QtGui>

namespace Ui {
class ExtensionDlg;
}

class ExtensionDlg : public QDialog
{
    Q_OBJECT
    
public:
    explicit ExtensionDlg(QWidget *parent = 0);
    ~ExtensionDlg();
    void initBasicInfo();
    void initDetailInfo();
public slots:
    void slot2Extension();
private:
    QWidget *baseWidget;
    QWidget *detailWidget;
    Ui::ExtensionDlg *ui;
};

#endif // EXTENSIONDLG_H
