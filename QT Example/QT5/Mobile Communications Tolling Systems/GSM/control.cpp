#include "control.h"
#include "ui_control.h"

Control::Control(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::Control)
{
    ui->setupUi(this);
    setWindowTitle("GSM管理界面");
    out = new Dataout(0,"0",this);
    in = new DataIn();
    ui->stackedWidget->setCurrentIndex(0);
    ui->stackedWidget_2->setCurrentIndex(0);
    QRegExp regExp("0?[.][0-9]+$");
    ui->lineEdit->setValidator(new QRegExpValidator(regExp,this));
    initTime();
    addBTSname();
    addCellID();
    connect(ui->confirm,SIGNAL(clicked()),this,SLOT(data_in()));
    connect(ui->confirm_2,SIGNAL(clicked()),this,SLOT(data_out()));
    connect(ui->pushButton,SIGNAL(clicked()),this,SLOT(page1()));
    connect(ui->pushButton_2,SIGNAL(clicked()),this,SLOT(page2()));
    connect(ui->confirm_3,SIGNAL(clicked()),this,SLOT(queryBTS()));
    connect(ui->pushButton_3,SIGNAL(clicked()),this,SLOT(page3()));
    connect(ui->pushButton_4,SIGNAL(clicked()),this,SLOT(page4()));
    connect(ui->confirm_4,SIGNAL(clicked()),this,SLOT(queryCell()));
    connect(ui->pushButton_6,SIGNAL(clicked()),this,SLOT(bulkInsert()));
    connect(ui->pushButton_5,SIGNAL(clicked()),this,SLOT(page5()));
    connect(ui->pushButton_9,SIGNAL(clicked()),this,SLOT(reCalculateDatas()));
    connect(ui->pushButton_7,SIGNAL(clicked()),this,SLOT(page6()));
    connect(ui->pushButton_11,SIGNAL(clicked()),this,SLOT(printNeighbor()));
    connect(ui->pushButton_8,SIGNAL(clicked()),this,SLOT(page7()));
    connect(ui->pushButton_10,SIGNAL(clicked()),this,SLOT(findNeighbor()));
    connect(ui->pushButton_12,SIGNAL(clicked()),this,SLOT(findCellInfo()));


    connect(ui->pushButton_13,SIGNAL(clicked()),this,SLOT(page13()));
    connect(ui->pushButton_14,SIGNAL(clicked()),this,SLOT(page14()));
    connect(ui->pushButton_15,SIGNAL(clicked()),this,SLOT(page15()));
    connect(ui->pushButton_16,SIGNAL(clicked()),this,SLOT(page16()));
    connect(ui->pushButton_17,SIGNAL(clicked()),this,SLOT(page17()));
    connect(ui->pushButton_18,SIGNAL(clicked()),this,SLOT(page18()));

    connect(ui->pushButton_22,SIGNAL(clicked()),this,SLOT(action22()));
    connect(ui->pushButton_23,SIGNAL(clicked()),this,SLOT(action23()));
}

