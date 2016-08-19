#include "qbuiltindlg.h"
#include "ui_qbuiltindlg.h"

QBuiltinDlg::QBuiltinDlg(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::QBuiltinDlg)
{
    displayTextEdit = new QTextEdit(tr("The standard text edit of QT"));
    QGridLayout* gridLayout = new QGridLayout;
/*
 *创建一个网格布局管理器QGridLayout对象，gridLayout布局管理器将会管理和排布所有的窗口部件。
 *接下来，创建7个QPushButton对象，这些对象分别用来控制颜色对话框、错误消息框、文件对话框、字体对话框、输入对话 框、页设置对话框、进度对话框和打印对话框的创建和显示。
 *然后调用QGridLayout::addWidget()函数，将所有的QPushButton以及QTextEdit窗口部件排布在网格布局管理器gridLayout中。
 *最后，函数QDialog::setLayout()将网格布局管理器gridLayout设置为内建对话框CBuiltinDlg对象的顶层布局管理器。
 */
    colorPushBtn	= new QPushButton(tr("Color Dialog"));
    errorPushBtn	= new QPushButton(tr("Error Message"));
    filePushBtn	= new QPushButton(tr("File Dialog"));
    fontPushBtn	= new QPushButton(tr("Front Dialog"));
    inputPushBtn	= new QPushButton(tr("Input Dialog"));
    pagePushBtn	= new QPushButton(tr("PageSet Dialog"));
    progressPushBtn = new QPushButton(tr("Process Dialog"));
    printPushBtn	= new QPushButton(tr("Printer Dialog"));
    gridLayout->addWidget(colorPushBtn, 0, 0, 1, 1);
    gridLayout->addWidget(errorPushBtn, 0, 1, 1, 1);
    gridLayout->addWidget(filePushBtn, 0, 2, 1, 1);
    gridLayout->addWidget(fontPushBtn, 1, 0, 1, 1);
    gridLayout->addWidget(inputPushBtn, 1, 1, 1, 1);
    gridLayout->addWidget(pagePushBtn, 1, 2, 1, 1);
    gridLayout->addWidget(progressPushBtn, 2, 0, 1, 1);
    gridLayout->addWidget(printPushBtn, 2, 1, 1, 1);
    gridLayout->addWidget(displayTextEdit, 3, 0, 3, 3);

/*
 *将所有的QPushButton对象的clicked()信号关联到内建对话框类CBuiltinDlg的槽函数doPushButton()，
 *即所有QPushButton对象的 单击操作都由统一的槽函数doPushButton()来处理。
*/
    connect(colorPushBtn, SIGNAL(clicked()), this, SLOT(doPushBtn()));
    connect(errorPushBtn, SIGNAL(clicked()), this, SLOT(doPushBtn()));
    connect(filePushBtn, SIGNAL(clicked()), this, SLOT(doPushBtn()));
    connect(fontPushBtn, SIGNAL(clicked()), this, SLOT(doPushBtn()));
    connect(inputPushBtn, SIGNAL(clicked()), this, SLOT(doPushBtn()));
    connect(pagePushBtn, SIGNAL(clicked()), this, SLOT(doPushBtn()));
    connect(progressPushBtn, SIGNAL(clicked()), this, SLOT(doPushBtn()));
    connect(printPushBtn, SIGNAL(clicked()), this, SLOT(doPushBtn()));

    setWindowTitle(tr("Builtin"));
    resize(400, 300);
    setLayout(gridLayout);
}

QBuiltinDlg::~QBuiltinDlg()
{
    delete ui;
}

