package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class OnResourceIdSetResponse implements SafeParcelable {
    public static final Creator<OnResourceIdSetResponse> CREATOR;
    private final int zzFG;
    private final List<String> zzTg;

    static {
        CREATOR = new zzba();
    }

    OnResourceIdSetResponse(int versionCode, List<String> resourceIds) {
        this.zzFG = versionCode;
        this.zzTg = resourceIds;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzba.zza(this, dest, flags);
    }

    public List<String> zzkE() {
        return this.zzTg;
    }
}
