package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzb implements Creator<ObjectChangedDetails> {
    static void zza(ObjectChangedDetails objectChangedDetails, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, objectChangedDetails.zzFG);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, objectChangedDetails.zzXf);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, objectChangedDetails.zzXg);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcT(x0);
    }

    public ObjectChangedDetails zzbz(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new ObjectChangedDetails(i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public ObjectChangedDetails[] zzcT(int i) {
        return new ObjectChangedDetails[i];
    }
}
