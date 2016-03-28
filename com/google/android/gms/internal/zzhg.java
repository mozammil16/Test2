package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@zzgi
public class zzhg {
    private Context mContext;
    private zzae zzlG;
    private boolean zzmE;
    private final Object zznh;
    private zzhy zznl;
    private zzam zzol;
    private zzal zzom;
    private final zzgh zzon;
    private boolean zzxO;
    private boolean zzxP;
    private final String zzyL;
    private final zzhh zzyM;
    private BigInteger zzyN;
    private final HashSet<zzhf> zzyO;
    private final HashMap<String, zzhj> zzyP;
    private boolean zzyQ;
    private int zzyR;
    private zzcc zzyS;
    private zzan zzyT;
    private final LinkedList<Thread> zzyU;
    private Boolean zzyV;
    private String zzyW;

    /* renamed from: com.google.android.gms.internal.zzhg.1 */
    class C02291 implements Runnable {
        final /* synthetic */ Thread zzyX;
        final /* synthetic */ zzhg zzyY;

        C02291(zzhg com_google_android_gms_internal_zzhg, Thread thread) {
            this.zzyY = com_google_android_gms_internal_zzhg;
            this.zzyX = thread;
        }

        public void run() {
            zzgh.zza(this.zzyY.mContext, this.zzyX, this.zzyY.zznl);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhg.2 */
    class C02302 implements Runnable {
        final /* synthetic */ zzhg zzyY;

        C02302(zzhg com_google_android_gms_internal_zzhg) {
            this.zzyY = com_google_android_gms_internal_zzhg;
        }

        public void run() {
            zzcb com_google_android_gms_internal_zzcb = new zzcb();
            com_google_android_gms_internal_zzcb.zzb(this.zzyY.mContext, this.zzyY.zznl.zzzH);
            try {
                this.zzyY.zzyS = zzab.zzaR().zza(com_google_android_gms_internal_zzcb);
            } catch (IllegalArgumentException e) {
                zzhx.zzac("Cannot initialize CSI reporter." + e.getMessage());
            }
        }
    }

    public zzhg(zzho com_google_android_gms_internal_zzho) {
        this.zznh = new Object();
        this.zzyN = BigInteger.ONE;
        this.zzyO = new HashSet();
        this.zzyP = new HashMap();
        this.zzyQ = false;
        this.zzxO = true;
        this.zzyR = 0;
        this.zzmE = false;
        this.zzyS = null;
        this.zzxP = true;
        this.zzol = null;
        this.zzyT = null;
        this.zzom = null;
        this.zzyU = new LinkedList();
        this.zzon = null;
        this.zzyV = null;
        this.zzyL = com_google_android_gms_internal_zzho.zzeu();
        this.zzyM = new zzhh(this.zzyL);
    }

    public String getSessionId() {
        return this.zzyL;
    }

    public Bundle zza(Context context, zzhi com_google_android_gms_internal_zzhi, String str) {
        Bundle bundle;
        synchronized (this.zznh) {
            bundle = new Bundle();
            bundle.putBundle("app", this.zzyM.zzc(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.zzyP.keySet()) {
                bundle2.putBundle(str2, ((zzhj) this.zzyP.get(str2)).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzyO.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzhf) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            com_google_android_gms_internal_zzhi.zza(this.zzyO);
            this.zzyO.clear();
        }
        return bundle;
    }

    public void zza(Context context, boolean z) {
        synchronized (this.zznh) {
            if (z != this.zzxO) {
                this.zzxO = z;
                zzhm.zza(context, z);
            }
        }
    }

    public void zza(zzhf com_google_android_gms_internal_zzhf) {
        synchronized (this.zznh) {
            this.zzyO.add(com_google_android_gms_internal_zzhf);
        }
    }

    public void zza(String str, zzhj com_google_android_gms_internal_zzhj) {
        synchronized (this.zznh) {
            this.zzyP.put(str, com_google_android_gms_internal_zzhj);
        }
    }

    public void zza(Thread thread) {
        zzca.zza(new C02291(this, thread));
    }

    public void zzb(Context context, zzhy com_google_android_gms_internal_zzhy) {
        synchronized (this.zznh) {
            if (!this.zzmE) {
                this.mContext = context.getApplicationContext();
                this.zznl = com_google_android_gms_internal_zzhy;
                this.zzxO = zzhm.zzr(context);
                this.zzyR = zzhm.zzs(context);
                zza(Thread.currentThread());
                this.zzyW = zzab.zzaM().zze(context, com_google_android_gms_internal_zzhy.zzzH);
                this.zzlG = new zzae(context.getApplicationContext(), this.zznl, new zzdf(context.getApplicationContext(), this.zznl, (String) zzca.zzql.get()));
                zzen();
                this.zzmE = true;
            }
        }
    }

    public void zzb(Boolean bool) {
        synchronized (this.zznh) {
            this.zzyV = bool;
        }
    }

    public void zzb(HashSet<zzhf> hashSet) {
        synchronized (this.zznh) {
            this.zzyO.addAll(hashSet);
        }
    }

    public String zzc(int i, String str) {
        Resources resources = this.zznl.zzzK ? this.mContext.getResources() : GooglePlayServicesUtil.getRemoteResource(this.mContext);
        return resources == null ? str : resources.getString(i);
    }

    public void zze(Throwable th) {
        new zzgh(this.mContext, this.zznl, null, null).zzb(th);
    }

    public boolean zzed() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzxP;
        }
        return z;
    }

    public String zzee() {
        String bigInteger;
        synchronized (this.zznh) {
            bigInteger = this.zzyN.toString();
            this.zzyN = this.zzyN.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public zzhh zzef() {
        zzhh com_google_android_gms_internal_zzhh;
        synchronized (this.zznh) {
            com_google_android_gms_internal_zzhh = this.zzyM;
        }
        return com_google_android_gms_internal_zzhh;
    }

    public zzcc zzeg() {
        zzcc com_google_android_gms_internal_zzcc;
        synchronized (this.zznh) {
            com_google_android_gms_internal_zzcc = this.zzyS;
        }
        return com_google_android_gms_internal_zzcc;
    }

    public boolean zzeh() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzyQ;
            this.zzyQ = true;
        }
        return z;
    }

    public boolean zzei() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzxO;
        }
        return z;
    }

