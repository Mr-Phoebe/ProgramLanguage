#include "widget.h"
#include "ui_widget.h"
#include <QtSql>
#include <QKeyEvent>
#include <QtGui>

// ## 键盘快捷键
void Widget::keyPressEvent(QKeyEvent *event)
{
    if(event->key() == Qt::Key_Enter || event->key() == Qt::Key_Return)
    {
        on_loginButton_clicked();//按钮槽函数
    }
}


// ## 登陆按钮
void Widget::on_loginButton_clicked()
{
    QString username = ui->usernameLineEdit->text();
    QString password = ui->passwordLineEdit->text();

    // ## 生成查询验证语句
    QString sql = QString("select * from login_t where username = '%1' and password = '%2'").arg(username).arg(password);
    QSqlQuery query(sql);

    if (query.next())
    {
        // ## 登录成功转入主界面
        ui->stackedWidget->setCurrentIndex(0);
        // ## 为了下次登陆而清空密码和账号
        ui->loginMsgLabel->clear();
        ui->usernameLineEdit->clear();
        ui->passwordLineEdit->clear();
    }
    else
    {
        // ## 登录失败，显示错误信息
        ui->loginMsgLabel->setText(tr("用户名或密码错误!!!"));
        ui->usernameLineEdit->clear();
        ui->passwordLineEdit->clear();
    }
}


// ## 退出按钮
void Widget::on_exitButton_clicked()
{
     qApp->quit();
}
