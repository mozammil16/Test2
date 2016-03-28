package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzaz implements Creator<OnLoadRealtimeResponse> {
    static void zza(OnLoadRealtimeResponse onLoadRealtimeResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, onLoadRealtimeResponse.zzFG);
        zzb.zza(parcel, 2, onLoadRealtimeResponse.zzmE);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcf(x0);
    }

    public OnLoadRealtimeResponse zzaM(Parcel parcel) {
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z = zza.zzc(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new OnLoadRealtimeResponse(i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OnLoadRealtimeResponse[] zzcf(int i) {
        return new OnLoadRealtimeResponse[i];
    }
}
