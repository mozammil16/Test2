package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzal extends zzbu {
    private static final String ID;

    static {
        ID = zza.GREATER_EQUALS.toString();
    }

    public zzal() {
        super(ID);
    }

    protected boolean zza(zzdd com_google_android_gms_tagmanager_zzdd, zzdd com_google_android_gms_tagmanager_zzdd2, Map<String, zzd.zza> map) {
        return com_google_android_gms_tagmanager_zzdd.zza(com_google_android_gms_tagmanager_zzdd2) >= 0;
    }
}
