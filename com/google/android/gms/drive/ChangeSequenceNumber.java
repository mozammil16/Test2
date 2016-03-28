package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzam;
import com.google.android.gms.internal.zzwy;

public class ChangeSequenceNumber implements SafeParcelable {
    public static final Creator<ChangeSequenceNumber> CREATOR;
    final int zzFG;
    final long zzRR;
    final long zzRS;
    final long zzRT;
    private volatile String zzRU;

    static {
        CREATOR = new zza();
    }

    ChangeSequenceNumber(int versionCode, long sequenceNumber, long databaseInstanceId, long accountId) {
        boolean z = true;
        this.zzRU = null;
        zzx.zzO(sequenceNumber != -1);
        zzx.zzO(databaseInstanceId != -1);
        if (accountId == -1) {
            z = false;
        }
        zzx.zzO(z);
        this.zzFG = versionCode;
        this.zzRR = sequenceNumber;
        this.zzRS = databaseInstanceId;
        this.zzRT = accountId;
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzRU == null) {
            this.zzRU = "ChangeSequenceNumber:" + Base64.encodeToString(zzkn(), 10);
        }
        return this.zzRU;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChangeSequenceNumber)) {
            return false;
        }
        ChangeSequenceNumber changeSequenceNumber = (ChangeSequenceNumber) obj;
        return changeSequenceNumber.zzRS == this.zzRS && changeSequenceNumber.zzRT == this.zzRT && changeSequenceNumber.zzRR == this.zzRR;
    }

    public int hashCode() {
        return (String.valueOf(this.zzRR) + String.valueOf(this.zzRS) + String.valueOf(this.zzRT)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    final byte[] zzkn() {
        zzwy com_google_android_gms_drive_internal_zzam = new zzam();
        com_google_android_gms_drive_internal_zzam.versionCode = this.zzFG;
        com_google_android_gms_drive_internal_zzam.zzUF = this.zzRR;
        com_google_android_gms_drive_internal_zzam.zzUG = this.zzRS;
        com_google_android_gms_drive_internal_zzam.zzUH = this.zzRT;
        return zzwy.zzf(com_google_android_gms_drive_internal_zzam);
    }
}
