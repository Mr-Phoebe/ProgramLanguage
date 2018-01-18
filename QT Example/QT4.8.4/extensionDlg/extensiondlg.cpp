#include "extensiondlg.h"
#include "ui_extensiondlg.h"

ExtensionDlg::ExtensionDlg(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::ExtensionDlg)
{
    setWindowTitle(tr("Extension Dialog"));
    initBasicInfo();
    initDetailInfo();
    QVBoxLayout *layout = new QVBoxLayout;
    layout->addWidget(baseWidget);
    layout->addWidget(detailWidget);
    layout->setSizeConstraint(QLayout::SetFixedSize);
    layout->setSpacing(10);
    setLayout(layout);
}

ExtensionDlg::~ExtensionDlg()
{
    delete ui;
}

void ExtensionDlg::initBasicInfo()
{
    baseWidget = new QWidget;
    QLabel *nameLabel = new QLabel(tr("Name"));
    QLineEdit *nameEdit = new QLineEdit;
    QLabel *sexLabel = new QLabel(tr("Sex"));
    QComboBox *sexCombobox = new QComboBox;
    sexCombobox->addItem(tr("male"));
    sexCombobox->addItem(tr("female"));
    QPushButton *okButton = new QPushButton(tr("OK"));
    QPushButton *detailButton = new QPushButton(tr("Detail"));
    connect(detailButton,SIGNAL(clicked()),this,SLOT(slot2Extension()));
    QDialogButtonBox *btnBox = new QDialogButtonBox(Qt::Horizontal);
    btnBox->addButton(okButton,QDialogButtonBox::ActionRole);
    btnBox->addButton(detailButton,QDialogButtonBox::ActionRole);
    QFormLayout *formlayout = new QFormLayout;
    formlayout->addRow(nameLabel,nameEdit);
    formlayout->addRow(sexLabel,sexCombobox);
    QVBoxLayout *vboxlayout = new QVBoxLayout;
    vboxlayout->addLayout(formlayout);
    vboxlayout->addWidget(btnBox);
    baseWidget->setLayout(vboxlayout);
}

void ExtensionDlg::initDetailInfo()
{
    detailWidget = new QWidget;
    QLabel *agelabel = new QLabel(tr("Age"));
    QLineEdit *ageEdit = new QLineEdit;
    ageEdit->setText(tr("25"));
    QLabel *deptlabel = new QLabel(tr("Department"));
    QComboBox *deptComboBox = new QComboBox;
    deptComboBox->addItem(tr("department1"));
    deptComboBox->addItem(tr("department2"));
    deptComboBox->addItem(tr("department3"));
    deptComboBox->addItem(tr("department4"));
    deptComboBox->insertSeparator(2);
    QLabel *addresslabel = new QLabel(tr("address"));
    QLineEdit *addressEdit = new QLineEdit;
    QFormLayout *formlayout = new QFormLayout;
    formlayout->addRow(agelabel,ageEdit);
    formlayout->addRow(deptlabel,deptComboBox);
    formlayout->addRow(addresslabel,addressEdit);
    detailWidget->setLayout(formlayout);
    detailWidget->hide();
}

void ExtensionDlg::slot2Extension()
{
    /*
    QWidget *miao = new QWidget;
    QLabel *d = new QLabel(tr("miao"));
    QFormLayout *H = new QFormLayout;
    H->addRow(d);
    miao->setLayout(H);
    miao->show();
    */
    if(detailWidget->isHidden())
    {
        detailWidget->show();
    }
    else
    {
        detailWidget->hide();
    }
}
