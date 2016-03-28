package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzj implements Result, SafeParcelable {
    public static final Creator<zzj> CREATOR;
    private final int zzFG;
    private final DataHolder zzMd;

    static {
        CREATOR = new zzk();
    }

    zzj(int i, DataHolder dataHolder) {
        this.zzFG = i;
        this.zzMd = dataHolder;
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return new Status(this.zzMd.getStatusCode());
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }

    DataHolder zzms() {
        return this.zzMd;
    }
}
