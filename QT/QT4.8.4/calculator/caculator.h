#ifndef CACULATOR_H
#define CACULATOR_H

#include <QMainWindow>
#include <QLineEdit>
#include <QWidget>
#include <QAction>
#include <QPushButton>
#include <QString>
#include <QChar>
#include <QHBoxLayout>

namespace Ui {
class caculator;
}


class caculator : public QMainWindow
{
    Q_OBJECT
    
public:
    explicit caculator(QWidget *parent = 0);
    ~caculator();
    
private:
    Ui::caculator *ui;
    bool dot;  //dotButton checkable
    bool caculToNum;   //next step could press on number button or caculSign button
    QChar caculSign;   //'+', '-', '*', '/'
    QString showEdit;  //show edit
    QString result;    //save result
    QString temp;      //save temp number

    //Register, save value of register
    QString regResult;

    //menu
    QMenu *helpMenu;

    //QAction of menu
    QAction *aboutAction;
    QAction *aboutQtAction;

    //main widget
    QWidget *mainWidget;
    //widget of main widget
    QLineEdit *lineEdit;

    //QPushButton
    QPushButton *emptyButton;
    QPushButton *backSpaceButton;
    QPushButton *ceButton;
    QPushButton *cButton;

    QPushButton *mcButton;
    QPushButton *sevenButton;
    QPushButton *eightButton;
    QPushButton *nineButton;
    QPushButton *divideButton;
    QPushButton *sqrtButton;

    QPushButton *mrButton;
    QPushButton *fourButton;
    QPushButton *fiveButton;
    QPushButton *sixButton;
    QPushButton *multipButton;
    QPushButton *modButton;

    QPushButton *msButton;
    QPushButton *oneButton;
    QPushButton *twoButton;
    QPushButton *threeButton;
    QPushButton *subButton;
    QPushButton *recipButton;

    QPushButton *mPlusButton;
    QPushButton *zeroButton;
    QPushButton *signButton;
    QPushButton *dotButton;
    QPushButton *plusButton;
    QPushButton *equalButton;

    //private function
    void createActions();
    void createMenus();
    void createMainWidget();
    void digitNum(int num);
private slots:
    //about caculator
    void about();

    //slots of button
    void on_backSpaceButton();
    void on_ceButton();
    void on_cButton();

    void on_mcButton();
    void on_sevenButton();
    void on_eightButton();
    void on_nineButton();
    void on_divideButton();
    void on_sqrtButton();

    void on_mrButton();
    void on_fourButton();
    void on_fiveButton();
    void on_sixButton();
    void on_multipButton();
    void on_modButton();

    void on_msButton();
    void on_oneButton();
    void on_twoButton();
    void on_threeButton();
    void on_subButton();
    void on_recipButton();

    void on_mPlusButton();
    void on_zeroButton();
    void on_signButton();
    void on_dotButton();
    void on_plusButton();
    void on_equalButton();
};

#endif // CACULATOR_H
