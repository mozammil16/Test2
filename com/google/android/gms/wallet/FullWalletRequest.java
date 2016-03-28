package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest implements SafeParcelable {
    public static final Creator<FullWalletRequest> CREATOR;
    private final int zzFG;
    String zzaCY;
    String zzaCZ;
    Cart zzaDi;

    public final class Builder {
        final /* synthetic */ FullWalletRequest zzaDj;

        private Builder(FullWalletRequest fullWalletRequest) {
            this.zzaDj = fullWalletRequest;
        }

        public FullWalletRequest build() {
            return this.zzaDj;
        }

        public Builder setCart(Cart cart) {
            this.zzaDj.zzaDi = cart;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.zzaDj.zzaCY = googleTransactionId;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.zzaDj.zzaCZ = merchantTransactionId;
            return this;
        }
    }

    static {
        CREATOR = new zzg();
    }

    FullWalletRequest() {
        this.zzFG = 1;
    }

    FullWalletRequest(int versionCode, String googleTransactionId, String merchantTransactionId, Cart cart) {
        this.zzFG = versionCode;
        this.zzaCY = googleTransactionId;
        this.zzaCZ = merchantTransactionId;
        this.zzaDi = cart;
    }

    public static Builder newBuilder() {
        FullWalletRequest fullWalletRequest = new FullWalletRequest();
        fullWalletRequest.getClass();
        return new Builder(null);
    }

    public int describeContents() {
        return 0;
    }

    public Cart getCart() {
        return this.zzaDi;
    }

    public String getGoogleTransactionId() {
        return this.zzaCY;
    }

    public String getMerchantTransactionId() {
        return this.zzaCZ;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
