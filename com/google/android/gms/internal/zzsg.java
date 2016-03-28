package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzrt.zza;

public final class zzsg implements SafeParcelable {
    public static final Creator<zzsg> CREATOR;
    final int versionCode;
    public zzru zzatm;
    public zzrt zzatn;

    static {
        CREATOR = new zzsh();
    }

    zzsg() {
        this.versionCode = 1;
    }

    zzsg(int i, IBinder iBinder, IBinder iBinder2) {
        this.versionCode = i;
        this.zzatn = zza.zzcj(iBinder);
        this.zzatm = zzru.zza.zzck(iBinder2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzsh.zza(this, dest, flags);
    }

    IBinder zzrq() {
        return this.zzatm.asBinder();
    }

    IBinder zzrr() {
        return this.zzatn.asBinder();
    }
}
