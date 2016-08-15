#include "widget.h"
#include "ui_widget.h"
#include <QtSql>
#include <QtGui>

void Widget::updateRoomInfoPage()
{
    const static QString roomTypes[3] = {tr("单人间"), tr("双人间"), tr("三人间")};
    const static QString roomStatus[3] = {tr("空闲"), tr("已预订"), tr("已入住")};
    QString sql = "select roomtype, roomno, status, price from room_t";
    QSqlQuery query(sql);

    ui->roomInfoTableWidget->setRowCount(40);
    QList<QStringList> roomInfoList;

    // ## 这里提取房屋信息
    while (query.next())
    {
        QStringList roomInfo;
        roomInfo << roomTypes[query.value(0).toInt()-1]
                 << query.value(1).toString()
                 << roomStatus[query.value(2).toInt()-1]
                 << query.value(3).toString();
        roomInfoList << roomInfo;

    }

    // ## 这里提取预订用户信息
    sql = "select name, roomnos, checkintime from customer_t";
    query.exec(sql);
    while (query.next())
    {
        QStringList roomnos = query.value(1).toString().split(" ");
        foreach (QString roomno, roomnos)
        {
            for (int i = 0; i < roomInfoList.size(); ++i)
            {
                if (roomInfoList[i][1] == roomno)
                {
                    roomInfoList[i] << query.value(2).toString()
                                    << query.value(0).toString();
                }
            }
        }
    }

    // ## 这里提取入住用户信息
    sql = "select name, roomno, checkintime from checkin_t";
    query.exec(sql);
    while (query.next())
    {
        QString roomno = query.value(1).toString();
        for (int i = 0; i < roomInfoList.size(); ++i)
        {
            if (roomInfoList[i][1] == roomno)
            {
                if (roomInfoList[i].size() >=6)
                    roomInfoList[i] << query.value(0).toString();
                else
                    roomInfoList[i] << query.value(2).toString()
                                    << query.value(0).toString();
            }
        }
    }

    int row = 0;
    foreach (QStringList roomInfo, roomInfoList)
    {
        for (int col = 0; col < roomInfo.size(); ++col)
            ui->roomInfoTableWidget->setItem(row, col, new QTableWidgetItem(roomInfo[col]));
        ++row;
    }
}
