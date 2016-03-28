package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;

public class zzk implements Creator<MarkerOptions> {
    static void zza(MarkerOptions markerOptions, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, markerOptions.getVersionCode());
        zzb.zza(parcel, 2, markerOptions.getPosition(), i, false);
        zzb.zza(parcel, 3, markerOptions.getTitle(), false);
        zzb.zza(parcel, 4, markerOptions.getSnippet(), false);
        zzb.zza(parcel, 5, markerOptions.zzqI(), false);
        zzb.zza(parcel, 6, markerOptions.getAnchorU());
        zzb.zza(parcel, 7, markerOptions.getAnchorV());
        zzb.zza(parcel, 8, markerOptions.isDraggable());
        zzb.zza(parcel, 9, markerOptions.isVisible());
        zzb.zza(parcel, 10, markerOptions.isFlat());
        zzb.zza(parcel, 11, markerOptions.getRotation());
        zzb.zza(parcel, 12, markerOptions.getInfoWindowAnchorU());
        zzb.zza(parcel, 13, markerOptions.getInfoWindowAnchorV());
        zzb.zza(parcel, 14, markerOptions.getAlpha());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzga(x0);
    }

    public MarkerOptions zzdX(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = TextTrackStyle.DEFAULT_FONT_SCALE;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    latLng = (LatLng) zza.zza(parcel, zzI, LatLng.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    f = zza.zzl(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    f2 = zza.zzl(parcel, zzI);
                    break;
                case Place.TYPE_BANK /*8*/:
                    z = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_BAR /*9*/:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    z3 = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_BICYCLE_STORE /*11*/:
                    f3 = zza.zzl(parcel, zzI);
                    break;
                case Place.TYPE_BOOK_STORE /*12*/:
                    f4 = zza.zzl(parcel, zzI);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    f5 = zza.zzl(parcel, zzI);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    f6 = zza.zzl(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public MarkerOptions[] zzga(int i) {
        return new MarkerOptions[i];
    }
}
