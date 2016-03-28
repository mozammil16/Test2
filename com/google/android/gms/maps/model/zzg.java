package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzg implements Creator<LatLngBounds> {
    static void zza(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, latLngBounds.getVersionCode());
        zzb.zza(parcel, 2, latLngBounds.southwest, i, false);
        zzb.zza(parcel, 3, latLngBounds.northeast, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfY(x0);
    }

    public LatLngBounds zzdV(Parcel parcel) {
        LatLng latLng = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzg;
            LatLng latLng3;
            int zzI = zza.zzI(parcel);
            LatLng latLng4;
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    latLng4 = latLng;
                    latLng = latLng2;
                    zzg = zza.zzg(parcel, zzI);
                    latLng3 = latLng4;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i;
                    latLng4 = (LatLng) zza.zza(parcel, zzI, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    latLng3 = (LatLng) zza.zza(parcel, zzI, LatLng.CREATOR);
                    latLng = latLng2;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    latLng3 = latLng;
                    latLng = latLng2;
                    zzg = i;
                    break;
            }
            i = zzg;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == zzJ) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public LatLngBounds[] zzfY(int i) {
        return new LatLngBounds[i];
    }
}
