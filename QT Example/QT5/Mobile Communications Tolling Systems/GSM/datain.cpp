#include "datain.h"
#include "ui_datain.h"
#include <qdebug.h>

DataIn::DataIn(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::DataIn)
{
    ui->setupUi(this);

//    connect(ui->MS,SIGNAL(clicked()),this,SLOT(MS()));
//    connect(ui->MSC,SIGNAL(clicked()),this,SLOT(MSC()));
//    connect(ui->BSC,SIGNAL(clicked()),this,SLOT(BSC()));
//    connect(ui->BTS,SIGNAL(clicked()),this,SLOT(BTS()));
//    connect(ui->Cell,SIGNAL(clicked()),this,SLOT(Cell()));
//    connect(ui->Freq,SIGNAL(clicked()),this,SLOT(Freq()));
//    connect(ui->Tianxian,SIGNAL(clicked()),this,SLOT(Tianxian()));
//    connect(ui->Neighbor,SIGNAL(clicked()),this,SLOT(Neighbor()));
//    connect(ui->Datas,SIGNAL(clicked()),this,SLOT(Datas()));
//    connect(ui->Locate,SIGNAL(clicked()),this,SLOT(Locate()));

//    connect(ui->confirm,SIGNAL(clicked()),this,SLOT(data_in()));
}

DataIn::~DataIn()
{
    delete ui;
}

void DataIn::data_in(int which)
{
    switch (which) {
    case 0:
        MS();
        break;
    case 1:
        MSC();
        break;
    case 2:
        BSC();
        break;
    case 3:
        BTS();
        break;
    case 4:
        Cell();
        break;
    case 5:
        Freq();
        break;
    case 6:
        Tianxian();
        break;
    case 7:
        Datas();
        break;
    case 8:
        Neighbor();
        break;
    case 9:
        Locate();
        break;
    default:
        break;
    }
}

void DataIn::MS()
{

    QAxObject excel("Excel.Application");
    excel.setProperty("Visible",false);
    QAxObject *workbooks = excel.querySubObject("WorkBooks");
    workbooks->dynamicCall("Open (const QString&)",QString("C:/Users/luckydog/Desktop/大三下小学期/数据库/数据库系统原理课程设计-16/背景资料/附录2-最小数据支撑集-08-v1.xls"));
    QAxObject *workbook = excel.querySubObject("ActiveWorkBook");//获取活动工作簿
    QAxObject *worksheet = workbook->querySubObject("WorkSheets(int)",1);//获取第1个工作表(sheet)

    QAxObject *used_range = worksheet->querySubObject("UsedRange");

    QAxObject *rows = used_range->querySubObject("Rows");
    int row_count = rows->property("Count").toInt();  //获取行数

    int k=2,record;

    while(k<=row_count)
    {
        QSqlQuery query;
        query.prepare("insert into MS values (?,?,?,?,?,?,?,?)");
        QAxObject *range[8];
        QVariantList  xinxi[8];
        record = k;
        for(int i=record;i<=record+49&&k<=row_count;i++)//一次最多批量处理49行
        {
            for(int j=0;j<8;j++)
            {
                range[j] = worksheet->querySubObject("Cells(int,int)",i,j+1); //获取cell的值
                if(j==4)
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toInt());
                else if(j==5||j==6)
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toDouble());
                else
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toString());
            }
            k ++;
        }
        for(int m=0;m<8;m++)
            query.addBindValue(xinxi[m]);
        query.execBatch(); //进行批处理

    }
    workbook->dynamicCall("Close(Boolean)", false);  //关闭文件
    excel.dynamicCall("Quit(void)");  //退出
    qDebug("导入MS成功！");
}

