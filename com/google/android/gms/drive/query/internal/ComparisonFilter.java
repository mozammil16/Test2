package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T> extends AbstractFilter {
    public static final zza CREATOR;
    final int zzFG;
    final Operator zzWw;
    final MetadataBundle zzWx;
    final MetadataField<T> zzWy;

    static {
        CREATOR = new zza();
    }

    ComparisonFilter(int versionCode, Operator operator, MetadataBundle value) {
        this.zzFG = versionCode;
        this.zzWw = operator;
        this.zzWx = value;
        this.zzWy = zze.zzb(value);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> field, T value) {
        this(1, operator, MetadataBundle.zza(field, value));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.zzWx.zza(this.zzWy);
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public <F> F zza(zzf<F> com_google_android_gms_drive_query_internal_zzf_F) {
        return com_google_android_gms_drive_query_internal_zzf_F.zzb(this.zzWw, this.zzWy, getValue());
    }
}