void Control::initTime()
{
    QSqlQuery query;
    QDateTime start_date_time;
    query.exec("select min(DATE),min(TIME) from DATAS");
    if(query.next()){
        int min_date = query.value(0).toInt();
        int min_time = query.value(1).toInt();
        int year = min_date / 10000;
        int month = min_date % 10000 / 100;
        int day = min_date % 100;
        int h = min_time / 10000;
        QTime start_time(h,0);
        QDate start_date(2000 +year,month,day);
        start_date_time = QDateTime(start_date,start_time);
    }

    query.exec("select max(DATE),max(TIME) from DATAS");
    QDateTime end_date_time;
    if(query.next()){
        int max_date = query.value(0).toInt();
        int max_time = query.value(1).toInt();
        int year = max_date / 10000;
        int month = max_date % 10000 / 100;
        int day = max_date % 100;
        int h = max_time / 10000;
        QTime end_time(h,0);
        QDate end_date(2000 +year,month,day);
        end_date_time = QDateTime(end_date,end_time);
    }
    ui->startDateTimeEdit->setDisplayFormat("yyyy-M-d HH");
    ui->endDateTimeEdit->setDisplayFormat("yyyy-M-d HH");
    ui->startDateTimeEdit->setMinimumDateTime(start_date_time);
    ui->startDateTimeEdit->setMaximumDateTime(end_date_time);
    ui->endDateTimeEdit->setMinimumDateTime(start_date_time);
    ui->endDateTimeEdit->setMaximumDateTime(end_date_time);

    ui->startDateTimeEdit_2->setDisplayFormat("yyyy-M-d HH");
    ui->endDateTimeEdit_2->setDisplayFormat("yyyy-M-d HH");
    ui->startDateTimeEdit_2->setMinimumDateTime(start_date_time);
    ui->startDateTimeEdit_2->setMaximumDateTime(end_date_time);
    ui->endDateTimeEdit_2->setMinimumDateTime(start_date_time);
    ui->endDateTimeEdit_2->setMaximumDateTime(end_date_time);

    ui->startDateTimeEdit_3->setDisplayFormat("yyyy-M-d HH");
    ui->endDateTimeEdit_3->setDisplayFormat("yyyy-M-d HH");
    ui->startDateTimeEdit_3->setMinimumDateTime(start_date_time);
    ui->startDateTimeEdit_3->setMaximumDateTime(end_date_time);
    ui->endDateTimeEdit_3->setMinimumDateTime(start_date_time);
    ui->endDateTimeEdit_3->setMaximumDateTime(end_date_time);

    ui->startDateTimeEdit_4->setDisplayFormat("yyyy-M-d HH");
    ui->endDateTimeEdit_4->setDisplayFormat("yyyy-M-d HH");
    ui->startDateTimeEdit_4->setMinimumDateTime(start_date_time);
    ui->startDateTimeEdit_4->setMaximumDateTime(end_date_time);
    ui->endDateTimeEdit_4->setMinimumDateTime(start_date_time);
    ui->endDateTimeEdit_4->setMaximumDateTime(end_date_time);
}

void Control::page1()
{
    ui->stackedWidget->setCurrentIndex(0);
}

void Control::page2()
{
    ui->stackedWidget->setCurrentIndex(1);
    ui->label_6->setVisible(false);
    ui->label_7->setVisible(false);
    ui->label_8->setVisible(false);
    ui->label_9->setVisible(false);
    ui->label_10->setVisible(false);
    ui->label_12->setVisible(false);
    ui->label_13->setVisible(false);
    ui->label_14->setVisible(false);
    ui->label_15->setVisible(false);
    ui->label_16->setVisible(false);

    ui->label_17->setVisible(false);
    ui->label_19->setVisible(false);
    ui->label_20->setVisible(false);
    ui->label_21->setVisible(false);
    ui->label_22->setVisible(false);
    ui->label_23->setVisible(false);
    ui->label_24->setVisible(false);
    ui->label_25->setVisible(false);
    ui->label_26->setVisible(false);
    ui->label_27->setVisible(false);
    ui->label_28->setVisible(false);
    ui->label_29->setVisible(false);
    ui->label_30->setVisible(false);
    ui->label_31->setVisible(false);
    ui->label_32->setVisible(false);
    ui->label_33->setVisible(false);
    ui->label_34->setVisible(false);
    ui->label_35->setVisible(false);
    ui->stackedWidget_3->setCurrentIndex(0);
}

void Control::page3()
{
    QSqlQuery query;
    query.exec("select distinct CellID from DATAS order by CellID");
    while(query.next()){
        ui->cellIDComboBox_2->addItem(query.value(0).toString());
    }
    ui->stackedWidget->setCurrentIndex(2);
    ui->stackedWidget_4->setCurrentIndex(0);
}

void Control::page4()
{
    ui->stackedWidget->setCurrentIndex(3);
}

void Control::page5()
{
    ui->stackedWidget_2->setCurrentIndex(0);
}

void Control::page6()
{
    ui->stackedWidget_2->setCurrentIndex(1);
}

void Control::page7()
{
    ui->stackedWidget_3->setCurrentIndex(0);
}

void Control::page13()
{
    ui->stackedWidget_3->setCurrentIndex(1);
}

void Control::page14()
{
    QSqlQuery query;
    query.exec("select distinct CellID from DATAS order by CellID");
    while(query.next()){
        ui->cellIDComboBox->addItem(query.value(0).toString());
    }
    ui->stackedWidget_3->setCurrentIndex(2);
}

void Control::page15()
{

    ui->stackedWidget_4->setCurrentIndex(0);
}

void Control::page16()
{
    QSqlQuery query;
    query.exec("select distinct CellID from DATAS order by CellID");
    while(query.next()){
        ui->cellIDComboBox_3->addItem(query.value(0).toString());
    }
    ui->stackedWidget_4->setCurrentIndex(1);
}

