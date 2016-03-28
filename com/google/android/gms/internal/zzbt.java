package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;

public class zzbt implements Creator<zzbs> {
    static void zza(zzbs com_google_android_gms_internal_zzbs, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_internal_zzbs.versionCode);
        zzb.zzc(parcel, 2, com_google_android_gms_internal_zzbs.zzpN);
        zzb.zzc(parcel, 3, com_google_android_gms_internal_zzbs.backgroundColor);
        zzb.zzc(parcel, 4, com_google_android_gms_internal_zzbs.zzpO);
        zzb.zzc(parcel, 5, com_google_android_gms_internal_zzbs.zzpP);
        zzb.zzc(parcel, 6, com_google_android_gms_internal_zzbs.zzpQ);
        zzb.zzc(parcel, 7, com_google_android_gms_internal_zzbs.zzpR);
        zzb.zzc(parcel, 8, com_google_android_gms_internal_zzbs.zzpS);
        zzb.zzc(parcel, 9, com_google_android_gms_internal_zzbs.zzpT);
        zzb.zza(parcel, 10, com_google_android_gms_internal_zzbs.zzpU, false);
        zzb.zzc(parcel, 11, com_google_android_gms_internal_zzbs.zzpV);
        zzb.zza(parcel, 12, com_google_android_gms_internal_zzbs.zzpW, false);
        zzb.zzc(parcel, 13, com_google_android_gms_internal_zzbs.zzpX);
        zzb.zzc(parcel, 14, com_google_android_gms_internal_zzbs.zzpY);
        zzb.zza(parcel, 15, com_google_android_gms_internal_zzbs.zzpZ, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzi(x0);
    }

    public zzbs zzd(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    i4 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    i5 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    i6 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    i7 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_BANK /*8*/:
                    i8 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_BAR /*9*/:
                    i9 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BICYCLE_STORE /*11*/:
                    i10 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_BOOK_STORE /*12*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    i11 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    i12 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzbs(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzbs[] zzi(int i) {
        return new zzbs[i];
    }
}
