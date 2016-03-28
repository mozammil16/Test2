package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import java.util.ArrayList;
import java.util.List;

public class zzad implements Creator<GetChangesRequest> {
    static void zza(GetChangesRequest getChangesRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, getChangesRequest.zzFG);
        zzb.zza(parcel, 2, getChangesRequest.zzUv, i, false);
        zzb.zzc(parcel, 3, getChangesRequest.zzUw);
        zzb.zzc(parcel, 4, getChangesRequest.zzUx, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbP(x0);
    }

    public GetChangesRequest zzaw(Parcel parcel) {
        List list = null;
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        ChangeSequenceNumber changeSequenceNumber = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int i3;
            ChangeSequenceNumber changeSequenceNumber2;
            int zzg;
            ArrayList zzc;
            int zzI = zza.zzI(parcel);
            List list2;
            List list3;
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list2 = list;
                    i3 = i;
                    changeSequenceNumber2 = changeSequenceNumber;
                    zzg = zza.zzg(parcel, zzI);
                    list3 = list2;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i2;
                    int i4 = i;
                    changeSequenceNumber2 = (ChangeSequenceNumber) zza.zza(parcel, zzI, ChangeSequenceNumber.CREATOR);
                    list3 = list;
                    i3 = i4;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    changeSequenceNumber2 = changeSequenceNumber;
                    zzg = i2;
                    list2 = list;
                    i3 = zza.zzg(parcel, zzI);
                    list3 = list2;
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    zzc = zza.zzc(parcel, zzI, DriveSpace.CREATOR);
                    i3 = i;
                    changeSequenceNumber2 = changeSequenceNumber;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    zzc = list;
                    i3 = i;
                    changeSequenceNumber2 = changeSequenceNumber;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            changeSequenceNumber = changeSequenceNumber2;
            i = i3;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzJ) {
            return new GetChangesRequest(i2, changeSequenceNumber, i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public GetChangesRequest[] zzbP(int i) {
        return new GetChangesRequest[i];
    }
}
