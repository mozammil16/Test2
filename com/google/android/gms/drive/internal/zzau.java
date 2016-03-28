package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.QueryEvent;
import com.google.android.gms.location.places.Place;

public class zzau implements Creator<OnEventResponse> {
    static void zza(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, onEventResponse.zzFG);
        zzb.zzc(parcel, 2, onEventResponse.zzTe);
        zzb.zza(parcel, 3, onEventResponse.zzUU, i, false);
        zzb.zza(parcel, 5, onEventResponse.zzUV, i, false);
        zzb.zza(parcel, 6, onEventResponse.zzUW, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzca(x0);
    }

    public OnEventResponse zzaH(Parcel parcel) {
        int i = 0;
        QueryEvent queryEvent = null;
        int zzJ = zza.zzJ(parcel);
        CompletionEvent completionEvent = null;
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    changeEvent = (ChangeEvent) zza.zza(parcel, zzI, ChangeEvent.CREATOR);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    completionEvent = (CompletionEvent) zza.zza(parcel, zzI, CompletionEvent.CREATOR);
                    break;
                case Place.TYPE_ATM /*6*/:
                    queryEvent = (QueryEvent) zza.zza(parcel, zzI, QueryEvent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new OnEventResponse(i2, i, changeEvent, completionEvent, queryEvent);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OnEventResponse[] zzca(int i) {
        return new OnEventResponse[i];
    }
}
