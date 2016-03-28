package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.List;

public class zzk implements Creator<ParentDriveIdSet> {
    static void zza(ParentDriveIdSet parentDriveIdSet, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, parentDriveIdSet.zzFG);
        zzb.zzc(parcel, 2, parentDriveIdSet.zzVr, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcy(x0);
    }

    public ParentDriveIdSet zzbf(Parcel parcel) {
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
                    list = zza.zzc(parcel, zzI, PartialDriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new ParentDriveIdSet(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public ParentDriveIdSet[] zzcy(int i) {
        return new ParentDriveIdSet[i];
    }
}
