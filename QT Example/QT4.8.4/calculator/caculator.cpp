#include "caculator.h"
#include "ui_caculator.h"
#include <QtGui>

caculator::caculator(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::caculator)
{
//    ui->setupUi(this);
    createActions();
    createMenus();

    //button of mainwidget
    mainWidget = new QWidget;
    createMainWidget();
    setCentralWidget(mainWidget);

    //initialization
    dot = false;
    caculToNum = false;
    showEdit = "0.";
    caculSign = '\0';
    result = temp = "";
    //value of register
    regResult = "";

    //set widget's title and fixed size
    setWindowTitle(tr("Simple caculator"));
    setWindowIcon(QIcon(":/images/icon.jpg"));
    setFixedSize(mainWidget->sizeHint().width(), mainWidget->sizeHint().height());
}

caculator::~caculator()
{
    delete ui;
}

void caculator::createActions()
{
    aboutAction = new QAction(tr("&About caculator"), this);
    connect(aboutAction, SIGNAL(triggered()),
            this, SLOT(about()));

    aboutQtAction = new QAction(tr("About &Qt"), this);
    connect(aboutQtAction, SIGNAL(triggered()),
            qApp, SLOT(aboutQt()));
    /*
     *button没有 triggered和activated的。
     *clicked 一般指点击、按下
     *triggered 一般是QAction等被触发
     *activated 一般指控件被激活等（激活原因可以有很多）
     */
}

void caculator::createMenus()
{
    helpMenu = menuBar()->addMenu(tr("&Help"));
    helpMenu->addAction(aboutAction);
    helpMenu->addAction(aboutQtAction);
}

