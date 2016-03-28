package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import java.util.ArrayList;

public class QuestEntityCreator implements Creator<QuestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(QuestEntity questEntity, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, questEntity.getGame(), i, false);
        zzb.zza(parcel, 2, questEntity.getQuestId(), false);
        zzb.zza(parcel, 3, questEntity.getAcceptedTimestamp());
        zzb.zza(parcel, 4, questEntity.getBannerImageUri(), i, false);
        zzb.zza(parcel, 5, questEntity.getBannerImageUrl(), false);
        zzb.zza(parcel, 6, questEntity.getDescription(), false);
        zzb.zza(parcel, 7, questEntity.getEndTimestamp());
        zzb.zza(parcel, 8, questEntity.getLastUpdatedTimestamp());
        zzb.zza(parcel, 9, questEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 10, questEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 12, questEntity.getName(), false);
        zzb.zza(parcel, 13, questEntity.zzpa());
        zzb.zza(parcel, 14, questEntity.getStartTimestamp());
        zzb.zzc(parcel, 15, questEntity.getState());
        zzb.zzc(parcel, 17, questEntity.zzoZ(), false);
        zzb.zzc(parcel, 16, questEntity.getType());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, questEntity.getVersionCode());
        zzb.zzH(parcel, zzK);
    }

    public QuestEntity createFromParcel(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        long j = 0;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        long j3 = 0;
        Uri uri2 = null;
        String str4 = null;
        String str5 = null;
        long j4 = 0;
        long j5 = 0;
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    gameEntity = (GameEntity) zza.zza(parcel, zzI, GameEntity.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = zza.zzi(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    uri = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    j2 = zza.zzi(parcel, zzI);
                    break;
                case Place.TYPE_BANK /*8*/:
                    j3 = zza.zzi(parcel, zzI);
                    break;
                case Place.TYPE_BAR /*9*/:
                    uri2 = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    break;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BOOK_STORE /*12*/:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    j4 = zza.zzi(parcel, zzI);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    j5 = zza.zzi(parcel, zzI);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_CAMPGROUND /*16*/:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_CAR_DEALER /*17*/:
                    arrayList = zza.zzc(parcel, zzI, MilestoneEntity.CREATOR);
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
            return new QuestEntity(i, gameEntity, str, j, uri, str2, str3, j2, j3, uri2, str4, str5, j4, j5, i2, i3, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public QuestEntity[] newArray(int size) {
        return new QuestEntity[size];
    }
}
