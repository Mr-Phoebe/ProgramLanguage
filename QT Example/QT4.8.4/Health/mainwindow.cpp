#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    setWindowFlags(Qt::FramelessWindowHint);

    this->setWindowIcon(QIcon(":/new/prefix1/icon"));

    QBitmap objBitmap(size());
    QPainter painter(&objBitmap);
    painter.fillRect(rect(),Qt::white);
    painter.setBrush(QColor(0,0,0));
    painter.drawRoundedRect(this->rect(),5,5);
    setMask(objBitmap);
    //设置背景
    QPalette pal;
    QPixmap pixmap(":/new/prefix1/frame");
    pal.setBrush(QPalette::Window, QBrush(pixmap));
    setPalette(pal);

    ui->closeButton->setStyleSheet("QPushButton{border-image: url(:/new/prefix1/close);}"
                             "QPushButton:hover{border-image: url(:/new/prefix1/close2);}"
                             "QPushButton:pressed{border-image: url(:/new/prefix1/close2);}");

    ui->minButton->setStyleSheet("QPushButton{border-image: url(:/new/prefix1/min);}"
                           "QPushButton:hover{border-image: url(:/new/prefix1/min2);}"
                           "QPushButton:pressed{border-image: url(:/new/prefix1/min2);}");

    ui->orderButton->setStyleSheet("QPushButton{border-image: url(:/new/prefix1/cai);}"
                           "QPushButton:hover{border-image: url(:/new/prefix1/cai2);}"
                           "QPushButton:pressed{border-image: url(:/new/prefix1/cai2);}");


    ui->orderButton->setMenu(new QMenu());
    //下拉列表
    QString styleSheet;
    QFile file(":/new/prefix1/menu");
    file.open(QFile::ReadOnly);
    styleSheet = QString(file.readAll());
    ui->orderButton->menu()->setStyleSheet(styleSheet);

    addMenuList();
    //登录画面
    QPixmap mainGraph(":/new/prefix1/mainpicture");
    ui->maingraph->setPixmap(mainGraph);
    ui->maingraph->setVisible(true);
    ui->labeldelete->setVisible(false);
    ui->buttondelete->setVisible(false);
    ui->showstatus->setVisible(false);
    ui->showusername->setVisible(false);
    //欢迎
    ui->today->setText(tr("<-欢迎使用健康管理->"));
    ui->hint->setText(tr("请在右上角菜单栏选择您的用户或新建用户"));
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::mousePressEvent(QMouseEvent *event)
{
    if (event->button() == Qt::LeftButton)
    {
        m_dragPos = event->globalPos() - frameGeometry().topLeft();
        event->accept();
    }
}

void MainWindow::mouseMoveEvent(QMouseEvent *event)
{
    if (event->buttons() & Qt::LeftButton)
    {
        if (m_dragPos.y() < 110)
                move(event->globalPos() - m_dragPos);

        event->accept();
    }
}

void MainWindow::mouseDoubleClickEvent(QMouseEvent *event)
{
    if (event->button() == Qt::LeftButton)
        if (m_dragPos.y() < 110)

    event->accept();
}

void MainWindow::on_closeButton_clicked()
{
    close();
}

void MainWindow::on_minButton_clicked()
{
    this->showMinimized();
}

