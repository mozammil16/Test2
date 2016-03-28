package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LocationSettingsResult implements Result, SafeParcelable {
    public static final LocationSettingsResultCreator CREATOR;
    private final int zzFG;
    private final Status zzHb;
    private final LocationSettingsStates zzamp;

    static {
        CREATOR = new LocationSettingsResultCreator();
    }

    LocationSettingsResult(int version, Status status, LocationSettingsStates states) {
        this.zzFG = version;
        this.zzHb = status;
        this.zzamp = states;
    }

    public LocationSettingsResult(Status status) {
        this(1, status, null);
    }

    public int describeContents() {
        return 0;
    }

    public LocationSettingsStates getLocationSettingsStates() {
        return this.zzamp;
    }

    public Status getStatus() {
        return this.zzHb;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel dest, int flags) {
        LocationSettingsResultCreator.zza(this, dest, flags);
    }
}
