package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import java.util.ArrayList;

public class RoomEntityCreator implements Creator<RoomEntity> {
    static void zza(RoomEntity roomEntity, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, roomEntity.getRoomId(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, roomEntity.getVersionCode());
        zzb.zza(parcel, 2, roomEntity.getCreatorId(), false);
        zzb.zza(parcel, 3, roomEntity.getCreationTimestamp());
        zzb.zzc(parcel, 4, roomEntity.getStatus());
        zzb.zza(parcel, 5, roomEntity.getDescription(), false);
        zzb.zzc(parcel, 6, roomEntity.getVariant());
        zzb.zza(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        zzb.zzc(parcel, 8, roomEntity.getParticipants(), false);
        zzb.zzc(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeY(x0);
    }

    public RoomEntity zzdh(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int zzJ = zza.zzJ(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = zza.zzi(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    bundle = zza.zzq(parcel, zzI);
                    break;
                case Place.TYPE_BANK /*8*/:
                    arrayList = zza.zzc(parcel, zzI, ParticipantEntity.CREATOR);
                    break;
                case Place.TYPE_BAR /*9*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i4 = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public RoomEntity[] zzeY(int i) {
        return new RoomEntity[i];
    }
}