void MainWindow::addMenuList()
{
    ui->orderButton->menu()->clear();
    QString sql = "select name,sex from user";
    QSqlQuery query(sql);
    round = 0;
    while (query.next())
    {
        nameInfo[round] = query.value(0).toString();
        sexInfo[round] = query.value(1).toInt();
        QAction *action = new QAction(this);

        if(sexInfo[round])action->setIcon(QIcon(":/new/prefix1/female"));
                else action->setIcon(QIcon(":/new/prefix1/male"));
        action->setText(nameInfo[round]);

        switch (round) {
        case 0:
            connect(action,SIGNAL(triggered()),this,SLOT(on_clicked0()));
            break;
        case 1:
            connect(action,SIGNAL(triggered()),this,SLOT(on_clicked1()));
            break;
        case 2:
            connect(action,SIGNAL(triggered()),this,SLOT(on_clicked2()));
            break;
        case 3:
            connect(action,SIGNAL(triggered()),this,SLOT(on_clicked3()));
            break;
        case 4:
            connect(action,SIGNAL(triggered()),this,SLOT(on_clicked4()));
            break;
        case 5:
            connect(action,SIGNAL(triggered()),this,SLOT(on_clicked5()));
            break;
        case 6:
            connect(action,SIGNAL(triggered()),this,SLOT(on_clicked6()));
            break;
        case 7:
            connect(action,SIGNAL(triggered()),this,SLOT(on_clicked7()));
            break;
        case 8:
            connect(action,SIGNAL(triggered()),this,SLOT(on_clicked8()));
            break;
        case 9:
            connect(action,SIGNAL(triggered()),this,SLOT(on_clicked9()));
            break;
        default:
            break;
        }
        ui->orderButton->menu()->addAction(action);
        round++;
    }

    ui->orderButton->menu()->addSeparator();
    QAction *add = new QAction(this);
    add->setText("添加新用户");
    add->setIcon(QIcon(":/new/prefix1/add"));

    connect(add,SIGNAL(triggered()),this,SLOT(on_clicked10()));

    ui->orderButton->menu()->addAction(add);
}

void MainWindow::DrawMainWindow(QString nn, int ss)
{
    //获取当前日期
    QDate present = QDate::currentDate();
    //显示顶部信息
    ui->maingraph->setVisible(false);
    ui->showstatus->setAlignment(Qt::AlignBottom|Qt::AlignRight);
    ui->showusername->setAlignment(Qt::AlignBottom|Qt::AlignLeft);
    ui->labeldelete->setVisible(true);
    ui->buttondelete->setVisible(true);
    ui->showstatus->setVisible(true);
    ui->showusername->setVisible(true);

    if(userinfo->weight.empty())//未测试过
    {
        QFont ftstatus("Arial",13,QFont::Bold,false);
        QFont ftusername("Arial",25,QFont::Bold,false);

        QPalette pa;
        pa.setColor(QPalette::WindowText,Qt::white);
        ui->showstatus->setText("Unrated");
        ui->showusername->setText(nn);

        ui->showstatus->setPalette(pa);
        ui->showstatus->setFont(ftstatus);

        ui->showusername->setPalette(pa);
        ui->showusername->setFont(ftusername);
        ui->today->setText(tr("您还未做过体检"));
        ui->hint->setText(tr("请在下面开始您的第一次体检"));
        ui->between->setText(" ");
    }
    else
    {
        //显示用户名和健康状况
        QFont ftstatus("Arial",13,QFont::Bold,false);
        QFont ftusername("Arial",25,QFont::Bold,false);

        QPalette pa;

       double BMI = userinfo->CalculateBMI(userinfo->weight.back(),userinfo->height.back());
       double FAT = userinfo->CalculateFat(userinfo->circle.back(),userinfo->weight.back());

            //Normalsize Skinny Overweight Puffy

        if( BMI < 18.5 )
        {
            ui->hint->setText(tr("您的体重低于正常指标，建议您加强营养！"));
            pa.setColor(QPalette::WindowText,Qt::blue);ui->showstatus->setText("Skinny");
        }
        else if( BMI < 24.0 )
        {
            ui->hint->setText(tr("您的身体指标正常，请继续保持！"));
            pa.setColor(QPalette::WindowText,Qt::green);ui->showstatus->setText("Normalsize");
        }
        else if( BMI < 28.0 )
        {
            ui->hint->setText("您已超重，请注意进行合理的饮食和运动！");
            pa.setColor(QPalette::WindowText,Qt::yellow);ui->showstatus->setText("Overweight");
        }
        else
        {
            ui->hint->setText("过度肥胖危害健康，请尽快减肥或咨询医生！");
            pa.setColor(QPalette::WindowText,Qt::red);ui->showstatus->setText("Puffy");
        }

        ui->showusername->setText(nn);

        ui->showstatus->setPalette(pa);
        ui->showstatus->setFont(ftstatus);

        ui->showusername->setPalette(pa);
        ui->showusername->setFont(ftusername);

        QDate todaytmp = userinfo->testtime.back();
        ui->today->setText("上次您在"+todaytmp.toString("yyyy-MM-dd")+"BMI为"+QString::number(BMI,'f',2)+" 体脂率为"+QString::number(FAT,'f',2));
        int daystmp = todaytmp.daysTo(present);
        if(daystmp == 0)ui->between->setText("您今天已完成体检！");
        else if(daystmp < 5)ui->between->setText("您上次体检在 "+QString::number(daystmp)+" 天前，您可以现在进行体检！");
        else ui->between->setText("您已经 "+QString::number(daystmp)+" 天没有进行体检了，建议您立即体检！");
    }
    ui->showresult->setVisible(true);
    //画折线图
    PaintLineGraph(nn,ss);

    ui->inputc->setText(QString::null);
    ui->inputh->setText(QString::null);
    ui->inputw->setText(QString::null);
}