void DataIn::MSC()
{
    QAxObject excel("Excel.Application");
    excel.setProperty("Visible",false);
    QAxObject *workbooks = excel.querySubObject("WorkBooks");
    workbooks->dynamicCall("Open (const QString&)",QString("C:/Users/luckydog/Desktop/大三下小学期/数据库/数据库系统原理课程设计-16/背景资料/附录2-最小数据支撑集-08-v1.xls"));
    QAxObject *workbook = excel.querySubObject("ActiveWorkBook");//获取活动工作簿
    QAxObject *worksheet = workbook->querySubObject("WorkSheets(int)",2);//获取第2个工作表(sheet)

    QAxObject *used_range = worksheet->querySubObject("UsedRange");
    QAxObject *rows = used_range->querySubObject("Rows");
    int row_count = rows->property("Count").toInt();  //获取行数

    int k=2,record;
    while(k<=row_count)
    {
        QSqlQuery query;
        query.prepare("insert into MSC values (?,?,?,?,?,?)");

        QAxObject *range[6];
        QVariantList  xinxi[6];
        record =k;
        for(int i=record;i<=record+49&&k<=row_count;i++)
        {
            for(int j=0;j<6;j++)
            {
                range[j] = worksheet->querySubObject("Cells(int,int)",i,j+1); //获取cell的值
                if(j==3||j==4||j==5)
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toDouble());
                else
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toString());
            }
            k ++;
        }
        for(int m=0;m<6;m++)
            query.addBindValue(xinxi[m]);
        query.execBatch(); //进行批处理

    }
    workbook->dynamicCall("Close(Boolean)", false);  //关闭文件
    excel.dynamicCall("Quit(void)");  //退出

    qDebug("导入MSC成功！");
}

void DataIn::BSC()
{
    QAxObject excel("Excel.Application");
    excel.setProperty("Visible",false);
    QAxObject *workbooks = excel.querySubObject("WorkBooks");
    workbooks->dynamicCall("Open (const QString&)",QString("C:/Users/luckydog/Desktop/大三下小学期/数据库/数据库系统原理课程设计-16/背景资料/附录2-最小数据支撑集-08-v1.xls"));
    QAxObject *workbook = excel.querySubObject("ActiveWorkBook");//获取活动工作簿
    QAxObject *worksheet = workbook->querySubObject("WorkSheets(int)",3);//获取第3个工作表(sheet)

    QAxObject *used_range = worksheet->querySubObject("UsedRange");
    QAxObject *rows = used_range->querySubObject("Rows");
    int row_count = rows->property("Count").toInt();  //获取行数

    int k=2,record;
    while(k<=row_count)
    {
        QSqlQuery query;
        query.prepare("insert into BSC values (?,?,?,?,?,?)");

        QAxObject *range[6];
        QVariantList  xinxi[6];
        record =k;
        for(int i=record;i<=record+49&&k<=row_count;i++)
        {
            for(int j=0;j<6;j++)
            {
                range[j] = worksheet->querySubObject("Cells(int,int)",i,j+1); //获取cell的值
                if(j==3||j==4)
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toDouble());
                else
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toString());
            }
            k ++;
        }
        for(int m=0;m<6;m++)
            query.addBindValue(xinxi[m]);
        query.execBatch(); //进行批处理

    }
    workbook->dynamicCall("Close(Boolean)", false);  //关闭文件
    excel.dynamicCall("Quit(void)");  //退出

    qDebug("导入BSC成功！");
}

