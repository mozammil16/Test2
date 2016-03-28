package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import java.util.List;

public interface zzte extends IInterface {

    public static abstract class zza extends Binder implements zzte {

        private static class zza implements zzte {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(String str, zztj com_google_android_gms_internal_zztj, zztf com_google_android_gms_internal_zztf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zztj != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zztj.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zztf != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zztf.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, zztj com_google_android_gms_internal_zztj, List<zztf> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zztj != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zztj.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, zztj com_google_android_gms_internal_zztj, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zztj != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zztj.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.zzle.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzte zzcu(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzte)) ? new zza(iBinder) : (zzte) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            zztj com_google_android_gms_internal_zztj = null;
            String readString;
            switch (code) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zztf zzev;
                    data.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    String readString2 = data.readString();
                    zztj zzew = data.readInt() != 0 ? zztj.CREATOR.zzew(data) : null;
                    if (data.readInt() != 0) {
                        zzev = zztf.CREATOR.zzev(data);
                    }
                    zza(readString2, zzew, zzev);
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        com_google_android_gms_internal_zztj = zztj.CREATOR.zzew(data);
                    }
                    zza(readString, com_google_android_gms_internal_zztj, data.createTypedArrayList(zztf.CREATOR));
                    return true;
                case Place.TYPE_AQUARIUM /*4*/:
                    data.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        com_google_android_gms_internal_zztj = zztj.CREATOR.zzew(data);
                    }
                    zza(readString, com_google_android_gms_internal_zztj, data.createByteArray());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.playlog.internal.IPlayLogService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(String str, zztj com_google_android_gms_internal_zztj, zztf com_google_android_gms_internal_zztf) throws RemoteException;

    void zza(String str, zztj com_google_android_gms_internal_zztj, List<zztf> list) throws RemoteException;

    void zza(String str, zztj com_google_android_gms_internal_zztj, byte[] bArr) throws RemoteException;
}
