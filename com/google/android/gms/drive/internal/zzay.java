package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzay implements Creator<OnMetadataResponse> {
    static void zza(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, onMetadataResponse.zzFG);
        zzb.zza(parcel, 2, onMetadataResponse.zzTp, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzce(x0);
    }

    public OnMetadataResponse zzaL(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzI, MetadataBundle.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OnMetadataResponse[] zzce(int i) {
        return new OnMetadataResponse[i];
    }
}
