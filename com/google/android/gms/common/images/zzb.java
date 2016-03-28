package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zzb implements Creator<WebImage> {
    static void zza(WebImage webImage, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, webImage.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, webImage.getUrl(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, webImage.getWidth());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, webImage.getHeight());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaD(x0);
    }

    public WebImage zzB(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            Uri uri2;
            int zzg;
            int zzI = zza.zzI(parcel);
            int i4;
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i4 = i;
                    i = i2;
                    uri2 = uri;
                    zzg = zza.zzg(parcel, zzI);
                    zzI = i4;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i3;
                    i4 = i2;
                    uri2 = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    zzI = i;
                    i = i4;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    uri2 = uri;
                    zzg = i3;
                    i4 = i;
                    i = zza.zzg(parcel, zzI);
                    zzI = i4;
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    zzI = zza.zzg(parcel, zzI);
                    i = i2;
                    uri2 = uri;
                    zzg = i3;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    zzI = i;
                    i = i2;
                    uri2 = uri;
                    zzg = i3;
                    break;
            }
            i3 = zzg;
            uri = uri2;
            i2 = i;
            i = zzI;
        }
        if (parcel.dataPosition() == zzJ) {
            return new WebImage(i3, uri, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public WebImage[] zzaD(int i) {
        return new WebImage[i];
    }
}
