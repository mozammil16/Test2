package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zzth implements Creator<zztf> {
    static void zza(zztf com_google_android_gms_internal_zztf, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zztf.versionCode);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zztf.zzatM);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zztf.tag, false);
        zzb.zza(parcel, 4, com_google_android_gms_internal_zztf.zzatN, false);
        zzb.zza(parcel, 5, com_google_android_gms_internal_zztf.zzatO, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzev(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgH(x0);
    }

    public zztf zzev(Parcel parcel) {
        Bundle bundle = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        long j = 0;
        byte[] bArr = null;
        String str = null;
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
                    str = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    bArr = zza.zzr(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    bundle = zza.zzq(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zztf(i, j, str, bArr, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zztf[] zzgH(int i) {
        return new zztf[i];
    }
}
