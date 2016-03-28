package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.internal.zzpk;
import java.util.List;

public class zza implements Creator<GeofencingRequest> {
    static void zza(GeofencingRequest geofencingRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, geofencingRequest.zzpp(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, geofencingRequest.getVersionCode());
        zzb.zzc(parcel, 2, geofencingRequest.getInitialTrigger());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfh(x0);
    }

    public GeofencingRequest zzdn(Parcel parcel) {
        int i = 0;
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI, zzpk.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new GeofencingRequest(i2, list, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public GeofencingRequest[] zzfh(int i) {
        return new GeofencingRequest[i];
    }
}
