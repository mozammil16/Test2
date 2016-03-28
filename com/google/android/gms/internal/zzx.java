package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzgi
public final class zzx implements SafeParcelable {
    public static final zzy CREATOR;
    public final int versionCode;
    public final boolean zzml;
    public final boolean zzmy;

    static {
        CREATOR = new zzy();
    }

    zzx(int i, boolean z, boolean z2) {
        this.versionCode = i;
        this.zzml = z;
        this.zzmy = z2;
    }

    public zzx(boolean z, boolean z2) {
        this.versionCode = 1;
        this.zzml = z;
        this.zzmy = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzy.zza(this, out, flags);
    }
}
