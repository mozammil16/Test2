package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.List;

public class zzba implements Creator<OnResourceIdSetResponse> {
    static void zza(OnResourceIdSetResponse onResourceIdSetResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, onResourceIdSetResponse.getVersionCode());
        zzb.zzb(parcel, 2, onResourceIdSetResponse.zzkE(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcg(x0);
    }

    public OnResourceIdSetResponse zzaN(Parcel parcel) {
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
            return new OnResourceIdSetResponse(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OnResourceIdSetResponse[] zzcg(int i) {
        return new OnResourceIdSetResponse[i];
    }
}
