package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zze implements Creator<GroundOverlayOptions> {
    static void zza(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, groundOverlayOptions.getVersionCode());
        zzb.zza(parcel, 2, groundOverlayOptions.zzqH(), false);
        zzb.zza(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        zzb.zza(parcel, 4, groundOverlayOptions.getWidth());
        zzb.zza(parcel, 5, groundOverlayOptions.getHeight());
        zzb.zza(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        zzb.zza(parcel, 7, groundOverlayOptions.getBearing());
        zzb.zza(parcel, 8, groundOverlayOptions.getZIndex());
        zzb.zza(parcel, 9, groundOverlayOptions.isVisible());
        zzb.zza(parcel, 10, groundOverlayOptions.getTransparency());
        zzb.zza(parcel, 11, groundOverlayOptions.getAnchorU());
        zzb.zza(parcel, 12, groundOverlayOptions.getAnchorV());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfX(x0);
    }

    public GroundOverlayOptions zzdU(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    latLng = (LatLng) zza.zza(parcel, zzI, LatLng.CREATOR);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    f = zza.zzl(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    f2 = zza.zzl(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    latLngBounds = (LatLngBounds) zza.zza(parcel, zzI, LatLngBounds.CREATOR);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    f3 = zza.zzl(parcel, zzI);
                    break;
                case Place.TYPE_BANK /*8*/:
                    f4 = zza.zzl(parcel, zzI);
                    break;
                case Place.TYPE_BAR /*9*/:
                    z = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    f5 = zza.zzl(parcel, zzI);
                    break;
                case Place.TYPE_BICYCLE_STORE /*11*/:
                    f6 = zza.zzl(parcel, zzI);
                    break;
                case Place.TYPE_BOOK_STORE /*12*/:
                    f7 = zza.zzl(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public GroundOverlayOptions[] zzfX(int i) {
        return new GroundOverlayOptions[i];
    }
}
