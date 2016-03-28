package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import java.util.List;

public class zzsq implements Creator<zzsp> {
    static void zza(zzsp com_google_android_gms_internal_zzsp, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzsp.versionCode);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zzsp.zzats, false);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zzsp.zzru(), false);
        zzb.zzc(parcel, 4, com_google_android_gms_internal_zzsp.zzatu, false);
        zzb.zza(parcel, 5, com_google_android_gms_internal_zzsp.zzatv);
        zzb.zza(parcel, 6, com_google_android_gms_internal_zzsp.zzrq(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzet(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgF(x0);
    }

    public zzsp zzet(Parcel parcel) {
        IBinder iBinder = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        long j = 0;
        List list = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    iBinder3 = zza.zzp(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    iBinder2 = zza.zzp(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    list = zza.zzc(parcel, zzI, zzsi.CREATOR);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    j = zza.zzi(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzsp(i, iBinder3, iBinder2, list, j, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzsp[] zzgF(int i) {
        return new zzsp[i];
    }
}
