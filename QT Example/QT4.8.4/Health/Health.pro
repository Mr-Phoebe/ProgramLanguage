#-------------------------------------------------
#
# Project created by QtCreator 2015-03-05T17:52:50
#
#-------------------------------------------------

QT       += core gui sql

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

TARGET = Health
TEMPLATE = app


SOURCES += main.cpp\
        mainwindow.cpp \
    userinfo.cpp

HEADERS  += mainwindow.h \
    connection.h \
    userinfo.h

FORMS    += mainwindow.ui

RESOURCES += \
    img.qrc
