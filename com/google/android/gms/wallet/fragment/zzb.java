package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

public class zzb implements Creator<WalletFragmentOptions> {
    static void zza(WalletFragmentOptions walletFragmentOptions, Parcel parcel, int i) {
        int zzK = com.google.android.gms.common.internal.safeparcel.zzb.zzK(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, walletFragmentOptions.zzFG);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, walletFragmentOptions.getEnvironment());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, walletFragmentOptions.getTheme());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, walletFragmentOptions.getFragmentStyle(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, walletFragmentOptions.getMode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhE(x0);
    }

    public WalletFragmentOptions zzfg(Parcel parcel) {
        int i = 1;
        int i2 = 0;
        int zzJ = zza.zzJ(parcel);
        WalletFragmentStyle walletFragmentStyle = null;
        int i3 = 1;
        int i4 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i4 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i3 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    walletFragmentStyle = (WalletFragmentStyle) zza.zza(parcel, zzI, WalletFragmentStyle.CREATOR);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new WalletFragmentOptions(i4, i3, i2, walletFragmentStyle, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public WalletFragmentOptions[] zzhE(int i) {
        return new WalletFragmentOptions[i];
    }
}
