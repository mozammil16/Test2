package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;

public interface zzt extends IInterface {

    public static abstract class zza extends Binder implements zzt {

        private static class zza implements zzt {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zzb(zzaa com_google_android_gms_common_internal_zzaa) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IResolveAccountCallbacks");
                    if (com_google_android_gms_common_internal_zzaa != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_common_internal_zzaa.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.common.internal.IResolveAccountCallbacks");
        }

        public static zzt zzV(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzt)) ? new zza(iBinder) : (zzt) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
                    zzb(data.readInt() != 0 ? (zzaa) zzaa.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.IResolveAccountCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzb(zzaa com_google_android_gms_common_internal_zzaa) throws RemoteException;
}
