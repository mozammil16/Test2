package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zzb implements Creator<zza> {
    static void zza(zza com_google_android_gms_maps_model_internal_zza, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, com_google_android_gms_maps_model_internal_zza.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, com_google_android_gms_maps_model_internal_zza.getType());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, com_google_android_gms_maps_model_internal_zza.zzqL(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, com_google_android_gms_maps_model_internal_zza.getBitmap(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgk(x0);
    }

    public zza zzeh(Parcel parcel) {
        Bitmap bitmap = null;
        byte b = (byte) 0;
        int zzJ = zza.zzJ(parcel);
        Bundle bundle = null;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    b = zza.zze(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    bundle = zza.zzq(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    bitmap = (Bitmap) zza.zza(parcel, zzI, Bitmap.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zza(i, b, bundle, bitmap);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zza[] zzgk(int i) {
        return new zza[i];
    }
}
