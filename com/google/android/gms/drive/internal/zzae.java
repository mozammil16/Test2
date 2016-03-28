package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzae implements Creator<GetDriveIdFromUniqueIdentifierRequest> {
    static void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, getDriveIdFromUniqueIdentifierRequest.zzFG);
        zzb.zza(parcel, 2, getDriveIdFromUniqueIdentifierRequest.zzUz, false);
        zzb.zza(parcel, 3, getDriveIdFromUniqueIdentifierRequest.zzUA);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzax(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbQ(x0);
    }

    public GetDriveIdFromUniqueIdentifierRequest zzax(Parcel parcel) {
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z = zza.zzc(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new GetDriveIdFromUniqueIdentifierRequest(i, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public GetDriveIdFromUniqueIdentifierRequest[] zzbQ(int i) {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }
}
