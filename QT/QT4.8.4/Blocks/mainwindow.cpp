#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    this->setMaximumSize(400,200);
    this->setMinimumSize(400,200);
    this->setWindowIcon(QIcon(":/new/prefix1/Mico"));
    this->setWindowFlags(Qt::WindowCloseButtonHint);
    this->setWindowTitle(" ");
    this->setObjectName("mainWindow");
    this->setStyleSheet("#mainWindow{border-image:url(:/new/prefix1/Main);}");//背景，加#号阻止继承

    QFont font("Arial",9,QFont::Bold,false);//字体
    QPalette pa;                            //颜色
    pa.setColor(QPalette::WindowText,Qt::blue);

    label = new QLabel(tr("在下面输入N(0<N<=15)"),this);
    label->setGeometry(50,15,200,20);
    label->setFont(font);
    label->setPalette(pa);

    lineEdit = new QLineEdit(this);
    lineEdit->setGeometry(50,40,180,40);
    lineEdit->setMaxLength(2);

    label2 = new QLabel(tr("给我出来！"),this);
    label2->setGeometry(110,100,70,50);
    label2->setFont(font);
    label2->setPalette(pa);

    button = new Button(this);
    button->setButtonPicture(QPixmap(":/new/prefix1/ButtonUp"));
    button->set_X_Y_width_height(50,100,50,50);
    button->setPressPicture(QPixmap(":/new/prefix1/ButtonDown"));
    button->setReleasePicture(QPixmap(":/new/prefix1/ButtonUp"));
    connect(button,SIGNAL(clicked()),this,SLOT(generateBlocks()));
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::generateBlocks()//信号与槽的参数必须一样
{
    int value = this->lineEdit->text().toInt();
    //qWarning("%d",value);
    if(value < 1 || value > 15)
    {
        QMessageBox::about(this,QString("提示"),QString(tr("输入错误，请重新输入！")));
    }
    else
    {
        if(value == 2)QMessageBox::about(this,QString(tr("提示")),QString(tr("N=2时没有魔方阵！")));
        else
        {
            showblocks.makeTable(value);
            showblocks.DisplayAnswer();
        }
    }
}

Button::Button(QWidget *parent) : QPushButton(parent)
{
    buttonPicture = new QPixmap();
    pressPicture = new QPixmap();
    releasePicture = new QPixmap();
    this->setFlat(true);
}

Button::~Button()
{

}

void Button::set_X_Y_width_height(int x, int y, int width, int height)
{
    this -> setIconSize(QSize(width, height));
    this -> setGeometry(x, y, width, height);
}

void Button::setButtonPicture(QPixmap pic)
{
    *buttonPicture = pic;
    this->setIcon(QIcon(*buttonPicture));
}

void Button::setPressPicture(QPixmap pic)
{
    *pressPicture = pic;
}

void Button::setReleasePicture(QPixmap pic)
{
    *releasePicture = pic;
}
//override
void Button::mouseDoubleClickEvent(QMouseEvent *e)
{

}

void Button::mouseMoveEvent(QMouseEvent *e)
{

}

void Button::mousePressEvent(QMouseEvent *e)
{
    this->setIcon(QIcon(*pressPicture));
}

void Button::mouseReleaseEvent(QMouseEvent *e)
{
    this->setIcon(QIcon(*releasePicture));
    emit clicked();
}
