#ifndef TCPSERVER_H
#define TCPSERVER_H

#include <QDialog>
#include <QTcpServer>
#include <QFile>
#include <QTime>

namespace Ui {
    class TcpServer;
}

class TcpServer : public QDialog
{
    Q_OBJECT

public:
    explicit TcpServer(QWidget *parent = 0);
    ~TcpServer();
    void refused();

    void initServer();


protected:
    void changeEvent(QEvent *e);

private:
    Ui::TcpServer *ui;
    qint16 tcpPort;
    QTcpServer *tcpServer;
    QString fileName;
    QString theFileName;
    QFile *localFile;

    qint64 TotalBytes;
    qint64 bytesWritten;
    qint64 bytesToWrite;
    qint64 loadSize;
    QByteArray outBlock;//缓存一次发送的数据

    QTcpSocket *clientConnection;

    QTime time;//计时器

private slots:
    void on_serverCloseBtn_clicked();
    void on_serverSendBtn_clicked();
    void on_serverOpenBtn_clicked();
    void sendMessage();

   void updateClientProgress(qint64 numBytes);
signals:
    void sendFileName(QString fileName);

};

#endif // TCPSERVER_H
