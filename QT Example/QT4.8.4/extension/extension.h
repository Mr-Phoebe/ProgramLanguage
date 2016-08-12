#ifndef EXTENSION_H
#define EXTENSION_H
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

class Extension : public QDialog
{
    Q_OBJECT
public:
    Extension(QWidget *parent=0);
    void createBaseInfo();
    void createDetailInfo();
public slots:
    void slotExtension();
private:
    QWidget *baseWidget;
    QWidget *detailWidget;

};

#endif // EXTENSION_H
