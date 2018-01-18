#include "widget.h"
#include "ui_widget.h"
#include <QtSql>
#include <QtGui>
#include <QMessageBox>

// ## 退出按钮
void Widget::on_Exit_clicked()
{
     qApp->quit();
}

// ## 关于按钮
void Widget::on_About_clicked()
{
    QMessageBox::about(this, tr("关于酒店管理系统"),
                           tr("<h2>酒店管理系统 1.0 </h2>"
                           "<p>酒店管理系统由2013211303班02组编写。"
                           "组员：吴浩男，钟克难，金东赫，周杰。"
                           "由Mr.Phoebe Coding Studio提供后续服务："
                           "http://blog.csdn.net/u013007900</p>"));
}

// ## 退出账号按钮
void Widget::on_ExitID_clicked()
{
    initLoginPage();
    initMainPage();
}

