package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zzbd implements Creator<OpenContentsRequest> {
    static void zza(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, openContentsRequest.zzFG);
        zzb.zza(parcel, 2, openContentsRequest.zzTh, i, false);
        zzb.zzc(parcel, 3, openContentsRequest.zzRW);
        zzb.zzc(parcel, 4, openContentsRequest.zzVb);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcj(x0);
    }

    public OpenContentsRequest zzaQ(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        DriveId driveId = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            DriveId driveId2;
            int zzg;
            int zzI = zza.zzI(parcel);
            int i4;
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i4 = i;
                    i = i2;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzI);
                    zzI = i4;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i3;
                    i4 = i2;
                    driveId2 = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    zzI = i;
                    i = i4;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    driveId2 = driveId;
                    zzg = i3;
                    i4 = i;
                    i = zza.zzg(parcel, zzI);
                    zzI = i4;
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    zzI = zza.zzg(parcel, zzI);
                    i = i2;
                    driveId2 = driveId;
                    zzg = i3;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    zzI = i;
                    i = i2;
                    driveId2 = driveId;
                    zzg = i3;
                    break;
            }
            i3 = zzg;
            driveId = driveId2;
            i2 = i;
            i = zzI;
        }
        if (parcel.dataPosition() == zzJ) {
            return new OpenContentsRequest(i3, driveId, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OpenContentsRequest[] zzcj(int i) {
        return new OpenContentsRequest[i];
    }
}
