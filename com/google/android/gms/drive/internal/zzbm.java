package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzbm implements Creator<TrashResourceRequest> {
    static void zza(TrashResourceRequest trashResourceRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, trashResourceRequest.zzFG);
        zzb.zza(parcel, 2, trashResourceRequest.zzTh, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcq(x0);
    }

    public TrashResourceRequest zzaX(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    driveId = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new TrashResourceRequest(i, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public TrashResourceRequest[] zzcq(int i) {
        return new TrashResourceRequest[i];
    }
}