void MainWindow::PaintLineGraph(QString nn, int ss)
{
    //const int LSide = 0,RSide = 550,Top = 0,Bottom = 220;
    double TValue = -10000,BValue = 10000;
    int LValue,RValue;
    QVector<double> bmi;
    QVector<double> fat;
    bmi.clear();fat.clear();
    for(int i=0;i<userinfo->height.size();i++)
    {
        bmi.push_back( userinfo->CalculateBMI( userinfo->weight[i],userinfo->height[i] ) );
        TValue = qMax(TValue,bmi.back());
        BValue = qMin(BValue,bmi.back());
        fat.push_back( userinfo->CalculateFat( userinfo->circle[i],userinfo->weight[i] ) );
    }

    QPixmap *board = new QPixmap(":/new/prefix1/board");
    QPainter painter(board);

    double TPoint , BPoint;
    if(TValue - BValue > 0.1)
    {
        TPoint = TValue + (TValue-BValue)*0.2;
        BPoint = BValue - (TValue-BValue)*0.2;
    }
    else if(bmi.size() == 0)
    {
        TPoint = 30.0;
        BPoint = 16.0;

    }
    else
    {
        TPoint = TValue + 2.0;
        BPoint = BValue - 2.0;
    }
    //画矩形
    QBrush brush(Qt::Dense4Pattern);
    QVector<double> posvec;
    QVector<int> typevec;
    posvec.clear();typevec.clear();
    posvec.push_back(TPoint);
    typevec.push_back(0);

    if(28.0 <= TPoint && 28.0 >= BPoint){posvec.push_back(28.0);typevec.push_back(0);}
    if(24.0 <= TPoint && 24.0 >= BPoint){posvec.push_back(24.0);typevec.push_back(1);}
    if(18.5 <= TPoint && 18.5 >= BPoint){posvec.push_back(18.5);typevec.push_back(2);}
    posvec.push_back(BPoint);
    if(typevec.size()<=1)
    {
        if(TPoint>=28.0) typevec.push_back(0);
        else if(TPoint>=24.0) typevec.push_back(1);
        else if(TPoint>=18.5) typevec.push_back(2);
        else typevec.push_back(3);
    }
    else typevec.push_back(typevec.back()+1);


    for(int i=1;i<posvec.size();i++)
    {
        switch (typevec[i]) {
        case 0:
            brush.setColor(Qt::red);
            break;
        case 1:
            brush.setColor(Qt::yellow);
            break;
        case 2:
            brush.setColor(Qt::green);
            break;
        case 3:
            brush.setColor(Qt::blue);
            break;
        }
        painter.setBrush(brush);
        painter.drawRect(0,Translate(TPoint,BPoint,posvec[i-1]),550,Translate(TPoint,BPoint,posvec[i-1]-posvec[i]));
    }
    //划线写字

    for(int i=1;i<posvec.size();i++)
    {
        QPen pen(Qt::red,2);
        painter.setBrush(Qt::NoBrush);
        painter.setPen(pen);
        painter.drawText(0,Translate(TPoint,BPoint,posvec[i]),QString::number(posvec[i],'f',2));
    }

    if(bmi.size() >= 2)
    {
        LValue = 1;
        QDate tmpr = userinfo->testtime.back(),tmpl = userinfo->testtime.front();
        RValue = tmpl.daysTo(tmpr) + 1;
        int LPoint = 0,RPoint = RValue+1;
        painter.setRenderHint(QPainter::Antialiasing,true);
        painter.setBrush(Qt::NoBrush);
        QPen pen1(Qt::magenta,2);
        QPen pen2(Qt::red,2);
        //起点特判
        painter.setPen(pen2);
        int xx = TranslateX(LPoint,RPoint,tmpl.daysTo(userinfo->testtime[0])+1);
        int yy = Translate(TPoint,BPoint,bmi[0]);
        painter.drawText(xx-17,yy-5,"BMI:"+QString::number(bmi[0],'f',2));
        painter.drawText(xx-17,yy+5,"体脂:"+QString::number(fat[0],'f',2));
        QDate tm = userinfo->testtime[0];
        painter.drawText(xx-17,217,tm.toString("yyMMdd"));

        for(int i=1;i<bmi.size();i++)
        {
            painter.setPen(pen1);
            int x1 = TranslateX(LPoint,RPoint,tmpl.daysTo(userinfo->testtime[i-1])+1);
            int x2 = TranslateX(LPoint,RPoint,tmpl.daysTo(userinfo->testtime[i])+1);
            int y1 = Translate(TPoint,BPoint,bmi[i-1]);
            int y2 = Translate(TPoint,BPoint,bmi[i]);
            painter.drawLine(x1,y1,x2,y2);
            painter.setPen(pen2);
            painter.drawText(x2-17,y2-5,"BMI:"+QString::number(bmi[i],'f',2));
            painter.drawText(x2-17,y2+5,"体脂:"+QString::number(fat[i],'f',2));
            QDate tmp = userinfo->testtime[i];
            painter.drawText(x2-17,217,tmp.toString("yyMMdd"));
        }
    }
    else if(bmi.size() == 1)
    {
        LValue = 1;
        QDate tmpr = userinfo->testtime.back(),tmpl = userinfo->testtime.front();
        RValue = tmpl.daysTo(tmpr) + 1;
        int LPoint = 0,RPoint = RValue+1;
        painter.setRenderHint(QPainter::Antialiasing,true);
        painter.setBrush(Qt::NoBrush);
        QPen pen1(Qt::magenta,2);
        QPen pen2(Qt::red,2);
        painter.setPen(pen2);
        int xx = TranslateX(LPoint,RPoint,tmpl.daysTo(userinfo->testtime[0])+1);
        int yy = Translate(TPoint,BPoint,bmi[0]);
        painter.drawText(xx-17,yy-5,"BMI:"+QString::number(bmi[0],'f',2));
        painter.drawText(xx-17,yy+5,"体脂:"+QString::number(fat[0],'f',2));
        QDate tm = userinfo->testtime[0];
        painter.drawText(xx-17,217,tm.toString("yyMMdd"));
        painter.setPen(pen1);
        painter.drawLine(xx,yy,xx+2,yy);
    }

    ui->linegraph->setPixmap(*board);

    //画历史记录表格
    QStandardItemModel *history_model = new QStandardItemModel();

    history_model->setHorizontalHeaderItem(0,new QStandardItem("测试日期"));
    history_model->setHorizontalHeaderItem(1,new QStandardItem("身高"));
    history_model->setHorizontalHeaderItem(2,new QStandardItem("体重"));
    history_model->setHorizontalHeaderItem(3,new QStandardItem("腰围"));
    history_model->setHorizontalHeaderItem(4,new QStandardItem("BMI"));
    history_model->setHorizontalHeaderItem(5,new QStandardItem("体脂率"));
    ui->tableview->setModel(history_model);
    ui->tableview->setColumnWidth(0,90);
    ui->tableview->setColumnWidth(1,70);
    ui->tableview->setColumnWidth(2,70);
    ui->tableview->setColumnWidth(3,70);
    ui->tableview->setColumnWidth(4,70);
    ui->tableview->setColumnWidth(5,70);

    ui->tableview->setEditTriggers(QAbstractItemView::NoEditTriggers);

    int start = qMax(0,this->userinfo->height.size()-10);
    for(int i=start;i<this->userinfo->height.size();i++)
    {
        QDate sdt = userinfo->testtime[i];
        history_model->setItem(i-start,0,new QStandardItem(sdt.toString("yyyy-MM-dd")));
        history_model->item(i-start,0)->setForeground(QBrush(Qt::blue));
        history_model->setItem(i-start,1,new QStandardItem(QString::number(userinfo->height[i],'f',4)));
        history_model->setItem(i-start,2,new QStandardItem(QString::number(userinfo->weight[i],'f',4)));
        history_model->setItem(i-start,3,new QStandardItem(QString::number(userinfo->circle[i],'f',4)));
        history_model->setItem(i-start,4,new QStandardItem(QString::number(bmi[i],'f',4)));
        history_model->setItem(i-start,5,new QStandardItem(QString::number(fat[i],'f',4)));
    }
}

