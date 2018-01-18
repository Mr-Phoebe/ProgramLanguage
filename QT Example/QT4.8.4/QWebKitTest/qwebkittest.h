#ifndef QWEBKITTEST_H  
#define QWEBKITTEST_H  
  
#include <QDialog>  
#include <QString>  
#include <QWidget>  
#include <QWebView>  
#include <QWebFrame>  
#include <QTextEdit>  
#include "mywebkit.h"  
  
namespace Ui {  
class QWebKitTest;  
}  
class QWebKitTest : public QDialog  
{  
    Q_OBJECT  
      
public:  
    explicit QWebKitTest(QWidget *parent = 0);  
    ~QWebKitTest();  
  
    void setValueFromWeb(const QString &strName,const QString &strPwd);  
  
protected slots:  
    void onBtnCallJSClicked();  
    void populateJavaScriptWindowObject();  
      
private slots:  
    void on_pushButton_clicked();  
  
private:  
    Ui::QWebKitTest *ui;  
    //MyWebKit* m_webObj;  
    class MyWebKit* m_webObj;  
};  
  
#endif // QWEBKITTEST_H  