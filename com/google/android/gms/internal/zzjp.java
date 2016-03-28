package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class zzjp implements SafeParcelable {
    public static final Creator<zzjp> CREATOR;
    private final int zzFG;
    private String zzJZ;

    static {
        CREATOR = new zzjq();
    }

    public zzjp() {
        this(1, null);
    }

    zzjp(int i, String str) {
        this.zzFG = i;
        this.zzJZ = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjp)) {
            return false;
        }
        return zzjv.zza(this.zzJZ, ((zzjp) obj).zzJZ);
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzJZ);
    }

    public void writeToParcel(Parcel out, int flags) {
        zzjq.zza(this, out, flags);
    }

    public String zzhl() {
        return this.zzJZ;
    }
}