void MainWindow::ShowResult(double hh, double ww, double cc)
{
    QDate present = QDate::currentDate();

    double lastheight,lastweight,lastcircle,lastbmi,lastfat;

    double bmi = this->userinfo->CalculateBMI(ww,hh);
    double fat = this->userinfo->CalculateFat(cc,ww);

    if(! this->userinfo->height.empty())
    {
        lastheight = this->userinfo->height.back();
        lastweight = this->userinfo->weight.back();
        lastcircle = this->userinfo->circle.back();
        lastbmi = this->userinfo->CalculateBMI(lastweight,lastheight);
        lastfat = this->userinfo->CalculateFat(lastcircle,lastweight);
    }

    QString sql = QString("insert into history(id,name,weight,height,circle,testtime) values(null,'%1',%2,%3,%4,'%5')")
            .arg(this->userinfo->name)
            .arg(QString::number(ww,'f',4))
            .arg(QString::number(hh,'f',4))
            .arg(QString::number(cc,'f',4))
            .arg(present.toString("yyyy-MM-dd"));
    QSqlQuery query(sql);
    QString tmpname = this->userinfo->name;
    int tmpsex = this->userinfo->sex;
    delete userinfo;
    userinfo = new UserInfo(tmpname,tmpsex);
    this->DrawMainWindow(tmpname,tmpsex);
    ui->showresult->setVisible(false);

    QPalette pa;
    if(this->userinfo->height.size() > 1)
    {
        QString tmp1,tmp2,tmp3,tmp4,tmp5;
        if(hh >= lastheight) tmp1 = "高";else tmp1 = "矮";
        if(ww >= lastweight) tmp2 = "胖";else tmp2 = "瘦";
        if(cc >= lastcircle) tmp3 = "增大";else tmp3 = "减小";
        if(bmi >= lastbmi) tmp4 = "增大";else tmp4 = "减小";
        if(fat >= lastfat) tmp5 = "增大";else tmp5 = "减小";

        ui->show1->setText(QString("用户 %1：与上次体检相比，").arg(tmpname));
        ui->show2->setText(QString("您%1了 %2 厘米，%3了 %4 公斤，腰围%5了 %6 厘米。").arg(tmp1).arg( QString::number((Abs(hh-lastheight))*100,'f',1) )
                           .arg(tmp2).arg( QString::number(Abs(ww-lastweight),'f',2) ).arg(tmp3).arg( QString::number(Abs(cc-lastcircle),'f',2) ) );
        ui->show3->setText(QString("您本次的BMI指数为 %1 ，与上次体检相比%2了 %3 。").arg( QString::number(bmi,'f',2) ).arg(tmp4).arg( QString::number(Abs(bmi-lastbmi),'f',2) ) );
        ui->show4->setText(QString("您本次的体脂率为 %1 ，与上次体检相比%2了 %3 。").arg( QString::number(fat,'f',2) ).arg(tmp5).arg( QString::number(Abs(fat-lastfat),'f',2) ) );
        if( bmi < 18.5 )
        {pa.setColor(QPalette::WindowText,Qt::blue);ui->show5->setText("您的体重低于正常指标，建议您加强营养！");}
        else if( bmi < 24.0 )
        {pa.setColor(QPalette::WindowText,Qt::green);ui->show5->setText("您的身体指标正常，请继续保持！");}
        else if( bmi < 28.0 )
        {pa.setColor(QPalette::WindowText,Qt::yellow);ui->show5->setText("您已超重，请注意进行合理的饮食和运动！");}
        else
        {pa.setColor(QPalette::WindowText,Qt::red);ui->show5->setText("过度肥胖危害健康，请尽快减肥或咨询医生！");}
        ui->show5->setPalette(pa);
        ui->show6->setText("本次测试的数据已经存档，您可以在上方的图表中查看，欢迎继续使用~");
    }
    else
    {
        ui->show1->setText(QString("用户 %1：").arg(tmpname));
        ui->show2->setText(QString("这是您的第一次体检。") );
        ui->show3->setText(QString("您本次的BMI指数为 %1 。").arg( QString::number(bmi,'f',2) ) );
        ui->show4->setText(QString("您本次的体脂率为 %1 。").arg( QString::number(fat,'f',2) ) );
        if( bmi < 18.5 )
        {pa.setColor(QPalette::WindowText,Qt::blue);ui->show5->setText("您的体重低于正常指标，建议您加强营养！");}
        else if( bmi < 24.0 )
        {pa.setColor(QPalette::WindowText,Qt::green);ui->show5->setText("您的身体指标正常，请继续保持！");}
        else if( bmi < 28.0 )
        {pa.setColor(QPalette::WindowText,Qt::yellow);ui->show5->setText("您已超重，请注意进行合理的饮食和运动！");}
        else
        {pa.setColor(QPalette::WindowText,Qt::red);ui->show5->setText("过度肥胖危害健康，请尽快减肥或咨询医生！");}
        ui->show5->setPalette(pa);
        ui->show6->setText("本次测试的数据已经存档，您可以在上方的图表中查看，欢迎继续使用~");
    }


}

