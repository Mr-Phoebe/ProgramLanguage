#include "window.h"
#include "ui_window.h"

Window::Window(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::Window)
{
    QGridLayout *grid = new QGridLayout;//网络布局
    grid->addWidget(createFirstExclusiveGroup(), 0, 0);
    //添加复选框到（0，0）位置
    grid->addWidget(createSecondExclusiveGroup(), 1, 0);
    grid->addWidget(createNonExclusiveGroup(), 0, 1);
    grid->addWidget(createPushButtonGroup(), 1, 1);
    setLayout(grid);//使布局管理器grid成为成为当前部件的布局
    setWindowTitle(tr("Group Boxes"));//窗口标题
    resize(480, 320);//设置窗口大小
}

Window::~Window()
{
    delete ui;
}

QGroupBox *Window::createFirstExclusiveGroup()
{
    //声明一个组框
    QGroupBox *groupBox = new QGroupBox(tr("Exclusive Radio Buttons"));
    //声明三个单选按钮，任意时刻只有一个被选中
    QRadioButton *radio1 = new QRadioButton(tr("&Radio button 1"));
    QRadioButton *radio2 = new QRadioButton(tr("R&adio button 2"));
    QRadioButton *radio3 = new QRadioButton(tr("Ra&dio button 3"));
    radio1->setChecked(true);// radio1默认使能

    QVBoxLayout *vbox = new QVBoxLayout;//纵向布局管理器
    vbox->addWidget(radio1);
    vbox->addWidget(radio2);
    vbox->addWidget(radio3);
    // spacer项目（或者叫“stretch”），它占满按钮下方的空间，
    //确保这些按钮处在他们所在布局的上方。
    vbox->addStretch(1);
    groupBox->setLayout(vbox);

    return groupBox;
}


QGroupBox *Window::createSecondExclusiveGroup()
{
    QGroupBox *groupBox = new QGroupBox(tr("E&xclusive Radio Buttons"));
    groupBox->setCheckable(true);//组框使能选择钮开启
    //The second group box is itself checkable

    groupBox->setChecked(false);//初始化使能状态
    //声明三个单选按钮，任意时刻只有一个被选中
    QRadioButton *radio1 = new QRadioButton(tr("Rad&io button 1"));
    QRadioButton *radio2 = new QRadioButton(tr("Radi&o button 2"));
    QRadioButton *radio3 = new QRadioButton(tr("Radio &button 3"));
    radio1->setChecked(true); // radio1默认使能
    QCheckBox *checkBox = new QCheckBox(tr("Ind&ependent checkbox"));
    checkBox->setChecked(true);// 复选框使能


    QVBoxLayout *vbox = new QVBoxLayout; //纵向布局管理器
    vbox->addWidget(radio1);
    vbox->addWidget(radio2);
    vbox->addWidget(radio3);
    vbox->addWidget(checkBox);
    vbox->addStretch(1);
    groupBox->setLayout(vbox);
    return groupBox;
}


QGroupBox *Window::createNonExclusiveGroup()
{
    QGroupBox *groupBox = new QGroupBox(tr("Non-Exclusive Checkboxes"));
    groupBox->setFlat(true);//平面组框


    QCheckBox *checkBox1 = new QCheckBox(tr("&Checkbox 1"));
    QCheckBox *checkBox2 = new QCheckBox(tr("C&heckbox 2"));
    checkBox2->setChecked(true);
    QCheckBox *tristateBox = new QCheckBox(tr("Tri-&state button"));
    tristateBox->setTristate(true);//三态使能
    tristateBox->setCheckState(Qt::PartiallyChecked);
    //partially checked.介于Qt::Unchecked和Qt::Checked之间

    QVBoxLayout *vbox = new QVBoxLayout;
    vbox->addWidget(checkBox1);
    vbox->addWidget(checkBox2);
    vbox->addWidget(tristateBox);
    vbox->addStretch(1);
    groupBox->setLayout(vbox);
    return groupBox;
}


QGroupBox *Window::createPushButtonGroup()
{
    QGroupBox *groupBox = new QGroupBox(tr("&Push Buttons"));
    groupBox->setCheckable(true);
    groupBox->setChecked(true);


    QPushButton *pushButton = new QPushButton(tr("&Normal Button"));
    QPushButton *toggleButton = new QPushButton(tr("&Toggle Button"));
    toggleButton->setCheckable(true);//拴属性使能,即二稳态按钮
    toggleButton->setChecked(true);
    QPushButton *flatButton = new QPushButton(tr("&Flat Button"));
    flatButton->setFlat(true);//平面按钮


    QPushButton *popupButton = new QPushButton(tr("Pop&up Button"));
    QMenu *menu = new QMenu(this);
    menu->addAction(tr("&First Item"));
    menu->addAction(tr("&Second Item"));
    menu->addAction(tr("&Third Item"));
    menu->addAction(tr("F&ourth Item"));
    popupButton->setMenu(menu);//按钮上增加菜单
    QAction *newAction = menu->addAction(tr("Submenu"));
    QMenu *subMenu = new QMenu(tr("Popup Submenu"));
    subMenu->addAction(tr("Item 1"));
    subMenu->addAction(tr("Item 2"));
    subMenu->addAction(tr("Item 3"));
    newAction->setMenu(subMenu);
    //QAction类提供了一个可以同时出现在菜单和工具条上的抽象用户界面操作
    QVBoxLayout *vbox = new QVBoxLayout;
    vbox->addWidget(pushButton);
    vbox->addWidget(toggleButton);
    vbox->addWidget(flatButton);
    vbox->addWidget(popupButton);
    vbox->addStretch(1);
    groupBox->setLayout(vbox);
    return groupBox;
}
