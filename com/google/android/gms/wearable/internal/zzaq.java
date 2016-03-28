package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzaq implements SafeParcelable {
    public static final Creator<zzaq> CREATOR;
    public final String label;
    public final String packageName;
    public final int versionCode;
    public final long zzaGC;

    static {
        CREATOR = new zzar();
    }

    zzaq(int i, String str, String str2, long j) {
        this.versionCode = i;
        this.packageName = str;
        this.label = str2;
        this.zzaGC = j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzar.zza(this, out, flags);
    }
}
