package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import java.util.Date;

public class zzmk {
    public static final zza zzWe;
    public static final zzb zzWf;
    public static final zzd zzWg;
    public static final zzc zzWh;
    public static final zze zzWi;

    public static class zza extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField<Date> {
        public zza(String str, int i) {
            super(str, i);
        }
    }

    public static class zzb extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zzb(String str, int i) {
            super(str, i);
        }
    }

    public static class zzc extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField<Date> {
        public zzc(String str, int i) {
            super(str, i);
        }
    }

    public static class zzd extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zzd(String str, int i) {
            super(str, i);
        }
    }

    public static class zze extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zze(String str, int i) {
            super(str, i);
        }
    }

    static {
        zzWe = new zza("created", 4100000);
        zzWf = new zzb("lastOpenedTime", 4300000);
        zzWg = new zzd("modified", 4100000);
        zzWh = new zzc("modifiedByMe", 4100000);
        zzWi = new zze("sharedWithMe", 4100000);
    }
}
