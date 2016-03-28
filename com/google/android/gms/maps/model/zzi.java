package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzi implements Creator<LatLng> {
    static void zza(LatLng latLng, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, latLng.getVersionCode());
        zzb.zza(parcel, 2, latLng.latitude);
        zzb.zza(parcel, 3, latLng.longitude);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfZ(x0);
    }

    public LatLng zzdW(Parcel parcel) {
        double d = 0.0d;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    d2 = zza.zzm(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    d = zza.zzm(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new LatLng(i, d2, d);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public LatLng[] zzfZ(int i) {
        return new LatLng[i];
    }
}
