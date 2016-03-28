package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

public abstract class zzk implements Parcelable {
    private volatile transient boolean zzSN;

    public zzk() {
        this.zzSN = false;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzx.zzN(!zzkz());
        this.zzSN = true;
        zzI(dest, flags);
    }

    protected abstract void zzI(Parcel parcel, int i);

    public final boolean zzkz() {
        return this.zzSN;
    }
}