void MainWindow::on_buttondelete_clicked()
{
    QString nm = this->userinfo->name;
    switch (QMessageBox::question(this,"删除用户",QString("确定要删除用户 %1 吗？").arg(nm),
                                  QMessageBox::Ok|QMessageBox::Cancel))
    {
    case QMessageBox::Ok:
        this->userinfo->DeleteUserData();
        ui->maingraph->setVisible(true);
        ui->today->setText("<-欢迎使用健康管理->");
        ui->hint->setText("请在右上角菜单栏选择您的用户或新建用户");
        ui->showusername->setVisible(false);
        ui->showstatus->setVisible(false);
        ui->labeldelete->setVisible(false);
        ui->buttondelete->setVisible(false);
        this->addMenuList();
        delete userinfo;
        break;
    case QMessageBox::Cancel:
        break;
    default:
        break;
    }
}


void MainWindow::on_showresult_clicked()
{
    double tmpcircle = ui->inputc->text().toDouble();
    double tmpweight = ui->inputw->text().toDouble();
    double tmpheight = ui->inputh->text().toDouble();

    if(tmpheight < 30 || tmpheight > 250) QMessageBox::about(this,"提示","请输入合理的身高，厘米为单位");
    else if(tmpweight < 3 || tmpweight > 400) QMessageBox::about(this,"提示","请输入正确的体重，千克为单位");
    else if(tmpcircle < 20 || tmpcircle > 200) QMessageBox::about(this,"提示","请输入正确的腰围，厘米为单位");
    else this->ShowResult(tmpheight/100,tmpweight,tmpcircle);
}
