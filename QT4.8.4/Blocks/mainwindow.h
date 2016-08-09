#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QPushButton>
#include <QPalette>
#include <QIcon>
#include <QPixmap>
#include <QFont>
#include <QLineEdit>
#include <QDebug>
#include <QMessageBox>
#include <QLabel>
#include <QString>
#include "showwidget.h"

namespace Ui {
class MainWindow;
}

class Button : public QPushButton
{
public:
    explicit Button(QWidget *parent = 0);
    ~Button();
    void setButtonPicture(QPixmap pic);
    void setPressPicture(QPixmap pic);
    void setReleasePicture(QPixmap pic);
    void set_X_Y_width_height(int x, int y, int width, int height);
    void mouseDoubleClickEvent(QMouseEvent *e);
    void mouseMoveEvent(QMouseEvent *e);
    void mousePressEvent(QMouseEvent *e);
    void mouseReleaseEvent(QMouseEvent *e);
private:
    QPixmap *buttonPicture;
    QPixmap *pressPicture;
    QPixmap *releasePicture;
};


class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

private:
    Ui::MainWindow *ui;
    QLabel *label;
    QLabel *label2;
    Button *button;
    QLineEdit *lineEdit;
    ShowWidget showblocks;
private slots:
    void generateBlocks();
};


#endif // MAINWINDOW_H
