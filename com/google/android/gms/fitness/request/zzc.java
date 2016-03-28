package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;

public class zzc implements Creator<zzb> {
    static void zza(zzb com_google_android_gms_fitness_request_zzb, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_fitness_request_zzb.getDeviceAddress(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, com_google_android_gms_fitness_request_zzb.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_fitness_request_zzb.zzlP(), i, false);
        zzb.zza(parcel, 3, com_google_android_gms_fitness_request_zzb.zzlQ(), false);
        zzb.zza(parcel, 4, com_google_android_gms_fitness_request_zzb.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdz(x0);
    }

    public zzb zzcb(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        IBinder iBinder = null;
        BleDevice bleDevice = null;
        String str2 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    bleDevice = (BleDevice) zza.zza(parcel, zzI, BleDevice.CREATOR);
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
            return new zzb(i, str2, bleDevice, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzb[] zzdz(int i) {
        return new zzb[i];
    }
}
