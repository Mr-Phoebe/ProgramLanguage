#-------------------------------------------------
#
# Project created by QtCreator 2016-07-06T17:10:11
#
#-------------------------------------------------

QT       += core gui sql axcontainer webkitwidgets network

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

TARGET = GSM
TEMPLATE = app


SOURCES += main.cpp\
        mainwindow.cpp \
    opendb.cpp \
    datain.cpp \
    dataout.cpp \
    registing.cpp \
    control.cpp \
    distance.cpp \
    point.cpp \
    chartdialog.cpp \
    gsmwebpage.cpp \
    gsmwebwiget.cpp

HEADERS  += mainwindow.h \
    opendb.h \
    datain.h \
    dataout.h \
    registing.h \
    control.h \
    distance.h \
    point.h \
    chartdialog.h \
    gsmwebpage.h \
    gsmwebwiget.h

FORMS    += mainwindow.ui \
    datain.ui \
    dataout.ui \
    registing.ui \
    control.ui \
    chartdialog.ui
