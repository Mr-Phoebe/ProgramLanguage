#include "qwebkittest.h"  
#include "ui_qwebkittest.h"  
  
QWebKitTest::QWebKitTest(QWidget *parent) :  
    QDialog(parent)  
{  
    m_webObj = new MyWebKit(this);  
    ui->setupUi(this);  
    ui->webView->setUrl((QUrl("qrc:/test.html")));  
    connect(ui->webView->page()->mainFrame(), SIGNAL(javaScriptWindowObjectCleared()), this, SLOT(populateJavaScriptWindowObject()));  
  
}  
  
QWebKitTest::~QWebKitTest()  
{  
    delete ui;  
}  
  
void QWebKitTest::setValueFromWeb(const QString &strName, const QString &strPwd)  
{  
    ui->textEdit->setText(strName);  
    ui->textEdit_2->setText(strPwd);  
}  
  
void QWebKitTest::onBtnCallJSClicked()  
{  
    QString strVal = QString("callfromqt(\"%1\",\"%2\");").arg(ui->textEdit->toPlainText()).arg(ui->textEdit_2->toPlainText() );  
    ui->webView->page()->mainFrame()->evaluateJavaScript(strVal);  
}  
  
void QWebKitTest::populateJavaScriptWindowObject()  
{  
    qDebug()<<"populateJavaScriptWindowObject";  
    ui->webView->page()->mainFrame()->addToJavaScriptWindowObject(QString("mywebkit"),m_webObj);  
}  
  
void QWebKitTest::on_pushButton_clicked()  
{  
    onBtnCallJSClicked();  
}  