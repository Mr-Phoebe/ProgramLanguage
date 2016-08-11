#ifndef REGISTING_H
#define REGISTING_H

#include <QDialog>
#include <QMessageBox>
#include <QSqlDatabase>
#include <QSqlQuery>

namespace Ui {
class registing;
}

class registing : public QDialog
{
    Q_OBJECT

public:
    explicit registing(QWidget *parent = 0);
    ~registing();
private slots:
    void regist();

private:
    Ui::registing *ui;
};

#endif // REGISTING_H
