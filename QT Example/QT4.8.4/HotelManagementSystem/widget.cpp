#include "widget.h"
#include "ui_widget.h"
#include <QtSql>
#include <QtGui>


Widget::Widget(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::Widget)
{
    ui->setupUi(this);
    /*
     *在QT中使用SQL需要在pro文件里面加上QT   += core gui sql
     */
    initLoginPage();
    initMainPage();
}

Widget::~Widget()
{
    delete ui;
}

void Widget::initLoginPage()
{
    ui->stackedWidget->setCurrentIndex(1);
}

void Widget::initMainPage()
{
    ui->mainTabWidget->setCurrentIndex(0);
    connect(ui->mainTabWidget, SIGNAL(currentChanged(int)), this, SLOT(updateAllInfo()));

    initOrderPage();
    initCheckInPage();
}

void Widget::initOrderPage()
{
    ui->ccheckintimeDateEdit->setDate(QDate::currentDate());
    ui->ccheckintimeDateEdit->setMinimumDate(QDate::currentDate());
    ui->cancelButton->setEnabled(false);
    ui->newCustomerButton->setEnabled(false);

    // ## 设置身份证和联系电话只能输入数字
    QRegExp regx("[0-9]+$");
    QValidator * validator = new QRegExpValidator(regx, ui->cidLineEdit);
    ui->cidLineEdit->setValidator(validator);
    ui->cphoneLineEdit->setValidator(validator);

    connect(ui->customerListWidget, SIGNAL(clicked(QModelIndex)), this, SLOT(processOrderCustomer()));
}

void Widget::initCheckInPage()
{
    // ## 默认只有第一个面板可用
    ui->ccheckintimeDateEdit_2->setDate(QDate::currentDate());
    ui->ccheckintimeDateEdit_2->setMinimumDate(QDate::currentDate());
    ui->ccheckintimeDateEdit_3->setMinimumDate(QDate::currentDate());
    ui->ccheckintimeDateEdit_4->setMinimumDate(QDate::currentDate());
    ui->customerGroupBox_3->setVisible(false);
    ui->customerGroupBox_4->setVisible(false);

    // ## 设置身份证和联系电话只能输入数字
    QRegExp regx("[0-9]+$");
    QValidator * validator = new QRegExpValidator(regx, ui->cidLineEdit);
    ui->cidLineEdit_2->setValidator(validator);
    ui->cidLineEdit_3->setValidator(validator);
    ui->cidLineEdit_4->setValidator(validator);
    ui->cphoneLineEdit_2->setValidator(validator);
    ui->cphoneLineEdit_3->setValidator(validator);
    ui->cphoneLineEdit_4->setValidator(validator);

    connect(ui->roomTableWidget, SIGNAL(cellPressed(int,int)), this, SLOT(processCheckInCustomer(int, int)));
}

// ## 更新其它管理界面所有的信息
void Widget::updateAllInfo()
{
    // ## 更新预定界面的信息
    updateOrderPage();

    // ## 更新入住界面的信息
    updateCheckInPage();

    // ## 更新房屋信息界面
    updateRoomInfoPage();

    // ## 更新退房信息
    updatePayPage();

    // ## 更新评价界面
    updateEvluatePage();
}
