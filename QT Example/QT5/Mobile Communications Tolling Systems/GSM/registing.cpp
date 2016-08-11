#include "registing.h"
#include "ui_registing.h"

registing::registing(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::registing)
{
    ui->setupUi(this);
    setWindowTitle("管理人员注册");
    QRegExp regExp("^[0-9A-Za-z]+$");
    ui->lineEdit1->setValidator(new QRegExpValidator(regExp,this));
    ui->lineEdit2->setValidator(new QRegExpValidator(regExp,this));
    connect(ui->cancel,SIGNAL(clicked()),this,SLOT(close()));
    connect(ui->confirm,SIGNAL(clicked()),this,SLOT(regist()));
}

registing::~registing()
{
    delete ui;
}

void registing::regist()
{
    QString textnum = ui->lineEdit1->text();
    QString textkey = ui->lineEdit2->text();
    if(textnum.isEmpty() || textkey.isEmpty())
    {
        QMessageBox *tsmessage = new QMessageBox;
        QString str;
        str += "输入信息不完整     ";
        tsmessage->setWindowTitle("错误");
        tsmessage->setText(str);
        tsmessage->exec();
    }
    else
    {
        QSqlQuery query;
        int flag = 1;
        query.exec("SELECT number FROM administrator WHERE number = '"+textnum+"'");
        while(query.next())
        {
            QString samenum = query.value(0).toString();
            if(samenum == textnum)
            {
                flag = 0;
                break;
            }
        }
        if(flag == 0)
        {
            QMessageBox *tsmessage = new QMessageBox;
            QString str;
            str += "该用户名已注册过     ";
            tsmessage->setWindowTitle("错误");
            tsmessage->setText(str);
            tsmessage->exec();
        }
        else
        {
            query.exec("INSERT INTO administrator (number, password)"
                       "VALUES('"+textnum+"', '"+textkey+"')");
            QMessageBox *tsmessage = new QMessageBox;
            QString str;
            str += "注册成功，请登陆     ";
            tsmessage->setWindowTitle("成功");
            tsmessage->setText(str);
            tsmessage->exec();
            this->hide();
        }
    }
}