void Control::page17()
{
    ui->stackedWidget_4->setCurrentIndex(2);
}

void Control::page18()
{
    ui->stackedWidget_4->setCurrentIndex(3);
}

Control::~Control()
{
    delete ui;
}

void Control::bulkInsert()
{
    QSqlQuery query;
    query.exec("exec DaoRu");
    if(query.lastError().type() != QSqlError::NoError)
    {
        QMessageBox* message = new QMessageBox();
        QString str;
        str += query.lastError().databaseText();
        message->setWindowTitle("错误");
        message->setText(str);
        message->exec();
//        ui->confirm->setEnabled(true);
        return;
    }
    initTime();
    addBTSname();
    addCellID();
    QMessageBox* message = new QMessageBox();
    QString str;
    str += "批量导入成功！";
    message->setWindowTitle("成功");
    message->setText(str);
    message->exec();
}

void Control::addBTSname()
{
    ui->comboBox_3->clear();
    QStringList BTSnames;
    QSqlQuery query;
    query.exec("select distinct BtsName from BTS");
    while(query.next())
        BTSnames.append(query.value(0).toString());
    ui->comboBox_3->addItems(BTSnames);
}

void Control::addCellID()
{
    ui->comboBox_4->clear();
    QStringList CellIDs;
    QSqlQuery query;
    query.exec("select distinct CellID from CELL");
    while(query.next())
        CellIDs.append(query.value(0).toString());
    ui->comboBox_4->addItems(CellIDs);
    ui->comboBox_5->addItems(CellIDs);
}

void Control::data_in()
{
    ui->confirm->setEnabled(false);
    in->data_in(ui->comboBox->currentIndex());
    initTime();
    addBTSname();
    addCellID();
    QMessageBox* message = new QMessageBox();
    QString str;
    str += "已导入！";
    message->setWindowTitle("成功");
    message->setText(str);
    message->exec();
    ui->confirm->setEnabled(true);
}

void Control::data_out()
{
    ui->confirm_2->setEnabled(false);
    if(!ui->txt->isChecked()&&!ui->excel->isChecked())
    {
        QMessageBox* message = new QMessageBox();
        QString str;
        str += "请选择导出文件类型！";
        message->setWindowTitle("错误");
        message->setText(str);
        message->exec();
        ui->confirm_2->setEnabled(true);
        return;
    }
    bool txtORexcel = ui->txt->isChecked()? true:false;
    out->data_out(ui->comboBox_2->currentText(),txtORexcel);
    QMessageBox* message = new QMessageBox();
    QString str;
    str += "导出成功！";
    message->setWindowTitle("成功");
    message->setText(str);
    message->exec();
    ui->confirm_2->setEnabled(true);
}

void Control::queryBTS()
{
    QString BTSname = ui->comboBox_3->currentText();
    QSqlQuery query;
    query.exec("select * from BTS where BtsName = '"+BTSname+"'");
    if(query.next())
    {
        ui->label_12->setText(query.value(2).toString());
        ui->label_13->setText(query.value(3).toString());
        ui->label_14->setText(query.value(4).toString());
        ui->label_15->setText(query.value(5).toString());
        ui->label_16->setText(query.value(6).toString());
        ui->label_6->setVisible(true);
        ui->label_7->setVisible(true);
        ui->label_8->setVisible(true);
        ui->label_9->setVisible(true);
        ui->label_10->setVisible(true);
        ui->label_12->setVisible(true);
        ui->label_13->setVisible(true);
        ui->label_14->setVisible(true);
        ui->label_15->setVisible(true);
        ui->label_16->setVisible(true);
    }
}

