package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzah.zza;

public class zzau implements SafeParcelable {
    public static final Creator<zzau> CREATOR;
    final int zzFG;
    public final zzah zzaFN;

    static {
        CREATOR = new zzav();
    }

    zzau(int i, IBinder iBinder) {
        this.zzFG = i;
        if (iBinder != null) {
            this.zzaFN = zza.zzcQ(iBinder);
        } else {
            this.zzaFN = null;
        }
    }

    public zzau(zzah com_google_android_gms_wearable_internal_zzah) {
        this.zzFG = 1;
        this.zzaFN = com_google_android_gms_wearable_internal_zzah;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzav.zza(this, dest, flags);
    }

    IBinder zzva() {
        return this.zzaFN == null ? null : this.zzaFN.asBinder();
    }
}
