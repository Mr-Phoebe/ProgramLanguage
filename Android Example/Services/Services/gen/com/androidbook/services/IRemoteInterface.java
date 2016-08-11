/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\perforce_dev\\Laurie_p4.mamlambo.com_6669\\Android\\Source\\Services\\src\\com\\androidbook\\services\\IRemoteInterface.aidl
 */
package com.androidbook.services;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import android.location.Location;
public interface IRemoteInterface extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.androidbook.services.IRemoteInterface
{
private static final java.lang.String DESCRIPTOR = "com.androidbook.services.IRemoteInterface";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IRemoteInterface interface,
 * generating a proxy if needed.
 */
public static com.androidbook.services.IRemoteInterface asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.androidbook.services.IRemoteInterface))) {
return ((com.androidbook.services.IRemoteInterface)iin);
}
return new com.androidbook.services.IRemoteInterface.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
{
return this;
}
public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getLastLocation:
{
data.enforceInterface(DESCRIPTOR);
android.location.Location _result = this.getLastLocation();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getGPXPoint:
{
data.enforceInterface(DESCRIPTOR);
com.androidbook.services.GPXPoint _result = this.getGPXPoint();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.androidbook.services.IRemoteInterface
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
public android.location.Location getLastLocation() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.location.Location _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLastLocation, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.location.Location.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
public com.androidbook.services.GPXPoint getGPXPoint() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.androidbook.services.GPXPoint _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getGPXPoint, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.androidbook.services.GPXPoint.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getLastLocation = (IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getGPXPoint = (IBinder.FIRST_CALL_TRANSACTION + 1);
}
public android.location.Location getLastLocation() throws android.os.RemoteException;
public com.androidbook.services.GPXPoint getGPXPoint() throws android.os.RemoteException;
}
