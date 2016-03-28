package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zzu implements Creator<Tile> {
    static void zza(Tile tile, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, tile.getVersionCode());
        zzb.zzc(parcel, 2, tile.width);
        zzb.zzc(parcel, 3, tile.height);
        zzb.zza(parcel, 4, tile.data, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzee(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgh(x0);
    }

    public Tile zzee(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    bArr = zza.zzr(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public Tile[] zzgh(int i) {
        return new Tile[i];
    }
}
