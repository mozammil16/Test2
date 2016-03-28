package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zzy implements Creator<VisibleRegion> {
    static void zza(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, visibleRegion.getVersionCode());
        zzb.zza(parcel, 2, visibleRegion.nearLeft, i, false);
        zzb.zza(parcel, 3, visibleRegion.nearRight, i, false);
        zzb.zza(parcel, 4, visibleRegion.farLeft, i, false);
        zzb.zza(parcel, 5, visibleRegion.farRight, i, false);
        zzb.zza(parcel, 6, visibleRegion.latLngBounds, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgj(x0);
    }

    public VisibleRegion zzeg(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    latLng4 = (LatLng) zza.zza(parcel, zzI, LatLng.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    latLng3 = (LatLng) zza.zza(parcel, zzI, LatLng.CREATOR);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    latLng2 = (LatLng) zza.zza(parcel, zzI, LatLng.CREATOR);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    latLng = (LatLng) zza.zza(parcel, zzI, LatLng.CREATOR);
                    break;
                case Place.TYPE_ATM /*6*/:
                    latLngBounds = (LatLngBounds) zza.zza(parcel, zzI, LatLngBounds.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public VisibleRegion[] zzgj(int i) {
        return new VisibleRegion[i];
    }
}
