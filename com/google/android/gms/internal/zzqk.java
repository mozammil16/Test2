package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.internal.zzpo.zza;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzqk implements Creator<zza> {
    static void zza(zza com_google_android_gms_internal_zzpo_zza, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzpo_zza.mOffset);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, com_google_android_gms_internal_zzpo_zza.zzFG);
        zzb.zzc(parcel, 2, com_google_android_gms_internal_zzpo_zza.mLength);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfM(x0);
    }

    public zza zzdJ(Parcel parcel) {
        int i = 0;
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zza(i3, i2, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zza[] zzfM(int i) {
        return new zza[i];
    }
}
