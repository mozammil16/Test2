package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zzl implements Creator<PartialDriveId> {
    static void zza(PartialDriveId partialDriveId, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, partialDriveId.zzFG);
        zzb.zza(parcel, 2, partialDriveId.zzSh, false);
        zzb.zza(parcel, 3, partialDriveId.zzSi);
        zzb.zzc(parcel, 4, partialDriveId.zzSj);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcz(x0);
    }

    public PartialDriveId zzbg(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        long j = 0;
        int i2 = -1;
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
                    j = zza.zzi(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new PartialDriveId(i, str, j, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public PartialDriveId[] zzcz(int i) {
        return new PartialDriveId[i];
    }
}
