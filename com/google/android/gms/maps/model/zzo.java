package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import java.util.List;

public class zzo implements Creator<PolylineOptions> {
    static void zza(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, polylineOptions.getVersionCode());
        zzb.zzc(parcel, 2, polylineOptions.getPoints(), false);
        zzb.zza(parcel, 3, polylineOptions.getWidth());
        zzb.zzc(parcel, 4, polylineOptions.getColor());
        zzb.zza(parcel, 5, polylineOptions.getZIndex());
        zzb.zza(parcel, 6, polylineOptions.isVisible());
        zzb.zza(parcel, 7, polylineOptions.isGeodesic());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgc(x0);
    }

    public PolylineOptions zzdZ(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    list = zza.zzc(parcel, zzI, LatLng.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    f2 = zza.zzl(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    f = zza.zzl(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    z = zza.zzc(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new PolylineOptions(i2, list, f2, i, f, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public PolylineOptions[] zzgc(int i) {
        return new PolylineOptions[i];
    }
}
