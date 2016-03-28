package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;

public class zzaw implements Creator<zzav> {
    static void zza(zzav com_google_android_gms_fitness_request_zzav, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, com_google_android_gms_fitness_request_zzav.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_fitness_request_zzav.getDeviceAddress(), false);
        zzb.zza(parcel, 3, com_google_android_gms_fitness_request_zzav.zzlQ(), false);
        zzb.zza(parcel, 4, com_google_android_gms_fitness_request_zzav.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzea(x0);
    }

    public zzav zzcB(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        IBinder iBinder = null;
        String str2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzav(i, str2, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzav[] zzea(int i) {
        return new zzav[i];
    }
}
