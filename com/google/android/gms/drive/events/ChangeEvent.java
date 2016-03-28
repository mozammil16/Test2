package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

public final class ChangeEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<ChangeEvent> CREATOR;
    final int zzFG;
    final DriveId zzRX;
    final int zzSO;

    static {
        CREATOR = new zza();
    }

    ChangeEvent(int versionCode, DriveId driveId, int changeFlags) {
        this.zzFG = versionCode;
        this.zzRX = driveId;
        this.zzSO = changeFlags;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzRX;
    }

    public int getType() {
        return 1;
    }

    public boolean hasBeenDeleted() {
        return (this.zzSO & 4) != 0;
    }

    public boolean hasContentChanged() {
        return (this.zzSO & 2) != 0;
    }

    public boolean hasMetadataChanged() {
        return (this.zzSO & 1) != 0;
    }

    public String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", new Object[]{this.zzRX, Integer.valueOf(this.zzSO)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
