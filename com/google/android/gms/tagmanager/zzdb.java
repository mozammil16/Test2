package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

class zzdb {
    private Context mContext;
    private Tracker zzBL;
    private GoogleAnalytics zzBN;

    static class zza implements Logger {
        zza() {
        }

        private static int zzhj(int i) {
            switch (i) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    return 0;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                case Place.TYPE_AQUARIUM /*4*/:
                    return 1;
                case Place.TYPE_ART_GALLERY /*5*/:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            zzbf.zzb("", exception);
        }

        public void error(String message) {
            zzbf.zzZ(message);
        }

        public int getLogLevel() {
            return zzhj(zzbf.getLogLevel());
        }

        public void info(String message) {
            zzbf.zzaa(message);
        }

        public void setLogLevel(int logLevel) {
            zzbf.zzac("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String message) {
            zzbf.zzab(message);
        }

        public void warn(String message) {
            zzbf.zzac(message);
        }
    }

    zzdb(Context context) {
        this.mContext = context;
    }

    private synchronized void zzdm(String str) {
        if (this.zzBN == null) {
            this.zzBN = GoogleAnalytics.getInstance(this.mContext);
            this.zzBN.setLogger(new zza());
            this.zzBL = this.zzBN.newTracker(str);
        }
    }

    public Tracker zzdl(String str) {
        zzdm(str);
        return this.zzBL;
    }
}
