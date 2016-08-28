#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include "dlgabout.h"
#include <QLineEdit>

namespace Ui {
    class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

private:
    Ui::MainWindow *ui;
private:
    bool isSaved;
    QString curFile;
    void do_file_New();
    void do_file_Open();
    bool do_file_Load(const QString& fileName);
    void do_file_SaveOrNot();
    void do_file_Save();
    void do_file_SaveAs();
    bool saveFile(const QString& filename);
    DlgAbout dlg;
    QLineEdit *find_textEditLine;
private slots:
    void on_actionFind_triggered();
    void on_actionPaste_triggered();
    void on_actionCopy_triggered();
    void on_actionCut_triggered();
    void on_actionUndo_triggered();
    void on_actionClose_triggered();
    void on_action_Open_triggered();
    void on_actionSave_As_triggered();
    void on_action_Save_triggered();
    void on_action_New_triggered();
    void on_action_Exit_triggered();
    void on_actionAbout_TextEditor_triggered();

    void show_findText();
};

#endif // MAINWINDOW_H
