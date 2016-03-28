package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zzg implements Creator<PutDataRequest> {
    static void zza(PutDataRequest putDataRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, putDataRequest.zzFG);
        zzb.zza(parcel, 2, putDataRequest.getUri(), i, false);
        zzb.zza(parcel, 4, putDataRequest.zzuY(), false);
        zzb.zza(parcel, 5, putDataRequest.getData(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzft(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhT(x0);
    }

    public PutDataRequest zzft(Parcel parcel) {
        byte[] bArr = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < zzJ) {
            Bundle bundle2;
            Uri uri2;
            int zzg;
            byte[] bArr2;
            int zzI = zza.zzI(parcel);
            byte[] bArr3;
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    bArr3 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = zza.zzg(parcel, zzI);
                    bArr2 = bArr3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i;
                    Bundle bundle3 = bundle;
                    uri2 = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    bArr2 = bArr;
                    bundle2 = bundle3;
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    uri2 = uri;
                    zzg = i;
                    bArr3 = bArr;
                    bundle2 = zza.zzq(parcel, zzI);
                    bArr2 = bArr3;
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    bArr2 = zza.zzr(parcel, zzI);
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    bArr2 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = i;
                    break;
            }
            i = zzg;
            uri = uri2;
            bundle = bundle2;
            bArr = bArr2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new PutDataRequest(i, uri, bundle, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public PutDataRequest[] zzhT(int i) {
        return new PutDataRequest[i];
    }
}
