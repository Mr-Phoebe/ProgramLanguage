#ifndef SHOWWIDGET_H
#define SHOWWIDGET_H

#include <QWidget>
#include <QLabel>
#include <QGridLayout>
#include <QString>
#include <QFont>
#include <QPainter>
#include <QPixmap>

namespace Ui {
class ShowWidget;
}

class Table
{
public:
    Table();
    int n;
    int data[15][15];
};

class ShowWidget : public QWidget
{
    Q_OBJECT

public:
    explicit ShowWidget(QWidget *parent = 0);
    ~ShowWidget();

    void makeTable(int n);
    Table Jishu(Table t);
    Table Shuangoushu(Table t);
    Table Danoushu(Table t);
    Table first(Table t);
    void DisplayAnswer();
private:
    QGridLayout *gridlayout;
    Table table;
    Ui::ShowWidget *ui;
};



#endif // SHOWWIDGET_H
