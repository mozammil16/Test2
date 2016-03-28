package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;

public class zza implements Creator<AddEventListenerRequest> {
    static void zza(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, addEventListenerRequest.zzFG);
        zzb.zza(parcel, 2, addEventListenerRequest.zzRX, i, false);
        zzb.zzc(parcel, 3, addEventListenerRequest.zzTe);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzai(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbw(x0);
    }

    public AddEventListenerRequest zzai(Parcel parcel) {
        int i = 0;
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            DriveId driveId2;
            int zzg;
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    int i3 = i;
                    driveId2 = driveId;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    zzI = i3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i2;
                    DriveId driveId3 = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzI, DriveId.CREATOR);
                    zzI = i;
                    driveId2 = driveId3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    zzI = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    zzI = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            driveId = driveId2;
            i = zzI;
        }
        if (parcel.dataPosition() == zzJ) {
            return new AddEventListenerRequest(i2, driveId, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public AddEventListenerRequest[] zzbw(int i) {
        return new AddEventListenerRequest[i];
    }
}
