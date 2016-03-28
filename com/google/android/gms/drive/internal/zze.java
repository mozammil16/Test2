package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.List;

public class zze implements Creator<CheckResourceIdsExistRequest> {
    static void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, checkResourceIdsExistRequest.getVersionCode());
        zzb.zzb(parcel, 2, checkResourceIdsExistRequest.zzkE(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzal(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbz(x0);
    }

    public CheckResourceIdsExistRequest zzal(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    list = zza.zzC(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new CheckResourceIdsExistRequest(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public CheckResourceIdsExistRequest[] zzbz(int i) {
        return new CheckResourceIdsExistRequest[i];
    }
}
