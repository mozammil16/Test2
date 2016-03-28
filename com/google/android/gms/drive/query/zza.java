package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import java.util.List;

public class zza implements Creator<Query> {
    static void zza(Query query, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, query.zzFG);
        zzb.zza(parcel, 1, query.zzWm, i, false);
        zzb.zza(parcel, 3, query.zzWn, false);
        zzb.zza(parcel, 4, query.zzWo, i, false);
        zzb.zzb(parcel, 5, query.zzWp, false);
        zzb.zza(parcel, 6, query.zzWq);
        zzb.zzc(parcel, 7, query.zzUx, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcA(x0);
    }

    public Query zzbh(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        List list2 = null;
        SortOrder sortOrder = null;
        String str = null;
        LogicalFilter logicalFilter = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    logicalFilter = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzI, LogicalFilter.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    sortOrder = (SortOrder) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzI, SortOrder.CREATOR);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    list2 = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI, DriveSpace.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new Query(i, logicalFilter, str, sortOrder, list2, z, list);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public Query[] zzcA(int i) {
        return new Query[i];
    }
}
