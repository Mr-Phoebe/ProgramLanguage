#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QtGui>

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    isSaved = false;
    curFile = tr("untitled.txt");
    setWindowTitle(curFile);
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_actionAbout_TextEditor_triggered()
{
    dlg.show();
}

void MainWindow::on_action_Exit_triggered()
{
    on_actionClose_triggered();
    qApp->quit();
}

void MainWindow::do_file_New()
{
    do_file_SaveOrNot();
    isSaved = false;
    curFile = tr("untitled.txt");
    setWindowTitle(curFile);
    ui->QtextEdit->clear();
    ui->QtextEdit->setVisible(true);
}

void MainWindow::do_file_SaveOrNot(){
    if(ui->QtextEdit->document()->isModified()){
        QMessageBox box;
        box.setWindowTitle("Save Changes");
        box.setIcon(QMessageBox::Warning);
        box.setText(curFile+tr("save or not"));
        box.setStandardButtons(QMessageBox::Yes | QMessageBox::No);
        if(box.exec() == QMessageBox::Yes)
            do_file_Save();
    }
}

void MainWindow::do_file_Open(){
    do_file_SaveOrNot();
    QString fileName = QFileDialog::getOpenFileName(this);
    if(!fileName.isEmpty())
        do_file_Load(fileName);
    ui->QtextEdit->setVisible(true);
}

bool MainWindow::do_file_Load(const QString& fileName){
    QFile file(fileName);
    if(!file.open(QFile::ReadOnly | QFile::Text)){
        QMessageBox::warning(this,tr("Warning"),tr("file errors %1:\n%2").arg(fileName).arg(file.errorString()));
        return false;
    }
    QTextStream in(&file);
    ui->QtextEdit->setText(in.readAll());
    curFile = QFileInfo(fileName).canonicalFilePath();
    setWindowTitle(curFile);
    return true;

}

void MainWindow::do_file_Save(){
    if(isSaved)
        saveFile(curFile);
    else do _file_SaveAs();
}

void MainWindow::do_file_SaveAs(){
    QString fileName = QFileDialog::getSaveFileName(this,tr("save as"),curFile);
    if(!fileName.isEmpty())
        saveFile(fileName);
}

bool MainWindow::saveFile(const QString &fileName){
    QFile file(fileName);
    if(!file.open(QFile::WriteOnly | QFile::Text)){
        QMessageBox::warning(this,tr("Warning"),
                             tr("file errors %1:\n %2").arg(fileName)
                             .arg(file.errorString()));
        return false;
    }
    QTextStream out(&file);
    out<<ui->QtextEdit->toPlainText();
    isSaved = true;
    curFile = QFileInfo(fileName).canonicalFilePath();
    setWindowTitle(curFile);
    return true;
}
void MainWindow::on_action_New_triggered()
{
    do_file_New();
}

void MainWindow::on_action_Save_triggered()
{
    do_file_Save();
}

void MainWindow::on_actionSave_As_triggered()
{
    do_file_SaveAs();
}

void MainWindow::on_action_Open_triggered()
{
    do_file_Open();
}

void MainWindow::on_actionClose_triggered()
{
    do_file_SaveOrNot();
    ui->QtextEdit->setVisible(false);
}

void MainWindow::on_actionUndo_triggered()
{
    ui->QtextEdit->undo();
}

void MainWindow::on_actionCut_triggered()
{
    ui->QtextEdit->cut();
}

void MainWindow::on_actionCopy_triggered()
{
    ui->QtextEdit->copy();
}

void MainWindow::on_actionPaste_triggered()
{
    ui->QtextEdit->paste();
}

void MainWindow::on_actionFind_triggered()
{
    QDialog *findDlg = new QDialog(this);
    findDlg->setWindowTitle(tr("Find Dialog"));
    find_textEditLine = new QLineEdit(findDlg);
    QPushButton *find_Btn = new QPushButton(tr("find"),findDlg);
    QVBoxLayout *layout = new QVBoxLayout(findDlg);
    layout->addWidget(find_textEditLine);
    layout->addWidget(find_Btn);
    findDlg->show();
    connect(find_Btn,SIGNAL(clicked()),this,SLOT(show_findText()));
}

void MainWindow::show_findText(){
    QString findText = find_textEditLine->text();
    if(!ui->QtextEdit->find(findText,QTextDocument::FindBackward)){
        QMessageBox::warning(this,tr("Find Dialog"),tr("file %1").arg(findText));
    }

}
