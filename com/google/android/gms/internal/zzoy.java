package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzoy implements Creator<zzox> {
    static void zza(zzox com_google_android_gms_internal_zzox, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzox.uid);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, com_google_android_gms_internal_zzox.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzox.packageName, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzft(x0);
    }

    public zzox zzdu(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzox(i2, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzox[] zzft(int i) {
        return new zzox[i];
    }
}
