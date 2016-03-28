package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class zzb implements Creator<SortOrder> {
    static void zza(SortOrder sortOrder, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, sortOrder.zzFG);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, sortOrder.zzWu, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, sortOrder.zzWv);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbi(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcB(x0);
    }

    public SortOrder zzbi(Parcel parcel) {
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list = zza.zzc(parcel, zzI, FieldWithSortOrder.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z = zza.zzc(parcel, zzI);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new SortOrder(i, list, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public SortOrder[] zzcB(int i) {
        return new SortOrder[i];
    }
}
