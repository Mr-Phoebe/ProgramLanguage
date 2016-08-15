#include "widget.h"
#include "ui_widget.h"
#include <QtSql>
#include <QtGui>

void Widget::on_newCustomerButton_clicked()
{
    resetOrderPage();
}

void Widget::on_commitButton_clicked()
{
    QString name = ui->cnameLineEdit->text();
    QString sex = ui->cmaleRadioButton->isChecked() ? tr("男") : tr("女");
    QString id = ui->cidLineEdit->text();
    QString phone = ui->cphoneLineEdit->text();
    QString checkintime = ui->ccheckintimeDateEdit->text();

    QList<QTableWidgetItem*> items = ui->orderRoomTableWidget->selectedItems();
    QStringList roomnos;
    foreach (QTableWidgetItem * item, items)
    {
        roomnos << item->text();
    }

    if (name.isEmpty() || id.length() != 18 || phone.length() != 11)
    {
        QMessageBox::information(this, tr("预定管理"), tr("用户信息不完整"));
    }
    else if (items.isEmpty())
    {
        QMessageBox::information(this, tr("预定管理"), tr("没有选定预定房间"));
    }
    else
    {
        QString roomno;
        foreach (QString str, roomnos)
        {
            roomno += str + " ";
        }

        QString text = tr("姓名：") + name + tr("\n性别：") + sex + tr("\n身份证号：") + id +
                       tr("\n联系电话：") + phone + tr("\n预定入住时间：") + checkintime +
                       tr("\n预定的房号：") + roomno;
        QMessageBox box;
        box.setWindowTitle(tr("信息确认"));
        box.setText(text);
        box.addButton(tr("确定"), QMessageBox::AcceptRole);
        box.addButton(tr("取消"), QMessageBox::RejectRole);


        if (box.exec() == QMessageBox::AcceptRole)
        {
            // ## 提交成功，将信息录入数据库，同时，更新此界面
            dealOrderPage();
            resetOrderPage();
        }
    }
}

void Widget::on_cancelButton_clicked()
{
    // ## 进入数据库中删除此条数据
    QString name = ui->cnameLineEdit->text();
    QString sql = QString("select roomnos from customer_t where name = '%1'").arg(name);
    QSqlQuery query(sql);

    if (query.next())
    {
        // ## 这里应该是必定找得到
        QStringList roomnos = query.value(0).toString().split(" ");

        foreach (QString roomno, roomnos)
        {
            sql = "update room_t set status = 1 where roomno = " + roomno;
            query.exec(sql);
        }

        sql = QString("delete from customer_t where name = '%1'").arg(name);
        query.exec(sql);

        updateOrderPage();
    }
    else
    {
        Q_ASSERT(false);
    }
}

void Widget::resetOrderPage()
{
    ui->cnameLineEdit->clear();
    ui->cnameLineEdit->setReadOnly(false);
    ui->cmaleRadioButton->setChecked(true);
    ui->cmaleRadioButton->setEnabled(true);
    ui->cfemaleRadioButton->setEnabled(true);
    ui->cidLineEdit->clear();
    ui->cidLineEdit->setReadOnly(false);
    ui->cphoneLineEdit->clear();
    ui->cphoneLineEdit->setReadOnly(false);
    ui->ccheckintimeDateEdit->setDate(QDate::currentDate());
    ui->ccheckintimeDateEdit->setReadOnly(false);
    ui->commitButton->setEnabled(true);
    ui->newCustomerButton->setEnabled(false);
    ui->cancelButton->setEnabled(false);

    // ## 从数据库中获取信息，更新界面
    updateOrderPage();
}