void DataIn::BTS()
{
    QAxObject excel("Excel.Application");
    excel.setProperty("Visible",false);
    QAxObject *workbooks = excel.querySubObject("WorkBooks");
    workbooks->dynamicCall("Open (const QString&)",QString("C:/Users/luckydog/Desktop/大三下小学期/数据库/数据库系统原理课程设计-16/背景资料/附录2-最小数据支撑集-08-v1.xls"));
    QAxObject *workbook = excel.querySubObject("ActiveWorkBook");//获取活动工作簿
    QAxObject *worksheet = workbook->querySubObject("WorkSheets(int)",4);//获取第4个工作表(sheet)

    QAxObject *used_range = worksheet->querySubObject("UsedRange");
    QAxObject *rows = used_range->querySubObject("Rows");
    int row_count = rows->property("Count").toInt();  //获取行数

    int k=2,record;
    while(k<=row_count)
    {

        QSqlQuery query;
        query.prepare("insert into BTS values (?,?,?,?,?,?,?)");
        QAxObject *range[7];
        QVariantList  xinxi[7];
        record =k;
        for(int i=record;i<=record+49&&k<=row_count;i++)
        {
            for(int j=0;j<7;j++)
            {
                range[j] = worksheet->querySubObject("Cells(int,int)",i,j+1); //获取cell的值
                if(j==2||j==3||j==4||j==6)
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toDouble());
                else
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toString());
            }
            k ++;
        }
        for(int m=0;m<7;m++)
            query.addBindValue(xinxi[m]);
        query.execBatch(); //进行批处理

    }
    workbook->dynamicCall("Close(Boolean)", false);  //关闭文件
    excel.dynamicCall("Quit(void)");  //退出

    qDebug()<<"BTS导入成功";
}

void DataIn::Cell()
{
    QAxObject excel("Excel.Application");
    excel.setProperty("Visible",false);
    QAxObject *workbooks = excel.querySubObject("WorkBooks");
    workbooks->dynamicCall("Open (const QString&)",QString("C:/Users/luckydog/Desktop/大三下小学期/数据库/数据库系统原理课程设计-16/背景资料/附录2-最小数据支撑集-08-v1.xls"));
    QAxObject *workbook = excel.querySubObject("ActiveWorkBook");//获取活动工作簿
    QAxObject *worksheet = workbook->querySubObject("WorkSheets(int)",5);//获取第5个工作表(sheet)

    QAxObject *used_range = worksheet->querySubObject("UsedRange");
    QAxObject *rows = used_range->querySubObject("Rows");
    int row_count = rows->property("Count").toInt();  //获取行数

    int k=2,record;
    while(k<=row_count)
    {

        QSqlQuery query;
        query.prepare("insert into CELL values (?,?,?,?,?,?,?,?,?)");
        QAxObject *range[9];
        QVariantList  xinxi[9];
        record =k;
        for(int i=record;i<=record+49&&k<=row_count;i++)
        {
            for(int j=0;j<9;j++)
            {
                range[j] = worksheet->querySubObject("Cells(int,int)",i,j+1); //获取cell的值
                if(j==4||j==5||j==6||j==7||j==8)
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toDouble());
                else
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toString());
            }
            k ++;
        }
        for(int m=0;m<9;m++)
            query.addBindValue(xinxi[m]);
        query.execBatch(); //进行批处理


    }
    workbook->dynamicCall("Close(Boolean)", false);  //关闭文件
    excel.dynamicCall("Quit(void)");  //退出

    qDebug()<<"小区基本信息导入成功";
}

void DataIn::Freq()
{
    QAxObject excel("Excel.Application");
    excel.setProperty("Visible",false);
    QAxObject *workbooks = excel.querySubObject("WorkBooks");
    workbooks->dynamicCall("Open (const QString&)",QString("C:/Users/luckydog/Desktop/大三下小学期/数据库/数据库系统原理课程设计-16/背景资料/附录2-最小数据支撑集-08-v1.xls"));
    QAxObject *workbook = excel.querySubObject("ActiveWorkBook");//获取活动工作簿
    QAxObject *worksheet = workbook->querySubObject("WorkSheets(int)",6);//获取第6个工作表(sheet)

    QAxObject *used_range = worksheet->querySubObject("UsedRange");
    QAxObject *rows = used_range->querySubObject("Rows");
    int row_count = rows->property("Count").toInt();  //获取行数

    int k=2,record;
    while(k<=row_count)
    {
        QSqlQuery query;
        query.prepare("insert into FREQ values (?,?)");

        QAxObject *range[2];
        QVariantList  xinxi[2];
        record =k;
        for(int i=record;i<=record+49&&k<=row_count;i++)
        {
            for(int j=0;j<2;j++)
            {
                range[j] = worksheet->querySubObject("Cells(int,int)",i,j+1); //获取cell的值
                if(j==1)
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toDouble());
                else
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toString());
            }
            k ++;
        }
        for(int m=0;m<2;m++)
            query.addBindValue(xinxi[m]);
        query.execBatch(); //进行批处理

    }
    workbook->dynamicCall("Close(Boolean)", false);  //关闭文件
    excel.dynamicCall("Quit(void)");  //退出

    qDebug()<<"小区频点信息导入成功";
}

