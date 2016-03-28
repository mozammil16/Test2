package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class zzc implements Creator<StreetViewPanoramaOptions> {
    static void zza(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, streetViewPanoramaOptions.getVersionCode());
        zzb.zza(parcel, 2, streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        zzb.zza(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        zzb.zza(parcel, 4, streetViewPanoramaOptions.getPosition(), i, false);
        zzb.zza(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        zzb.zza(parcel, 6, streetViewPanoramaOptions.zzqw());
        zzb.zza(parcel, 7, streetViewPanoramaOptions.zzqm());
        zzb.zza(parcel, 8, streetViewPanoramaOptions.zzqx());
        zzb.zza(parcel, 9, streetViewPanoramaOptions.zzqy());
        zzb.zza(parcel, 10, streetViewPanoramaOptions.zzqi());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfT(x0);
    }

    public StreetViewPanoramaOptions zzdQ(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int zzJ = zza.zzJ(parcel);
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) zza.zza(parcel, zzI, StreetViewPanoramaCamera.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    latLng = (LatLng) zza.zza(parcel, zzI, LatLng.CREATOR);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    num = zza.zzh(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    b5 = zza.zze(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    b4 = zza.zze(parcel, zzI);
                    break;
                case Place.TYPE_BANK /*8*/:
                    b3 = zza.zze(parcel, zzI);
                    break;
                case Place.TYPE_BAR /*9*/:
                    b2 = zza.zze(parcel, zzI);
                    break;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    b = zza.zze(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b5, b4, b3, b2, b);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public StreetViewPanoramaOptions[] zzfT(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}