void Control::queryCell()
{
    QString CellID = ui->comboBox_4->currentText();
    QSqlQuery query;
    query.exec("select count(*) from CELL,FREQ where CELL.CellID=FREQ.CellID and CELL.CellID = '"+CellID+"'");
    if(query.next())
        ui->label_35->setText(query.value(0).toString());
    query.exec("select * from CELL where CellID = '"+CellID+"'");
    if(query.next())
    {
        ui->label_23->setText(query.value(1).toString());
        ui->label_22->setText(query.value(2).toString());
        ui->label_17->setText(query.value(3).toString());
        ui->label_24->setText(query.value(4).toString());
        ui->label_25->setText(query.value(5).toString());
        ui->label_31->setText(query.value(6).toString());
        ui->label_32->setText(query.value(7).toString());
        ui->label_33->setText(query.value(8).toString());
        ui->label_17->setVisible(true);
        ui->label_19->setVisible(true);
        ui->label_20->setVisible(true);
        ui->label_21->setVisible(true);
        ui->label_22->setVisible(true);
        ui->label_23->setVisible(true);
        ui->label_24->setVisible(true);
        ui->label_25->setVisible(true);
        ui->label_26->setVisible(true);
        ui->label_27->setVisible(true);
        ui->label_28->setVisible(true);
        ui->label_29->setVisible(true);
        ui->label_30->setVisible(true);
        ui->label_31->setVisible(true);
        ui->label_32->setVisible(true);
        ui->label_33->setVisible(true);
        ui->label_34->setVisible(true);
        ui->label_35->setVisible(true);
    }
}

void Control::reCalculateDatas()
{
    QSqlQuery query;
    query.exec("exec inDATAS2");
    if(query.lastError().type() != QSqlError::NoError)
    {
        QMessageBox* message = new QMessageBox();
        QString str;
        str += query.lastError().databaseText();
        message->setWindowTitle("错误");
        message->setText(str);
        message->exec();
        ui->confirm->setEnabled(true);
        return;
    }
    QMessageBox* message = new QMessageBox();
    QString str;
    str += "重新计算成功！";
    message->setWindowTitle("成功");
    message->setText(str);
    message->exec();
}

void Control::findNeighbor()
{
    Distance* countDistance = new Distance();
    QVector<Point*> pointVec;
    QSqlQuery query;
    query.exec("select CellID,Longitude,Latitude from CELL");
    while(query.next())
    {
        Point* p=new Point(query.value(0).toInt(),query.value(1).toDouble(),query.value(2).toDouble());
        pointVec.append(p);
    }
    for(int i=0;i<pointVec.size();i++)
        for(int j=i+1;j<pointVec.size();j++)
        {
            double result =
                    countDistance->countDistance(pointVec.at(i)->Longitude,pointVec.at(i)->Latitude,
                                         pointVec.at(j)->Longitude,pointVec.at(j)->Latitude);
            query.exec("insert into Distance values("+
                       QString::number(pointVec.at(i)->CellID)
                       +","+QString::number(pointVec.at(j)->CellID)+","+QString::number(result)+"),""("+
                       QString::number(pointVec.at(j)->CellID)
                       +","+QString::number(pointVec.at(i)->CellID)+","+QString::number(result)+")");
        }
    QMessageBox* message = new QMessageBox();
    QString str;
    str += "邻居计算成功！";
    message->setWindowTitle("成功");
    message->setText(str);
    message->exec();
}

void Control::printNeighbor()
{
    QString whichID = ui->comboBox_5->currentText();
    QSqlTableModel* model = new QSqlTableModel(this);
    model->setTable("Distance");
    model->setEditStrategy(QSqlTableModel::OnManualSubmit);
    model->setFilter("CellID1="+whichID+" and distance<=2 order by distance asc");
    model->setHeaderData(1,Qt::Horizontal,tr("邻居"));
    model->setHeaderData(2,Qt::Horizontal,tr("距离（千米）"));
    model->select();
    ui->tableView->setModel(model);
    ui->tableView->show();
    ui->tableView->setColumnHidden(model->fieldIndex("CellID1"),true);
}

