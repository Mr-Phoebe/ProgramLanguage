#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    setWindowTitle("GSM管理人员登录");
    createDB();

//    connect(ui->pushButton,SIGNAL(clicked()),this,SLOT(toDataIn()));
    connect(ui->registing,SIGNAL(clicked()),this,SLOT(goRegist()));
    connect(ui->signin,SIGNAL(clicked()),this,SLOT(goSignin()));
}

void MainWindow::createDB()
{
    bool isExist=false;
    QSqlQuery query;
    query.exec("select count(*) from sysobjects where name = 'administrator'");
    if(query.next())
    {
        int count = query.value(0).toInt();
        if(count==1)
            isExist = true;
        qDebug()<<isExist;
    }
    if(!isExist)
    {
        query.exec("create table administrator ("
                   "number varchar(20),"
                   "password varchar(20),"
                   "primary key(number,password))");
    }
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::toDataIn()
{
//    Dataout* out = new Dataout();
//    DataIn* in = new DataIn();
//    out->exec();
    QSqlQuery query;
    query.exec("insert into MSC values('6666','555','hjk',111.123,123.123,2000);");
}

void MainWindow::goRegist()
{
    registing* regist=new registing();
    regist->exec();
}

void MainWindow::goSignin()
{
    QString textnum = ui->UserEdit->text();
    QString textkey = ui->PassEdit->text();
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
        int flag1 = 1;//用来判断用户是否已经注册的标志位
        int flag2 = 1;//用来判断密码是否输入正确的标志位
        query.exec("SELECT number, password FROM administrator WHERE number = '"+textnum+"'");
        while(query.next())
        {
            QString Num = query.value(0).toString();
            QString Key = query.value(1).toString();
            if(Num == textnum)
            {
                flag1 = 0;
                if(Key == textkey)
                {
                    flag2 = 0;
                }
                break;
            }
        }
        if(flag1 == 1)
        {
            QMessageBox *tsmessage = new QMessageBox;
            QString str;
            str += "该用户没有注册信息     ";
            tsmessage->setWindowTitle("错误");
            tsmessage->setText(str);
            tsmessage->exec();
        }
        else if(flag1 == 0 && flag2 == 1)//判断密码是否输入正确
        {
            QMessageBox *tsmessage = new QMessageBox;
            QString str;
            str += "密码输入错误     ";
            tsmessage->setWindowTitle("错误");
            tsmessage->setText(str);
            tsmessage->exec();
        }
        else//成功登录
        {
            Control* ctrl= new Control();
            ctrl->exec();
        }
    }
}
