#include <QtGui>

#include "dialog.h"


#define MESSAGE \
    Dialog::tr("<p>Message boxes have a caption, a text, " \
               "and any number of buttons, each with standard or custom texts." \
               "<p>Click a button to close the message box. Pressing the Esc button " \
               "will activate the detected escape button (if any).")


Dialog::Dialog(QWidget *parent)
    : QDialog(parent)
{

    setWindowTitle(tr("Standard Dialogs"));
    errorMessageDialog = new QErrorMessage(this);


    int frameStyle = QFrame::Sunken | QFrame::Panel;


    //Name
    nameLabel = new QLabel;
    nameLabel->setFrameStyle(frameStyle);
    QPushButton *nameButton = new QPushButton(tr("&Name"));

    //Sex
    sexLabel = new QLabel;
    sexLabel->setFrameStyle(frameStyle);
    QPushButton *sexButton = new QPushButton(tr("&Sex"));

    //Age
    ageLabel = new QLabel;
    ageLabel->setFrameStyle(frameStyle);
    QPushButton *ageButton = new QPushButton(tr("&Age"));

    //Stature
    statureLabel = new QLabel;
    statureLabel->setFrameStyle(frameStyle);
    QPushButton *statureButton = new QPushButton(tr("S&tature"));

    //Color
    colorLabel = new QLabel;
    colorLabel->setFrameStyle(frameStyle);
    QPushButton *colorButton = new QPushButton(tr("&Color"));

    //Font
    fontLabel = new QLabel;
    fontLabel->setFrameStyle(frameStyle);
    QPushButton *fontButton = new QPushButton(tr("&Font"));

    //Critical MessageBox
    criticalLabel = new QLabel;
    criticalLabel->setFrameStyle(frameStyle);
    QPushButton *criticalButton =
            new QPushButton(tr("Critica&l"));

    //Information MessageBox
    informationLabel = new QLabel;
    informationLabel->setFrameStyle(frameStyle);
    QPushButton *informationButton =
            new QPushButton(tr("&Information"));

    //Question MessageBox
    questionLabel = new QLabel;
    questionLabel->setFrameStyle(frameStyle);
    QPushButton *questionButton =
            new QPushButton(tr("&Question"));

    //Warning MessageBox
    warningLabel = new QLabel;
    warningLabel->setFrameStyle(frameStyle);
    QPushButton *warningButton = new QPushButton(tr("&Warning"));

    //Error MessageBox
    errorLabel = new QLabel;
    errorLabel->setFrameStyle(frameStyle);
    QPushButton *errorButton =
            new QPushButton(tr("Show &Message"));


    connect(ageButton, SIGNAL(clicked()), this, SLOT(getAge()));
    connect(statureButton, SIGNAL(clicked()), this, SLOT(getStature()));
    connect(sexButton, SIGNAL(clicked()), this, SLOT(getSex()));
    connect(nameButton, SIGNAL(clicked()), this, SLOT(getName()));
    connect(colorButton, SIGNAL(clicked()), this, SLOT(getColor()));
    connect(fontButton, SIGNAL(clicked()), this, SLOT(getFont()));

    connect(criticalButton, SIGNAL(clicked()), this, SLOT(getCriticalMessage()));
    connect(informationButton, SIGNAL(clicked()),
            this, SLOT(getInformationMessage()));
    connect(questionButton, SIGNAL(clicked()), this, SLOT(getQuestionMessage()));
    connect(warningButton, SIGNAL(clicked()), this, SLOT(getWarningMessage()));
    connect(errorButton, SIGNAL(clicked()), this, SLOT(getErrorMessage()));

    //Setup Layout
    QGridLayout *layout = new QGridLayout;
    layout->setColumnStretch(1, 1);
    layout->setColumnMinimumWidth(1, 250);

    layout->addWidget(nameButton, 0, 0);
    layout->addWidget(nameLabel, 0, 1);
    layout->addWidget(sexButton, 1, 0);
    layout->addWidget(sexLabel, 1, 1);
    layout->addWidget(ageButton, 3, 0);
    layout->addWidget(ageLabel, 3, 1);
    layout->addWidget(statureButton, 4, 0);
    layout->addWidget(statureLabel, 4, 1);

    layout->addWidget(colorButton, 5, 0);
    layout->addWidget(colorLabel, 5, 1);
    layout->addWidget(fontButton, 6, 0);
    layout->addWidget(fontLabel, 6, 1);

    layout->addWidget(criticalButton, 7, 0);
    layout->addWidget(criticalLabel, 7, 1);
    layout->addWidget(informationButton, 8, 0);
    layout->addWidget(informationLabel, 8, 1);
    layout->addWidget(questionButton, 9, 0);
    layout->addWidget(questionLabel, 9, 1);
    layout->addWidget(warningButton, 10, 0);
    layout->addWidget(warningLabel, 10, 1);
    layout->addWidget(errorButton, 11, 0);
    layout->addWidget(errorLabel, 11, 1);


    setLayout(layout);


}

