package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import java.util.ArrayList;
import java.util.List;

public class zzal implements Creator<LoadRealtimeRequest> {
    static void zza(LoadRealtimeRequest loadRealtimeRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, loadRealtimeRequest.zzFG);
        zzb.zza(parcel, 2, loadRealtimeRequest.zzRX, i, false);
        zzb.zza(parcel, 3, loadRealtimeRequest.zzUD);
        zzb.zzb(parcel, 4, loadRealtimeRequest.zzUE, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbT(x0);
    }

    public LoadRealtimeRequest zzaA(Parcel parcel) {
        List list = null;
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            boolean z2;
            DriveId driveId2;
            int zzg;
            ArrayList zzC;
            int zzI = zza.zzI(parcel);
            List list2;
            List list3;
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list2 = list;
                    z2 = z;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzI);
                    list3 = list2;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i;
                    boolean z3 = z;
                    driveId2 = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    list3 = list;
                    z2 = z3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    driveId2 = driveId;
                    zzg = i;
                    list2 = list;
                    z2 = zza.zzc(parcel, zzI);
                    list3 = list2;
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    zzC = zza.zzC(parcel, zzI);
                    z2 = z;
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    zzC = list;
                    z2 = z;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            z = z2;
            Object obj = zzC;
        }
        if (parcel.dataPosition() == zzJ) {
            return new LoadRealtimeRequest(i, driveId, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public LoadRealtimeRequest[] zzbT(int i) {
        return new LoadRealtimeRequest[i];
    }
}
