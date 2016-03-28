package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.places.Place;

public class zzj implements Creator<CreateFileIntentSenderRequest> {
    static void zza(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, createFileIntentSenderRequest.zzFG);
        zzb.zza(parcel, 2, createFileIntentSenderRequest.zzTp, i, false);
        zzb.zzc(parcel, 3, createFileIntentSenderRequest.zzRV);
        zzb.zza(parcel, 4, createFileIntentSenderRequest.zzSy, false);
        zzb.zza(parcel, 5, createFileIntentSenderRequest.zzSA, i, false);
        zzb.zza(parcel, 6, createFileIntentSenderRequest.zzTq, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzap(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbE(x0);
    }

    public CreateFileIntentSenderRequest zzap(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int zzJ = zza.zzJ(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzI, MetadataBundle.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    driveId = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    break;
                case Place.TYPE_ATM /*6*/:
                    num = zza.zzh(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId, num);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public CreateFileIntentSenderRequest[] zzbE(int i) {
        return new CreateFileIntentSenderRequest[i];
    }
}
