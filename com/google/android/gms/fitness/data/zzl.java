package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

public class zzl extends com.google.android.gms.fitness.data.zzk.zza {
    private final OnDataPointListener zzZF;

    public static class zza {
        private static final zza zzZG;
        private final Map<OnDataPointListener, zzl> zzZH;

        static {
            zzZG = new zza();
        }

        private zza() {
            this.zzZH = new HashMap();
        }

        public static zza zzlG() {
            return zzZG;
        }

        public zzl zza(OnDataPointListener onDataPointListener) {
            zzl com_google_android_gms_fitness_data_zzl;
            synchronized (this.zzZH) {
                com_google_android_gms_fitness_data_zzl = (zzl) this.zzZH.get(onDataPointListener);
                if (com_google_android_gms_fitness_data_zzl == null) {
                    com_google_android_gms_fitness_data_zzl = new zzl(null);
                    this.zzZH.put(onDataPointListener, com_google_android_gms_fitness_data_zzl);
                }
            }
            return com_google_android_gms_fitness_data_zzl;
        }

        public zzl zzb(OnDataPointListener onDataPointListener) {
            zzl com_google_android_gms_fitness_data_zzl;
            synchronized (this.zzZH) {
                com_google_android_gms_fitness_data_zzl = (zzl) this.zzZH.get(onDataPointListener);
            }
            return com_google_android_gms_fitness_data_zzl;
        }

        public zzl zzc(OnDataPointListener onDataPointListener) {
            zzl com_google_android_gms_fitness_data_zzl;
            synchronized (this.zzZH) {
                com_google_android_gms_fitness_data_zzl = (zzl) this.zzZH.remove(onDataPointListener);
                if (com_google_android_gms_fitness_data_zzl != null) {
                } else {
                    com_google_android_gms_fitness_data_zzl = new zzl(null);
                }
            }
            return com_google_android_gms_fitness_data_zzl;
        }
    }

    private zzl(OnDataPointListener onDataPointListener) {
        this.zzZF = (OnDataPointListener) zzx.zzl(onDataPointListener);
    }

    public void zzc(DataPoint dataPoint) throws RemoteException {
        this.zzZF.onDataPoint(dataPoint);
    }
}
