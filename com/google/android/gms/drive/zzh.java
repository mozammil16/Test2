package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.List;

public class zzh implements Creator<RealtimeDocumentSyncRequest> {
    static void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, realtimeDocumentSyncRequest.zzFG);
        zzb.zzb(parcel, 2, realtimeDocumentSyncRequest.zzSB, false);
        zzb.zzb(parcel, 3, realtimeDocumentSyncRequest.zzSC, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaa(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbn(x0);
    }

    public RealtimeDocumentSyncRequest zzaa(Parcel parcel) {
        List list = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        List list2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    list2 = zza.zzC(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    list = zza.zzC(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new RealtimeDocumentSyncRequest(i, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public RealtimeDocumentSyncRequest[] zzbn(int i) {
        return new RealtimeDocumentSyncRequest[i];
    }
}