void Control::findCellInfo()
{
    if(!checkDurationValid())
    {
        QMessageBox::warning(this,"警告","请选择正确的时间段",QMessageBox::Yes);
        return;
    }
    if(ui->lineEdit->text().isEmpty())
    {
        QMessageBox::warning(this,"警告","请输入拥塞门限（0到1的小数）",QMessageBox::Yes);
        return;
    }
    double rate= ui->lineEdit->text().toDouble();
    QSqlQuery query;
    query.exec("exec countCongs");
    QDateTime start = ui->startDateTimeEdit->dateTime();
    QDateTime end = ui->endDateTimeEdit->dateTime();

    int year1 = start.date().year() % 10 * 10000;
    int month1 = start.date().month() * 100;
    int day1 = start.date().day();
    int hour1 = start.time().hour();
    int year2 = end.date().year() % 10 * 10000;
    int month2 = end.date().month() * 100;
    int day2 = end.date().day();
    int hour2 = end.time().hour();

    query.exec(QString("exec finder2 %1,%2,%3,%4,%5").arg(rate).arg(year1 + month1 + day1).arg(hour1)
               .arg(year2 + month2 + day2).arg(hour2));//finder2只列rate超过门限的部分数据

    QSqlTableModel* model = new QSqlTableModel(this);
    model->setTable("H_result");
    model->setEditStrategy(QSqlTableModel::OnManualSubmit);
    model->setFilter("H_rate>"+QString::number(rate) +" order by CellID,bdate,btime");
    model->setHeaderData(0,Qt::Horizontal,tr("日期"));
    model->setHeaderData(1,Qt::Horizontal,tr("小时"));
    model->setHeaderData(2,Qt::Horizontal,tr("小区ID"));
    model->setHeaderData(3,Qt::Horizontal,tr("小时级话务量"));
    model->setHeaderData(4,Qt::Horizontal,tr("小时级拥塞率"));
    model->setHeaderData(5,Qt::Horizontal,tr("小时级半速率话务量比例"));
    model->select();
    ui->tableView_2->setModel(model);
    ui->tableView_2->show();
}

bool Control::checkDurationValid()
{
    QDateTime start = ui->startDateTimeEdit->dateTime();
    start = start.addSecs(3600);
    QDateTime end = ui->endDateTimeEdit->dateTime();
    return start <= end;
}
bool Control::checkDurationValid_2()
{
    QDateTime start = ui->startDateTimeEdit_2->dateTime();
    start = start.addSecs(3600);
    QDateTime end = ui->endDateTimeEdit_2->dateTime();
    return start <= end;
}
bool Control::checkDurationValid_3()
{
    QDateTime start = ui->startDateTimeEdit_3->dateTime();
    start = start.addSecs(3600);
    QDateTime end = ui->endDateTimeEdit_3->dateTime();
    return start <= end;
}
bool Control::checkDurationValid_4()
{
    QDateTime start = ui->startDateTimeEdit_4->dateTime();
    start = start.addSecs(3600);
    QDateTime end = ui->endDateTimeEdit_4->dateTime();
    return start <= end;
}

void Control::on_teleAmountButton_clicked()
{
    if(!checkDurationValid_2()){
        QMessageBox::warning(this,"警告","请选择正确的时间段",QMessageBox::Yes);
        return;
    }
    QString cellid = ui->cellIDComboBox->currentText();
    QString title = "小区" + cellid +   "小时级话务量折线图";
    QString data_name = "小时级话务量";
    QString xAxis_name = "时间";
    QStringList xAxis_data_list;
    QString yAxis_name = "话务量";
    QStringList yAxis_data_list;
    QDateTime start = ui->startDateTimeEdit_2->dateTime();
    QDateTime end = ui->endDateTimeEdit_2->dateTime();
    QSqlQuery query;
    for(;start <= end ; start = start.addSecs(3600)){
        int year = start.date().year() % 10 * 10000;
        int month = start.date().month() * 100;
        int day = start.date().day();
        int hour = start.time().hour();
        xAxis_data_list.push_back(QString("%1").arg((year + month +day) * 100 + hour));
        query.exec(QString("exec calc_tele_amount %1,%2,%3").arg(cellid).arg(year + month + day).arg(hour));
        query.next();
        yAxis_data_list.push_back(query.value(0).toString());
    }
    QString xAxis_data = xAxis_data_list.join(",");
    QString yAxis_data = yAxis_data_list.join(",");
    GSMWebPage *page = new GSMWebPage(title + ";" + data_name + ";" + xAxis_name + ";" + xAxis_data + ";" + yAxis_name + ";" + yAxis_data);
    ChartDialog w;
    QWebView view(&w);
    view.setPage(page);
    view.setGeometry(0,0,1000,400);
    view.load(QUrl("file:///F:/QT/GSM/test.html"));
    w.exec();
}



