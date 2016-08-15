#ifndef WIDGET_H
#define WIDGET_H

#include <QWidget>
#include <QTextCodec>

namespace Ui {
    class Widget;
}

class Widget : public QWidget
{
    Q_OBJECT

public:
    explicit Widget(QWidget *parent = 0);
    ~Widget();

private:
    void initLoginPage();
    void initMainPage();
    void initOrderPage();
    void initCheckInPage();

    void resetOrderPage();
    void resetCheckInPage();
    void resetEvluatePage();

    void updateOrderPage();
    void updateCheckInPage();
    void updateRoomInfoPage();
    void updatePayPage();
    void updateEvluatePage();

    void dealOrderPage();
    void dealCheckInPage();
    void dealPayPage();
    void dealEvluatePage();

    bool isValidCheckInCustomer(const QString&, const QString&, const QString&);
    bool isEmptyCheckInCustomer(const QString&, const QString&, const QString&);

    void keyPressEvent(QKeyEvent *);

private:
    Ui::Widget *ui;

private slots:
    void on_submitButton_clicked();
    void on_moneyAddButton_clicked();
    void on_commitButton_2_clicked();
    void on_cancelButton_clicked();
    void on_newCustomerButton_clicked();
    void on_commitButton_clicked();
    void on_exitButton_clicked();
    void on_loginButton_clicked();
    void updateAllInfo();
    void processOrderCustomer();
    void processCheckInCustomer(int, int);
    void on_Exit_clicked();
    void on_About_clicked();
    void on_ExitID_clicked();
};

#endif // WIDGET_H
