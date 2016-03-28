package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzax implements Creator<OnListParentsResponse> {
    static void zza(OnListParentsResponse onListParentsResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, onListParentsResponse.zzFG);
        zzb.zza(parcel, 2, onListParentsResponse.zzUZ, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcd(x0);
    }

    public OnListParentsResponse zzaK(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    dataHolder = (DataHolder) zza.zza(parcel, zzI, DataHolder.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new OnListParentsResponse(i, dataHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OnListParentsResponse[] zzcd(int i) {
        return new OnListParentsResponse[i];
    }
}
