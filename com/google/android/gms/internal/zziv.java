package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class zziv {

    public static class zza implements SafeParcelable {
        public static final zziw CREATOR;
        final int zzFG;
        public final Account zzFY;
        public final boolean zzFZ;
        public final boolean zzGa;
        public final boolean zzGb;

        static {
            CREATOR = new zziw();
        }

        public zza() {
            this(null, false, false, false);
        }

        zza(int i, Account account, boolean z, boolean z2, boolean z3) {
            this.zzFG = i;
            this.zzFY = account;
            this.zzFZ = z;
            this.zzGa = z2;
            this.zzGb = z3;
        }

        public zza(Account account, boolean z, boolean z2, boolean z3) {
            this(1, account, z, z2, z3);
        }

        public int describeContents() {
            zziw com_google_android_gms_internal_zziw = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zziw com_google_android_gms_internal_zziw = CREATOR;
            zziw.zza(this, out, flags);
        }
    }

    public static class zzb implements Result, SafeParcelable {
        public static final zzix CREATOR;
        final int zzFG;
        public Status zzGc;
        public List<zzjb> zzGd;
        public String[] zzGe;

        static {
            CREATOR = new zzix();
        }

        public zzb() {
            this.zzFG = 1;
        }

        zzb(int i, Status status, List<zzjb> list, String[] strArr) {
            this.zzFG = i;
            this.zzGc = status;
            this.zzGd = list;
            this.zzGe = strArr;
        }

        public int describeContents() {
            zzix com_google_android_gms_internal_zzix = CREATOR;
            return 0;
        }

        public Status getStatus() {
            return this.zzGc;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzix com_google_android_gms_internal_zzix = CREATOR;
            zzix.zza(this, out, flags);
        }
    }
}
