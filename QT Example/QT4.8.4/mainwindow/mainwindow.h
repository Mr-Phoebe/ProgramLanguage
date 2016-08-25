#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>

class QAction;
class QMenu;
class QToolBar;
class QTextEdit;

class MainWindow : public QMainWindow
{
    Q_OBJECT
public:
    MainWindow();
    
    void createMenus();
    void createActions();
    void createToolBars();
    
public slots:
    void slotNewFile();
    void slotOpenFile();
    void slotSaveFile();
    void slotCopy();
    void slotCut();
    void slotPaste();
    void slotAbout();
    
private:
    
    QTextCodec *codec;
    
    QMenu *fileMenu;
    QMenu *editMenu;
    QMenu *aboutMenu;
    QToolBar *fileTool;
    QToolBar *editTool;
    QAction *fileOpenAction;
    QAction *fileNewAction;
    QAction *fileSaveAction;
    QAction *exitAction;
    QAction *copyAction;
    QAction *cutAction;
    QAction *pasteAction;
    QAction *aboutAction;
 
    QTextEdit * text;
};

#endif // MAINWINDOW_H
