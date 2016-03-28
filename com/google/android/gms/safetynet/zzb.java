package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzb implements Creator<zza> {
    static void zza(zza com_google_android_gms_safetynet_zza, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, com_google_android_gms_safetynet_zza.zzFG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, com_google_android_gms_safetynet_zza.getJwsResult(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgY(x0);
    }

    public zza zzeL(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zza(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zza[] zzgY(int i) {
        return new zza[i];
    }
}
