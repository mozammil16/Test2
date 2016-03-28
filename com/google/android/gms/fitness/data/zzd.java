package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import java.util.List;

public class zzd implements Creator<Bucket> {
    static void zza(Bucket bucket, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, bucket.zzlp());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, bucket.getVersionCode());
        zzb.zza(parcel, 2, bucket.zzlq());
        zzb.zza(parcel, 3, bucket.getSession(), i, false);
        zzb.zzc(parcel, 4, bucket.zzln());
        zzb.zzc(parcel, 5, bucket.getDataSets(), false);
        zzb.zzc(parcel, 6, bucket.getBucketType());
        zzb.zza(parcel, 7, bucket.zzlo());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdh(x0);
    }

    public Bucket zzbL(Parcel parcel) {
        long j = 0;
        List list = null;
        boolean z = false;
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        int i2 = 0;
        Session session = null;
        long j2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j = zza.zzi(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    session = (Session) zza.zza(parcel, zzI, Session.CREATOR);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    list = zza.zzc(parcel, zzI, DataSet.CREATOR);
                    break;
                case Place.TYPE_ATM /*6*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    z = zza.zzc(parcel, zzI);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new Bucket(i3, j2, j, session, i2, list, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public Bucket[] zzdh(int i) {
        return new Bucket[i];
    }
}
