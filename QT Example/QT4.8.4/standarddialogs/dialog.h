#ifndef DIALOG_H
#define DIALOG_H

#include <QDialog>

QT_BEGIN_NAMESPACE
class QLabel;
class QErrorMessage;
QT_END_NAMESPACE

class Dialog : public QDialog
{
    Q_OBJECT

public:

    Dialog(QWidget *parent = 0);

private slots:

    void getAge();
    void getStature();
    void getSex();
    void getName();
    void getColor();
    void getFont();

    void getCriticalMessage();
    void getInformationMessage();
    void getQuestionMessage();
    void getWarningMessage();
    void getErrorMessage();

private:

    QLabel *nameLabel;
    QLabel *sexLabel;
    QLabel *ageLabel;
    QLabel *statureLabel;

    QLabel *colorLabel;
    QLabel *fontLabel;

    QLabel *criticalLabel;
    QLabel *informationLabel;
    QLabel *questionLabel;
    QLabel *warningLabel;
    QLabel *errorLabel;
    QErrorMessage *errorMessageDialog;

};

#endif
