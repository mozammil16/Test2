package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzb implements Creator<zza> {
    static void zza(zza com_google_android_gms_fitness_data_zza, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, com_google_android_gms_fitness_data_zza.getPackageName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, com_google_android_gms_fitness_data_zza.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, com_google_android_gms_fitness_data_zza.getVersion(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, com_google_android_gms_fitness_data_zza.zzlm(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzde(x0);
    }

    public zza zzbJ(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzI);
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
            return new zza(i, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zza[] zzde(int i) {
        return new zza[i];
    }
}
