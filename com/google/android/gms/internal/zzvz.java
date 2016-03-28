package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class zzvz implements SafeParcelable {
    public static final Creator<zzvz> CREATOR;
    private final int zzFG;
    String[] zzaEr;
    byte[][] zzaEs;

    static {
        CREATOR = new zzwa();
    }

    zzvz() {
        this(1, new String[0], new byte[0][]);
    }

    zzvz(int i, String[] strArr, byte[][] bArr) {
        this.zzFG = i;
        this.zzaEr = strArr;
        this.zzaEs = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzwa.zza(this, out, flags);
    }
}
