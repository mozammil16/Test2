package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import java.util.ArrayList;

public class zzm implements Creator<MaskedWalletRequest> {
    static void zza(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, maskedWalletRequest.getVersionCode());
        zzb.zza(parcel, 2, maskedWalletRequest.zzaCZ, false);
        zzb.zza(parcel, 3, maskedWalletRequest.zzaDT);
        zzb.zza(parcel, 4, maskedWalletRequest.zzaDU);
        zzb.zza(parcel, 5, maskedWalletRequest.zzaDV);
        zzb.zza(parcel, 6, maskedWalletRequest.zzaDW, false);
        zzb.zza(parcel, 7, maskedWalletRequest.zzaCS, false);
        zzb.zza(parcel, 8, maskedWalletRequest.zzaDX, false);
        zzb.zza(parcel, 9, maskedWalletRequest.zzaDi, i, false);
        zzb.zza(parcel, 10, maskedWalletRequest.zzaDY);
        zzb.zza(parcel, 11, maskedWalletRequest.zzaDZ);
        zzb.zza(parcel, 12, maskedWalletRequest.zzaEa, i, false);
        zzb.zza(parcel, 13, maskedWalletRequest.zzaEb);
        zzb.zza(parcel, 14, maskedWalletRequest.zzaEc);
        zzb.zzc(parcel, 15, maskedWalletRequest.zzaEd, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhw(x0);
    }

    public MaskedWalletRequest zzeZ(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
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
                    z = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    z3 = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BANK /*8*/:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BAR /*9*/:
                    cart = (Cart) zza.zza(parcel, zzI, Cart.CREATOR);
                    break;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    z4 = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_BICYCLE_STORE /*11*/:
                    z5 = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_BOOK_STORE /*12*/:
                    countrySpecificationArr = (CountrySpecification[]) zza.zzb(parcel, zzI, CountrySpecification.CREATOR);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    z6 = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    z7 = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    arrayList = zza.zzc(parcel, zzI, CountrySpecification.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public MaskedWalletRequest[] zzhw(int i) {
        return new MaskedWalletRequest[i];
    }
}
