#-------------------------------------------------
#
# Project created by QtCreator 2014-03-02T20:05:24
#
#-------------------------------------------------

QT       += core gui sql

TARGET = HotelManagementSystem
TEMPLATE = app


SOURCES += main.cpp\
        widget.cpp \
    Evaluate.cpp \
    Check_in.cpp \
    Check_out.cpp \
    Reserve.cpp \
    Login.cpp \
    Room.cpp \
    Menu.cpp

HEADERS  += widget.h \
    connection.h

FORMS    += widget.ui

RESOURCES += \
    res.qrc
