package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzgi
public final class zzhy implements SafeParcelable {
    public static final zzhz CREATOR;
    public final int versionCode;
    public String zzzH;
    public int zzzI;
    public int zzzJ;
    public boolean zzzK;

    static {
        CREATOR = new zzhz();
    }

    public zzhy(int i, int i2, boolean z) {
        this(1, "afma-sdk-a-v" + i + "." + i2 + "." + (z ? "0" : "1"), i, i2, z);
    }

    zzhy(int i, String str, int i2, int i3, boolean z) {
        this.versionCode = i;
        this.zzzH = str;
        this.zzzI = i2;
        this.zzzJ = i3;
        this.zzzK = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzhz.zza(this, out, flags);
    }
}
