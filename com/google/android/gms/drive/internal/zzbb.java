package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.StorageStats;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzbb implements Creator<OnStorageStatsResponse> {
    static void zza(OnStorageStatsResponse onStorageStatsResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, onStorageStatsResponse.zzFG);
        zzb.zza(parcel, 2, onStorageStatsResponse.zzVa, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzch(x0);
    }

    public OnStorageStatsResponse zzaO(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        StorageStats storageStats = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    storageStats = (StorageStats) zza.zza(parcel, zzI, StorageStats.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new OnStorageStatsResponse(i, storageStats);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OnStorageStatsResponse[] zzch(int i) {
        return new OnStorageStatsResponse[i];
    }
}
