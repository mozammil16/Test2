package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzsm.zza;

public final class zzss implements SafeParcelable {
    public static final Creator<zzss> CREATOR;
    final int versionCode;
    public long zzatv;
    public zzsm zzatw;

    static {
        CREATOR = new zzst();
    }

    zzss() {
        this.versionCode = 1;
    }

    zzss(int i, long j, IBinder iBinder) {
        this.versionCode = i;
        this.zzatv = j;
        this.zzatw = zza.zzco(iBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzst.zza(this, dest, flags);
    }

    IBinder zzrq() {
        return this.zzatw.asBinder();
    }
}
