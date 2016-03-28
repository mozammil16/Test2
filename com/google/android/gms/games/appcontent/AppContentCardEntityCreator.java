package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import java.util.ArrayList;

public class AppContentCardEntityCreator implements Creator<AppContentCardEntity> {
    static void zza(AppContentCardEntity appContentCardEntity, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, appContentCardEntity.getActions(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, appContentCardEntity.getVersionCode());
        zzb.zzc(parcel, 2, appContentCardEntity.zzmT(), false);
        zzb.zzc(parcel, 3, appContentCardEntity.zzmI(), false);
        zzb.zza(parcel, 4, appContentCardEntity.zzmJ(), false);
        zzb.zzc(parcel, 5, appContentCardEntity.zzmU());
        zzb.zza(parcel, 6, appContentCardEntity.getDescription(), false);
        zzb.zza(parcel, 7, appContentCardEntity.getExtras(), false);
        zzb.zza(parcel, 10, appContentCardEntity.zzmV(), false);
        zzb.zza(parcel, 11, appContentCardEntity.getTitle(), false);
        zzb.zzc(parcel, 12, appContentCardEntity.zzmW());
        zzb.zza(parcel, 13, appContentCardEntity.getType(), false);
        zzb.zza(parcel, 14, appContentCardEntity.getId(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzet(x0);
    }

    public AppContentCardEntity zzcT(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        String str = null;
        int i2 = 0;
        String str2 = null;
        Bundle bundle = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    arrayList = zza.zzc(parcel, zzI, AppContentActionEntity.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    arrayList2 = zza.zzc(parcel, zzI, AppContentAnnotationEntity.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    arrayList3 = zza.zzc(parcel, zzI, AppContentConditionEntity.CREATOR);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    bundle = zza.zzq(parcel, zzI);
                    break;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BICYCLE_STORE /*11*/:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BOOK_STORE /*12*/:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    str6 = zza.zzo(parcel, zzI);
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
            return new AppContentCardEntity(i, arrayList, arrayList2, arrayList3, str, i2, str2, bundle, str3, str4, i3, str5, str6);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public AppContentCardEntity[] zzet(int i) {
        return new AppContentCardEntity[i];
    }
}
