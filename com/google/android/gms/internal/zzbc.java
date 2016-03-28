package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.zzbk.zza;

@zzgi
public final class zzbc extends zza {
    private final AppEventListener zzpd;

    public zzbc(AppEventListener appEventListener) {
        this.zzpd = appEventListener;
    }

    public void onAppEvent(String name, String info) {
        this.zzpd.onAppEvent(name, info);
    }
}
