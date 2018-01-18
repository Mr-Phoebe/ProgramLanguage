#include "colordlg.h"
#include "ui_colordlg.h"

ColorDlg::ColorDlg(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::ColorDlg)
{
//    ui->setupUi(this);
    btnok = new QPushButton("ok");
    labeltxt = new QLabel("showtext");
    btncolor = new QPushButton("color dlg");
    QVBoxLayout *layout = new QVBoxLayout;
    pParent = parent;
    layout->addWidget(btnok);
    layout->addWidget(btncolor);
    layout->addWidget(labeltxt);

    connect(btnok, SIGNAL(clicked()), this, SLOT(inputtxt()));
    connect(this,SIGNAL(setTxt(QString)), labeltxt,SLOT(setText(QString)));
    connect(btncolor,SIGNAL(clicked()),this,SLOT(show_clr()));
    resize(300,200);    //改变窗口大小
    setLayout(layout);
}

ColorDlg::~ColorDlg()
{
    delete ui;
}

void ColorDlg::show_clr()
{
    QColorDialog::setCustomColor(0,QRgb(0x0000FF));
    QColor color =  QColorDialog::getColor(QColor(0,255,0));
//    QColor color =  QColorDialog::getColor(QColor(0,255,0),pParent,tr("Color You Like"));
    QString str;
    if(color.isValid())
    {
        str.sprintf("R:%d G:%d B:%d",color.red(), color.green(), color.blue());
        QMessageBox::information(0,"Get Selected Color",str,QMessageBox::Ok,QMessageBox::Yes);
    }
}

void ColorDlg::inputtxt()
{
    bool isOk;
    txt = QInputDialog::getText(pParent, "Input Dialog",
                                "Please input your Text",
                                 QLineEdit::Normal,"", &isOk);
    if(isOk)
    {
        QMessageBox ::information(pParent, "information",
                                  "Your comment is <b><color = red>" + txt + "</b></color>",
                                   QMessageBox::Yes|QMessageBox::No, QMessageBox::Yes);
        emit(setTxt(txt));
    }
}
