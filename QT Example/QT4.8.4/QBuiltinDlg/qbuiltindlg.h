#ifndef QBUILTINDLG_H
#define QBUILTINDLG_H

#include <QMainWindow>
#include <QApplication>
#include <QPushButton>
#include <QDialog>
#include <QGridLayout>
#include <QWidget>
#include <QHBoxLayout>
#include <QLabel>
#include <QTextEdit>
#include <QLineEdit>
#include <QComboBox>
#include <QDialogButtonBox>
#include <QGridLayout>
#include <QDialog>
#include <QtGui>

namespace Ui {
class QBuiltinDlg;
}

class QTextEdit;
class QPushButton;
class QBuiltinDlg : public QDialog
{
    Q_OBJECT
public:
    explicit QBuiltinDlg(QWidget* parent = 0);
    virtual ~QBuiltinDlg();

private:

    QTextEdit*  displayTextEdit;
    QPushButton*	colorPushBtn;
    QPushButton*	errorPushBtn;
    QPushButton*	filePushBtn;
    QPushButton*	fontPushBtn;
    QPushButton*	inputPushBtn;
    QPushButton*	pagePushBtn;
    QPushButton*	progressPushBtn;
    QPushButton*	printPushBtn;

private slots:
    void doPushBtn();
private:
    Ui::QBuiltinDlg *ui;
};

#endif // QBUILTINDLG_H





