package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.CameraPosition;

public class zza implements Creator<GoogleMapOptions> {
    static void zza(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, googleMapOptions.getVersionCode());
        zzb.zza(parcel, 2, googleMapOptions.zzqh());
        zzb.zza(parcel, 3, googleMapOptions.zzqi());
        zzb.zzc(parcel, 4, googleMapOptions.getMapType());
        zzb.zza(parcel, 5, googleMapOptions.getCamera(), i, false);
        zzb.zza(parcel, 6, googleMapOptions.zzqj());
        zzb.zza(parcel, 7, googleMapOptions.zzqk());
        zzb.zza(parcel, 8, googleMapOptions.zzql());
        zzb.zza(parcel, 9, googleMapOptions.zzqm());
        zzb.zza(parcel, 10, googleMapOptions.zzqn());
        zzb.zza(parcel, 11, googleMapOptions.zzqo());
        zzb.zza(parcel, 12, googleMapOptions.zzqp());
        zzb.zza(parcel, 14, googleMapOptions.zzqq());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfS(x0);
    }

    public GoogleMapOptions zzdP(Parcel parcel) {
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        int i = 0;
        byte b = (byte) 0;
        byte b2 = (byte) 0;
        int i2 = 0;
        CameraPosition cameraPosition = null;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        byte b7 = (byte) 0;
        byte b8 = (byte) 0;
        byte b9 = (byte) 0;
        byte b10 = (byte) 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    b = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    b2 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    cameraPosition = (CameraPosition) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzI, CameraPosition.CREATOR);
                    break;
                case Place.TYPE_ATM /*6*/:
                    b3 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    b4 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzI);
                    break;
                case Place.TYPE_BANK /*8*/:
                    b5 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzI);
                    break;
                case Place.TYPE_BAR /*9*/:
                    b6 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzI);
                    break;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    b7 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzI);
                    break;
                case Place.TYPE_BICYCLE_STORE /*11*/:
                    b8 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzI);
                    break;
                case Place.TYPE_BOOK_STORE /*12*/:
                    b9 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzI);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    b10 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzI);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new GoogleMapOptions(i, b, b2, i2, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public GoogleMapOptions[] zzfS(int i) {
        return new GoogleMapOptions[i];
    }
}
