package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzac implements SafeParcelable {
    public static final Creator<zzac> CREATOR;
    public final int statusCode;
    public final int versionCode;
    public final ParcelFileDescriptor zzaGm;

    static {
        CREATOR = new zzad();
    }

    zzac(int i, int i2, ParcelFileDescriptor parcelFileDescriptor) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaGm = parcelFileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzad.zza(this, dest, flags | 1);
    }
}
