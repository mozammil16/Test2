package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.GoogleMapOptions;

public interface IMapFragmentDelegate extends IInterface {

    public static abstract class zza extends Binder implements IMapFragmentDelegate {

        private static class zza implements IMapFragmentDelegate {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public IGoogleMapDelegate getMap() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.zzle.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    IGoogleMapDelegate zzbu = com.google.android.gms.maps.internal.IGoogleMapDelegate.zza.zzbu(obtain2.readStrongBinder());
                    return zzbu;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getMapAsync(zzm callback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.zzle.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isReady() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.zzle.transact(11, obtain, obtain2, 0);
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

            public void onCreate(Bundle savedInstanceState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    if (savedInstanceState != null) {
                        obtain.writeInt(1);
                        savedInstanceState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd onCreateView(zzd inflaterWrapper, zzd containerWrapper, Bundle savedInstanceState) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    obtain.writeStrongBinder(inflaterWrapper != null ? inflaterWrapper.asBinder() : null);
                    if (containerWrapper != null) {
                        iBinder = containerWrapper.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (savedInstanceState != null) {
                        obtain.writeInt(1);
                        savedInstanceState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzau = com.google.android.gms.dynamic.zzd.zza.zzau(obtain2.readStrongBinder());
                    return zzau;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDestroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.zzle.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDestroyView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.zzle.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onInflate(zzd activityWrapper, GoogleMapOptions options, Bundle savedInstanceState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    obtain.writeStrongBinder(activityWrapper != null ? activityWrapper.asBinder() : null);
                    if (options != null) {
                        obtain.writeInt(1);
                        options.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (savedInstanceState != null) {
                        obtain.writeInt(1);
                        savedInstanceState.writeToParcel(obtain, 0);
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

            public void onLowMemory() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.zzle.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.zzle.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onResume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    this.zzle.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSaveInstanceState(Bundle outState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    if (outState != null) {
                        obtain.writeInt(1);
                        outState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        outState.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IMapFragmentDelegate zzby(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMapFragmentDelegate)) ? new zza(iBinder) : (IMapFragmentDelegate) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    IGoogleMapDelegate map = getMap();
                    reply.writeNoException();
                    reply.writeStrongBinder(map != null ? map.asBinder() : null);
                    return true;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    onInflate(com.google.android.gms.dynamic.zzd.zza.zzau(data.readStrongBinder()), data.readInt() != 0 ? GoogleMapOptions.CREATOR.zzdP(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    onCreate(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case Place.TYPE_AQUARIUM /*4*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    zzd onCreateView = onCreateView(com.google.android.gms.dynamic.zzd.zza.zzau(data.readStrongBinder()), com.google.android.gms.dynamic.zzd.zza.zzau(data.readStrongBinder()), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (onCreateView != null) {
                        iBinder = onCreateView.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Place.TYPE_ART_GALLERY /*5*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    onResume();
                    reply.writeNoException();
                    return true;
                case Place.TYPE_ATM /*6*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    onPause();
                    reply.writeNoException();
                    return true;
                case Place.TYPE_BAKERY /*7*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    onDestroyView();
                    reply.writeNoException();
                    return true;
                case Place.TYPE_BANK /*8*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    onDestroy();
                    reply.writeNoException();
                    return true;
                case Place.TYPE_BAR /*9*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    onLowMemory();
                    reply.writeNoException();
                    return true;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    Bundle bundle = data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null;
                    onSaveInstanceState(bundle);
                    reply.writeNoException();
                    if (bundle != null) {
                        reply.writeInt(1);
                        bundle.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case Place.TYPE_BICYCLE_STORE /*11*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    boolean isReady = isReady();
                    reply.writeNoException();
                    reply.writeInt(isReady ? 1 : 0);
                    return true;
                case Place.TYPE_BOOK_STORE /*12*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    getMapAsync(com.google.android.gms.maps.internal.zzm.zza.zzbH(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IGoogleMapDelegate getMap() throws RemoteException;

    void getMapAsync(zzm com_google_android_gms_maps_internal_zzm) throws RemoteException;

    boolean isReady() throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    zzd onCreateView(zzd com_google_android_gms_dynamic_zzd, zzd com_google_android_gms_dynamic_zzd2, Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onDestroyView() throws RemoteException;

    void onInflate(zzd com_google_android_gms_dynamic_zzd, GoogleMapOptions googleMapOptions, Bundle bundle) throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;
}