void QBuiltinDlg::doPushBtn()
{
    /*
     *槽函数的开头，首先是获取发送信号的QPushButton对象的指针。函数QOjbect::sender()返回发送信号的对象的指针，返回类型 为QObject*。
     *模板函数 T qobject_cast(QObject* object)
     *完成类型的转换，将<QOjbect*>类型的对象指针转换为类型为<T   *>的对象指针，如果转换成功，返回正确的对象指针，否则 返回0。
     *类型T必须是直接或间接继承自QOjbect的类，并且在该类的定义里有Q_OBJECT宏变量（否则qobject_cast()函数的返回值是未定义的）。
     *此外，可以认为一个类继承自它自身。qobject_cast()模板函数的作用类似于标准C++的
     *dynamic_cast()模板函数，不过qobject_cast()不需要运行时类型信息（Run-Time Type Information, RTTI）的支持。
*/
    QPushButton* btn = qobject_cast<QPushButton*>(sender());
    /*
     *if()条件判断语句，判断发送信号的对象是否是相应的QPushButton对象（colorBtn、errorPushBtn等），如果是则创建 相应的Qt内建对话框并进行显示；
     *否则将会跳过该段代码，直到找到条件为true的if()条件语句。
     */
    if(btn == colorPushBtn)
    {// 颜色对话框.
        QPalette palette = displayTextEdit->palette();
        const QColor& color = QColorDialog::getColor(palette.color(QPalette::Base), this);
        if(color.isValid())
        {
            palette.setColor(QPalette::Base, color);
            displayTextEdit->setPalette(palette);

        }
    }
    /*
     *上面这段代码是颜色对话框的例子，它的功能是利用Qt内建的颜色对话框QColorDialog类获取用户选择的颜色，然后设置文本 编辑框的背景色。
     *函数QTextEdit::palette()获取文本编辑框对象displayTextEdit的调色板。
     *接下来，调用 QColorDialog::getColor()函数创建并显示一个模态的颜色对话框，并返回用户选择的颜色对象的常量引用（对时对象的引用是无效的，必须使用常量引用）赋给变量color；
     *如果用户单击“取消”按钮，颜色对话框将返回一个无效的颜色；
     *颜色对话框的颜色初始化为palette.color  (QPalette::Base)，即文本编辑框的背景色；父窗口部件为this。
     *QColor::isValid() 函数判断颜色对话框返回的颜色是否有效。如果颜色对话框返回的颜色是有效的，函数QPalette::setColor() 设 置调色板的背景颜色为颜色对话框返回的颜色。
     *此处的QPalette:: setColor() 函数具有2个参数，第1个参数QPalette::Base指定了调色板的角色，
     *告诉程序应该设置调色板的所有三个颜色组中的哪一个角色的颜色（该函数将会影响到所有的三个颜色组）；
     *第2个参数  color 指定应该设置的颜色。最后，函数QtextEdit::setPalette()重新设置文本编辑框的调色板。
*/
    else if(btn == errorPushBtn)
    {// 错误消息框.
        QErrorMessage box(this);
        box.setWindowTitle(tr("Error Message"));
        box.showMessage(tr("Error 1"));
        box.showMessage(tr("Error 2"));
        box.showMessage(tr("Error 3"));
        box.showMessage(tr("Error 4"));
        box.showMessage(tr("Error 5"));
        box.exec();
    }
    /*
     *该段代码是一个错误消息框的例子。在这个例子中，多次调用了QErrorMessage::showMessage()函数，该函数的功能是在错误消 息框中显示错误信息。
     *多次调用该函数，是为了演示显示不同错误信息、多个相同错误信息以及错误消息框的“再次显示这个消息”复选框选中与否的效果。
     *最后，执行QErrorMessage::exec()显示对话框。
     *此为“基于属性的”API方法
     */
    else if(btn == filePushBtn)
    {// 文件对话框.
        QString fileName = QFileDialog::getOpenFileName(this,tr("open the file"),"/home/czm",
                                                        tr("All files(*.*)"";;text files(*.txt)"";;XML files(*.xml)"));
        displayTextEdit->setText(fileName);
    }
    /*
     *该段代码打开一个文件对话框，获取用户选择的文件名并显示在文本编辑框中。此处，函数QFileDialog::getOpenFileName()具有4个参数。
     *其中，实参 this 指定文件对话框的父窗口部件；实参 tr("打开文件") 指定文件对话框的标题；
     *实参“/home/czm”指 定了文件对话框的默认路径；最后一个参数比较复杂，它指定了文件对话框的多个文件过滤器，过滤器之间通过两个分 号“;;”间隔。
     *如果用户选择了文件，并单击“确定”按钮，那么该文件对话框将返回用户选择的文件名；而如果用户单击“取消”按 钮，该对话框将返回一个NULL 字符串。
     */
    else if(btn == fontPushBtn)
    {// 字体对话框.
        bool ok;
        const QFont& font = QFontDialog::getFont(&ok, displayTextEdit->font(),this,tr("字体对话框"));
        if(ok)
        {// 如果<确定>,设置字体.
            displayTextEdit->setFont(font);
        }
    }
    /*
     *QFontDialog::getFont()   函数创建并显示一个字体对话框。此处，该函数具有四个参数：
     *第1个参数是一个输出参数，用于标识用 户的选择状态，如果用户单击“确定”按钮，该字体对话框将会设置ok变量为true；而如果用户单击“取消”按钮，ok将会被设置 为false。
     *第2个参数指定了对话框的初始颜色，当用户取消颜色的选择时，字体对话框将初始颜色作为返回值。
     *this参数指定了父窗口部件，最后一个参数指定了字体对话框的标题。
     */
    else if(btn == inputPushBtn)
    {// 输入对话框.
        bool ok;
        QString text = QInputDialog::getText(this,tr("InputDialog"),tr("Please Input text"),
                                            QLineEdit::Normal,QDir::home().dirName(),&ok);
        if(ok && !text.isEmpty())
        {
            displayTextEdit->setText(text);
        }
    }
    /*
     *QInputDialog::getText()函数创建并显示一个文本输入对话框。
     *前2个参数分别指定了输入对话框的父窗口部件和对话框的标题；
     *第3个参数指定了标签的显示文本；
     *第4个参数指定了行编辑框QLineEdit输入内容的显示模式，此处 为QLineEdit::Normal，即按用户输入的实际内容显示；
     *第5个参数指定了行编辑框默认显示的内容，函数QDir::home()  返回用 户的home路径，QDir::dirName()返回路径的名字；
     *最后一个参数和QFontDialog::getFont()函数的第1个参数的作用相同。
     */
    else if(btn == pagePushBtn)
    {// 页设置对话框.
        QPrinter printer;
        QPageSetupDialog dlg(&printer, this);
        dlg.setWindowTitle(tr("PageSet Dialog"));
        if (dlg.exec() == QDialog::Accepted)
        {
            // 进行下一步的处理。
        }
    }
    /*
     *首先，定义了一个打印机QPrinter对象printer。
     *然后创建了一个页设置对话框QPageSetupDialog对象，并设置对话框的标题。
     *在这个例子中，只是简单地创建和显示一个页设置对话框，该对话框返回后没有进行下一步的处理。
     */
    else if(btn == progressPushBtn)
    {// 进度对话框.
        QProgressDialog progress(tr("Coping..."), tr("Cancel"),0,10000,this);
        progress.setWindowModality(Qt::WindowModal);
        progress.setWindowTitle(tr("Process Dialog"));
        progress.show();
        for(int i=0; i<10000; i++)
        {
            progress.setValue(i);
            qApp->processEvents();
            if(progress.wasCanceled())
                break;
            //... 复制文件处理。
            qDebug() << i;
        }
        progress.setValue(10000);
    }
    /*
     *这一段代码创建了一个进度对话框，并模拟了显示一个长时间操作的工作进程。
     *首先，调用了QProgressDialog的构造函数，创建了一个进度对话框的栈对象。构造函数有5个参数。
     *第1个参数是一个字符串，它指定了显示给用户的提示信息，表明当前正在进行的工作：
     *第2个参数指定了“取消”按钮的显示文本，如果该参数为0的话，进度对话框将没有“取消”按钮，即创建进度对话框的代码为QProgressDialog progress(tr("Coping..."), 0 , 0, 10000, this)
     *接下来的2个参数分别指定了操作的步数（在上面的例子中，可以假定进度对话框显示复制10 000个文件的进展情况，
     *第3个参 数设定为0，第4个参数设定为10 000，即这两个参数的差值决定了这个复制操作的步数为10 000）。
     *第5个参数指定了进度对话框的父窗口部件。
     *接下来，函数setWindowModality()设置进度对话框的类型为Qt::WindowModal，即为模态对话框。
     *有两种方式使用进度对话框QProgressDialog：模态对话框方式。
     *使用一个模态进度对话框显示长时间操作的工作进度对于编程是比较简单的，
         *但是必须调用QApplication::processEvents()函数或者QEventLoop::processEvents(QEventLoop::ExcludeUserInputEvents)函数以保证事件循环还可以处理其他事件，
         *以防止应用程序因为长时间的操作而导致没有反应。
         *在自定义对话框的例子中，使用了模态进度对话框，通过QProgressDialog::setValue()函数推进显示的进度；
         *通过QProgressDialog::wasCancled()函数判断用户是否中途选择 了“取消”按钮，如果是，将中断复制文件操作。
         *此外，代码使用了qDebug()函数打印for()语句的运行进度，模拟复制操作。
     *非模态对话框方式。非模态进度对话框适用于显示在后台运行的长时间操作的工作进度，这样的话，用户就能够和应用程序 的其他窗口进行交互。
     */
    else if(btn == printPushBtn)
    {// 打印对话框.
        QPrinter printer;
        QPrintDialog dlg(&printer, this);
        dlg.setWindowTitle(tr("Printer Dialog"));
        if (dlg.exec() == QDialog::Accepted)
        {
            // 进行下一步的处理。
        }
    }

}

