package com.google.android.gms.analytics;

import android.app.IntentService;
import android.content.Intent;
import android.util.Pair;
import com.google.android.gms.location.GeofenceStatusCodes;

public final class AnalyticsService extends IntentService {
    static int zzAZ;

    static {
        zzAZ = 1800;
    }

    public AnalyticsService() {
        super("AnalyticsService");
    }

    public AnalyticsService(String name) {
        super(name);
    }

    static void zzC(int i) {
        zzAZ = i;
    }

    protected void onHandleIntent(Intent intent) {
        try {
            synchronized (AnalyticsReceiver.zzmz) {
                if (AnalyticsReceiver.zzAY != null && AnalyticsReceiver.zzAY.isHeld()) {
                    AnalyticsReceiver.zzAY.release();
                }
            }
        } catch (SecurityException e) {
        }
        GoogleAnalytics instance = GoogleAnalytics.getInstance(this);
        zzae.zzab("Analytics Service called.");
        Pair zzfg = instance.zzgl().zzfg();
        if (!(zzfg == null || zzfg.first == null || zzfg.second == null || Math.abs(System.currentTimeMillis() - ((Long) zzfg.first).longValue()) < ((long) (zzAZ * GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE)))) {
            instance.dispatchLocalHits();
        }
        stopSelf();
    }
}
