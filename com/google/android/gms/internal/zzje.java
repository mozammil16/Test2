package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public interface zzje extends IInterface {

    public static abstract class zza extends Binder implements zzje {

        private static class zza implements zzje {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(com.google.android.gms.internal.zziv.zza com_google_android_gms_internal_zziv_zza, zzjf com_google_android_gms_internal_zzjf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    if (com_google_android_gms_internal_zziv_zza != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zziv_zza.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjf != null ? com_google_android_gms_internal_zzjf.asBinder() : null);
                    this.zzle.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzjf com_google_android_gms_internal_zzjf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjf != null ? com_google_android_gms_internal_zzjf.asBinder() : null);
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzjf com_google_android_gms_internal_zzjf, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjf != null ? com_google_android_gms_internal_zzjf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzle.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzjf com_google_android_gms_internal_zzjf, String str, zzjb[] com_google_android_gms_internal_zzjbArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjf != null ? com_google_android_gms_internal_zzjf.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeTypedArray(com_google_android_gms_internal_zzjbArr, 0);
                    this.zzle.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzjf com_google_android_gms_internal_zzjf, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjf != null ? com_google_android_gms_internal_zzjf.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzle.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzjf com_google_android_gms_internal_zzjf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzjf != null ? com_google_android_gms_internal_zzjf.asBinder() : null);
                    this.zzle.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzje zzI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzje)) ? new zza(iBinder) : (zzje) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(com.google.android.gms.internal.zzjf.zza.zzJ(data.readStrongBinder()), data.readString(), (zzjb[]) data.createTypedArray(zzjb.CREATOR));
                    reply.writeNoException();
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(com.google.android.gms.internal.zzjf.zza.zzJ(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zzb(com.google.android.gms.internal.zzjf.zza.zzJ(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_AQUARIUM /*4*/:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(com.google.android.gms.internal.zzjf.zza.zzJ(data.readStrongBinder()), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_ART_GALLERY /*5*/:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(data.readInt() != 0 ? com.google.android.gms.internal.zziv.zza.CREATOR.zzp(data) : null, com.google.android.gms.internal.zzjf.zza.zzJ(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_ATM /*6*/:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(com.google.android.gms.internal.zzjf.zza.zzJ(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(com.google.android.gms.internal.zziv.zza com_google_android_gms_internal_zziv_zza, zzjf com_google_android_gms_internal_zzjf) throws RemoteException;

    void zza(zzjf com_google_android_gms_internal_zzjf) throws RemoteException;

    void zza(zzjf com_google_android_gms_internal_zzjf, String str, String str2) throws RemoteException;

    void zza(zzjf com_google_android_gms_internal_zzjf, String str, zzjb[] com_google_android_gms_internal_zzjbArr) throws RemoteException;

    void zza(zzjf com_google_android_gms_internal_zzjf, boolean z) throws RemoteException;

    void zzb(zzjf com_google_android_gms_internal_zzjf) throws RemoteException;
}
