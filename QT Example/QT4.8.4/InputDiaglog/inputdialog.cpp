#include "inputdialog.h"
#include "ui_inputdialog.h"

InputDialog::InputDialog(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::InputDialog)
{
    setWindowTitle(tr("Input Dialog"));

        //创建各种标签对象
    label1=new QLabel(tr("Name"));
    label2=new QLabel(tr("Sex"));
    label3=new QLabel(tr("Age"));
    label4=new QLabel(tr("Stature"));

        //创建各种显示标签
    nameLabel=new QLabel(tr("LiMing"));
    sexLabel=new QLabel(tr("F"));
    ageLabel=new QLabel(tr("12"));
    statureLabel=new QLabel(tr("123"));

        //创建各种修改按钮
    nameButton=new QPushButton(tr("Modify"));
    sexButton=new QPushButton(tr("Modify"));
    ageButton=new QPushButton(tr("Modify"));
    statureButton=new QPushButton(tr("Modify"));

        //布局管理
    QGridLayout *layout=new QGridLayout(this);

    layout->addWidget(label1,0,0);
    layout->addWidget(nameLabel,0,1);
    layout->addWidget(nameButton,0,2);

    layout->addWidget(label2,1,0);
    layout->addWidget(sexLabel,1,1);
    layout->addWidget(sexButton,1,2);

    layout->addWidget(label3,2,0);
    layout->addWidget(ageLabel,2,1);
    layout->addWidget(ageButton,2,2);

    layout->addWidget(label4,3,0);
    layout->addWidget(statureLabel,3,1);
    layout->addWidget(statureButton,3,2);

    setLayout(layout);

        //信号处理
    connect(nameButton,SIGNAL(clicked()),this,SLOT(slotName()));
    connect(sexButton,SIGNAL(clicked()),this,SLOT(slotSex()));
    connect(ageButton,SIGNAL(clicked()),this,SLOT(slotAge()));
    connect(statureButton,SIGNAL(clicked()),this,SLOT(slotStature()));

}

InputDialog::~InputDialog()
{
    delete ui;
}

void InputDialog::slotAge()
{
    bool ok;
    int age=QInputDialog::getInteger(this,tr("User Age"),tr("Please input your age"),ageLabel->text().toInt(),0,100,1,&ok);

    if (ok)
    {
        ageLabel->setText(QString(tr("%1")).arg(age));//QString::arg()函数用第一个arg()调用会替换“％1”，第2个arg()调用会替换“％2”。上面的
    }
}

void InputDialog::slotSex()
{
    QStringList list;
    list<<tr("male")<<tr("female");
    bool ok;
    QString sex=QInputDialog::getItem(this,tr("Sex"),tr("Please select your sex"),list,0,false,&ok);
    if(ok)
    {
        sexLabel->setText(sex);
    }
}

void InputDialog::slotName()
{
    bool ok;
    QString name=QInputDialog::getText(this,tr("User Name"),tr("Input your name"),QLineEdit::Normal,nameLabel->text(),&ok);
    if(ok&& !name.isEmpty())
    {
        nameLabel->setText(name);
    }
}

void InputDialog::slotStature()
{

    bool ok;
    double d=QInputDialog::getDouble(this,tr("User Stature"),tr("please input your stature"),170.00,0,200,2,&ok);
    if(ok)
    {
        statureLabel->setText(QString(tr("%1")).arg(d));
    }
}