void Widget::updateOrderPage()
{
    ui->orderRoomTableWidget->clear();
    ui->customerListWidget->clear();

    // ## 查询最多一列的房屋行数
    QString sql = "select count(*) from room_t where status = 1 group by roomtype";
    QSqlQuery query(sql);

    int maxRow = 0;
    while (query.next())
    {
        int roomcount = query.value(0).toInt();
        if (maxRow < roomcount)
            maxRow = roomcount;
    }
    ui->orderRoomTableWidget->setRowCount(maxRow);

    // ## 查询可供预定的房屋总数
    sql = "select roomno, roomtype from room_t where status = 1";
    query.exec(sql);

    int r1 = 0, r2 = 0, r3 = 0;
    while (query.next())
    {
        QString roomno = query.value(0).toString();
        int roomtype = query.value(1).toInt() - 1;
        if (roomtype == 0)
            ui->orderRoomTableWidget->setItem(r1++, roomtype, new QTableWidgetItem(roomno));
        else if (roomtype == 1)
            ui->orderRoomTableWidget->setItem(r2++, roomtype, new QTableWidgetItem(roomno));
        else
            ui->orderRoomTableWidget->setItem(r3++, roomtype, new QTableWidgetItem(roomno));
    }

    // ## 设置列名
    QStringList lables;
    lables << tr("单人间(￥240)") << tr("双人间(￥220)") << tr("三人间(￥270)");
    ui->orderRoomTableWidget->setHorizontalHeaderLabels(lables);

    sql = "select name, roomnos from customer_t";
    query.exec(sql);
    while (query.next())
    {
        QString name = query.value(0).toString();
        QString roomnos = query.value(1).toString();
        QString text = tr("%1, 预定：%2").arg(name).arg(roomnos);
        ui->customerListWidget->addItem(text);
    }
}

// ## 将提交的预定信息，移入数据库
void Widget::dealOrderPage()
{
    QSqlQuery query;
    QString sql;

    QList<QTableWidgetItem*> items = ui->orderRoomTableWidget->selectedItems();
    QString roomnos;
    foreach (QTableWidgetItem * item, items)
    {
        roomnos += item->text() + " ";
        int roomno = item->text().toInt();
        // ## 构建房屋表更新语句
        sql = QString("update room_t set status = 2 where roomno = %1").arg(roomno);
        query.exec(sql);
    }

    QString name = ui->cnameLineEdit->text();
    int sex = ui->cmaleRadioButton->isChecked() ? 0 : 1;
    QString id = ui->cidLineEdit->text();
    QString phone = ui->cphoneLineEdit->text();
    QString checkintime = ui->ccheckintimeDateEdit->text();

    // ## 构建用户表插入语句
    sql = QString("insert into customer_t values(null,'%1', %2, '%3', '%4', '%5', '%6')").arg(name)
          .arg(sex).arg(id).arg(phone).arg(roomnos).arg(checkintime);
    query.exec(sql);
}

// ## 当点击了其中任何一个预定客户之后，只能取消预定
void Widget::processOrderCustomer()
{
    ui->commitButton->setEnabled(false);
    ui->cancelButton->setEnabled(true);
    ui->newCustomerButton->setEnabled(true);
    ui->cnameLineEdit->setReadOnly(true);
    ui->cidLineEdit->setReadOnly(true);
    ui->cphoneLineEdit->setReadOnly(true);
    ui->ccheckintimeDateEdit->setReadOnly(true);
    ui->cmaleRadioButton->setEnabled(false);
    ui->cfemaleRadioButton->setEnabled(false);


    QStringList name = ui->customerListWidget->selectedItems().at(0)->text().split(",");
    QString sql = QString("select sex, id, phone, checkintime from customer_t where name = '%1'").arg(name[0]);
    QSqlQuery query(sql);

    if (query.next())
    {
        // ## 这里应该是必定找得到
        ui->cnameLineEdit->setText(name[0]);
        if (query.value(0).toInt())
            ui->cfemaleRadioButton->setChecked(true);
        else
            ui->cmaleRadioButton->setChecked(true);
        ui->cidLineEdit->setText(query.value(1).toString());
        ui->cphoneLineEdit->setText(query.value(2).toString());
        ui->ccheckintimeDateEdit->setDate(query.value(3).toDate());
    }
    else
    {
        Q_ASSERT(false);
    }
}

