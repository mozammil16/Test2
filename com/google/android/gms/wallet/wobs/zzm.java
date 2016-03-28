package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzm implements Creator<zzl> {
    static void zza(zzl com_google_android_gms_wallet_wobs_zzl, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_wallet_wobs_zzl.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_wallet_wobs_zzl.zzaFm);
        zzb.zza(parcel, 3, com_google_android_gms_wallet_wobs_zzl.zzaFn);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhO(x0);
    }

    public zzl zzfo(Parcel parcel) {
        long j = 0;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = zza.zzi(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzl(i, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzl[] zzhO(int i) {
        return new zzl[i];
    }
}
