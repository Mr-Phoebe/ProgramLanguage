#ifndef INPUTDIALOG_H
#define INPUTDIALOG_H

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


namespace Ui {
class InputDialog;
}

class InputDialog : public QDialog
{
    Q_OBJECT
    
public:
    explicit InputDialog(QWidget *parent = 0);
    ~InputDialog();
    
    QPushButton *nameButton;
    QPushButton *sexButton;
    QPushButton *ageButton;
    QPushButton *statureButton;

    QLabel *label1;
    QLabel *label2;
    QLabel *label3;
    QLabel *label4;

    QLabel *nameLabel;
    QLabel *sexLabel;
    QLabel *ageLabel;
    QLabel *statureLabel;

private:
    Ui::InputDialog *ui;

private slots:
    void slotName();
    void slotSex();
    void slotAge();
    void slotStature();
};

#endif // INPUTDIALOG_H
