package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.location.places.Place;

public class zzl implements Creator<MaskedWallet> {
    static void zza(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, maskedWallet.getVersionCode());
        zzb.zza(parcel, 2, maskedWallet.zzaCY, false);
        zzb.zza(parcel, 3, maskedWallet.zzaCZ, false);
        zzb.zza(parcel, 4, maskedWallet.zzaDe, false);
        zzb.zza(parcel, 5, maskedWallet.zzaDb, false);
        zzb.zza(parcel, 6, maskedWallet.zzaDc, i, false);
        zzb.zza(parcel, 7, maskedWallet.zzaDd, i, false);
        zzb.zza(parcel, 8, maskedWallet.zzaDQ, i, false);
        zzb.zza(parcel, 9, maskedWallet.zzaDR, i, false);
        zzb.zza(parcel, 10, maskedWallet.zzaDf, i, false);
        zzb.zza(parcel, 11, maskedWallet.zzaDg, i, false);
        zzb.zza(parcel, 12, maskedWallet.zzaDh, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhv(x0);
    }

    public MaskedWallet zzeY(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
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
                    strArr = zza.zzA(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    address = (Address) zza.zza(parcel, zzI, Address.CREATOR);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    address2 = (Address) zza.zza(parcel, zzI, Address.CREATOR);
                    break;
                case Place.TYPE_BANK /*8*/:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) zza.zzb(parcel, zzI, LoyaltyWalletObject.CREATOR);
                    break;
                case Place.TYPE_BAR /*9*/:
                    offerWalletObjectArr = (OfferWalletObject[]) zza.zzb(parcel, zzI, OfferWalletObject.CREATOR);
                    break;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    userAddress = (UserAddress) zza.zza(parcel, zzI, UserAddress.CREATOR);
                    break;
                case Place.TYPE_BICYCLE_STORE /*11*/:
                    userAddress2 = (UserAddress) zza.zza(parcel, zzI, UserAddress.CREATOR);
                    break;
                case Place.TYPE_BOOK_STORE /*12*/:
                    instrumentInfoArr = (InstrumentInfo[]) zza.zzb(parcel, zzI, InstrumentInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public MaskedWallet[] zzhv(int i) {
        return new MaskedWallet[i];
    }
}
