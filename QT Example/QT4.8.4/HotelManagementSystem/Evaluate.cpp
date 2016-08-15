#include "widget.h"
#include "ui_widget.h"
#include <QtSql>
#include <QtGui>

void Widget::on_submitButton_clicked()
{
    dealEvluatePage();
    resetEvluatePage();
    updateEvluatePage();
}

void Widget::resetEvluatePage()
{
    ui->textEdit->clear();
    ui->evluate1RadioButton->setChecked(true);
}

void Widget::updateEvluatePage()
{
    const static QString evluateRanks[3] = {tr("满意"), tr("一般"), tr("不满意")};
    QString sql = "select count(*) from evluate_t";
    QSqlQuery query(sql);
    query.next();
    int rows = query.value(0).toInt();
    ui->evluateTableWidget->setRowCount(rows);

    sql = "select * from evluate_t";
    query.exec(sql);

    int row = 0;
    while (query.next())
    {
        QString rank = evluateRanks[query.value(1).toInt()];
        QString content = query.value(2).toString();
        ui->evluateTableWidget->setItem(row, 0, new QTableWidgetItem(rank));
        ui->evluateTableWidget->setItem(row, 1, new QTableWidgetItem(content));
        ++row;
    }
}

void Widget::dealEvluatePage()
{
    QString rank = "0";
    if (ui->evluate2RadioButton->isChecked())
        rank = "1";
    else if (ui->evluate3RadioButton->isChecked())
        rank = "2";

    QString content = ui->textEdit->toPlainText();

    QString sql = QString("insert into evluate_t values(null, %1, '%2')").arg(rank).arg(content);
    QSqlQuery query(sql);
}


