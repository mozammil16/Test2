package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.zzc;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzj;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import java.util.List;

public interface zzpu extends IInterface {

    public static abstract class zza extends Binder implements zzpu {

        private static class zza implements zzpu {
            private IBinder zzle;

            zza(IBinder iBinder) {
                this.zzle = iBinder;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public void zza(zzqh com_google_android_gms_internal_zzqh, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzqo com_google_android_gms_internal_zzqo, String str, String str2, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (com_google_android_gms_internal_zzqo != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzpv != null) {
                        iBinder = com_google_android_gms_internal_zzpv.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(16, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(AddPlaceRequest addPlaceRequest, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (addPlaceRequest != null) {
                        obtain.writeInt(1);
                        addPlaceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzpv != null) {
                        iBinder = com_google_android_gms_internal_zzpv.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(14, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(PlaceReport placeReport, zzqh com_google_android_gms_internal_zzqh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (placeReport != null) {
                        obtain.writeInt(1);
                        placeReport.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(15, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzc com_google_android_gms_location_places_zzc, zzqh com_google_android_gms_internal_zzqh, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (com_google_android_gms_location_places_zzc != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_location_places_zzc.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzf com_google_android_gms_location_places_zzf, zzqh com_google_android_gms_internal_zzqh, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (com_google_android_gms_location_places_zzf != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_location_places_zzf.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzj com_google_android_gms_location_places_zzj, LatLngBounds latLngBounds, List<String> list, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (com_google_android_gms_location_places_zzj != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_location_places_zzj.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringList(list);
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzpv != null) {
                        iBinder = com_google_android_gms_internal_zzpv.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(LatLng latLng, PlaceFilter placeFilter, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placeFilter != null) {
                        obtain.writeInt(1);
                        placeFilter.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzpv != null) {
                        iBinder = com_google_android_gms_internal_zzpv.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(LatLngBounds latLngBounds, int i, String str, PlaceFilter placeFilter, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (placeFilter != null) {
                        obtain.writeInt(1);
                        placeFilter.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzpv != null) {
                        iBinder = com_google_android_gms_internal_zzpv.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzpv != null) {
                        iBinder = com_google_android_gms_internal_zzpv.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (autocompleteFilter != null) {
                        obtain.writeInt(1);
                        autocompleteFilter.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzpv != null) {
                        iBinder = com_google_android_gms_internal_zzpv.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(List<String> list, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeStringList(list);
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzpv != null) {
                        iBinder = com_google_android_gms_internal_zzpv.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(zzqh com_google_android_gms_internal_zzqh, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzle.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(PlaceFilter placeFilter, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (placeFilter != null) {
                        obtain.writeInt(1);
                        placeFilter.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzpv != null) {
                        iBinder = com_google_android_gms_internal_zzpv.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzpv != null) {
                        iBinder = com_google_android_gms_internal_zzpv.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(List<String> list, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeStringList(list);
                    if (com_google_android_gms_internal_zzqh != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzqh.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (com_google_android_gms_internal_zzpv != null) {
                        iBinder = com_google_android_gms_internal_zzpv.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzle.transact(17, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzpu zzbo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpu)) ? new zza(iBinder) : (zzpu) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            zzqh com_google_android_gms_internal_zzqh = null;
            String readString;
            List createStringArrayList;
            switch (code) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    LatLngBounds zzdV = data.readInt() != 0 ? LatLngBounds.CREATOR.zzdV(data) : null;
                    int readInt = data.readInt();
                    String readString2 = data.readString();
                    PlaceFilter zzdB = data.readInt() != 0 ? PlaceFilter.CREATOR.zzdB(data) : null;
                    if (data.readInt() != 0) {
                        com_google_android_gms_internal_zzqh = zzqh.CREATOR.zzdI(data);
                    }
                    zza(zzdV, readInt, readString2, zzdB, com_google_android_gms_internal_zzqh, com.google.android.gms.internal.zzpv.zza.zzbp(data.readStrongBinder()));
                    return true;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        com_google_android_gms_internal_zzqh = zzqh.CREATOR.zzdI(data);
                    }
                    zza(readString, com_google_android_gms_internal_zzqh, com.google.android.gms.internal.zzpv.zza.zzbp(data.readStrongBinder()));
                    return true;
                case Place.TYPE_AQUARIUM /*4*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    LatLng zzdW = data.readInt() != 0 ? LatLng.CREATOR.zzdW(data) : null;
                    PlaceFilter zzdB2 = data.readInt() != 0 ? PlaceFilter.CREATOR.zzdB(data) : null;
                    if (data.readInt() != 0) {
                        com_google_android_gms_internal_zzqh = zzqh.CREATOR.zzdI(data);
                    }
                    zza(zzdW, zzdB2, com_google_android_gms_internal_zzqh, com.google.android.gms.internal.zzpv.zza.zzbp(data.readStrongBinder()));
                    return true;
                case Place.TYPE_ART_GALLERY /*5*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    PlaceFilter zzdB3 = data.readInt() != 0 ? PlaceFilter.CREATOR.zzdB(data) : null;
                    if (data.readInt() != 0) {
                        com_google_android_gms_internal_zzqh = zzqh.CREATOR.zzdI(data);
                    }
                    zzb(zzdB3, com_google_android_gms_internal_zzqh, com.google.android.gms.internal.zzpv.zza.zzbp(data.readStrongBinder()));
                    return true;
                case Place.TYPE_ATM /*6*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        com_google_android_gms_internal_zzqh = zzqh.CREATOR.zzdI(data);
                    }
                    zzb(readString, com_google_android_gms_internal_zzqh, com.google.android.gms.internal.zzpv.zza.zzbp(data.readStrongBinder()));
                    return true;
                case Place.TYPE_BAKERY /*7*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    createStringArrayList = data.createStringArrayList();
                    if (data.readInt() != 0) {
                        com_google_android_gms_internal_zzqh = zzqh.CREATOR.zzdI(data);
                    }
                    zza(createStringArrayList, com_google_android_gms_internal_zzqh, com.google.android.gms.internal.zzpv.zza.zzbp(data.readStrongBinder()));
                    return true;
                case Place.TYPE_BANK /*8*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? zzj.CREATOR.zzdD(data) : null, data.readInt() != 0 ? LatLngBounds.CREATOR.zzdV(data) : null, data.createStringArrayList(), data.readInt() != 0 ? zzqh.CREATOR.zzdI(data) : null, com.google.android.gms.internal.zzpv.zza.zzbp(data.readStrongBinder()));
                    return true;
                case Place.TYPE_BAR /*9*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? zzf.CREATOR.zzdC(data) : null, data.readInt() != 0 ? zzqh.CREATOR.zzdI(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    return true;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? zzqh.CREATOR.zzdI(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    return true;
                case Place.TYPE_BICYCLE_STORE /*11*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? zzc.CREATOR.zzdA(data) : null, data.readInt() != 0 ? zzqh.CREATOR.zzdI(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    return true;
                case Place.TYPE_BOOK_STORE /*12*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zzb(data.readInt() != 0 ? zzqh.CREATOR.zzdI(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    return true;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readString(), data.readInt() != 0 ? LatLngBounds.CREATOR.zzdV(data) : null, data.readInt() != 0 ? AutocompleteFilter.CREATOR.zzdz(data) : null, data.readInt() != 0 ? zzqh.CREATOR.zzdI(data) : null, com.google.android.gms.internal.zzpv.zza.zzbp(data.readStrongBinder()));
                    return true;
                case Place.TYPE_BUS_STATION /*14*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    AddPlaceRequest addPlaceRequest = data.readInt() != 0 ? (AddPlaceRequest) AddPlaceRequest.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        com_google_android_gms_internal_zzqh = zzqh.CREATOR.zzdI(data);
                    }
                    zza(addPlaceRequest, com_google_android_gms_internal_zzqh, com.google.android.gms.internal.zzpv.zza.zzbp(data.readStrongBinder()));
                    return true;
                case Place.TYPE_CAFE /*15*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    PlaceReport createFromParcel = data.readInt() != 0 ? PlaceReport.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        com_google_android_gms_internal_zzqh = zzqh.CREATOR.zzdI(data);
                    }
                    zza(createFromParcel, com_google_android_gms_internal_zzqh);
                    return true;
                case Place.TYPE_CAMPGROUND /*16*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? zzqo.CREATOR.zzdM(data) : null, data.readString(), data.readString(), data.readInt() != 0 ? zzqh.CREATOR.zzdI(data) : null, com.google.android.gms.internal.zzpv.zza.zzbp(data.readStrongBinder()));
                    return true;
                case Place.TYPE_CAR_DEALER /*17*/:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    createStringArrayList = data.createStringArrayList();
                    if (data.readInt() != 0) {
                        com_google_android_gms_internal_zzqh = zzqh.CREATOR.zzdI(data);
                    }
                    zzb(createStringArrayList, com_google_android_gms_internal_zzqh, com.google.android.gms.internal.zzpv.zza.zzbp(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzqh com_google_android_gms_internal_zzqh, PendingIntent pendingIntent) throws RemoteException;

    void zza(zzqo com_google_android_gms_internal_zzqo, String str, String str2, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException;

    void zza(AddPlaceRequest addPlaceRequest, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException;

    void zza(PlaceReport placeReport, zzqh com_google_android_gms_internal_zzqh) throws RemoteException;

    void zza(zzc com_google_android_gms_location_places_zzc, zzqh com_google_android_gms_internal_zzqh, PendingIntent pendingIntent) throws RemoteException;

    void zza(zzf com_google_android_gms_location_places_zzf, zzqh com_google_android_gms_internal_zzqh, PendingIntent pendingIntent) throws RemoteException;

    void zza(zzj com_google_android_gms_location_places_zzj, LatLngBounds latLngBounds, List<String> list, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException;

    void zza(LatLng latLng, PlaceFilter placeFilter, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException;

    void zza(LatLngBounds latLngBounds, int i, String str, PlaceFilter placeFilter, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException;

    void zza(String str, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException;

    void zza(String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException;

    void zza(List<String> list, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException;

    void zzb(zzqh com_google_android_gms_internal_zzqh, PendingIntent pendingIntent) throws RemoteException;

    void zzb(PlaceFilter placeFilter, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException;

    void zzb(String str, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException;

    void zzb(List<String> list, zzqh com_google_android_gms_internal_zzqh, zzpv com_google_android_gms_internal_zzpv) throws RemoteException;
}
