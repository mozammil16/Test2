package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zzh implements Creator<zzg> {
    static void zza(zzg com_google_android_gms_wallet_wobs_zzg, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_wallet_wobs_zzg.getVersionCode());
        zzb.zzc(parcel, 2, com_google_android_gms_wallet_wobs_zzg.zzaFg);
        zzb.zza(parcel, 3, com_google_android_gms_wallet_wobs_zzg.zzaFh, false);
        zzb.zza(parcel, 4, com_google_android_gms_wallet_wobs_zzg.zzaFi);
        zzb.zza(parcel, 5, com_google_android_gms_wallet_wobs_zzg.zzaDo, false);
        zzb.zza(parcel, 6, com_google_android_gms_wallet_wobs_zzg.zzaFj);
        zzb.zzc(parcel, 7, com_google_android_gms_wallet_wobs_zzg.zzaFk);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfl(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhL(x0);
    }

    public zzg zzfl(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    d = zza.zzm(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    j = zza.zzi(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzg(i3, i, str2, d, str, j, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzg[] zzhL(int i) {
        return new zzg[i];
    }
}