void Dialog::getAge()
{

    bool ok;
    int age = QInputDialog::getInteger(this,tr("User Age"),
                        tr("Please input age"),ageLabel->text().toInt(),0,150,1,&ok);
    if(ok)
    {
        ageLabel->setText(QString(tr("%1")).arg(age));
    }
}

void Dialog::getStature()
{

    bool ok;
    double d = QInputDialog::getDouble(this,tr("Stature"),
                        tr("Please input stature"),6782.5,0,65536.00,1,&ok);
    if(ok)
    {
        statureLabel->setText(QString(tr("%1")).arg(d));
    }
}

void Dialog::getSex()
{

    QStringList items;
    items << tr("male") << tr("female");

    bool ok;
    QString sex = QInputDialog::getItem(this,tr("Sex"),
                        tr("Please select sex"),items,0,false,&ok);
    if (ok)
    {
        sexLabel->setText(sex);
    }
}

void Dialog::getName()
{

    bool ok;
    QString name = QInputDialog::getText(this,tr("User Name"),
                        tr("Please input new name"),QLineEdit::Normal,nameLabel->text(),&ok);

    if(ok && !name.isEmpty())
    {
        nameLabel->setText(name);
    }
}

void Dialog::getColor()
{
    QColor color = QColorDialog::getColor(Qt::green, this);

    if (color.isValid())
    {
        colorLabel->setText(color.name());
        colorLabel->setPalette(QPalette(color));
        colorLabel->setAutoFillBackground(true);
    }
}

void Dialog::getFont()
{
    bool ok;
    QFont font = QFontDialog::getFont(&ok, QFont(fontLabel->text()), this);

    if (ok)
    {
        fontLabel->setText(font.key());
        fontLabel->setFont(font);
    }
}

void Dialog::getCriticalMessage()
{
    QMessageBox::StandardButton reply;
    reply = QMessageBox::critical(this, tr("QMessageBox::critical()"),
                                    MESSAGE,
                                    QMessageBox::Abort | QMessageBox::Retry | QMessageBox::Ignore);

    if (reply == QMessageBox::Abort)
    {
        criticalLabel->setText(tr("Abort"));
    }
    else if (reply == QMessageBox::Retry)
    {
        criticalLabel->setText(tr("Retry"));
    }
    else
    {
        criticalLabel->setText(tr("Ignore"));
    }
}

void Dialog::getInformationMessage()
{
    QMessageBox::StandardButton reply;
    reply = QMessageBox::information(this, tr("QMessageBox::information()"), MESSAGE);

    if (reply == QMessageBox::Ok)
    {
        informationLabel->setText(tr("OK"));
    }
    else
    {
        informationLabel->setText(tr("Escape"));
    }
}

void Dialog::getQuestionMessage()
{
    QMessageBox::StandardButton reply;
    reply = QMessageBox::question(this, tr("QMessageBox::question()"),
                                    MESSAGE,
                                    QMessageBox::Yes | QMessageBox::No | QMessageBox::Cancel);

    if (reply == QMessageBox::Yes)
    {
        questionLabel->setText(tr("Yes"));
    }
    else if (reply == QMessageBox::No)
    {
        questionLabel->setText(tr("No"));
    }
    else
    {
        questionLabel->setText(tr("Cancel"));
    }
}

void Dialog::getWarningMessage()
{
    QMessageBox msgBox(QMessageBox::Warning, tr("QMessageBox::warning()"),
                       MESSAGE, 0, this);
    msgBox.addButton(tr("Save &Again"), QMessageBox::AcceptRole);
    msgBox.addButton(tr("&Continue"), QMessageBox::RejectRole);

    if (msgBox.exec() == QMessageBox::AcceptRole)
    {
        warningLabel->setText(tr("Save Again"));
    }
    else
    {
        warningLabel->setText(tr("Continue"));
    }

}

void Dialog::getErrorMessage()
{
    errorMessageDialog->showMessage(
            tr("This dialog shows and remembers error messages. "
               "If the checkbox is checked (as it is by default), "
               "the shown message will be shown again, "
               "but if the user unchecks the box the message "
               "will not appear again if QErrorMessage::showMessage() "
               "is called with the same message."));

    errorLabel->setText(tr("If the box is unchecked, the message "
                           "won't appear again."));
}
