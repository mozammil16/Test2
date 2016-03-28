package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzrt.zza;

public final class zzsc implements SafeParcelable {
    public static final Creator<zzsc> CREATOR;
    final int versionCode;
    public zzrr zzatl;
    public zzru zzatm;
    public zzrt zzatn;

    static {
        CREATOR = new zzsd();
    }

    zzsc() {
        this.versionCode = 1;
    }

    zzsc(int i, IBinder iBinder, zzrr com_google_android_gms_internal_zzrr, IBinder iBinder2) {
        this.versionCode = i;
        this.zzatn = zza.zzcj(iBinder);
        this.zzatl = com_google_android_gms_internal_zzrr;
        this.zzatm = zzru.zza.zzck(iBinder2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzsd.zza(this, dest, flags);
    }

    IBinder zzrq() {
        return this.zzatm.asBinder();
    }

    IBinder zzrr() {
        return this.zzatn.asBinder();
    }
}