void Control::on_congestRatioButton_clicked()
{
    if(!checkDurationValid_2()){
        QMessageBox::warning(this,"警告","请选择正确的时间段",QMessageBox::Yes);
        return;
    }
    QString cellid = ui->cellIDComboBox->currentText();
    QString title = "小区" + cellid +   "小时级拥塞率折线图";
    QString data_name = "小时级拥塞率";
    QString xAxis_name = "时间";
    QStringList xAxis_data_list;
    QString yAxis_name = "拥塞率";
    QStringList yAxis_data_list;
    QDateTime start = ui->startDateTimeEdit_2->dateTime();
    QDateTime end = ui->endDateTimeEdit_2->dateTime();
    QSqlQuery query;
    for(;start <= end ; start = start.addSecs(3600)){
        int year = start.date().year() % 10 * 10000;
        int month = start.date().month() * 100;
        int day = start.date().day();
        int hour = start.time().hour();
        xAxis_data_list.push_back(QString("%1").arg((year + month +day) * 100 + hour));
        query.exec(QString("exec calc_congest_ratio %1,%2,%3").arg(cellid).arg(year + month + day).arg(hour));
        query.next();
        yAxis_data_list.push_back(query.value(0).toString());
    }
    QString xAxis_data = xAxis_data_list.join(",");
    QString yAxis_data = yAxis_data_list.join(",");
    GSMWebPage *page = new GSMWebPage(title + ";" + data_name + ";" + xAxis_name + ";" + xAxis_data + ";" + yAxis_name + ";" + yAxis_data);
    ChartDialog w;
    QWebView view(&w);
    view.setPage(page);
    view.setGeometry(0,0,1000,400);
    view.load(QUrl("file:///F:/QT/GSM/test.html"));
    w.exec();
}

void Control::on_hafAmountRatioButton_clicked()
{
    if(!checkDurationValid_2()){
        QMessageBox::warning(this,"警告","请选择正确的时间段",QMessageBox::Yes);
        return;
    }
    QString cellid = ui->cellIDComboBox->currentText();
    QString title = "小区" + cellid +   "小时级半速率话务量比例";
    QString data_name = "小时级半速率话务量比例";
    QString xAxis_name = "时间";
    QStringList xAxis_data_list;
    QString yAxis_name = "半速率话务量比例";
    QStringList yAxis_data_list;
    QDateTime start = ui->startDateTimeEdit_2->dateTime();
    QDateTime end = ui->endDateTimeEdit_2->dateTime();
    QSqlQuery query;
    for(;start <= end ; start = start.addSecs(3600)){
        int year = start.date().year() % 10 * 10000;
        int month = start.date().month() * 100;
        int day = start.date().day();
        int hour = start.time().hour();
        xAxis_data_list.push_back(QString("%1").arg((year + month +day) * 100 + hour));
        query.exec(QString("exec calc_half_ratio %1,%2,%3").arg(cellid).arg(year + month + day).arg(hour));
        query.next();
        yAxis_data_list.push_back(query.value(0).toString());
    }
    QString xAxis_data = xAxis_data_list.join(",");
    QString yAxis_data = yAxis_data_list.join(",");
    GSMWebPage *page = new GSMWebPage(title + ";" + data_name + ";" + xAxis_name + ";" + xAxis_data + ";" + yAxis_name + ";" + yAxis_data);
    ChartDialog w;
    QWebView view(&w);
    view.setPage(page);
    view.setGeometry(0,0,1000,400);
    view.load(QUrl("file:///F:/QT/GSM/test.html"));
    w.exec();
}

void Control::on_teleAmountButton_2_clicked()
{
    if(!checkDurationValid_3()){
        QMessageBox::warning(this,"警告","请选择正确的时间段",QMessageBox::Yes);
        return;
    }
    QString cellid = ui->cellIDComboBox->currentText();
    QString title = "小区" + cellid +   "小时级话务量折线图";
    QString data_name = "小时级话务量";
    QString xAxis_name = "时间";
    QStringList xAxis_data_list;
    QString yAxis_name = "话务量";
    QStringList yAxis_data_list;
    QDateTime start = ui->startDateTimeEdit_3->dateTime();
    QDateTime end = ui->endDateTimeEdit_3->dateTime();
    QSqlQuery query;
    for(;start <= end ; start = start.addSecs(3600)){
        int year = start.date().year() % 10 * 10000;
        int month = start.date().month() * 100;
        int day = start.date().day();
        int hour = start.time().hour();
        xAxis_data_list.push_back(QString("%1").arg((year + month +day) * 100 + hour));
        query.exec(QString("exec calc_tele_amount %1,%2,%3").arg(cellid).arg(year + month + day).arg(hour));
        query.next();
        yAxis_data_list.push_back(query.value(0).toString());
    }
    QString xAxis_data = xAxis_data_list.join(",");
    QString yAxis_data = yAxis_data_list.join(",");
    GSMWebPage *page = new GSMWebPage(title + ";" + data_name + ";" + xAxis_name + ";" + xAxis_data + ";" + yAxis_name + ";" + yAxis_data);
    ChartDialog w;
    QWebView view(&w);
    view.setPage(page);
    view.setGeometry(0,0,1000,400);
    view.load(QUrl("file:///F:/QT/GSM/test.html"));
    w.exec();
}

