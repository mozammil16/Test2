package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;

public class PlusCommonExtras implements SafeParcelable {
    public static final zzf CREATOR;
    public static String TAG;
    private final int zzFG;
    private String zzaux;
    private String zzauy;

    static {
        TAG = "PlusCommonExtras";
        CREATOR = new zzf();
    }

    public PlusCommonExtras() {
        this.zzFG = 1;
        this.zzaux = "";
        this.zzauy = "";
    }

    PlusCommonExtras(int versionCode, String gpsrc, String clientCallingPackage) {
        this.zzFG = versionCode;
        this.zzaux = gpsrc;
        this.zzauy = clientCallingPackage;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.zzFG == plusCommonExtras.zzFG && zzw.equal(this.zzaux, plusCommonExtras.zzaux) && zzw.equal(this.zzauy, plusCommonExtras.zzauy);
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzFG), this.zzaux, this.zzauy);
    }

    public String toString() {
        return zzw.zzk(this).zza("versionCode", Integer.valueOf(this.zzFG)).zza("Gpsrc", this.zzaux).zza("ClientCallingPackage", this.zzauy).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }

    public String zzrQ() {
        return this.zzaux;
    }

    public String zzrR() {
        return this.zzauy;
    }

    public void zzu(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", zzc.zza(this));
    }
}
