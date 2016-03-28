package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzap implements Creator<zzao> {
    static void zza(zzao com_google_android_gms_fitness_request_zzao, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_fitness_request_zzao.zzmb(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, com_google_android_gms_fitness_request_zzao.getVersionCode());
        zzb.zza(parcel, 2, com_google_android_gms_fitness_request_zzao.zzlQ(), false);
        zzb.zza(parcel, 3, com_google_android_gms_fitness_request_zzao.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdW(x0);
    }

    public zzao zzcx(Parcel parcel) {
        String str = null;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < zzJ) {
            int i2;
            PendingIntent pendingIntent2;
            String str2;
            IBinder iBinder2;
            int zzI = zza.zzI(parcel);
            String str3;
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    IBinder iBinder3 = iBinder;
                    pendingIntent2 = (PendingIntent) zza.zza(parcel, zzI, PendingIntent.CREATOR);
                    str2 = str;
                    iBinder2 = iBinder3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    str3 = str;
                    iBinder2 = zza.zzp(parcel, zzI);
                    str2 = str3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzI);
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    str3 = str;
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = zza.zzg(parcel, zzI);
                    str2 = str3;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    str2 = str;
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    break;
            }
            i = i2;
            pendingIntent = pendingIntent2;
            iBinder = iBinder2;
            str = str2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzao(i, pendingIntent, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzao[] zzdW(int i) {
        return new zzao[i];
    }
}
