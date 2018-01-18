#include "dataout.h"
#include "ui_dataout.h"
#include <QDir>
#include <QMessageBox>

using namespace std;

Dataout::Dataout(int flag,QString where, QWidget *parent) :
    QDialog(parent),
    ui(new Ui::Dataout)
{
    ui->setupUi(this);
    flags = flag;
    Where = where;
//    QButtonGroup *type = new QButtonGroup;
//    type->addButton(ui->yes);
//    type->addButton(ui->no);

    connect(ui->confirm,SIGNAL(clicked()),this,SLOT(testtest()));
    connect(ui->cancel,SIGNAL(clicked()),this,SLOT(reject()));
}

void Dataout::testtest()
{
//    if(!ui->yes->isChecked()&&!ui->no->isChecked())
//    {
//        QMessageBox::warning(this,"警告","请选择是否覆盖",QMessageBox::Yes);
//        return;
//    }
    out_queryResult();
    this->reject();
}

Dataout::~Dataout()
{
    delete ui;
}

void Dataout::out_queryResult()
{
        QSqlQuery query;
        query.exec("Select count(name) from syscolumns Where ID=OBJECT_ID('"+Where+"')");
        int count;
        if(query.next())
            count = query.value(0).toInt();
        string filePath = "C:\\Users\\luckydog\\Desktop\\DB\\"+Where.toStdString()+".txt";
        char filefile[60];
        filePath.copy(filefile,filePath.length(),0);
        filefile[filePath.length()]='\0';
        ofstream fs(filefile,ios::out|ios::trunc);
        string a[count];
        query.exec("Select name from syscolumns Where ID=OBJECT_ID('"+Where+"') order by colid");
        for(int j=0;query.next();j++)
        {
            a[j] = query.value(0).toString().toStdString();
            fs<<setiosflags(ios::left)<<setw(20)<<a[j];
        }
        fs<<endl;
        if(flags!=23)
            Where+= " where CellID1 = "+QString::number(flags)+" and distance<=2 order by distance asc";
        else
            Where+= " order by CellID,bdate,btime";
        query.exec("select * from "+Where);
        while(query.next())
        {
            for(int j=0;j<count;j++)
            {
                a[j] = query.value(j).toString().toStdString();
                fs<<setiosflags(ios::left)<<setw(20)<<a[j];
            }
            fs<<endl;
        }
        fs.close();
//    qDebug()<<"导出"+Where+"成功！";
    return;
}

void Dataout::data_out(QString where, bool txtORexcel)
{
    qDebug()<<where;
    if(!txtORexcel)
    {
        QString filePath = "C:\\Users\\luckydog\\Desktop\\DB\\GSM_"+where+".xlsx";
        if(!filePath.isEmpty()){
            QAxObject *excel = new QAxObject(this);
            excel->setControl("Excel.Application");//连接Excel控件
            excel->dynamicCall("SetVisible (bool Visible)","false");//不显示窗体
            excel->setProperty("DisplayAlerts", false);//不显示任何警告信息。如果为true那么在关闭是会出现类似“文件已修改，是否保存”的提示
            QAxObject *workbooks = excel->querySubObject("WorkBooks");//获取工作簿集合
            workbooks->dynamicCall("Add");//新建一个工作簿
            QAxObject *workbook = excel->querySubObject("ActiveWorkBook");//获取当前工作簿
            QAxObject *worksheets = workbook->querySubObject("Sheets");//获取工作表集合
            QAxObject *worksheet = worksheets->querySubObject("Item(int)",1);//获取工作表集合的工作表1，即sheet1

            QSqlQuery query;
            int count=0;
            query.exec("Select name from syscolumns Where ID=OBJECT_ID('"+where+"') order by colid");
            for(;query.next();count++)
            {
                QString v = (char)(65+count) + QString::number(1);
                QAxObject* cell = worksheet->querySubObject("Range(QVariant, QVariant)",v);
                cell->dynamicCall("SetValue(const QVariant&)",QVariant(query.value(0).toString()));
            }
            query.exec("select * from "+where);
            int i = 1;
            while(query.next())
            {
                for(int j=0;j<count;j++)
                {
                    QString v = (char)(65+j) + QString::number(i+1);
                    QAxObject* cell = worksheet->querySubObject("Range(QVariant, QVariant)",v);
                    cell->dynamicCall("SetValue(const QVariant&)",QVariant(query.value(j).toString()));
    //                qDebug()<<query.value(j).toString();
                }
                    i++;
            }

            workbook->dynamicCall("SaveAs(const QString&)",QDir::toNativeSeparators(filePath));//保存至filePath，注意一定要用QDir::toNativeSeparators将路径中的"/"转换为"\"，不然一定保存不了。
            workbook->dynamicCall("Close()");//关闭工作簿
            excel->dynamicCall("Quit()");//关闭excel
            delete excel;
            excel=NULL;
        }
    }
    else
    {
        QSqlQuery query;
        query.exec("Select count(name) from syscolumns Where ID=OBJECT_ID('"+where+"')");
        int count;
        if(query.next())
            count = query.value(0).toInt();
        qDebug()<<count;
        string filePath = "C:\\Users\\luckydog\\Desktop\\DB\\"+where.toStdString()+".txt";
        char filefile[60];
        filePath.copy(filefile,filePath.length(),0);
        filefile[filePath.length()]='\0';
        ofstream fs(filefile,ios::out|ios::trunc);
        string a[count];
        query.exec("Select name from syscolumns Where ID=OBJECT_ID('"+where+"') order by colid");
        for(int j=0;query.next();j++)
        {
            a[j] = query.value(0).toString().toStdString();
            fs<<setiosflags(ios::left)<<setw(20)<<a[j];
        }
        fs<<endl;
        query.exec("select * from "+where);
        while(query.next())
        {
            for(int j=0;j<count;j++)
            {
                a[j] = query.value(j).toString().toStdString();
                fs<<setiosflags(ios::left)<<setw(20)<<a[j];
            }
            fs<<endl;
        }
        fs.close();
    }
    qDebug()<<"导出"+where+"成功！";
    ui->confirm->setEnabled(true);
}
