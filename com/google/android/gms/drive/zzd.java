package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zzd implements Creator<DriveId> {
    static void zza(DriveId driveId, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, driveId.zzFG);
        zzb.zza(parcel, 2, driveId.zzSh, false);
        zzb.zza(parcel, 3, driveId.zzSi);
        zzb.zza(parcel, 4, driveId.zzRS);
        zzb.zzc(parcel, 5, driveId.zzSj);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbi(x0);
    }

    public DriveId zzX(Parcel parcel) {
        long j = 0;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        int i2 = -1;
        long j2 = 0;
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
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    j = zza.zzi(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new DriveId(i, str, j2, j, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public DriveId[] zzbi(int i) {
        return new DriveId[i];
    }
}
