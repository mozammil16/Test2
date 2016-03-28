package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmv;
import com.google.android.gms.internal.zzxd.zzc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataSet implements SafeParcelable {
    public static final Creator<DataSet> CREATOR;
    private final int zzFG;
    private boolean zzYF;
    private final List<DataPoint> zzYM;
    private final List<DataSource> zzYN;
    private final DataType zzYo;
    private final DataSource zzYp;

    static {
        CREATOR = new zzf();
    }

    DataSet(int versionCode, DataSource dataSource, DataType dataType, List<RawDataPoint> dataPoints, List<DataSource> uniqueDataSources, boolean serverHasMoreData) {
        this.zzYF = false;
        this.zzFG = versionCode;
        this.zzYp = dataSource;
        this.zzYo = dataSource.getDataType();
        this.zzYF = serverHasMoreData;
        this.zzYM = new ArrayList(dataPoints.size());
        if (versionCode < 2) {
            uniqueDataSources = Collections.singletonList(dataSource);
        }
        this.zzYN = uniqueDataSources;
        for (RawDataPoint dataPoint : dataPoints) {
            this.zzYM.add(new DataPoint(this.zzYN, dataPoint));
        }
    }

    public DataSet(DataSource dataSource) {
        this.zzYF = false;
        this.zzFG = 3;
        this.zzYp = (DataSource) zzx.zzl(dataSource);
        this.zzYo = dataSource.getDataType();
        this.zzYM = new ArrayList();
        this.zzYN = new ArrayList();
        this.zzYN.add(this.zzYp);
    }

    public DataSet(RawDataSet dataSet, List<DataSource> uniqueDataSources) {
        this(zzmv.zzb(dataSet), (List) uniqueDataSources);
    }

    public DataSet(zzc dataSet, List<DataSource> uniqueDataSources) {
        this.zzYF = false;
        this.zzFG = 3;
        this.zzYp = (DataSource) zzd(uniqueDataSources, dataSet.zzaID);
        this.zzYo = this.zzYp.getDataType();
        this.zzYN = uniqueDataSources;
        this.zzYF = dataSet.zzaIx;
        List<RawDataPoint> zza = zzmu.zza(((DataSource) zzd(uniqueDataSources, dataSet.zzaID)).zzly().zzaIf, dataSet.zzaIK);
        this.zzYM = new ArrayList(zza.size());
        for (RawDataPoint dataPoint : zza) {
            this.zzYM.add(new DataPoint(this.zzYN, dataPoint));
        }
    }

    public static DataSet create(DataSource dataSource) {
        zzx.zzb((Object) dataSource, (Object) "DataSource should be specified");
        return new DataSet(dataSource);
    }

    private boolean zza(DataSet dataSet) {
        return zzw.equal(getDataType(), dataSet.getDataType()) && zzw.equal(this.zzYp, dataSet.zzYp) && zzw.equal(this.zzYM, dataSet.zzYM) && this.zzYF == dataSet.zzYF;
    }

    private static <T> T zzd(List<T> list, int i) {
        return (i < 0 || i >= list.size()) ? null : list.get(i);
    }

    public void add(DataPoint dataPoint) {
        zzx.zzb(dataPoint.getDataSource().getStreamIdentifier().equals(this.zzYp.getStreamIdentifier()), "Conflicting data sources found %s vs %s", dataPoint.getDataSource(), this.zzYp);
        zzx.zzb(dataPoint.getDataType().getName().equals(getDataType().getName()), "Conflicting data types found %s vs %s", dataPoint.getDataType(), getDataType());
        zzx.zzb(dataPoint.getTimestamp(TimeUnit.NANOSECONDS) > 0, "Data point does not have the timestamp set: %s", dataPoint);
        zzx.zzb(dataPoint.getStartTime(TimeUnit.NANOSECONDS) <= dataPoint.getEndTime(TimeUnit.NANOSECONDS), "Data point with start time greater than end time found: %s", dataPoint);
        zzb(dataPoint);
    }

    public void addAll(Iterable<DataPoint> dataPoints) {
        for (DataPoint add : dataPoints) {
            add(add);
        }
    }

    public DataPoint createDataPoint() {
        return DataPoint.create(this.zzYp);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataSet) && zza((DataSet) o));
    }

    public List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.zzYM);
    }

    public DataSource getDataSource() {
        return this.zzYp;
    }

    public DataType getDataType() {
        return this.zzYp.getDataType();
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzYp);
    }

    public String toString() {
        List zzlw = zzlw();
        String str = "DataSet{%s %s}";
        Object[] objArr = new Object[2];
        objArr[0] = this.zzYp.toDebugString();
        if (this.zzYM.size() >= 10) {
            zzlw = String.format("%d data points, first 5: %s", new Object[]{Integer.valueOf(this.zzYM.size()), zzlw.subList(0, 5)});
        }
        objArr[1] = zzlw;
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzf.zza(this, parcel, flags);
    }

    public void zzb(DataPoint dataPoint) {
        this.zzYM.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource != null && !this.zzYN.contains(originalDataSource)) {
            this.zzYN.add(originalDataSource);
        }
    }

    public void zzb(Iterable<DataPoint> iterable) {
        for (DataPoint zzb : iterable) {
            zzb(zzb);
        }
    }

    List<RawDataPoint> zzk(List<DataSource> list) {
        List<RawDataPoint> arrayList = new ArrayList(this.zzYM.size());
        for (DataPoint rawDataPoint : this.zzYM) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }

    public boolean zzlo() {
        return this.zzYF;
    }

    List<RawDataPoint> zzlw() {
        return zzk(this.zzYN);
    }

    List<DataSource> zzlx() {
        return this.zzYN;
    }
}
