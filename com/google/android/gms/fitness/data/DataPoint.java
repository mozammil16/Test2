package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmx;
import com.google.android.gms.internal.zzxd.zzb;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint implements SafeParcelable {
    public static final Creator<DataPoint> CREATOR;
    private final int zzFG;
    private long zzYG;
    private long zzYH;
    private final Value[] zzYI;
    private DataSource zzYJ;
    private long zzYK;
    private long zzYL;
    private final DataSource zzYp;

    static {
        CREATOR = new zze();
    }

    DataPoint(int versionCode, DataSource dataSource, long timestampNanos, long startTimeNanos, Value[] values, DataSource originalDataSource, long rawTimestamp, long insertionTimeMillis) {
        this.zzFG = versionCode;
        this.zzYp = dataSource;
        this.zzYJ = originalDataSource;
        this.zzYG = timestampNanos;
        this.zzYH = startTimeNanos;
        this.zzYI = values;
        this.zzYK = rawTimestamp;
        this.zzYL = insertionTimeMillis;
    }

    private DataPoint(DataSource dataSource) {
        this.zzFG = 4;
        this.zzYp = (DataSource) zzx.zzb((Object) dataSource, (Object) "Data source cannot be null");
        List<Field> fields = dataSource.getDataType().getFields();
        this.zzYI = new Value[fields.size()];
        int i = 0;
        for (Field format : fields) {
            this.zzYI[i] = new Value(format.getFormat());
            i++;
        }
    }

    public DataPoint(DataSource dataSource, DataSource originalDataSource, zzb rawDataPoint) {
        this(4, dataSource, zza(Long.valueOf(rawDataPoint.zzaIA), 0), zza(Long.valueOf(rawDataPoint.zzaIB), 0), zzmx.zza(dataSource.zzly().zzaIf, rawDataPoint.zzaIC), originalDataSource, zza(Long.valueOf(rawDataPoint.zzaIH), 0), zza(Long.valueOf(rawDataPoint.zzaII), 0));
    }

    DataPoint(List<DataSource> dataSources, RawDataPoint rawDataPoint) {
        this((List) dataSources, zzmu.zzb(rawDataPoint));
    }

    DataPoint(List<DataSource> dataSources, zzb rawDataPoint) {
        this(zzc(dataSources, rawDataPoint.zzaID), zzc(dataSources, rawDataPoint.zzaIF), rawDataPoint);
    }

    public static DataPoint create(DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    public static DataPoint extract(Intent intent) {
        return intent == null ? null : (DataPoint) zzc.zza(intent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
    }

    private static long zza(Long l, long j) {
        return l != null ? l.longValue() : j;
    }

    private boolean zza(DataPoint dataPoint) {
        return zzw.equal(this.zzYp, dataPoint.zzYp) && this.zzYG == dataPoint.zzYG && this.zzYH == dataPoint.zzYH && Arrays.equals(this.zzYI, dataPoint.zzYI) && zzw.equal(this.zzYJ, dataPoint.zzYJ);
    }

    private static DataSource zzc(List<DataSource> list, int i) {
        return (i < 0 || i >= list.size()) ? null : (DataSource) list.get(i);
    }

    private void zzdi(int i) {
        zzx.zzb(i == getDataType().getFields().size(), "Attempting to insert %s values, but needed %s: %s", Integer.valueOf(i), Integer.valueOf(getDataType().getFields().size()), getDataType().getFields());
    }

    private boolean zzlr() {
        return getDataType() == DataType.TYPE_LOCATION_SAMPLE;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof DataPoint) && zza((DataPoint) o));
    }

    public DataSource getDataSource() {
        return this.zzYp;
    }

    public DataType getDataType() {
        return this.zzYp.getDataType();
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzYG, TimeUnit.NANOSECONDS);
    }

    public DataSource getOriginalDataSource() {
        return this.zzYJ;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzYH, TimeUnit.NANOSECONDS);
    }

    public long getTimestamp(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzYG, TimeUnit.NANOSECONDS);
    }

    public long getTimestampNanos() {
        return this.zzYG;
    }

    public Value getValue(Field field) {
        return this.zzYI[getDataType().indexOf(field)];
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzYp, Long.valueOf(this.zzYG), Long.valueOf(this.zzYH));
    }

    public DataPoint setFloatValues(float... values) {
        zzdi(values.length);
        for (int i = 0; i < values.length; i++) {
            this.zzYI[i].setFloat(values[i]);
        }
        return this;
    }

    public DataPoint setIntValues(int... values) {
        zzdi(values.length);
        for (int i = 0; i < values.length; i++) {
            this.zzYI[i].setInt(values[i]);
        }
        return this;
    }

    public DataPoint setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
        this.zzYH = timeUnit.toNanos(startTime);
        this.zzYG = timeUnit.toNanos(endTime);
        return this;
    }

    public DataPoint setTimestamp(long timestamp, TimeUnit timeUnit) {
        this.zzYG = timeUnit.toNanos(timestamp);
        if (zzlr() && zzmo.zza(timeUnit)) {
            Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
            this.zzYG = zzmo.zza(this.zzYG, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public String toString() {
        String str = "DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}";
        Object[] objArr = new Object[7];
        objArr[0] = Arrays.toString(this.zzYI);
        objArr[1] = Long.valueOf(this.zzYH);
        objArr[2] = Long.valueOf(this.zzYG);
        objArr[3] = Long.valueOf(this.zzYK);
        objArr[4] = Long.valueOf(this.zzYL);
        objArr[5] = this.zzYp.toDebugString();
        objArr[6] = this.zzYJ != null ? this.zzYJ.toDebugString() : "N/A";
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }

    public Value[] zzls() {
        return this.zzYI;
    }

    public long zzlt() {
        return this.zzYK;
    }

    public long zzlu() {
        return this.zzYL;
    }

    public long zzlv() {
        return this.zzYH;
    }
}
