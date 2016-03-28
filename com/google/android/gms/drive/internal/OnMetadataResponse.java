package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
    public static final Creator<OnMetadataResponse> CREATOR;
    final int zzFG;
    final MetadataBundle zzTp;

    static {
        CREATOR = new zzay();
    }

    OnMetadataResponse(int versionCode, MetadataBundle metadata) {
        this.zzFG = versionCode;
        this.zzTp = metadata;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzay.zza(this, dest, flags);
    }

    public MetadataBundle zzkU() {
        return this.zzTp;
    }
}
