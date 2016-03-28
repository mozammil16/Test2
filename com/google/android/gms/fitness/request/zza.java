package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.HashMap;
import java.util.Map;

public class zza extends com.google.android.gms.fitness.request.zzt.zza {
    private final BleScanCallback zzaaI;

    public static class zza {
        private static final zza zzaaJ;
        private final Map<BleScanCallback, zza> zzaaK;

        static {
            zzaaJ = new zza();
        }

        private zza() {
            this.zzaaK = new HashMap();
        }

        public static zza zzlO() {
            return zzaaJ;
        }

        public zza zza(BleScanCallback bleScanCallback) {
            zza com_google_android_gms_fitness_request_zza;
            synchronized (this.zzaaK) {
                com_google_android_gms_fitness_request_zza = (zza) this.zzaaK.get(bleScanCallback);
                if (com_google_android_gms_fitness_request_zza == null) {
                    com_google_android_gms_fitness_request_zza = new zza(null);
                    this.zzaaK.put(bleScanCallback, com_google_android_gms_fitness_request_zza);
                }
            }
            return com_google_android_gms_fitness_request_zza;
        }

        public zza zzb(BleScanCallback bleScanCallback) {
            zza com_google_android_gms_fitness_request_zza;
            synchronized (this.zzaaK) {
                com_google_android_gms_fitness_request_zza = (zza) this.zzaaK.get(bleScanCallback);
                if (com_google_android_gms_fitness_request_zza != null) {
                } else {
                    com_google_android_gms_fitness_request_zza = new zza(null);
                }
            }
            return com_google_android_gms_fitness_request_zza;
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.zzaaI = (BleScanCallback) zzx.zzl(bleScanCallback);
    }

    public void onDeviceFound(BleDevice device) throws RemoteException {
        this.zzaaI.onDeviceFound(device);
    }

    public void onScanStopped() throws RemoteException {
        this.zzaaI.onScanStopped();
    }
}