    public String zzej() {
        String str;
        synchronized (this.zznh) {
            str = this.zzyW;
        }
        return str;
    }

    public Boolean zzek() {
        Boolean bool;
        synchronized (this.zznh) {
            bool = this.zzyV;
        }
        return bool;
    }

    public zzae zzel() {
        return this.zzlG;
    }

    public boolean zzem() {
        boolean z;
        synchronized (this.zznh) {
            if (this.zzyR < ((Integer) zzca.zzqN.get()).intValue()) {
                this.zzyR = ((Integer) zzca.zzqN.get()).intValue();
                zzhm.zza(this.mContext, this.zzyR);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    void zzen() {
        zzca.zza(new C02302(this));
    }

    public zzan zzo(Context context) {
        if (!((Boolean) zzca.zzqB.get()).booleanValue() || !zzme.zzkg() || zzed()) {
            return null;
        }
        synchronized (this.zznh) {
            if (this.zzol == null) {
                if (context instanceof Activity) {
                    this.zzol = new zzam((Application) context.getApplicationContext(), (Activity) context);
                } else {
                    return null;
                }
            }
            if (this.zzom == null) {
                this.zzom = new zzal();
            }
            if (this.zzyT == null) {
                this.zzyT = new zzan(this.zzol, this.zzom, new zzgh(this.mContext, this.zznl, null, null));
            }
            this.zzyT.zzbt();
            zzan com_google_android_gms_internal_zzan = this.zzyT;
            return com_google_android_gms_internal_zzan;
        }
    }

    public void zzz(boolean z) {
        synchronized (this.zznh) {
            this.zzxP = z;
        }
    }
}
