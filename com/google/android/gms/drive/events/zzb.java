package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.places.Place;
import java.util.List;

public class zzb implements Creator<CompletionEvent> {
    static void zza(CompletionEvent completionEvent, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, completionEvent.zzFG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, completionEvent.zzRX, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, completionEvent.zzHg, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, completionEvent.zzSP, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, completionEvent.zzSQ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, completionEvent.zzSR, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 7, completionEvent.zzSS, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, completionEvent.zzrX);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, completionEvent.zzST, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzae(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbr(x0);
    }

    public CompletionEvent zzae(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int zzJ = zza.zzJ(parcel);
        List list = null;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    driveId = (DriveId) zza.zza(parcel, zzI, DriveId.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) zza.zza(parcel, zzI, ParcelFileDescriptor.CREATOR);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzI, ParcelFileDescriptor.CREATOR);
                    break;
                case Place.TYPE_ATM /*6*/:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzI, MetadataBundle.CREATOR);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    list = zza.zzC(parcel, zzI);
                    break;
                case Place.TYPE_BANK /*8*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_BAR /*9*/:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new CompletionEvent(i2, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, list, i, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public CompletionEvent[] zzbr(int i) {
        return new CompletionEvent[i];
    }
}
