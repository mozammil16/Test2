package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzf implements Creator<PlusCommonExtras> {
    static void zza(PlusCommonExtras plusCommonExtras, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, plusCommonExtras.zzrQ(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, plusCommonExtras.getVersionCode());
        zzb.zza(parcel, 2, plusCommonExtras.zzrR(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzex(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgK(x0);
    }

    public PlusCommonExtras zzex(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
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
            return new PlusCommonExtras(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public PlusCommonExtras[] zzgK(int i) {
        return new PlusCommonExtras[i];
    }
}
