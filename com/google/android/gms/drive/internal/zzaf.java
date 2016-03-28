package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzaf implements Creator<GetMetadataRequest> {
    static void zza(GetMetadataRequest getMetadataRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, getMetadataRequest.zzFG);
        zzb.zza(parcel, 2, getMetadataRequest.zzTh, i, false);
        zzb.zza(parcel, 3, getMetadataRequest.zzUB);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzay(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbR(x0);
    }

    public GetMetadataRequest zzay(Parcel parcel) {
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            DriveId driveId2;
            int zzg;
            boolean z2;
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    boolean z3 = z;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzI);
                    z2 = z3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    z2 = z;
                    driveId2 = driveId3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z2 = zza.zzc(parcel, zzI);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    z2 = z;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            z = z2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new GetMetadataRequest(i, driveId, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public GetMetadataRequest[] zzbR(int i) {
        return new GetMetadataRequest[i];
    }
}
