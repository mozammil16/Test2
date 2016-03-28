package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.query.Query;

public class zzbg implements Creator<QueryRequest> {
    static void zza(QueryRequest queryRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, queryRequest.zzFG);
        zzb.zza(parcel, 2, queryRequest.zzVd, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcl(x0);
    }

    public QueryRequest zzaS(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    query = (Query) zza.zza(parcel, zzI, Query.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new QueryRequest(i, query);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public QueryRequest[] zzcl(int i) {
        return new QueryRequest[i];
    }
}
