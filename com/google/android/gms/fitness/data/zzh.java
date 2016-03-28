package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class zzh implements Creator<DataType> {
    static void zza(DataType dataType, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, dataType.getName(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataType.getVersionCode());
        zzb.zzc(parcel, 2, dataType.getFields(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdm(x0);
    }

    public DataType zzbP(Parcel parcel) {
        List list = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    list = zza.zzc(parcel, zzI, Field.CREATOR);
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
            return new DataType(i, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public DataType[] zzdm(int i) {
        return new DataType[i];
    }
}
