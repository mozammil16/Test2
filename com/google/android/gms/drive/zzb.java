package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zzb implements Creator<Contents> {
    static void zza(Contents contents, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, contents.zzFG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, contents.zzOx, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, contents.zzRV);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, contents.zzRW);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, contents.zzRX, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, contents.zzRY);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbh(x0);
    }

    public Contents zzW(Parcel parcel) {
        DriveId driveId = null;
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzI, ParcelFileDescriptor.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    driveId = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    z = zza.zzc(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public Contents[] zzbh(int i) {
        return new Contents[i];
    }
}
