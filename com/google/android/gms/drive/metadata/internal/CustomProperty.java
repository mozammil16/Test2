package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class CustomProperty implements SafeParcelable {
    public static final Creator<CustomProperty> CREATOR;
    final String mValue;
    final int zzFG;
    final CustomPropertyKey zzVo;

    static {
        CREATOR = new zzc();
    }

    CustomProperty(int versionCode, CustomPropertyKey key, String value) {
        this.zzFG = versionCode;
        zzx.zzb((Object) key, (Object) "key");
        this.zzVo = key;
        this.mValue = value;
    }

    public CustomProperty(CustomPropertyKey key, String value) {
        this(1, key, value);
    }

    public int describeContents() {
        return 0;
    }

    public String getValue() {
        return this.mValue;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public CustomPropertyKey zzkX() {
        return this.zzVo;
    }
}
