package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.internal.zzkw;
import com.google.android.gms.internal.zzlk;
import com.google.android.gms.location.places.Place;
import java.util.List;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        private static class zza implements zzd {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public String getAccountName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zzle.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ICancelToken zza(zzb com_google_android_gms_plus_internal_zzb, int i, int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.zzle.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    ICancelToken zzS = com.google.android.gms.common.internal.ICancelToken.zza.zzS(obtain2.readStrongBinder());
                    return zzS;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzlk com_google_android_gms_internal_zzlk) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (com_google_android_gms_internal_zzlk != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzlk.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    this.zzle.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, int i, String str, Uri uri, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.zzle.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, zzlk com_google_android_gms_internal_zzlk) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    if (com_google_android_gms_internal_zzlk != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzlk.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzle.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb com_google_android_gms_plus_internal_zzb, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeStringList(list);
                    this.zzle.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzkw com_google_android_gms_internal_zzkw, zzkw com_google_android_gms_internal_zzkw2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zzkw != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzkw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzkw2 != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzkw2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzb com_google_android_gms_plus_internal_zzb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    this.zzle.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzcE(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(str);
                    this.zzle.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(com_google_android_gms_plus_internal_zzb != null ? com_google_android_gms_plus_internal_zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zzle.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzrK() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zzle.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzrL() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zzle.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzrM() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zzle.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzrN() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zzle.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzd zzcy(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new zza(iBinder) : (zzd) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            zzkw com_google_android_gms_internal_zzkw = null;
            String accountName;
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzcw(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzcw(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzb(com.google.android.gms.plus.internal.zzb.zza.zzcw(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_AQUARIUM /*4*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(data.readInt() != 0 ? zzlk.CREATOR.zzT(data) : null);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_ART_GALLERY /*5*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = getAccountName();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case Place.TYPE_ATM /*6*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzrK();
                    reply.writeNoException();
                    return true;
                case Place.TYPE_BANK /*8*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzcw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_BAR /*9*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzcw(data.readStrongBinder()), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_BUS_STATION /*14*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzcw(data.readStrongBinder()), data.readInt(), data.readString(), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CAMPGROUND /*16*/:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    ICancelToken zza = zza(com.google.android.gms.plus.internal.zzb.zza.zzcw(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    if (zza != null) {
                        asBinder = zza.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case Place.TYPE_CAR_DEALER /*17*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzcE(data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CAR_RENTAL /*18*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzc(com.google.android.gms.plus.internal.zzb.zza.zzcw(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CAR_REPAIR /*19*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzb(com.google.android.gms.plus.internal.zzb.zza.zzcw(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_ESTABLISHMENT /*34*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zza(com.google.android.gms.plus.internal.zzb.zza.zzcw(data.readStrongBinder()), data.createStringArrayList());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FURNITURE_STORE /*40*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzd(com.google.android.gms.plus.internal.zzb.zza.zzcw(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_GAS_STATION /*41*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = zzrL();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    boolean zzrM = zzrM();
                    reply.writeNoException();
                    reply.writeInt(zzrM ? 1 : 0);
                    return true;
                case Place.TYPE_GROCERY_OR_SUPERMARKET /*43*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = zzrN();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case Place.TYPE_GYM /*44*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zze(com.google.android.gms.plus.internal.zzb.zza.zzcw(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HAIR_CARE /*45*/:
                    zzlk zzT;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    zzb zzcw = com.google.android.gms.plus.internal.zzb.zza.zzcw(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        zzT = zzlk.CREATOR.zzT(data);
                    }
                    zza(zzcw, zzT);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HARDWARE_STORE /*46*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    String readString = data.readString();
                    zzkw zzL = data.readInt() != 0 ? zzkw.CREATOR.zzL(data) : null;
                    if (data.readInt() != 0) {
                        com_google_android_gms_internal_zzkw = zzkw.CREATOR.zzL(data);
                    }
                    zza(readString, zzL, com_google_android_gms_internal_zzkw);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    String getAccountName() throws RemoteException;

    ICancelToken zza(zzb com_google_android_gms_plus_internal_zzb, int i, int i2, int i3, String str) throws RemoteException;

    void zza(zzlk com_google_android_gms_internal_zzlk) throws RemoteException;

    void zza(zzb com_google_android_gms_plus_internal_zzb) throws RemoteException;

    void zza(zzb com_google_android_gms_plus_internal_zzb, int i, String str, Uri uri, String str2, String str3) throws RemoteException;

    void zza(zzb com_google_android_gms_plus_internal_zzb, Uri uri, Bundle bundle) throws RemoteException;

    void zza(zzb com_google_android_gms_plus_internal_zzb, zzlk com_google_android_gms_internal_zzlk) throws RemoteException;

    void zza(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException;

    void zza(zzb com_google_android_gms_plus_internal_zzb, String str, String str2) throws RemoteException;

    void zza(zzb com_google_android_gms_plus_internal_zzb, List<String> list) throws RemoteException;

    void zza(String str, zzkw com_google_android_gms_internal_zzkw, zzkw com_google_android_gms_internal_zzkw2) throws RemoteException;

    void zzb(zzb com_google_android_gms_plus_internal_zzb) throws RemoteException;

    void zzb(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException;

    void zzc(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException;

    void zzcE(String str) throws RemoteException;

    void zzd(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException;

    void zze(zzb com_google_android_gms_plus_internal_zzb, String str) throws RemoteException;

    void zzrK() throws RemoteException;

    String zzrL() throws RemoteException;

    boolean zzrM() throws RemoteException;

    String zzrN() throws RemoteException;
}
