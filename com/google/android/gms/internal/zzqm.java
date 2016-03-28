package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.plus.PlusShare;
import java.util.List;

public class zzqm implements SafeParcelable {
    public static final zzqn CREATOR;
    final int zzFG;
    private final String zzapf;
    private final List<zza> zzapg;

    public static final class zza implements SafeParcelable {
        public static final zzql CREATOR;
        final int zzFG;
        private final String zzFQ;
        private final String zzSy;

        static {
            CREATOR = new zzql();
        }

        zza(int i, String str, String str2) {
            this.zzFG = i;
            this.zzSy = str;
            this.zzFQ = str2;
        }

        public int describeContents() {
            zzql com_google_android_gms_internal_zzql = CREATOR;
            return 0;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzqm_zza = (zza) object;
            return zzw.equal(this.zzSy, com_google_android_gms_internal_zzqm_zza.zzSy) && zzw.equal(this.zzFQ, com_google_android_gms_internal_zzqm_zza.zzFQ);
        }

        public String getTitle() {
            return this.zzSy;
        }

        public String getUri() {
            return this.zzFQ;
        }

        public int hashCode() {
            return zzw.hashCode(this.zzSy, this.zzFQ);
        }

        public String toString() {
            return zzw.zzk(this).zza(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.zzSy).zza("uri", this.zzFQ).toString();
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzql com_google_android_gms_internal_zzql = CREATOR;
            zzql.zza(this, parcel, flags);
        }
    }

    static {
        CREATOR = new zzqn();
    }

    zzqm(int i, String str, List<zza> list) {
        this.zzFG = i;
        this.zzapf = str;
        this.zzapg = list;
    }

    public int describeContents() {
        zzqn com_google_android_gms_internal_zzqn = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzqm)) {
            return false;
        }
        zzqm com_google_android_gms_internal_zzqm = (zzqm) object;
        return zzw.equal(this.zzapf, com_google_android_gms_internal_zzqm.zzapf) && zzw.equal(this.zzapg, com_google_android_gms_internal_zzqm.zzapg);
    }

    public List<zza> getActions() {
        return this.zzapg;
    }

    public String getData() {
        return this.zzapf;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzapf, this.zzapg);
    }

    public String toString() {
        return zzw.zzk(this).zza("data", this.zzapf).zza("actions", this.zzapg).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzqn com_google_android_gms_internal_zzqn = CREATOR;
        zzqn.zza(this, parcel, flags);
    }
}
