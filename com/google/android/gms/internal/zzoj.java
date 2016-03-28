package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.result.BleDevicesResult;

public interface zzoj extends IInterface {

    public static abstract class zza extends Binder implements zzoj {

        private static class zza implements zzoj {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(BleDevicesResult bleDevicesResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
                    if (bleDevicesResult != null) {
                        obtain.writeInt(1);
                        bleDevicesResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
        }

        public static zzoj zzaU(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzoj)) ? new zza(iBinder) : (zzoj) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
                    zza(data.readInt() != 0 ? (BleDevicesResult) BleDevicesResult.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(BleDevicesResult bleDevicesResult) throws RemoteException;
}
