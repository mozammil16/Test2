package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzar implements Creator<OnDownloadProgressResponse> {
    static void zza(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, onDownloadProgressResponse.zzFG);
        zzb.zza(parcel, 2, onDownloadProgressResponse.zzUR);
        zzb.zza(parcel, 3, onDownloadProgressResponse.zzUS);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbX(x0);
    }

    public OnDownloadProgressResponse zzaE(Parcel parcel) {
        long j = 0;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = zza.zzi(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new OnDownloadProgressResponse(i, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public OnDownloadProgressResponse[] zzbX(int i) {
        return new OnDownloadProgressResponse[i];
    }
}
