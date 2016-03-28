package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.zzq;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class zzl implements Creator<SessionReadResult> {
    static void zza(SessionReadResult sessionReadResult, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, sessionReadResult.getSessions(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, sessionReadResult.getVersionCode());
        zzb.zzc(parcel, 2, sessionReadResult.zzmt(), false);
        zzb.zza(parcel, 3, sessionReadResult.getStatus(), i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzek(x0);
    }

    public SessionReadResult zzcL(Parcel parcel) {
        Status status = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list2 = zza.zzc(parcel, zzI, Session.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    list = zza.zzc(parcel, zzI, zzq.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    status = (Status) zza.zza(parcel, zzI, Status.CREATOR);
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
            return new SessionReadResult(i, list2, list, status);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public SessionReadResult[] zzek(int i) {
        return new SessionReadResult[i];
    }
}
