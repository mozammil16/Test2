package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class zzao implements SafeParcelable, Node {
    public static final Creator<zzao> CREATOR;
    private final String zzFA;
    final int zzFG;
    private final String zzSJ;

    static {
        CREATOR = new zzap();
    }

    zzao(int i, String str, String str2) {
        this.zzFG = i;
        this.zzFA = str;
        this.zzSJ = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof zzao)) {
            return false;
        }
        zzao com_google_android_gms_wearable_internal_zzao = (zzao) o;
        return com_google_android_gms_wearable_internal_zzao.zzFA.equals(this.zzFA) && com_google_android_gms_wearable_internal_zzao.zzSJ.equals(this.zzSJ);
    }

    public String getDisplayName() {
        return this.zzSJ;
    }

    public String getId() {
        return this.zzFA;
    }

    public int hashCode() {
        return ((this.zzFA.hashCode() + 629) * 37) + this.zzSJ.hashCode();
    }

    public String toString() {
        return "NodeParcelable{" + this.zzFA + "," + this.zzSJ + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzap.zza(this, dest, flags);
    }
}
