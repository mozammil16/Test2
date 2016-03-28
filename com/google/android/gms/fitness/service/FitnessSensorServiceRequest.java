package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.data.zzk.zza;
import java.util.concurrent.TimeUnit;

public class FitnessSensorServiceRequest implements SafeParcelable {
    public static final Creator<FitnessSensorServiceRequest> CREATOR;
    public static final int UNSPECIFIED = -1;
    private final int zzFG;
    private final DataSource zzYp;
    private final long zzabX;
    private final long zzabY;
    private final zzk zzabp;

    static {
        CREATOR = new zza();
    }

    FitnessSensorServiceRequest(int versionCode, DataSource dataSource, IBinder listenerBinder, long samplingRateMicros, long batchIntervalMicros) {
        this.zzFG = versionCode;
        this.zzYp = dataSource;
        this.zzabp = zza.zzav(listenerBinder);
        this.zzabX = samplingRateMicros;
        this.zzabY = batchIntervalMicros;
    }

    private boolean zza(FitnessSensorServiceRequest fitnessSensorServiceRequest) {
        return zzw.equal(this.zzYp, fitnessSensorServiceRequest.zzYp) && this.zzabX == fitnessSensorServiceRequest.zzabX && this.zzabY == fitnessSensorServiceRequest.zzabY;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof FitnessSensorServiceRequest) && zza((FitnessSensorServiceRequest) that));
    }

    public long getBatchInterval(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzabY, TimeUnit.MICROSECONDS);
    }

    public DataSource getDataSource() {
        return this.zzYp;
    }

    public SensorEventDispatcher getDispatcher() {
        return new zzb(this.zzabp);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return this.zzabX == -1 ? -1 : timeUnit.convert(this.zzabX, TimeUnit.MICROSECONDS);
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzYp, Long.valueOf(this.zzabX), Long.valueOf(this.zzabY));
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", new Object[]{this.zzYp});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }

    public long zzlI() {
        return this.zzabX;
    }

    IBinder zzmg() {
        return this.zzabp.asBinder();
    }

    public long zzmw() {
        return this.zzabY;
    }
}