void DataIn::Tianxian()
{
    QAxObject excel("Excel.Application");
    excel.setProperty("Visible",false);
    QAxObject *workbooks = excel.querySubObject("WorkBooks");
    workbooks->dynamicCall("Open (const QString&)",QString("C:/Users/luckydog/Desktop/大三下小学期/数据库/数据库系统原理课程设计-16/背景资料/附录2-最小数据支撑集-08-v1.xls"));
    QAxObject *workbook = excel.querySubObject("ActiveWorkBook");//获取活动工作簿
    QAxObject *worksheet = workbook->querySubObject("WorkSheets(int)",7);//获取第7个工作表(sheet)

    QAxObject *used_range = worksheet->querySubObject("UsedRange");
    QAxObject *rows = used_range->querySubObject("Rows");
    int row_count = rows->property("Count").toInt();  //获取行数

    int k=2,record;
    while(k<=row_count)
    {
        QSqlQuery query;
        query.prepare("insert into Antenna values (?,?,?,?,?,?,?,?)");

        QAxObject *range[8];
        QVariantList  xinxi[8];
        record =k;
        for(int i=record;i<=record+49&&k<=row_count;i++)
        {
            for(int j=0;j<8;j++)
            {
                range[j] = worksheet->querySubObject("Cells(int,int)",i,j+1); //获取cell的值
                if(j!=0)
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toDouble());
                else
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toString());
            }
            k ++;
        }
        for(int m=0;m<8;m++)
            query.addBindValue(xinxi[m]);
        query.execBatch(); //进行批处理

    }
    workbook->dynamicCall("Close(Boolean)", false);  //关闭文件
    excel.dynamicCall("Quit(void)");  //退出

    qDebug()<<"天线信息导入成功";
}

void DataIn::Neighbor()
{
    QAxObject excel("Excel.Application");
    excel.setProperty("Visible",false);
    QAxObject *workbooks = excel.querySubObject("WorkBooks");
    workbooks->dynamicCall("Open (const QString&)",QString("C:/Users/luckydog/Desktop/大三下小学期/数据库/数据库系统原理课程设计-16/背景资料/附录2-最小数据支撑集-08-v1.xls"));
    QAxObject *workbook = excel.querySubObject("ActiveWorkBook");//获取活动工作簿
    QAxObject *worksheet = workbook->querySubObject("WorkSheets(int)",8);//获取第8个工作表(sheet)

    QAxObject *used_range = worksheet->querySubObject("UsedRange");
    QAxObject *rows = used_range->querySubObject("Rows");
    int row_count = rows->property("Count").toInt();  //获取行数

    int k=2,record;
    while(k<=row_count)
    {
        QSqlQuery query;
        query.prepare("insert into neighbor values (?,?,?,?)");

        QAxObject *range[4];
        QVariantList  xinxi[4];
        record =k;
        for(int i=record;i<=record+49&&k<=row_count;i++)
        {
            for(int j=0;j<4;j++)
            {
                range[j] = worksheet->querySubObject("Cells(int,int)",i,j+1); //获取cell的值
                if(j!=0)
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toDouble());
                else
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toString());
            }
            k ++;
        }
        for(int m=0;m<4;m++)
            query.addBindValue(xinxi[m]);
        query.execBatch(); //进行批处理

    }
    workbook->dynamicCall("Close(Boolean)", false);  //关闭文件
    excel.dynamicCall("Quit(void)");  //退出

    qDebug()<<"邻区信息导入成功";
}

