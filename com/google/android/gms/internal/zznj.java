package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzar;
import com.google.android.gms.fitness.request.zzav;
import com.google.android.gms.fitness.request.zzb;
import com.google.android.gms.fitness.request.zzu;
import com.google.android.gms.location.places.Place;

public interface zznj extends IInterface {

    public static abstract class zza extends Binder implements zznj {

        private static class zza implements zznj {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(StartBleScanRequest startBleScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (startBleScanRequest != null) {
                        obtain.writeInt(1);
                        startBleScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzar com_google_android_gms_fitness_request_zzar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (com_google_android_gms_fitness_request_zzar != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzav com_google_android_gms_fitness_request_zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (com_google_android_gms_fitness_request_zzav != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzav.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_fitness_request_zzb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (com_google_android_gms_fitness_request_zzb != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzb.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzu com_google_android_gms_fitness_request_zzu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (com_google_android_gms_fitness_request_zzu != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzu.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zznj zzaG(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznj)) ? new zza(iBinder) : (zznj) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            zzu com_google_android_gms_fitness_request_zzu = null;
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    StartBleScanRequest startBleScanRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        startBleScanRequest = (StartBleScanRequest) StartBleScanRequest.CREATOR.createFromParcel(data);
                    }
                    zza(startBleScanRequest);
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzar com_google_android_gms_fitness_request_zzar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzar = (zzar) zzar.CREATOR.createFromParcel(data);
                    }
                    zza(com_google_android_gms_fitness_request_zzar);
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    zzb com_google_android_gms_fitness_request_zzb;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzb = (zzb) zzb.CREATOR.createFromParcel(data);
                    }
                    zza(com_google_android_gms_fitness_request_zzb);
                    return true;
                case Place.TYPE_AQUARIUM /*4*/:
                    zzav com_google_android_gms_fitness_request_zzav;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzav = (zzav) zzav.CREATOR.createFromParcel(data);
                    }
                    zza(com_google_android_gms_fitness_request_zzav);
                    return true;
                case Place.TYPE_ART_GALLERY /*5*/:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (data.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzu = (zzu) zzu.CREATOR.createFromParcel(data);
                    }
                    zza(com_google_android_gms_fitness_request_zzu);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(StartBleScanRequest startBleScanRequest) throws RemoteException;

    void zza(zzar com_google_android_gms_fitness_request_zzar) throws RemoteException;

    void zza(zzav com_google_android_gms_fitness_request_zzav) throws RemoteException;

    void zza(zzb com_google_android_gms_fitness_request_zzb) throws RemoteException;

    void zza(zzu com_google_android_gms_fitness_request_zzu) throws RemoteException;
}
