package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzls;
import java.util.ArrayList;

public final class zzd implements SafeParcelable {
    public static final Creator<zzd> CREATOR;
    private final int zzFG;
    String zzaFc;
    String zzaFd;
    ArrayList<zzb> zzaFe;

    static {
        CREATOR = new zze();
    }

    zzd() {
        this.zzFG = 1;
        this.zzaFe = zzls.zzkb();
    }

    zzd(int i, String str, String str2, ArrayList<zzb> arrayList) {
        this.zzFG = i;
        this.zzaFc = str;
        this.zzaFd = str2;
        this.zzaFe = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
