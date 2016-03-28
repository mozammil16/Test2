package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzst implements Creator<zzss> {
    static void zza(zzss com_google_android_gms_internal_zzss, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzss.versionCode);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzss.zzatv);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzss.zzrq(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgG(x0);
    }

    public zzss zzeu(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        long j = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j = zza.zzi(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzss(i, j, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzss[] zzgG(int i) {
        return new zzss[i];
    }
}
