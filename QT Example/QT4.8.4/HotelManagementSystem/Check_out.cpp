#include "widget.h"
#include "ui_widget.h"
#include <QtSql>
#include <QtGui>

void Widget::on_commitButton_2_clicked()
{
    dealCheckInPage();
    resetCheckInPage();
    updateCheckInPage();
}

void Widget::on_moneyAddButton_clicked()
{
    dealPayPage();
    updatePayPage();
}

void Widget::dealPayPage()
{
    int row = ui->checkInTableWidget->currentRow();
    if (-1 == row)
    {
        QMessageBox::information(this, tr("退房管理"), tr("尚未选定房间，请先选定一个房间"));
    }
    else
    {
        QString roomno = ui->checkInTableWidget->item(row, 0)->text();
        QString checkin = ui->checkInTableWidget->item(row, 3)->text();
        int price = ui->checkInTableWidget->item(row, 2)->text().toInt();
        int days = QDate::fromString(checkin, "yyyy-MM-dd").daysTo(QDate::currentDate());

        int totalCost = days * price;
        QMessageBox::information(this, tr("退房管理"), tr("一共费用：%1").arg(totalCost));

        // ## 删除顾客信息
        QString sql = "delete from checkin_t where roomno = " + roomno;
        QSqlQuery query(sql);

        // ## 更新房屋信息
        sql = "update room_t set status = 1 where roomno = " + roomno;
        query.exec(sql);
    }
}

void Widget::updatePayPage()
{
    const static QString roomTypes[3] = {tr("单人间"), tr("双人间"), tr("三人间")};

    // ## 这里提取入住用户信息
    QString sql = "select count(distinct roomno) from checkin_t";
    QSqlQuery query(sql);
    query.next();
    ui->checkInTableWidget->setRowCount(query.value(0).toInt());

    sql = "select checkin_t.roomno, roomtype, price, checkintime, name from room_t, checkin_t "
          "where room_t.roomno = checkin_t.roomno";
    query.exec(sql);

    QList<QStringList> roomInfoList;
    while (query.next())
    {
        QString roomno = query.value(0).toString();
        QString roomtype = roomTypes[query.value(1).toInt() - 1];
        QString price = query.value(2).toString();
        QString checkin = query.value(3).toString();
        QString name = query.value(4).toString();

        bool isExist = false;
        // ## 先查询这里是否是同一房间的住客
        for (int i = 0; i < roomInfoList.size(); ++i)
        {
            if (roomInfoList[i][0] == roomno)
            {
                roomInfoList[i] << name;
                isExist = true;
                break;
            }
        }
        if (isExist)
            continue;

        QStringList roomInfo;
        roomInfo << roomno << roomtype << price << checkin << name;
        roomInfoList << roomInfo;
    }

    int row = 0;
    foreach (QStringList roomInfo, roomInfoList)
    {
        for (int col = 0; col < roomInfo.size(); ++col)
            ui->checkInTableWidget->setItem(row, col, new QTableWidgetItem(roomInfo[col]));
        ++row;
    }
}

