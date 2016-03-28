package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzni;
import com.google.android.gms.internal.zzni.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest implements SafeParcelable {
    public static final Creator<DataTypeCreateRequest> CREATOR;
    private final String mName;
    private final int zzFG;
    private final String zzFO;
    private final List<Field> zzZd;
    private final zzni zzabi;

    public static class Builder {
        private String mName;
        private List<Field> zzZd;

        public Builder() {
            this.zzZd = new ArrayList();
        }

        public Builder addField(Field field) {
            if (!this.zzZd.contains(field)) {
                this.zzZd.add(field);
            }
            return this;
        }

        public Builder addField(String name, int format) {
            boolean z = (name == null || name.isEmpty()) ? false : true;
            zzx.zzb(z, (Object) "Invalid name specified");
            return addField(Field.zzn(name, format));
        }

        public DataTypeCreateRequest build() {
            boolean z = true;
            zzx.zza(this.mName != null, (Object) "Must set the name");
            if (this.zzZd.isEmpty()) {
                z = false;
            }
            zzx.zza(z, (Object) "Must specify the data fields");
            return new DataTypeCreateRequest();
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }
    }

    static {
        CREATOR = new zzk();
    }

    DataTypeCreateRequest(int versionCode, String name, List<Field> fields, IBinder callback, String packageName) {
        this.zzFG = versionCode;
        this.mName = name;
        this.zzZd = Collections.unmodifiableList(fields);
        this.zzabi = callback == null ? null : zza.zzaF(callback);
        this.zzFO = packageName;
    }

    private DataTypeCreateRequest(Builder builder) {
        this(builder.mName, builder.zzZd, null, null);
    }

    public DataTypeCreateRequest(DataTypeCreateRequest request, zzni callback, String packageName) {
        this(request.mName, request.zzZd, callback, packageName);
    }

    public DataTypeCreateRequest(String name, List<Field> fields, zzni callback, String packageName) {
        this.zzFG = 2;
        this.mName = name;
        this.zzZd = Collections.unmodifiableList(fields);
        this.zzabi = callback;
        this.zzFO = packageName;
    }

    private boolean zzb(DataTypeCreateRequest dataTypeCreateRequest) {
        return zzw.equal(this.mName, dataTypeCreateRequest.mName) && zzw.equal(this.zzZd, dataTypeCreateRequest.zzZd);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataTypeCreateRequest) && zzb((DataTypeCreateRequest) o));
    }

    public List<Field> getFields() {
        return this.zzZd;
    }

    public String getName() {
        return this.mName;
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName, this.zzZd);
    }

    public String toString() {
        return zzw.zzk(this).zza("name", this.mName).zza("fields", this.zzZd).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }

    public IBinder zzlQ() {
        return this.zzabi == null ? null : this.zzabi.asBinder();
    }
}
