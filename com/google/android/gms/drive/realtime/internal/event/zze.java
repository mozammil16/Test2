package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zze implements Creator<ReferenceShiftedDetails> {
    static void zza(ReferenceShiftedDetails referenceShiftedDetails, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, referenceShiftedDetails.zzFG);
        zzb.zza(parcel, 2, referenceShiftedDetails.zzXy, false);
        zzb.zza(parcel, 3, referenceShiftedDetails.zzXz, false);
        zzb.zzc(parcel, 4, referenceShiftedDetails.zzXA);
        zzb.zzc(parcel, 5, referenceShiftedDetails.zzXB);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcW(x0);
    }

    public ReferenceShiftedDetails zzbC(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new ReferenceShiftedDetails(i3, str2, str, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public ReferenceShiftedDetails[] zzcW(int i) {
        return new ReferenceShiftedDetails[i];
    }
}
