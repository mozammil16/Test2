package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject implements SafeParcelable {
    public static final Creator<OfferWalletObject> CREATOR;
    private final int zzFG;
    CommonWalletObject zzaDk;
    String zzaEh;
    String zzfl;

    static {
        CREATOR = new zzo();
    }

    OfferWalletObject() {
        this.zzFG = 3;
    }

    OfferWalletObject(int versionCode, String id, String redemptionCode, CommonWalletObject commonWalletObject) {
        this.zzFG = versionCode;
        this.zzaEh = redemptionCode;
        if (versionCode < 3) {
            this.zzaDk = CommonWalletObject.zzuV().zzdJ(id).zzuW();
        } else {
            this.zzaDk = commonWalletObject;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzaDk.getId();
    }

    public String getRedemptionCode() {
        return this.zzaEh;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzo.zza(this, dest, flags);
    }
}
