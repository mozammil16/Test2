package com.google.android.gms.internal;

public final class zzlp {

    public static final class zza {
        public static zzki<String> zzRA;
        public static zzki<String> zzRB;
        public static zzki<String> zzRC;
        public static zzki<String> zzRD;
        public static zzki<Long> zzRE;
        public static zzki<Boolean> zzRy;
        public static zzki<Integer> zzRz;

        static {
            zzRy = zzki.zzg("gms:common:stats:logging:debug", false);
            zzRz = zzki.zza("gms:common:stats:logging:level", Integer.valueOf(zzlq.zzRF));
            zzRA = zzki.zzp("gms:common:stats:logging:ignored_calling_processes", "");
            zzRB = zzki.zzp("gms:common:stats:logging:ignored_calling_services", "");
            zzRC = zzki.zzp("gms:common:stats:logging:ignored_target_processes", "");
            zzRD = zzki.zzp("gms:common:stats:logging:ignored_target_services", "com.google.android.gms.auth.GetToken");
            zzRE = zzki.zza("gms:common:stats:logging:time_out_duration", Long.valueOf(600000));
        }
    }
}
