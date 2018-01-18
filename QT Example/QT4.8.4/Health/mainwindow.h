#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QStringList>
#include <QBitmap>
#include <QPixmap>
#include <QPainter>
#include <QPalette>
#include <QPoint>
#include <QString>
#include <QMessageBox>
#include <QMouseEvent>
#include <QtSql>
#include <QMenu>
#include <QAction>
#include <QBrush>
#include <QObject>
#include <QStandardItemModel>
#include <QLayout>
#include <QFont>
#include <QPainter>
#include <QInputDialog>
#include "userinfo.h"

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

    void addMenuList();
    void DrawMainWindow(QString nn,int ss);
    void PaintLineGraph(QString nn,int ss);
    void ShowResult(double hh,double ww,double cc);
protected:
        void mousePressEvent(QMouseEvent *event);
        void mouseMoveEvent(QMouseEvent *event);
        void mouseDoubleClickEvent(QMouseEvent *event);

private slots:
        void on_closeButton_clicked();
        void on_minButton_clicked();

private:
    int Translate(double top,double bottom,double value)
    {
        return int( (top - value)/(top - bottom)*220 );
    }
    int TranslateX(int left,int right,int value)
    {
        return (value - left)*550/(right - left);
    }
    double Abs(double x)
    {
        if(x < 0) return -x;
        else return x;
    }
    Ui::MainWindow *ui;
    QPoint  m_dragPos;

    QString nameInfo[12];
    int sexInfo[12];
    int round;

    UserInfo *userinfo;
private slots:
    void on_clicked0()
    {
        userinfo = new UserInfo(nameInfo[0],sexInfo[0]);
        DrawMainWindow(nameInfo[0],sexInfo[0]);
    }
    void on_clicked1()
    {
        userinfo = new UserInfo(nameInfo[1],sexInfo[1]);
        DrawMainWindow(nameInfo[1],sexInfo[1]);
    }
    void on_clicked2()
    {
        userinfo = new UserInfo(nameInfo[2],sexInfo[2]);
        DrawMainWindow(nameInfo[2],sexInfo[2]);
    }
    void on_clicked3()
    {
        userinfo = new UserInfo(nameInfo[3],sexInfo[3]);
        DrawMainWindow(nameInfo[3],sexInfo[3]);
    }
    void on_clicked4()
    {
        userinfo = new UserInfo(nameInfo[4],sexInfo[4]);
        DrawMainWindow(nameInfo[4],sexInfo[4]);
    }
    void on_clicked5()
    {
        userinfo = new UserInfo(nameInfo[5],sexInfo[5]);
        DrawMainWindow(nameInfo[5],sexInfo[5]);
    }
    void on_clicked6()
    {
        userinfo = new UserInfo(nameInfo[6],sexInfo[6]);
        DrawMainWindow(nameInfo[6],sexInfo[6]);
    }
    void on_clicked7()
    {
        userinfo = new UserInfo(nameInfo[7],sexInfo[7]);
        DrawMainWindow(nameInfo[7],sexInfo[7]);
    }
    void on_clicked8()
    {
        userinfo = new UserInfo(nameInfo[8],sexInfo[8]);
        DrawMainWindow(nameInfo[8],sexInfo[8]);
    }
    void on_clicked9()
    {
        userinfo = new UserInfo(nameInfo[9],sexInfo[9]);
        DrawMainWindow(nameInfo[9],sexInfo[9]);
    }
    void on_clicked10()
    {
        if(round >= 10)
            QMessageBox::about(this,QString("提示"),QString("用户数已达上限！"));
        else
        {

            bool ok = true;
            QString text;
        mark:
            text = QInputDialog::getText(this,"新建用户","请输入用户名（不超过25个字符）：",
                                                 QLineEdit::Normal,"New User",&ok);
            if(!ok) return;
            if(text.isEmpty())
            {
                QMessageBox::about(this,"提示","用户名不能为空");
                goto mark;
            }
            else if(text.length()>25)
            {
                QString a = QString::number(text.length());
                QMessageBox::about(this,"提示",QString("用户名不能超过25个字符，您输入了 %1 个字符").arg(a) );
                goto mark;
            }
            else
            {
                QString sql = QString("select name from user where name = '%1'").arg(text);
                QSqlQuery query(sql);
                if(query.next())
                {
                    QMessageBox::about(this,"提示","用户已存在！");
                    goto mark;
                }
            }

            QStringList SexItems;
            SexItems<<"男"<<"女";
            QString sexChosen;

            QString SexItem;
        mark1:
            ok = true;
            SexItem = QInputDialog::getItem(this,"新建用户","请选择性别",
                                                    SexItems,0,false,&ok);
            if(!ok) return;
            if(SexItem.isEmpty())
            {
                QMessageBox::about(this,"提示","请重新选择");
                goto mark1;
            }
            if(SexItem == QString("男")) sexChosen = "0";
            else sexChosen = "1";

            QString sql = QString("insert into user values(null,'%1',%2)").arg(text).arg(sexChosen);
            QSqlQuery query(sql);
            addMenuList();
            userinfo = new UserInfo(text,sexChosen.toInt());
            DrawMainWindow(text,sexChosen.toInt());
        }
    }
    void on_buttondelete_clicked();
    void on_showresult_clicked();
};



#endif // MAINWINDOW_H
