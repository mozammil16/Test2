package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zza implements SafeParcelable {
    public static final Creator<zza> CREATOR;
    public final int zzFG;
    private String zzawF;

    static {
        CREATOR = new zzb();
    }

    zza(int i, String str) {
        this.zzFG = i;
        this.zzawF = str;
    }

    public int describeContents() {
        return 0;
    }

    public String getJwsResult() {
        return this.zzawF;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
