package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesSetDetails implements SafeParcelable {
    public static final Creator<ValuesSetDetails> CREATOR;
    final int mIndex;
    final int zzFG;
    final int zzXf;
    final int zzXg;

    static {
        CREATOR = new zzk();
    }

    ValuesSetDetails(int versionCode, int index, int valueIndex, int valueCount) {
        this.zzFG = versionCode;
        this.mIndex = index;
        this.zzXf = valueIndex;
        this.zzXg = valueCount;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }
}
