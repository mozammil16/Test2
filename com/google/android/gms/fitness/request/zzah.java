package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import java.util.List;

public class zzah implements Creator<SessionReadRequest> {
    static void zza(SessionReadRequest sessionReadRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, sessionReadRequest.getSessionName(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, sessionReadRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionReadRequest.getSessionId(), false);
        zzb.zza(parcel, 3, sessionReadRequest.zzlp());
        zzb.zza(parcel, 4, sessionReadRequest.zzlq());
        zzb.zzc(parcel, 5, sessionReadRequest.getDataTypes(), false);
        zzb.zzc(parcel, 6, sessionReadRequest.getDataSources(), false);
        zzb.zza(parcel, 7, sessionReadRequest.zzmj());
        zzb.zza(parcel, 8, sessionReadRequest.zzlV());
        zzb.zzb(parcel, 9, sessionReadRequest.getExcludedPackages(), false);
        zzb.zza(parcel, 10, sessionReadRequest.zzlQ(), false);
        zzb.zza(parcel, 11, sessionReadRequest.getPackageName(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzct(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdS(x0);
    }

    public SessionReadRequest zzct(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        List list = null;
        List list2 = null;
        boolean z = false;
        boolean z2 = false;
        List list3 = null;
        IBinder iBinder = null;
        String str3 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = zza.zzi(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    list = zza.zzc(parcel, zzI, DataType.CREATOR);
                    break;
                case Place.TYPE_ATM /*6*/:
                    list2 = zza.zzc(parcel, zzI, DataSource.CREATOR);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    z = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_BANK /*8*/:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_BAR /*9*/:
                    list3 = zza.zzC(parcel, zzI);
                    break;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    iBinder = zza.zzp(parcel, zzI);
                    break;
                case Place.TYPE_BICYCLE_STORE /*11*/:
                    str3 = zza.zzo(parcel, zzI);
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
            return new SessionReadRequest(i, str, str2, j, j2, list, list2, z, z2, list3, iBinder, str3);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public SessionReadRequest[] zzdS(int i) {
        return new SessionReadRequest[i];
    }
}
