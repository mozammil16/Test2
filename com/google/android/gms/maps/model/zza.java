package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zza implements Creator<CameraPosition> {
    static void zza(CameraPosition cameraPosition, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, cameraPosition.getVersionCode());
        zzb.zza(parcel, 2, cameraPosition.target, i, false);
        zzb.zza(parcel, 3, cameraPosition.zoom);
        zzb.zza(parcel, 4, cameraPosition.tilt);
        zzb.zza(parcel, 5, cameraPosition.bearing);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfV(x0);
    }

    public CameraPosition zzdS(Parcel parcel) {
        float f = 0.0f;
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < zzJ) {
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzI, LatLng.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzI);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public CameraPosition[] zzfV(int i) {
        return new CameraPosition[i];
    }
}
