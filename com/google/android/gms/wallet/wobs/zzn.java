package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class zzn implements SafeParcelable {
    public static final Creator<zzn> CREATOR;
    String description;
    private final int zzFG;
    String zzatp;

    static {
        CREATOR = new zzo();
    }

    zzn() {
        this.zzFG = 1;
    }

    zzn(int i, String str, String str2) {
        this.zzFG = i;
        this.zzatp = str;
        this.description = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzo.zza(this, dest, flags);
    }
}