void DataIn::Datas()
{
    QAxObject excel("Excel.Application");
    excel.setProperty("Visible",false);
    QAxObject *workbooks = excel.querySubObject("WorkBooks");
    workbooks->dynamicCall("Open (const QString&)",QString("C:/Users/luckydog/Desktop/大三下小学期/数据库/数据库系统原理课程设计-16/背景资料/附录2-最小数据支撑集-08-v1.xls"));
    QAxObject *workbook = excel.querySubObject("ActiveWorkBook");//获取活动工作簿
    QAxObject *worksheet = workbook->querySubObject("WorkSheets(int)",9);//获取第9个工作表(sheet)

    QAxObject *used_range = worksheet->querySubObject("UsedRange");
    QAxObject *rows = used_range->querySubObject("Rows");
    int row_count = rows->property("Count").toInt();  //获取行数

    int k=2,record;
    while(k<=row_count)
    {

        QSqlQuery query;
        query.prepare("insert into DATAS values (?,?,?,?,?,?,?,?,?,?)");
        QAxObject *range[10];
        QVariantList  xinxi[10];
        record =k;
        for(int i=record;i<=record+49&&k<=row_count;i++)
        {
            for(int j=0;j<10;j++)
            {
                range[j] = worksheet->querySubObject("Cells(int,int)",i,j+1); //获取cell的值
                if(j!=2)
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toDouble());
                else
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toString());

            }
            k ++;
        }
        for(int m=0;m<10;m++)
            query.addBindValue(xinxi[m]);
        query.execBatch(); //进行批处理


    }

    workbook->dynamicCall("Close(Boolean)", false);  //关闭文件
    excel.dynamicCall("Quit(void)");  //退出

    qDebug()<<"话务数据导入成功";
}

void DataIn::Locate()
{
    QAxObject excel("Excel.Application");
    excel.setProperty("Visible",false);
    QAxObject *workbooks = excel.querySubObject("WorkBooks");
    workbooks->dynamicCall("Open (const QString&)",QString("C:/Users/luckydog/Desktop/大三下小学期/数据库/数据库系统原理课程设计-16/背景资料/附录2-最小数据支撑集-08-v1.xls"));
    QAxObject *workbook = excel.querySubObject("ActiveWorkBook");//获取活动工作簿
    QAxObject *worksheet = workbook->querySubObject("WorkSheets(int)",10);//获取第10个工作表(sheet)

    QAxObject *used_range = worksheet->querySubObject("UsedRange");
    QAxObject *rows = used_range->querySubObject("Rows");
    int row_count = rows->property("Count").toInt();  //获取行数

    int k=2,record;
    while(k<=row_count)
    {
        QSqlQuery query;
        query.prepare("insert into detectInfo values (?,?,?,?,?)");

        QAxObject *range[5];
        QVariantList  xinxi[5];
        record =k;
        for(int i=record;i<=record+49&&k<=row_count;i++)
        {
            for(int j=0;j<5;j++)
            {
                range[j] = worksheet->querySubObject("Cells(int,int)",i,j+1); //获取cell的值
                if(j==2||j==3||j==4)
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toDouble());
                else
                    xinxi[j]<<(range[j]->dynamicCall("Value2()").toString());
            }
            k ++;
        }
        for(int m=0;m<5;m++)
            query.addBindValue(xinxi[m]);
        query.execBatch(); //进行批处理

    }

    workbook->dynamicCall("Close(Boolean)", false);  //关闭文件
    excel.dynamicCall("Quit(void)");  //退出

    qDebug()<<"路测信息导入成功";
}
