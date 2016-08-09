#include "showwidget.h"
#include "ui_showwidget.h"

ShowWidget::ShowWidget(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::ShowWidget)
{
    ui->setupUi(this);
    gridlayout = new QGridLayout();
    gridlayout->setSpacing(2);
    gridlayout->setMargin(2);
    gridlayout->setSizeConstraint(QLayout::SetFixedSize);
    this->setWindowFlags(Qt::WindowCloseButtonHint);
    this->setWindowIcon(QIcon(":/new/prefix1/Mico"));
    this->setLayout(gridlayout);
}

ShowWidget::~ShowWidget()
{
    delete ui;
}

void ShowWidget::makeTable(int n)
{
    Table* gentmp = new Table();
    table = *gentmp;
    table.n = n;
    if(n % 2 == 1)
    {
        table = Jishu(table);
    }
    else if(n % 4 == 0)
    {
        table = Shuangoushu(table);
    }
    else
    {
        table = Danoushu(table);
    }
}

Table ShowWidget::Jishu(Table t)
{
    int i,j,k;
    i = 0;
    j = t.n/2;
    for(k=1;k<=t.n*t.n;k++)
    {
        t.data[i][j] = k;
        i--;
        j--;
        if(k%t.n == 0)
        {
            i+=2;
            j++;
        }
        else
        {
            if(i < 0) i += t.n;
            if(j < 0) j += t.n;
        }
    }
    return t;
}

Table ShowWidget::Shuangoushu(Table t)
{
    int i,j;
    for(i=0;i<t.n/2;i++)
    {
        for(j=0;j<t.n/2;j++)
        {
            if(i%2 == 0)
            {
                if(j%2 == 0) t.data[i][j] = 0;
                else t.data[i][j] = 1;
            }
            else
            {
                if(j%2 == 1) t.data[i][j] = 0;
                else t.data[i][j] = 1;
            }
        }
        for(j = t.n/2;j<t.n;j++)
        {
            if(i%2 == 0)
            {
                if(j%2 == 1) t.data[i][j] = 0;
                else t.data[i][j] = 1;
            }
            else
            {
                if(j%2 == 0) t.data[i][j] = 0;
                else t.data[i][j] = 1;
            }
        }
    }

    for(i = t.n/2;i<t.n;i++)
    {
        for(j=0;j<t.n/2;j++)
        {
            if(i%2 == 0)
            {
                if(j%2 == 1) t.data[i][j] = 0;
                else t.data[i][j] = 1;
            }
            else
            {
                if(j%2 == 0) t.data[i][j] = 0;
                else t.data[i][j] = 1;
            }
        }
        for(j = t.n/2;j<t.n;j++)
        {
            if(i%2 == 0)
            {
                if(j%2 == 0) t.data[i][j] = 0;
                else t.data[i][j] = 1;
            }
            else
            {
                if(j%2 == 1) t.data[i][j] = 0;
                else t.data[i][j] = 1;
            }
        }
    }

    for(i=0;i<t.n;i++)
        for(j=0;j<t.n;j++)
            if(t.data[i][j] == 1) t.data[i][j] = i*t.n+j+1;

    for(i=t.n-1;i>=0;i--)
        for(j=t.n-1;j>=0;j--)
            if(t.data[i][j] == 0) t.data[i][j] = (t.n-1-i)*t.n+(t.n-1-j)+1;

    return t;
}

Table ShowWidget::first(Table t)
{
    Table tmp;
    tmp.n = t.n;
    int i,j;
    for(i=0;i<t.n/2;i++)
        for(j=0;j<t.n/2;j++)
            tmp.data[i][j] = t.data[i][j]+(t.n/2)*(t.n/2);
    return tmp;
}

Table ShowWidget::Danoushu(Table t)
{
    Table A,B,C,D;
    int i,j;
    A.n = t.n/2;
    A = Jishu(A);
    A.n = t.n;
    B = first(A);
    C = first(B);
    D = first(C);
    A.n = t.n/2;

    for(i=0;i<t.n/4;i++)
        for(j=t.n/2-1;j>t.n/4;j--) qSwap(A.data[i][j],D.data[i][j]);

    for(j=t.n/2-2;j>t.n/4-1;j--)
            qSwap(A.data[t.n/4][j],D.data[t.n/4][j]);

    for(i=t.n/4+1;i<t.n/2;i++)
        for(j=t.n/2-1;j>t.n/4;j--)
            qSwap(A.data[i][j],D.data[i][j]);

    for(i=0;i<t.n/2;i++)
        for(j=0;j<t.n/4-1;j++)
            qSwap(B.data[i][j],C.data[i][j]);

    for(i=0;i<t.n/2;i++)//将四个数组A1,B1,C1,D1连起来构成魔方阵matrix1
    {
        for(j=0;j<t.n/2;j++)
            t.data[i][j]=A.data[i][j];
        for(j=t.n/2;j<t.n;j++)
            t.data[i][j]=C.data[i][j-t.n/2];
    }
    for(i=t.n/2;i<t.n;i++)
    {
        for(j=0;j<t.n/2;j++)
            t.data[i][j]=D.data[i-t.n/2][j];
        for(j=t.n/2;j<t.n;j++)
            t.data[i][j]=B.data[i-t.n/2][j-t.n/2];
    }
    return t;
}

void ShowWidget::DisplayAnswer()
{
    Table t = this->table;

    QLayoutItem *child;
    while((child = gridlayout->takeAt(0)) != 0)
    {
        delete child->widget();
        delete child;
    }

    for(int i=0;i<t.n;i++)
        for(int j=0;j<t.n;j++)
        {
            QLabel *label = new QLabel();
            QPixmap pmap(":/new/prefix1/Back");
            QPainter painter1;
            QFont font1("Arial",13,QFont::Bold,false);
            QFont font2("Arial",9,QFont::Bold,false);
            painter1.begin(&pmap);
            if(t.n<10) painter1.setFont(font1);
            else painter1.setFont(font2);
            painter1.setPen(Qt::blue);
            painter1.drawText(3,3,20,20,Qt::AlignCenter,QString::number(t.data[i][j],10));//将数字转化成输出
            painter1.end();
            label->setPixmap(pmap);
            gridlayout->addWidget(label,i,j);
        }

    this->setWindowTitle(QString::number(t.n,10) + tr("阶魔方阵"));
    this->show();
}

Table::Table()
{
    n = 0;
    for(int i=0;i<15;i++)
        for(int j=0;j<15;j++)
            data[i][j] = 0;
}