void caculator::createMainWidget()
{   //set show edit property
    lineEdit = new QLineEdit(tr("0."));
    lineEdit->setFixedSize(246, 27);
    lineEdit->setAlignment(Qt::AlignRight);
    lineEdit->setMaxLength(19);
    lineEdit->setReadOnly(true);
    /*
     *QTextEdit设置 setEnable(false)后滚动框出现但滚动条消失，无法滚动。如果是想不让其中的内容被人为修改，应该用setReadOnly(true);来代替。
     */
    QFont font = lineEdit->font();
    font.setPointSize(font.pointSize() + 8);
    lineEdit->setFont(font);

    //set second line widget
    emptyButton = new QPushButton(tr(""));
    emptyButton->setFixedSize(35, 25);
    emptyButton->setEnabled(false);
    //set color of palette
    QPalette palRed;
    palRed.setColor(QPalette::ButtonText,QColor(255, 0, 0));
    QPalette palBlue;
    palBlue.setColor(QPalette::ButtonText,QColor(0, 0, 255));

    backSpaceButton = new QPushButton(tr("Backspace"));
    backSpaceButton->setFixedSize(65, 25);
    backSpaceButton->setPalette(palRed);
    connect(backSpaceButton, SIGNAL(clicked()),
            this, SLOT(on_backSpaceButton()));

    ceButton = new QPushButton(tr("CE"));
    ceButton->setFixedSize(65, 25);
    ceButton->setPalette(palRed);
    connect(ceButton, SIGNAL(clicked()),
            this, SLOT(on_ceButton()));


    cButton = new QPushButton(tr("C"));
    cButton->setFixedSize(65, 25);
    cButton->setPalette(palRed);
    connect(cButton, SIGNAL(clicked()),
            this, SLOT(on_cButton()));

    QHBoxLayout *secondLayout = new QHBoxLayout;
    secondLayout->addWidget(emptyButton);
    secondLayout->addWidget(backSpaceButton);
    secondLayout->addWidget(ceButton);
    secondLayout->addWidget(cButton);

    //set third line widget
    mcButton = new QPushButton(tr("MC"));
    mcButton->setFixedSize(35, 25);
    mcButton->setPalette(palRed);
    connect(mcButton, SIGNAL(clicked()),
            this, SLOT(on_mcButton()));

    sevenButton = new QPushButton(tr("7"));
    sevenButton->setFixedSize(35, 25);
    sevenButton->setPalette(palBlue);
    sevenButton->setShortcut(tr("7"));  //bind number 7 key
    connect(sevenButton, SIGNAL(clicked()),
            this, SLOT(on_sevenButton()));

    eightButton = new QPushButton(tr("8"));
    eightButton->setFixedSize(35, 25);
    eightButton->setPalette(palBlue);
    eightButton->setShortcut(tr("8"));
    connect(eightButton, SIGNAL(clicked()),
            this, SLOT(on_eightButton()));

    nineButton = new QPushButton(tr("9"));
    nineButton->setFixedSize(35, 25);
    nineButton->setPalette(palBlue);
    nineButton->setShortcut(tr("9"));
    connect(nineButton, SIGNAL(clicked()),
            this, SLOT(on_nineButton()));

    divideButton = new QPushButton(tr("/"));
    divideButton->setFixedSize(35, 25);
    divideButton->setPalette(palRed);
    divideButton->setShortcut(tr("/"));
    connect(divideButton, SIGNAL(clicked()),
            this, SLOT(on_divideButton()));

    sqrtButton = new QPushButton(tr("sqrt"));
    sqrtButton->setFixedSize(35, 25);
    sqrtButton->setPalette(palBlue);
    connect(sqrtButton, SIGNAL(clicked()),
            this, SLOT(on_sqrtButton()));

    QHBoxLayout *thirdLayout = new QHBoxLayout;
    thirdLayout->addWidget(mcButton);
    thirdLayout->addWidget(sevenButton);
    thirdLayout->addWidget(eightButton);
    thirdLayout->addWidget(nineButton);
    thirdLayout->addWidget(divideButton);
    thirdLayout->addWidget(sqrtButton);

    //set fourth line widget
    mrButton = new QPushButton(tr("MR"));
    mrButton->setFixedSize(35, 25);
    mrButton->setPalette(palRed);
    connect(mrButton, SIGNAL(clicked()),
            this, SLOT(on_mrButton()));

    fourButton = new QPushButton(tr("4"));
    fourButton->setFixedSize(35, 25);
    fourButton->setPalette(palBlue);
    fourButton->setShortcut(tr("4"));
    connect(fourButton, SIGNAL(clicked()),
            this, SLOT(on_fourButton()));

    fiveButton = new QPushButton(tr("5"));
    fiveButton->setFixedSize(35, 25);
    fiveButton->setPalette(palBlue);
    fiveButton->setShortcut(tr("5"));
    connect(fiveButton, SIGNAL(clicked()),
            this, SLOT(on_fiveButton()));

    sixButton = new QPushButton(tr("6"));
    sixButton->setFixedSize(35, 25);
    sixButton->setPalette(palBlue);
    sixButton->setShortcut(tr("6"));
    connect(sixButton, SIGNAL(clicked()),
            this, SLOT(on_sixButton()));

    multipButton = new QPushButton(tr("*"));
    multipButton->setFixedSize(35, 25);
    multipButton->setPalette(palRed);
    multipButton->setShortcut(tr("*"));
    connect(multipButton, SIGNAL(clicked()),
            this, SLOT(on_multipButton()));

    modButton = new QPushButton(tr("%"));
    modButton->setFixedSize(35, 25);
    modButton->setPalette(palBlue);
    connect(modButton, SIGNAL(clicked()),
            this, SLOT(on_modButton()));

    QHBoxLayout *fourLayout = new QHBoxLayout;
    fourLayout->addWidget(mrButton);
    fourLayout->addWidget(fourButton);
    fourLayout->addWidget(fiveButton);
    fourLayout->addWidget(sixButton);
    fourLayout->addWidget(multipButton);
    fourLayout->addWidget(modButton);

    //set five line widget
    msButton = new QPushButton(tr("MS"));
    msButton->setFixedSize(35, 25);
    msButton->setPalette(palRed);
    connect(msButton, SIGNAL(clicked()),
            this, SLOT(on_msButton()));

    oneButton = new QPushButton(tr("1"));
    oneButton->setFixedSize(35, 25);
    oneButton->setPalette(palBlue);
    oneButton->setShortcut(tr("1"));
    connect(oneButton, SIGNAL(clicked()),
            this, SLOT(on_oneButton()));

    twoButton = new QPushButton(tr("2"));
    twoButton->setFixedSize(35, 25);
    twoButton->setPalette(palBlue);
    twoButton->setShortcut(tr("2"));
    connect(twoButton, SIGNAL(clicked()),
            this, SLOT(on_twoButton()));

    threeButton = new QPushButton(tr("3"));
    threeButton->setFixedSize(35, 25);
    threeButton->setPalette(palBlue);
    threeButton->setShortcut(tr("3"));
    connect(threeButton, SIGNAL(clicked()),
            this, SLOT(on_threeButton()));

    subButton = new QPushButton(tr("-"));
    subButton->setFixedSize(35, 25);
    subButton->setPalette(palRed);
    subButton->setShortcut(tr("-"));
    connect(subButton, SIGNAL(clicked()),
            this, SLOT(on_subButton()));

    recipButton = new QPushButton(tr("1/x"));
    recipButton->setFixedSize(35, 25);
    recipButton->setPalette(palBlue);
    connect(recipButton, SIGNAL(clicked()),
            this, SLOT(on_recipButton()));

    QHBoxLayout *fiveLayout = new QHBoxLayout;
    fiveLayout->addWidget(msButton);
    fiveLayout->addWidget(oneButton);
    fiveLayout->addWidget(twoButton);
    fiveLayout->addWidget(threeButton);
    fiveLayout->addWidget(subButton);
    fiveLayout->addWidget(recipButton);

    //set sixth line widget
    mPlusButton = new QPushButton(tr("M+"));
    mPlusButton->setFixedSize(35, 25);
    mPlusButton->setPalette(palRed);
    connect(mPlusButton, SIGNAL(clicked()),
            this, SLOT(on_mPlusButton()));

    zeroButton = new QPushButton(tr("0"));
    zeroButton->setFixedSize(35, 25);
    zeroButton->setPalette(palBlue);
    zeroButton->setShortcut(tr("0"));
    connect(zeroButton, SIGNAL(clicked()),
            this, SLOT(on_zeroButton()));

    signButton = new QPushButton(tr("+/-"));
    signButton->setFixedSize(35, 25);
    signButton->setPalette(palBlue);
    connect(signButton, SIGNAL(clicked()),
            this, SLOT(on_signButton()));

    dotButton = new QPushButton(tr("."));
    dotButton->setFixedSize(35, 25);
    dotButton->setPalette(palBlue);
    dotButton->setShortcut(tr("."));
    connect(dotButton, SIGNAL(clicked()),
            this, SLOT(on_dotButton()));

    plusButton = new QPushButton(tr("+"));
    plusButton->setFixedSize(35, 25);
    plusButton->setPalette(palRed);
    plusButton->setShortcut(tr("+"));
    connect(plusButton, SIGNAL(clicked()),
            this, SLOT(on_plusButton()));

    equalButton = new QPushButton(tr("="));
    equalButton->setFixedSize(35, 25);
    equalButton->setPalette(palRed);
    equalButton->setShortcut(tr("Enter"));
    connect(equalButton, SIGNAL(clicked()),
            this, SLOT(on_equalButton()));

    QHBoxLayout *sixLayout = new QHBoxLayout;
    sixLayout->addWidget(mPlusButton);
    sixLayout->addWidget(zeroButton);
    sixLayout->addWidget(signButton);
    sixLayout->addWidget(dotButton);
    sixLayout->addWidget(plusButton);
    sixLayout->addWidget(equalButton);

    //main layout
    QVBoxLayout *mainLayout = new QVBoxLayout;
    mainLayout->addWidget(lineEdit);
    mainLayout->addLayout(secondLayout);
    mainLayout->addLayout(thirdLayout);
    mainLayout->addLayout(fourLayout);
    mainLayout->addLayout(fiveLayout);
    mainLayout->addLayout(sixLayout);
    mainWidget->setLayout(mainLayout);
}

