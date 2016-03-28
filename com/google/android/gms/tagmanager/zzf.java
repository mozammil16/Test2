package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzf extends zzaj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = zza.APP_ID.toString();
    }

    public zzf(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        return zzde.zzx(this.mContext.getPackageName());
    }

    public boolean zzsD() {
        return true;
    }
}
