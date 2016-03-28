package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class zzd implements SafeParcelable {
    public static final Creator<zzd> CREATOR;
    private final int zzFG;
    LoyaltyWalletObject zzaCV;
    OfferWalletObject zzaCW;
    GiftCardWalletObject zzaCX;

    static {
        CREATOR = new zze();
    }

    zzd() {
        this.zzFG = 3;
    }

    zzd(int i, LoyaltyWalletObject loyaltyWalletObject, OfferWalletObject offerWalletObject, GiftCardWalletObject giftCardWalletObject) {
        this.zzFG = i;
        this.zzaCV = loyaltyWalletObject;
        this.zzaCW = offerWalletObject;
        this.zzaCX = giftCardWalletObject;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
