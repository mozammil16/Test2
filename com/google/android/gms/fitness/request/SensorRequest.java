package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest {
    public static final int ACCURACY_MODE_DEFAULT = 2;
    public static final int ACCURACY_MODE_HIGH = 3;
    public static final int ACCURACY_MODE_LOW = 1;
    private final DataType zzYo;
    private final DataSource zzYp;
    private final long zzZQ;
    private final int zzZR;
    private final long zzabs;
    private final long zzabt;
    private final LocationRequest zzabx;
    private final long zzaby;

    public static class Builder {
        private DataType zzYo;
        private DataSource zzYp;
        private long zzZQ;
        private int zzZR;
        private long zzabs;
        private long zzabt;
        private long zzaby;
        private boolean zzabz;

        public Builder() {
            this.zzZQ = -1;
            this.zzabt = 0;
            this.zzabs = 0;
            this.zzabz = false;
            this.zzZR = SensorRequest.ACCURACY_MODE_DEFAULT;
            this.zzaby = Long.MAX_VALUE;
        }

        public SensorRequest build() {
            boolean z = false;
            boolean z2 = (this.zzYp == null && this.zzYo == null) ? false : true;
            zzx.zza(z2, (Object) "Must call setDataSource() or setDataType()");
            if (this.zzYo == null || this.zzYp == null || this.zzYo.equals(this.zzYp.getDataType())) {
                z = true;
            }
            zzx.zza(z, (Object) "Specified data type is incompatible with specified data source");
            return new SensorRequest();
        }

        public Builder setAccuracyMode(int accuracyMode) {
            this.zzZR = SensorRequest.zzdP(accuracyMode);
            return this;
        }

        public Builder setDataSource(DataSource dataSource) {
            this.zzYp = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.zzYo = dataType;
            return this;
        }

        public Builder setFastestRate(int fastestInterval, TimeUnit unit) {
            zzx.zzb(fastestInterval >= 0, (Object) "Cannot use a negative interval");
            this.zzabz = true;
            this.zzabt = unit.toMicros((long) fastestInterval);
            return this;
        }

        public Builder setMaxDeliveryLatency(int interval, TimeUnit unit) {
            zzx.zzb(interval >= 0, (Object) "Cannot use a negative delivery interval");
            this.zzabs = unit.toMicros((long) interval);
            return this;
        }

        public Builder setSamplingRate(long interval, TimeUnit unit) {
            zzx.zzb(interval >= 0, (Object) "Cannot use a negative sampling interval");
            this.zzZQ = unit.toMicros(interval);
            if (!this.zzabz) {
                this.zzabt = this.zzZQ / 2;
            }
            return this;
        }

        public Builder setTimeout(long timeout, TimeUnit timeUnit) {
            boolean z = true;
            boolean z2 = timeout > 0;
            Object[] objArr = new Object[SensorRequest.ACCURACY_MODE_LOW];
            objArr[0] = Long.valueOf(timeout);
            zzx.zzb(z2, "Invalid time out value specified: %d", objArr);
            if (timeUnit == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Invalid time unit specified");
            this.zzaby = timeUnit.toMicros(timeout);
            return this;
        }
    }

    private SensorRequest(DataSource dataSource, LocationRequest locationRequest) {
        this.zzabx = locationRequest;
        this.zzZQ = TimeUnit.MILLISECONDS.toMicros(locationRequest.getInterval());
        this.zzabt = TimeUnit.MILLISECONDS.toMicros(locationRequest.getFastestInterval());
        this.zzabs = this.zzZQ;
        this.zzYo = dataSource.getDataType();
        this.zzZR = zza(locationRequest);
        this.zzYp = dataSource;
        long expirationTime = locationRequest.getExpirationTime();
        if (expirationTime == Long.MAX_VALUE) {
            this.zzaby = Long.MAX_VALUE;
        } else {
            this.zzaby = TimeUnit.MILLISECONDS.toMicros(expirationTime - SystemClock.elapsedRealtime());
        }
    }

    private SensorRequest(Builder builder) {
        this.zzYp = builder.zzYp;
        this.zzYo = builder.zzYo;
        this.zzZQ = builder.zzZQ;
        this.zzabt = builder.zzabt;
        this.zzabs = builder.zzabs;
        this.zzZR = builder.zzZR;
        this.zzabx = null;
        this.zzaby = builder.zzaby;
    }

    public static SensorRequest fromLocationRequest(DataSource dataSource, LocationRequest locationRequest) {
        return new SensorRequest(dataSource, locationRequest);
    }

    private static int zza(LocationRequest locationRequest) {
        switch (locationRequest.getPriority()) {
            case LocationRequest.PRIORITY_HIGH_ACCURACY /*100*/:
                return ACCURACY_MODE_HIGH;
            case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                return ACCURACY_MODE_LOW;
            default:
                return ACCURACY_MODE_DEFAULT;
        }
    }

    private boolean zza(SensorRequest sensorRequest) {
        return zzw.equal(this.zzYp, sensorRequest.zzYp) && zzw.equal(this.zzYo, sensorRequest.zzYo) && this.zzZQ == sensorRequest.zzZQ && this.zzabt == sensorRequest.zzabt && this.zzabs == sensorRequest.zzabs && this.zzZR == sensorRequest.zzZR && zzw.equal(this.zzabx, sensorRequest.zzabx) && this.zzaby == sensorRequest.zzaby;
    }

    public static int zzdP(int i) {
        switch (i) {
            case ACCURACY_MODE_LOW /*1*/:
            case ACCURACY_MODE_HIGH /*3*/:
                return i;
            default:
                return ACCURACY_MODE_DEFAULT;
        }
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SensorRequest) && zza((SensorRequest) that));
    }

    public int getAccuracyMode() {
        return this.zzZR;
    }

    public DataSource getDataSource() {
        return this.zzYp;
    }

    public DataType getDataType() {
        return this.zzYo;
    }

    public long getFastestRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzabt, TimeUnit.MICROSECONDS);
    }

    public long getMaxDeliveryLatency(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzabs, TimeUnit.MICROSECONDS);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzZQ, TimeUnit.MICROSECONDS);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzYp, this.zzYo, Long.valueOf(this.zzZQ), Long.valueOf(this.zzabt), Long.valueOf(this.zzabs), Integer.valueOf(this.zzZR), this.zzabx, Long.valueOf(this.zzaby));
    }

    public String toString() {
        return zzw.zzk(this).zza("dataSource", this.zzYp).zza("dataType", this.zzYo).zza("samplingRateMicros", Long.valueOf(this.zzZQ)).zza("deliveryLatencyMicros", Long.valueOf(this.zzabs)).zza("timeOutMicros", Long.valueOf(this.zzaby)).toString();
    }

    public long zzmh() {
        return this.zzaby;
    }
}
