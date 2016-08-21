#ifndef COLORDLG_H
#define COLORDLG_H

#include <QMainWindow>
#include <QApplication>
#include <QPushButton>
#include <QDialog>
#include <QGridLayout>
#include <QWidget>
#include <QHBoxLayout>
#include <QLabel>
#include <QLineEdit>
#include <QComboBox>
#include <QDialogButtonBox>
#include <QGridLayout>
#include <QDialog>
#include <QtGui>
#include <QString>
#include <QVBoxLayout>
#include <QInputDialog>
#include <QMessageBox>
#include <QColorDialog>

namespace Ui {
class ColorDlg;
}

class ColorDlg : public QDialog
{
    Q_OBJECT
    
public:
    explicit ColorDlg(QWidget *parent = 0);
    ~ColorDlg();

signals:
    void setTxt(QString txt);

public slots:
    void inputtxt();
    void show_clr();

private:
    Ui::ColorDlg *ui;
    QPushButton *btnok;
    QPushButton *btncolor;
    QLabel * labeltxt;
    QString txt;
    QWidget * pParent;
};

#endif // COLORDLG_H