void caculator::digitNum(int num)
{   //haven't input number
    if(showEdit == "0.")
    {   //whether press dot
        if(dot == false)
            showEdit = QString::number(num)+".";
        else
            showEdit.append(QString::number(num));
    }
    else
        if(showEdit.length() < 16)
        {
            if(dot == false)
            {
                showEdit.insert(showEdit.length()-1, QString::number(num));
            }
            else
            {
                showEdit.insert(showEdit.length()-1, QString::number(num));//连接 和 插入
                //showEdit.append(QString::number(num));//miao
            }
        }
    caculToNum = false;
    lineEdit->setText(showEdit);
}

//private slots
void caculator::about()
{
    QTextCodec *tc = QTextCodec::codecForName("GBK");//文字的编码方式
    QTextCodec::setCodecForTr(tc);
    QMessageBox::about(this, tr("About Qt caculator"),
                       tr("<h2>Qt caculator 1.0 </h2>"
                       "<p>Qt caculator is a small application that "
                       "demonstrates QAction, QMainWinodow, QWidget, "
                       "QMenuBar, QPushButton, QLineEdit,  and many "
                       "other Qt classes.</p>"));
}

void caculator::on_backSpaceButton()
{
    if(showEdit != "0.")
    {   //one number that could is negative or positive
        if((showEdit.length() == 3 && showEdit.at(0) == '-')
         || showEdit.length() == 2)
        {   //clear this step
            on_ceButton();
        }
        else
        {
            if(showEdit.at(showEdit.length()-1) != '.')
                showEdit.remove(showEdit.length()-1, 1);
            else
                showEdit.remove(showEdit.length()-2, 1);
        }

        lineEdit->setText(showEdit);
    }
}