void Control::on_congestRatioButton_2_clicked()
{
    if(!checkDurationValid_3()){
        QMessageBox::warning(this,"警告","请选择正确的时间段",QMessageBox::Yes);
        return;
    }
    QString cellid = ui->cellIDComboBox_2->currentText();
    QString title = "小区" + cellid +   "小时级拥塞率折线图";
    QString data_name = "小时级拥塞率";
    QString xAxis_name = "时间";
    QStringList xAxis_data_list;
    QString yAxis_name = "拥塞率";
    QStringList yAxis_data_list;
    QDateTime start = ui->startDateTimeEdit_3->dateTime();
    QDateTime end = ui->endDateTimeEdit_3->dateTime();
    QSqlQuery query;
    for(;start <= end ; start = start.addSecs(3600)){
        int year = start.date().year() % 10 * 10000;
        int month = start.date().month() * 100;
        int day = start.date().day();
        int hour = start.time().hour();
        xAxis_data_list.push_back(QString("%1").arg((year + month +day) * 100 + hour));
        query.exec(QString("exec calc_congest_ratio %1,%2,%3").arg(cellid).arg(year + month + day).arg(hour));
        query.next();
        yAxis_data_list.push_back(query.value(0).toString());
    }
    QString xAxis_data = xAxis_data_list.join(",");
    QString yAxis_data = yAxis_data_list.join(",");
    GSMWebPage *page = new GSMWebPage(title + ";" + data_name + ";" + xAxis_name + ";" + xAxis_data + ";" + yAxis_name + ";" + yAxis_data);
    ChartDialog w;
    QWebView view(&w);
    view.setPage(page);
    view.setGeometry(0,0,1000,400);
    view.load(QUrl("file:///F:/QT/GSM/test.html"));
    w.exec();
}

void Control::on_pushButton_19_clicked()
{
    if(!checkDurationValid_3()){
        QMessageBox::warning(this,"警告","请选择正确的时间段",QMessageBox::Yes);
        return;
    }
    QString cellid = ui->cellIDComboBox_2->currentText();
    QString title = "小区" + cellid +   "小时级每线话务量";
    QString data_name = "小时级每线话务量";
    QString xAxis_name = "时间";
    QStringList xAxis_data_list;
    QString yAxis_name = "每线话务量";
    QStringList yAxis_data_list;
    QDateTime start = ui->startDateTimeEdit_3->dateTime();
    QDateTime end = ui->endDateTimeEdit_3->dateTime();
    QSqlQuery query;
    for(;start <= end ; start = start.addSecs(3600)){
        int year = start.date().year() % 10 * 10000;
        int month = start.date().month() * 100;
        int day = start.date().day();
        int hour = start.time().hour();
        xAxis_data_list.push_back(QString("%1").arg((year + month +day) * 100 + hour));
        query.exec(QString("exec calc_tch_tele_amount %1,%2,%3").arg(cellid).arg(year + month + day).arg(hour));
        query.next();
        yAxis_data_list.push_back(query.value(0).toString());
    }
    QString xAxis_data = xAxis_data_list.join(",");
    QString yAxis_data = yAxis_data_list.join(",");
    GSMWebPage *page = new GSMWebPage(title + ";" + data_name + ";" + xAxis_name + ";" + xAxis_data + ";" + yAxis_name + ";" + yAxis_data);
    ChartDialog w;
    QWebView view(&w);
    view.setPage(page);
    view.setGeometry(0,0,1000,400);
    view.load(QUrl("file:///F:/QT/GSM/test.html"));
    w.exec();
}

