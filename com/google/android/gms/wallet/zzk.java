package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.wallet.wobs.zzd;
import com.google.android.gms.wallet.wobs.zzf;
import com.google.android.gms.wallet.wobs.zzj;
import com.google.android.gms.wallet.wobs.zzl;
import com.google.android.gms.wallet.wobs.zzn;
import com.google.android.gms.wallet.wobs.zzp;
import java.util.ArrayList;

public class zzk implements Creator<LoyaltyWalletObject> {
    static void zza(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, loyaltyWalletObject.getVersionCode());
        zzb.zza(parcel, 2, loyaltyWalletObject.zzfl, false);
        zzb.zza(parcel, 3, loyaltyWalletObject.zzaDx, false);
        zzb.zza(parcel, 4, loyaltyWalletObject.zzaDy, false);
        zzb.zza(parcel, 5, loyaltyWalletObject.zzaDz, false);
        zzb.zza(parcel, 6, loyaltyWalletObject.zzapd, false);
        zzb.zza(parcel, 7, loyaltyWalletObject.zzaDA, false);
        zzb.zza(parcel, 8, loyaltyWalletObject.zzaDB, false);
        zzb.zza(parcel, 9, loyaltyWalletObject.zzaDC, false);
        zzb.zza(parcel, 10, loyaltyWalletObject.zzaDD, false);
        zzb.zza(parcel, 11, loyaltyWalletObject.zzaDE, false);
        zzb.zzc(parcel, 12, loyaltyWalletObject.state);
        zzb.zzc(parcel, 13, loyaltyWalletObject.zzaDF, false);
        zzb.zza(parcel, 14, loyaltyWalletObject.zzaDG, i, false);
        zzb.zzc(parcel, 15, loyaltyWalletObject.zzaDH, false);
        zzb.zza(parcel, 17, loyaltyWalletObject.zzaDJ, false);
        zzb.zza(parcel, 16, loyaltyWalletObject.zzaDI, false);
        zzb.zza(parcel, 19, loyaltyWalletObject.zzaDL);
        zzb.zzc(parcel, 18, loyaltyWalletObject.zzaDK, false);
        zzb.zzc(parcel, 21, loyaltyWalletObject.zzaDN, false);
        zzb.zzc(parcel, 20, loyaltyWalletObject.zzaDM, false);
        zzb.zza(parcel, 23, loyaltyWalletObject.zzaDP, i, false);
        zzb.zzc(parcel, 22, loyaltyWalletObject.zzaDO, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhu(x0);
    }

    public LoyaltyWalletObject zzeX(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        int i2 = 0;
        ArrayList zzkb = zzls.zzkb();
        zzl com_google_android_gms_wallet_wobs_zzl = null;
        ArrayList zzkb2 = zzls.zzkb();
        String str11 = null;
        String str12 = null;
        ArrayList zzkb3 = zzls.zzkb();
        boolean z = false;
        ArrayList zzkb4 = zzls.zzkb();
        ArrayList zzkb5 = zzls.zzkb();
        ArrayList zzkb6 = zzls.zzkb();
        zzf com_google_android_gms_wallet_wobs_zzf = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    str5 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    str6 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BANK /*8*/:
                    str7 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BAR /*9*/:
                    str8 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    str9 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BICYCLE_STORE /*11*/:
                    str10 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BOOK_STORE /*12*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    zzkb = zza.zzc(parcel, zzI, zzp.CREATOR);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    com_google_android_gms_wallet_wobs_zzl = (zzl) zza.zza(parcel, zzI, zzl.CREATOR);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    zzkb2 = zza.zzc(parcel, zzI, LatLng.CREATOR);
                    break;
                case Place.TYPE_CAMPGROUND /*16*/:
                    str11 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_CAR_DEALER /*17*/:
                    str12 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_CAR_RENTAL /*18*/:
                    zzkb3 = zza.zzc(parcel, zzI, zzd.CREATOR);
                    break;
                case Place.TYPE_CAR_REPAIR /*19*/:
                    z = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_CAR_WASH /*20*/:
                    zzkb4 = zza.zzc(parcel, zzI, zzn.CREATOR);
                    break;
                case Place.TYPE_CASINO /*21*/:
                    zzkb5 = zza.zzc(parcel, zzI, zzj.CREATOR);
                    break;
                case Place.TYPE_CEMETERY /*22*/:
                    zzkb6 = zza.zzc(parcel, zzI, zzn.CREATOR);
                    break;
                case Place.TYPE_CHURCH /*23*/:
                    com_google_android_gms_wallet_wobs_zzf = (zzf) zza.zza(parcel, zzI, zzf.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, zzkb, com_google_android_gms_wallet_wobs_zzl, zzkb2, str11, str12, zzkb3, z, zzkb4, zzkb5, zzkb6, com_google_android_gms_wallet_wobs_zzf);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public LoyaltyWalletObject[] zzhu(int i) {
        return new LoyaltyWalletObject[i];
    }
}
