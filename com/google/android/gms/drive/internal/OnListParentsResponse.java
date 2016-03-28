package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zzk;

public class OnListParentsResponse extends zzk implements SafeParcelable {
    public static final Creator<OnListParentsResponse> CREATOR;
    final int zzFG;
    final DataHolder zzUZ;

    static {
        CREATOR = new zzax();
    }

    OnListParentsResponse(int versionCode, DataHolder parents) {
        this.zzFG = versionCode;
        this.zzUZ = parents;
    }

    public int describeContents() {
        return 0;
    }

    protected void zzI(Parcel parcel, int i) {
        zzax.zza(this, parcel, i);
    }

    public DataHolder zzkT() {
        return this.zzUZ;
    }
}