//clear temp status
void caculator::on_ceButton()
{
    dot = false;
    caculToNum = false;
    temp = "";
    showEdit = "0.";
    lineEdit->setText(showEdit);
}
//clear all status
void caculator::on_cButton()
{
    dot = false;
    caculToNum = false;
    caculSign = '\0';
    result = temp = "";
    showEdit = "0.";
    lineEdit->setText(showEdit);
}
//clear register
void caculator::on_mcButton()
{
    regResult = "";
    emptyButton->setText("");
}

void caculator::on_sevenButton()
{
    digitNum(7);
}

void caculator::on_eightButton()
{
    digitNum(8);
}

void caculator::on_nineButton()
{
    digitNum(9);
}

void caculator::on_divideButton()
{
    on_equalButton();
    caculSign = '/';
}

void caculator::on_sqrtButton()
{
    if(showEdit.toDouble() >= 0)
    {
        double res = sqrt(showEdit.toDouble());
        showEdit = QString::number(res);
        if(!showEdit.contains('.'))
            showEdit.append(".");
        lineEdit->setText(showEdit);
    }
    else
    {
        on_cButton();
        lineEdit->setText("Input Error!");
    }
    dot = false;
}

void caculator::on_mrButton()
{
    if(!regResult.isEmpty())
    {
        result = regResult;
        if(!regResult.contains('.'))
            regResult.append(".");
        lineEdit->setText(regResult);

        showEdit = "0.";
        dot = false;
        caculToNum = true;
    }
}

void caculator::on_fourButton()
{
    digitNum(4);
}

void caculator::on_fiveButton()
{
    digitNum(5);
}

void caculator::on_sixButton()
{
    digitNum(6);
}

void caculator::on_multipButton()
{
    on_equalButton();
    caculSign = '*';
}

void caculator::on_modButton()
{
}

void caculator::on_msButton()
{
    if(lineEdit->text().toDouble() != 0)
    {
        regResult = lineEdit->text();
        emptyButton->setText("M");
    }
}

void caculator::on_oneButton()
{
    digitNum(1);
}

void caculator::on_twoButton()
{
    digitNum(2);
}

void caculator::on_threeButton()
{
    digitNum(3);
}

void caculator::on_subButton()
{
    on_equalButton();
    caculSign = '-';
}

void caculator::on_recipButton()
{
    if(showEdit.toDouble() != 0)
    {
        double res = 1.0/showEdit.toDouble();
        showEdit = QString::number(res);
        if(!showEdit.contains('.'))
            showEdit.append(".");
        lineEdit->setText(showEdit);
    }
    else
    {
        on_cButton();
        lineEdit->setText("Input Error!");
    }
    dot = false;
}

void caculator::on_mPlusButton()
{
    if(regResult.isEmpty() && lineEdit->text().toDouble() != 0)
    {
        regResult = lineEdit->text();
        emptyButton->setText("M");
    }
    else
        if(!regResult.isEmpty() && lineEdit->text().toDouble() != 0)
        {
            QString regTemp = lineEdit->text();
            double res = regResult.toDouble() + regTemp.toDouble();
            if(res != 0)
                regResult = QString::number(res);
            else
                on_mcButton();
        }
}

void caculator::on_zeroButton()
{
    digitNum(0);
}

void caculator::on_signButton()
{
    if(showEdit != "0.")
    {
        if(showEdit.at(0) != '-')
            showEdit.insert(0, "-");
        else
            showEdit.remove(0, 1);
        lineEdit->setText(showEdit);
    }
}

void caculator::on_dotButton()
{
    if(dot == false)
        dot = true;
}

void caculator::on_plusButton()
{
    on_equalButton();
    caculSign = '+';
}

void caculator::on_equalButton()
{
    if(result.isEmpty())
        result = showEdit;
    else  //result isn't empty, and now step isn't press on number
        if(caculToNum == false)
            temp = showEdit;

    double res;
    bool flag = false;
    if(!temp.isEmpty() && caculToNum == false)
    {
        switch(caculSign.toAscii())
        {
        case '/':
            if(temp.toDouble() != 0)
                res = result.toDouble() / temp.toDouble();
            else
                flag = true;
            break;
        case '*':
            res = result.toDouble() * temp.toDouble();
            break;
        case '-':
            res = result.toDouble() - temp.toDouble();
            break;
        case '+':
            res = result.toDouble() + temp.toDouble();
            break;
        }

        if(flag)
        {
            on_cButton();
            lineEdit->setText("Input Error!");
        }
        else
        {
            result = QString::number(res);
            if(!result.contains('.'))
                result.append(".");
            lineEdit->setText(result);
        }
    }

    showEdit = "0.";
    dot = false;
    caculToNum = true;
}

