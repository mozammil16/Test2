package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class zzl implements SafeParcelable {
    public static final Creator<zzl> CREATOR;
    private final int zzFG;
    long zzaFm;
    long zzaFn;

    static {
        CREATOR = new zzm();
    }

    zzl() {
        this.zzFG = 1;
    }

    zzl(int i, long j, long j2) {
        this.zzFG = i;
        this.zzaFm = j;
        this.zzaFn = j2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }
}
