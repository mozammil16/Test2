package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class zzi implements Creator<ListSubscriptionsResult> {
    static void zza(ListSubscriptionsResult listSubscriptionsResult, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, listSubscriptionsResult.getSubscriptions(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, listSubscriptionsResult.getVersionCode());
        zzb.zza(parcel, 2, listSubscriptionsResult.getStatus(), i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzei(x0);
    }

    public ListSubscriptionsResult zzcJ(Parcel parcel) {
        Status status = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list = zza.zzc(parcel, zzI, Subscription.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
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
            return new ListSubscriptionsResult(i, list, status);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public ListSubscriptionsResult[] zzei(int i) {
        return new ListSubscriptionsResult[i];
    }
}
