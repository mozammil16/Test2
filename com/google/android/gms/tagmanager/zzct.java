package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class zzct extends zzcs {
    private static final Object zzBQ;
    private static zzct zzaAF;
    private boolean connected;
    private Handler handler;
    private boolean zzaAA;
    private boolean zzaAB;
    private zzau zzaAC;
    private zzbk zzaAD;
    private boolean zzaAE;
    private Context zzaAv;
    private zzat zzaAw;
    private volatile zzar zzaAx;
    private int zzaAy;
    private boolean zzaAz;

    /* renamed from: com.google.android.gms.tagmanager.zzct.2 */
    class C02892 implements Callback {
        final /* synthetic */ zzct zzaAG;

        C02892(zzct com_google_android_gms_tagmanager_zzct) {
            this.zzaAG = com_google_android_gms_tagmanager_zzct;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && zzct.zzBQ.equals(msg.obj)) {
                this.zzaAG.dispatch();
                if (this.zzaAG.zzaAy > 0 && !this.zzaAG.zzaAE) {
                    this.zzaAG.handler.sendMessageDelayed(this.zzaAG.handler.obtainMessage(1, zzct.zzBQ), (long) this.zzaAG.zzaAy);
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzct.3 */
    class C02903 implements Runnable {
        final /* synthetic */ zzct zzaAG;

        C02903(zzct com_google_android_gms_tagmanager_zzct) {
            this.zzaAG = com_google_android_gms_tagmanager_zzct;
        }

        public void run() {
            this.zzaAG.zzaAw.dispatch();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzct.1 */
    class C04531 implements zzau {
        final /* synthetic */ zzct zzaAG;

        C04531(zzct com_google_android_gms_tagmanager_zzct) {
            this.zzaAG = com_google_android_gms_tagmanager_zzct;
        }

        public void zzD(boolean z) {
            this.zzaAG.zzb(z, this.zzaAG.connected);
        }
    }

    static {
        zzBQ = new Object();
    }

    private zzct() {
        this.zzaAy = 1800000;
        this.zzaAz = true;
        this.zzaAA = false;
        this.connected = true;
        this.zzaAB = true;
        this.zzaAC = new C04531(this);
        this.zzaAE = false;
    }

    private void zzfF() {
        this.zzaAD = new zzbk(this);
        this.zzaAD.zzD(this.zzaAv);
    }

    private void zzfI() {
        this.handler = new Handler(this.zzaAv.getMainLooper(), new C02892(this));
        if (this.zzaAy > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzBQ), (long) this.zzaAy);
        }
    }

    public static zzct zztR() {
        if (zzaAF == null) {
            zzaAF = new zzct();
        }
        return zzaAF;
    }

    public synchronized void dispatch() {
        if (this.zzaAA) {
            this.zzaAx.zzc(new C02903(this));
        } else {
            zzbf.zzab("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzaAz = true;
        }
    }

    synchronized void zzE(boolean z) {
        zzb(this.zzaAE, z);
    }

    synchronized void zza(Context context, zzar com_google_android_gms_tagmanager_zzar) {
        if (this.zzaAv == null) {
            this.zzaAv = context.getApplicationContext();
            if (this.zzaAx == null) {
                this.zzaAx = com_google_android_gms_tagmanager_zzar;
            }
        }
    }

    synchronized void zzb(boolean z, boolean z2) {
        if (!(this.zzaAE == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.zzaAy > 0) {
                    this.handler.removeMessages(1, zzBQ);
                }
            }
            if (!z && z2 && this.zzaAy > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzBQ), (long) this.zzaAy);
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            zzbf.zzab(append.append(str).toString());
            this.zzaAE = z;
            this.connected = z2;
        }
    }

    synchronized void zzfJ() {
        if (!this.zzaAE && this.connected && this.zzaAy > 0) {
            this.handler.removeMessages(1, zzBQ);
            this.handler.sendMessage(this.handler.obtainMessage(1, zzBQ));
        }
    }

    synchronized zzat zztS() {
        if (this.zzaAw == null) {
            if (this.zzaAv == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.zzaAw = new zzbx(this.zzaAC, this.zzaAv);
        }
        if (this.handler == null) {
            zzfI();
        }
        this.zzaAA = true;
        if (this.zzaAz) {
            dispatch();
            this.zzaAz = false;
        }
        if (this.zzaAD == null && this.zzaAB) {
            zzfF();
        }
        return this.zzaAw;
    }
}
