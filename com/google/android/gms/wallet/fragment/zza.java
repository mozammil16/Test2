package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public class zza implements Creator<WalletFragmentInitParams> {
    static void zza(WalletFragmentInitParams walletFragmentInitParams, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, walletFragmentInitParams.zzFG);
        zzb.zza(parcel, 2, walletFragmentInitParams.getAccountName(), false);
        zzb.zza(parcel, 3, walletFragmentInitParams.getMaskedWalletRequest(), i, false);
        zzb.zzc(parcel, 4, walletFragmentInitParams.getMaskedWalletRequestCode());
        zzb.zza(parcel, 5, walletFragmentInitParams.getMaskedWallet(), i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzff(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhD(x0);
    }

    public WalletFragmentInitParams zzff(Parcel parcel) {
        MaskedWallet maskedWallet = null;
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        int i = 0;
        int i2 = -1;
        MaskedWalletRequest maskedWalletRequest = null;
        String str = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    maskedWalletRequest = (MaskedWalletRequest) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzI, MaskedWalletRequest.CREATOR);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    maskedWallet = (MaskedWallet) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzI, MaskedWallet.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new WalletFragmentInitParams(i, str, maskedWalletRequest, i2, maskedWallet);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public WalletFragmentInitParams[] zzhD(int i) {
        return new WalletFragmentInitParams[i];
    }
}
