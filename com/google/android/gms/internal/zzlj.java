package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.internal.zzlh.zza;
import java.util.ArrayList;

public class zzlj implements Creator<zza> {
    static void zza(zza com_google_android_gms_internal_zzlh_zza, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzlh_zza.versionCode);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzlh_zza.className, false);
        zzb.zzc(parcel, 3, com_google_android_gms_internal_zzlh_zza.zzRc, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaY(x0);
    }

    public zza zzS(Parcel parcel) {
        ArrayList arrayList = null;
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI, zzlh.zzb.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zza(i, str, arrayList);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zza[] zzaY(int i) {
        return new zza[i];
    }
}
