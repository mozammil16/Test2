package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzu extends zzaj {
    private static final String ID;
    private static final String NAME;
    private static final String zzaym;
    private final DataLayer zzaxx;

    static {
        ID = zza.CUSTOM_VAR.toString();
        NAME = zzb.NAME.toString();
        zzaym = zzb.DEFAULT_VALUE.toString();
    }

    public zzu(DataLayer dataLayer) {
        super(ID, NAME);
        this.zzaxx = dataLayer;
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        Object obj = this.zzaxx.get(zzde.zzg((zzd.zza) map.get(NAME)));
        if (obj != null) {
            return zzde.zzx(obj);
        }
        zzd.zza com_google_android_gms_internal_zzd_zza = (zzd.zza) map.get(zzaym);
        return com_google_android_gms_internal_zzd_zza != null ? com_google_android_gms_internal_zzd_zza : zzde.zzuf();
    }

    public boolean zzsD() {
        return false;
    }
}
