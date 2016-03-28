package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;

public class ParticipantEntityCreator implements Creator<ParticipantEntity> {
    static void zza(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, participantEntity.getParticipantId(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, participantEntity.getVersionCode());
        zzb.zza(parcel, 2, participantEntity.getDisplayName(), false);
        zzb.zza(parcel, 3, participantEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 4, participantEntity.getHiResImageUri(), i, false);
        zzb.zzc(parcel, 5, participantEntity.getStatus());
        zzb.zza(parcel, 6, participantEntity.zznl(), false);
        zzb.zza(parcel, 7, participantEntity.isConnectedToRoom());
        zzb.zza(parcel, 8, participantEntity.getPlayer(), i, false);
        zzb.zzc(parcel, 9, participantEntity.getCapabilities());
        zzb.zza(parcel, 10, participantEntity.getResult(), i, false);
        zzb.zza(parcel, 11, participantEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 12, participantEntity.getHiResImageUrl(), false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeW(x0);
    }

    public ParticipantEntity zzdf(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
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
                    uri = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    uri2 = (Uri) zza.zza(parcel, zzI, Uri.CREATOR);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    z = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_BANK /*8*/:
                    playerEntity = (PlayerEntity) zza.zza(parcel, zzI, PlayerEntity.CREATOR);
                    break;
                case Place.TYPE_BAR /*9*/:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    participantResult = (ParticipantResult) zza.zza(parcel, zzI, ParticipantResult.CREATOR);
                    break;
                case Place.TYPE_BICYCLE_STORE /*11*/:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BOOK_STORE /*12*/:
                    str5 = zza.zzo(parcel, zzI);
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
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public ParticipantEntity[] zzeW(int i) {
        return new ParticipantEntity[i];
    }
}
