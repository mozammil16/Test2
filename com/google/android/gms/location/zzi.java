package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.List;

public class zzi implements Creator<zzh> {
    static void zza(zzh com_google_android_gms_location_zzh, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_location_zzh.zzaml, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, com_google_android_gms_location_zzh.getVersionCode());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfm(x0);
    }

    public zzh zzdq(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        List list = zzh.zzamk;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list = zza.zzc(parcel, zzI, Location.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzh(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzh[] zzfm(int i) {
        return new zzh[i];
    }
}