void Control::on_pushButton_20_clicked()
{
    if(!checkDurationValid_4()){
        QMessageBox::warning(this,"警告","请选择正确的时间段",QMessageBox::Yes);
        return;
    }
    QString cellid = ui->cellIDComboBox_3->currentText();
    QString title = "小区" + cellid +   "分钟级话务量";
    QString data_name = "分钟级话务量";
    QString xAxis_name = "时间";
    QStringList xAxis_data_list;
    QString yAxis_name = "话务量";
    QStringList yAxis_data_list;
    QDateTime start = ui->startDateTimeEdit_4->dateTime();
    QDateTime end = ui->endDateTimeEdit_4->dateTime();
    QSqlQuery query;
    for(;start <= end ; start = start.addSecs(60)){
        int year = start.date().year() % 10 * 10000;
        int month = start.date().month() * 100;
        int day = start.date().day();
        int hour = start.time().hour() * 100;
        int minute = start.time().minute();
        xAxis_data_list.push_back(QString("%1").arg(year + month +day) + QString("%1").arg(hour+minute));
        query.exec(QString("exec calc_tele_amount_minute %1,%2,%3").arg(cellid).arg(year + month + day).arg(hour +minute));
        query.next();
        yAxis_data_list.push_back(query.value(0).toString());
    }
    QString xAxis_data = xAxis_data_list.join(",");
    QString yAxis_data = yAxis_data_list.join(",");
    GSMWebPage *page = new GSMWebPage(title + ";" + data_name + ";" + xAxis_name + ";" + xAxis_data + ";" + yAxis_name + ";" + yAxis_data);
    ChartDialog w;
    QWebView view(&w);
    view.setPage(page);
    view.setGeometry(0,0,1000,400);
    view.load(QUrl("file:///F:/QT/GSM/test.html"));
    w.exec();
}

void Control::on_pushButton_21_clicked()
{
    if(!checkDurationValid_4()){
        QMessageBox::warning(this,"警告","请选择正确的时间段",QMessageBox::Yes);
        return;
    }
    QString cellid = ui->cellIDComboBox_3->currentText();
    QString title = "小区" + cellid +   " 15分钟级话务量";
    QString data_name = "15分钟级话务量";
    QString xAxis_name = "时间";
    QStringList xAxis_data_list;
    QString yAxis_name = "话务量";
    QStringList yAxis_data_list;
    QDateTime start = ui->startDateTimeEdit_4->dateTime();
    QDateTime end = ui->endDateTimeEdit_4->dateTime();
    QSqlQuery query;
    for(;start <= end ; start = start.addSecs(900)){
        int year = start.date().year() % 10 * 10000;
        int month = start.date().month() * 100;
        int day = start.date().day();
        int hour = start.time().hour() * 100;
        int minute = start.time().minute();
        xAxis_data_list.push_back(QString("%1").arg(year + month +day) + QString("%1").arg(hour+minute));
        query.exec(QString("exec calc_tele_amount_quater %1,%2,%3").arg(cellid).arg(year + month + day).arg(hour +minute));
        query.next();
        yAxis_data_list.push_back(query.value(0).toString());
    }
    QString xAxis_data = xAxis_data_list.join(",");
    QString yAxis_data = yAxis_data_list.join(",");
    GSMWebPage *page = new GSMWebPage(title + ";" + data_name + ";" + xAxis_name + ";" + xAxis_data + ";" + yAxis_name + ";" + yAxis_data);
    ChartDialog w;
    QWebView view(&w);
    view.setPage(page);
    view.setGeometry(0,0,1000,400);
    view.load(QUrl("file:///F:/QT/GSM/test.html"));
    w.exec();
}

void Control::action22()
{
    printNeighbor();
    int whichID = ui->comboBox_5->currentText().toInt();
    Dataout* out_neighbor = new Dataout(whichID,"Distance",this);
    out_neighbor->exec();
    out_neighbor=NULL;
    QMessageBox* message = new QMessageBox();
    QString str;
    str += "导出结果成功！";
    message->setWindowTitle("成功");
    message->setText(str);
    message->exec();
}

void Control::action23()
{
    if(!checkDurationValid())
    {
        QMessageBox::warning(this,"警告","请选择正确的时间段",QMessageBox::Yes);
        return;
    }
    if(ui->lineEdit->text().isEmpty())
    {
        QMessageBox::warning(this,"警告","请输入拥塞门限（0到1的小数）",QMessageBox::Yes);
        return;
    }
    findCellInfo();
    Dataout* out_congsCell = new Dataout(23,"H_result",this);
    out_congsCell->exec();
    out_congsCell=NULL;
    QMessageBox* message = new QMessageBox();
    QString str;
    str += "导出结果成功！";
    message->setWindowTitle("成功");
    message->setText(str);
    message->exec();
}
