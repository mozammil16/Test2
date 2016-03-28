package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.location.places.Place;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzju extends zzk<zzjz> {
    private static final Object zzKB;
    private static final Object zzKC;
    private static final zzkc zzKh;
    private final Listener zzIB;
    private double zzJm;
    private boolean zzJn;
    private com.google.android.gms.common.api.zza.zzb<Status> zzKA;
    private ApplicationMetadata zzKi;
    private final CastDevice zzKj;
    private final Map<String, MessageReceivedCallback> zzKk;
    private final long zzKl;
    private zzc zzKm;
    private String zzKn;
    private boolean zzKo;
    private boolean zzKp;
    private boolean zzKq;
    private int zzKr;
    private int zzKs;
    private final AtomicLong zzKt;
    private String zzKu;
    private String zzKv;
    private Bundle zzKw;
    private final Map<Long, com.google.android.gms.common.api.zza.zzb<Status>> zzKx;
    private final zzb zzKy;
    private com.google.android.gms.common.api.zza.zzb<ApplicationConnectionResult> zzKz;

    private class zzb implements OnConnectionFailedListener {
        final /* synthetic */ zzju zzKG;

        private zzb(zzju com_google_android_gms_internal_zzju) {
            this.zzKG = com_google_android_gms_internal_zzju;
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.zzKG.zzht();
        }
    }

    private static final class zza implements ApplicationConnectionResult {
        private final Status zzHb;
        private final ApplicationMetadata zzKD;
        private final String zzKE;
        private final boolean zzKF;
        private final String zzyL;

        public zza(Status status) {
            this(status, null, null, null, false);
        }

        public zza(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.zzHb = status;
            this.zzKD = applicationMetadata;
            this.zzKE = str;
            this.zzyL = str2;
            this.zzKF = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.zzKD;
        }

        public String getApplicationStatus() {
            return this.zzKE;
        }

        public String getSessionId() {
            return this.zzyL;
        }

        public Status getStatus() {
            return this.zzHb;
        }

        public boolean getWasLaunched() {
            return this.zzKF;
        }
    }

    private static class zzc extends com.google.android.gms.internal.zzka.zza {
        private final Handler mHandler;
        private final AtomicReference<zzju> zzKH;

        /* renamed from: com.google.android.gms.internal.zzju.zzc.1 */
        class C02521 implements Runnable {
            final /* synthetic */ zzju zzKI;
            final /* synthetic */ int zzKJ;
            final /* synthetic */ zzc zzKK;

            C02521(zzc com_google_android_gms_internal_zzju_zzc, zzju com_google_android_gms_internal_zzju, int i) {
                this.zzKK = com_google_android_gms_internal_zzju_zzc;
                this.zzKI = com_google_android_gms_internal_zzju;
                this.zzKJ = i;
            }

            public void run() {
                if (this.zzKI.zzIB != null) {
                    this.zzKI.zzIB.onApplicationDisconnected(this.zzKJ);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzju.zzc.2 */
        class C02532 implements Runnable {
            final /* synthetic */ zzju zzKI;
            final /* synthetic */ zzc zzKK;
            final /* synthetic */ zzjw zzKL;

            C02532(zzc com_google_android_gms_internal_zzju_zzc, zzju com_google_android_gms_internal_zzju, zzjw com_google_android_gms_internal_zzjw) {
                this.zzKK = com_google_android_gms_internal_zzju_zzc;
                this.zzKI = com_google_android_gms_internal_zzju;
                this.zzKL = com_google_android_gms_internal_zzjw;
            }

            public void run() {
                this.zzKI.zza(this.zzKL);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzju.zzc.3 */
        class C02543 implements Runnable {
            final /* synthetic */ zzju zzKI;
            final /* synthetic */ zzc zzKK;
            final /* synthetic */ zzjp zzKM;

            C02543(zzc com_google_android_gms_internal_zzju_zzc, zzju com_google_android_gms_internal_zzju, zzjp com_google_android_gms_internal_zzjp) {
                this.zzKK = com_google_android_gms_internal_zzju_zzc;
                this.zzKI = com_google_android_gms_internal_zzju;
                this.zzKM = com_google_android_gms_internal_zzjp;
            }

            public void run() {
                this.zzKI.zza(this.zzKM);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzju.zzc.4 */
        class C02554 implements Runnable {
            final /* synthetic */ String zzIr;
            final /* synthetic */ zzju zzKI;
            final /* synthetic */ zzc zzKK;
            final /* synthetic */ String zzKN;

            C02554(zzc com_google_android_gms_internal_zzju_zzc, zzju com_google_android_gms_internal_zzju, String str, String str2) {
                this.zzKK = com_google_android_gms_internal_zzju_zzc;
                this.zzKI = com_google_android_gms_internal_zzju;
                this.zzIr = str;
                this.zzKN = str2;
            }

            public void run() {
                synchronized (this.zzKI.zzKk) {
                    MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.zzKI.zzKk.get(this.zzIr);
                }
                if (messageReceivedCallback != null) {
                    messageReceivedCallback.onMessageReceived(this.zzKI.zzKj, this.zzIr, this.zzKN);
                    return;
                }
                zzju.zzKh.zzb("Discarded message for unknown namespace '%s'", this.zzIr);
            }
        }

        public zzc(zzju com_google_android_gms_internal_zzju) {
            this.zzKH = new AtomicReference(com_google_android_gms_internal_zzju);
            this.mHandler = new Handler(com_google_android_gms_internal_zzju.getLooper());
        }

        private void zza(zzju com_google_android_gms_internal_zzju, long j, int i) {
            synchronized (com_google_android_gms_internal_zzju.zzKx) {
                com.google.android.gms.common.api.zza.zzb com_google_android_gms_common_api_zza_zzb = (com.google.android.gms.common.api.zza.zzb) com_google_android_gms_internal_zzju.zzKx.remove(Long.valueOf(j));
            }
            if (com_google_android_gms_common_api_zza_zzb != null) {
                com_google_android_gms_common_api_zza_zzb.zzd(new Status(i));
            }
        }

        private boolean zza(zzju com_google_android_gms_internal_zzju, int i) {
            synchronized (zzju.zzKC) {
                if (com_google_android_gms_internal_zzju.zzKA != null) {
                    com_google_android_gms_internal_zzju.zzKA.zzd(new Status(i));
                    com_google_android_gms_internal_zzju.zzKA = null;
                    return true;
                }
                return false;
            }
        }

        public void onApplicationDisconnected(int statusCode) {
            zzju com_google_android_gms_internal_zzju = (zzju) this.zzKH.get();
            if (com_google_android_gms_internal_zzju != null) {
                com_google_android_gms_internal_zzju.zzKu = null;
                com_google_android_gms_internal_zzju.zzKv = null;
                zza(com_google_android_gms_internal_zzju, statusCode);
                if (com_google_android_gms_internal_zzju.zzIB != null) {
                    this.mHandler.post(new C02521(this, com_google_android_gms_internal_zzju, statusCode));
                }
            }
        }

        public void zza(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            zzju com_google_android_gms_internal_zzju = (zzju) this.zzKH.get();
            if (com_google_android_gms_internal_zzju != null) {
                com_google_android_gms_internal_zzju.zzKi = applicationMetadata;
                com_google_android_gms_internal_zzju.zzKu = applicationMetadata.getApplicationId();
                com_google_android_gms_internal_zzju.zzKv = str2;
                synchronized (zzju.zzKB) {
                    if (com_google_android_gms_internal_zzju.zzKz != null) {
                        com_google_android_gms_internal_zzju.zzKz.zzd(new zza(new Status(0), applicationMetadata, str, str2, z));
                        com_google_android_gms_internal_zzju.zzKz = null;
                    }
                }
            }
        }

        public void zza(String str, double d, boolean z) {
            zzju.zzKh.zzb("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public void zza(String str, long j) {
            zzju com_google_android_gms_internal_zzju = (zzju) this.zzKH.get();
            if (com_google_android_gms_internal_zzju != null) {
                zza(com_google_android_gms_internal_zzju, j, 0);
            }
        }

        public void zza(String str, long j, int i) {
            zzju com_google_android_gms_internal_zzju = (zzju) this.zzKH.get();
            if (com_google_android_gms_internal_zzju != null) {
                zza(com_google_android_gms_internal_zzju, j, i);
            }
        }

        public void zzai(int i) {
            zzju zzhy = zzhy();
            if (zzhy != null) {
                zzju.zzKh.zzb("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
                if (i != 0) {
                    zzhy.zzaI(2);
                }
            }
        }

        public void zzaj(int i) {
            zzju com_google_android_gms_internal_zzju = (zzju) this.zzKH.get();
            if (com_google_android_gms_internal_zzju != null) {
                synchronized (zzju.zzKB) {
                    if (com_google_android_gms_internal_zzju.zzKz != null) {
                        com_google_android_gms_internal_zzju.zzKz.zzd(new zza(new Status(i)));
                        com_google_android_gms_internal_zzju.zzKz = null;
                    }
                }
            }
        }

        public void zzak(int i) {
            zzju com_google_android_gms_internal_zzju = (zzju) this.zzKH.get();
            if (com_google_android_gms_internal_zzju != null) {
                zza(com_google_android_gms_internal_zzju, i);
            }
        }

        public void zzal(int i) {
            zzju com_google_android_gms_internal_zzju = (zzju) this.zzKH.get();
            if (com_google_android_gms_internal_zzju != null) {
                zza(com_google_android_gms_internal_zzju, i);
            }
        }

        public void zzb(zzjp com_google_android_gms_internal_zzjp) {
            zzju com_google_android_gms_internal_zzju = (zzju) this.zzKH.get();
            if (com_google_android_gms_internal_zzju != null) {
                zzju.zzKh.zzb("onApplicationStatusChanged", new Object[0]);
                this.mHandler.post(new C02543(this, com_google_android_gms_internal_zzju, com_google_android_gms_internal_zzjp));
            }
        }

        public void zzb(zzjw com_google_android_gms_internal_zzjw) {
            zzju com_google_android_gms_internal_zzju = (zzju) this.zzKH.get();
            if (com_google_android_gms_internal_zzju != null) {
                zzju.zzKh.zzb("onDeviceStatusChanged", new Object[0]);
                this.mHandler.post(new C02532(this, com_google_android_gms_internal_zzju, com_google_android_gms_internal_zzjw));
            }
        }

        public void zzb(String str, byte[] bArr) {
            if (((zzju) this.zzKH.get()) != null) {
                zzju.zzKh.zzb("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
            }
        }

        public zzju zzhy() {
            zzju com_google_android_gms_internal_zzju = (zzju) this.zzKH.getAndSet(null);
            if (com_google_android_gms_internal_zzju == null) {
                return null;
            }
            com_google_android_gms_internal_zzju.zzho();
            return com_google_android_gms_internal_zzju;
        }

        public boolean zzhz() {
            return this.zzKH.get() == null;
        }

        public void zzn(String str, String str2) {
            zzju com_google_android_gms_internal_zzju = (zzju) this.zzKH.get();
            if (com_google_android_gms_internal_zzju != null) {
                zzju.zzKh.zzb("Receive (type=text, ns=%s) %s", str, str2);
                this.mHandler.post(new C02554(this, com_google_android_gms_internal_zzju, str, str2));
            }
        }
    }

    static {
        zzKh = new zzkc("CastClientImpl");
        zzKB = new Object();
        zzKC = new Object();
    }

    public zzju(Context context, Looper looper, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, connectionCallbacks, onConnectionFailedListener);
        this.zzKj = castDevice;
        this.zzIB = listener;
        this.zzKl = j;
        this.zzKk = new HashMap();
        this.zzKt = new AtomicLong(0);
        this.zzKx = new HashMap();
        zzho();
        this.zzKy = new zzb();
        registerConnectionFailedListener(this.zzKy);
    }

    private void zza(zzjp com_google_android_gms_internal_zzjp) {
        boolean z;
        String zzhl = com_google_android_gms_internal_zzjp.zzhl();
        if (zzjv.zza(zzhl, this.zzKn)) {
            z = false;
        } else {
            this.zzKn = zzhl;
            z = true;
        }
        zzKh.zzb("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzKo));
        if (this.zzIB != null && (z || this.zzKo)) {
            this.zzIB.onApplicationStatusChanged();
        }
        this.zzKo = false;
    }

    private void zza(zzjw com_google_android_gms_internal_zzjw) {
        boolean z;
        ApplicationMetadata applicationMetadata = com_google_android_gms_internal_zzjw.getApplicationMetadata();
        if (!zzjv.zza(applicationMetadata, this.zzKi)) {
            this.zzKi = applicationMetadata;
            this.zzIB.onApplicationMetadataChanged(this.zzKi);
        }
        double zzhs = com_google_android_gms_internal_zzjw.zzhs();
        if (zzhs == Double.NaN || Math.abs(zzhs - this.zzJm) <= 1.0E-7d) {
            z = false;
        } else {
            this.zzJm = zzhs;
            z = true;
        }
        boolean zzhA = com_google_android_gms_internal_zzjw.zzhA();
        if (zzhA != this.zzJn) {
            this.zzJn = zzhA;
            z = true;
        }
        zzKh.zzb("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzKp));
        if (this.zzIB != null && (z || this.zzKp)) {
            this.zzIB.onVolumeChanged();
        }
        int zzhB = com_google_android_gms_internal_zzjw.zzhB();
        if (zzhB != this.zzKr) {
            this.zzKr = zzhB;
            z = true;
        } else {
            z = false;
        }
        zzKh.zzb("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzKp));
        if (this.zzIB != null && (z || this.zzKp)) {
            this.zzIB.zzab(this.zzKr);
        }
        zzhB = com_google_android_gms_internal_zzjw.zzhC();
        if (zzhB != this.zzKs) {
            this.zzKs = zzhB;
            z = true;
        } else {
            z = false;
        }
        zzKh.zzb("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzKp));
        if (this.zzIB != null && (z || this.zzKp)) {
            this.zzIB.zzac(this.zzKs);
        }
        this.zzKp = false;
    }

    private void zzc(com.google.android.gms.common.api.zza.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) {
        synchronized (zzKB) {
            if (this.zzKz != null) {
                this.zzKz.zzd(new zza(new Status(CastStatusCodes.CANCELED)));
            }
            this.zzKz = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult;
        }
    }

    private void zze(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
        synchronized (zzKC) {
            if (this.zzKA != null) {
                com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status.zzd(new Status(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE));
                return;
            }
            this.zzKA = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status;
        }
    }

    private void zzho() {
        this.zzKq = false;
        this.zzKr = -1;
        this.zzKs = -1;
        this.zzKi = null;
        this.zzKn = null;
        this.zzJm = 0.0d;
        this.zzJn = false;
    }

    private void zzht() {
        zzKh.zzb("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zzKk) {
            this.zzKk.clear();
        }
    }

    private void zzhu() throws IllegalStateException {
        if (!this.zzKq || this.zzKm == null || this.zzKm.zzhz()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void disconnect() {
        /*
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = zzKh;
        r1 = "disconnect(); ServiceListener=%s, isConnected=%b";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = r6.zzKm;
        r2[r4] = r3;
        r3 = r6.isConnected();
        r3 = java.lang.Boolean.valueOf(r3);
        r2[r5] = r3;
        r0.zzb(r1, r2);
        r0 = r6.zzKm;
        r1 = 0;
        r6.zzKm = r1;
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r0 = r0.zzhy();
        if (r0 != 0) goto L_0x0031;
    L_0x0027:
        r0 = zzKh;
        r1 = "already disposed, so short-circuiting";
        r2 = new java.lang.Object[r4];
        r0.zzb(r1, r2);
    L_0x0030:
        return;
    L_0x0031:
        r6.zzht();
        r0 = r6.isConnected();	 Catch:{ RemoteException -> 0x004d }
        if (r0 != 0) goto L_0x0040;
    L_0x003a:
        r0 = r6.isConnecting();	 Catch:{ RemoteException -> 0x004d }
        if (r0 == 0) goto L_0x0049;
    L_0x0040:
        r0 = r6.zzjb();	 Catch:{ RemoteException -> 0x004d }
        r0 = (com.google.android.gms.internal.zzjz) r0;	 Catch:{ RemoteException -> 0x004d }
        r0.disconnect();	 Catch:{ RemoteException -> 0x004d }
    L_0x0049:
        super.disconnect();
        goto L_0x0030;
    L_0x004d:
        r0 = move-exception;
        r1 = zzKh;	 Catch:{ all -> 0x0063 }
        r2 = "Error while disconnecting the controller interface: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0063 }
        r4 = 0;
        r5 = r0.getMessage();	 Catch:{ all -> 0x0063 }
        r3[r4] = r5;	 Catch:{ all -> 0x0063 }
        r1.zza(r0, r2, r3);	 Catch:{ all -> 0x0063 }
        super.disconnect();
        goto L_0x0030;
    L_0x0063:
        r0 = move-exception;
        super.disconnect();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzju.disconnect():void");
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        zzhu();
        return this.zzKi;
    }

    public String getApplicationStatus() throws IllegalStateException {
        zzhu();
        return this.zzKn;
    }

    public boolean isMute() throws IllegalStateException {
        zzhu();
        return this.zzJn;
    }

    public void zzL(boolean z) throws IllegalStateException, RemoteException {
        ((zzjz) zzjb()).zza(z, this.zzJm, this.zzJn);
    }

    protected zzjz zzO(IBinder iBinder) {
        return com.google.android.gms.internal.zzjz.zza.zzP(iBinder);
    }

    public void zza(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((zzjz) zzjb()).zza(d, this.zzJm, this.zzJn);
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle) {
        zzKh.zzb("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_1) {
            this.zzKq = true;
            this.zzKo = true;
            this.zzKp = true;
        } else {
            this.zzKq = false;
        }
        if (i == Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_1) {
            this.zzKw = new Bundle();
            this.zzKw.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.zza(i, iBinder, bundle);
    }

    public void zza(String str, MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        zzjv.zzaK(str);
        zzaJ(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zzKk) {
                this.zzKk.put(str, messageReceivedCallback);
            }
            ((zzjz) zzjb()).zzaN(str);
        }
    }

    public void zza(String str, LaunchOptions launchOptions, com.google.android.gms.common.api.zza.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        zzc((com.google.android.gms.common.api.zza.zzb) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        ((zzjz) zzjb()).zza(str, launchOptions);
    }

    public void zza(String str, com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) throws IllegalStateException, RemoteException {
        zze((com.google.android.gms.common.api.zza.zzb) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
        ((zzjz) zzjb()).zzaM(str);
    }

    public void zza(String str, String str2, com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            zzjv.zzaK(str);
            zzhu();
            long incrementAndGet = this.zzKt.incrementAndGet();
            try {
                this.zzKx.put(Long.valueOf(incrementAndGet), com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
                ((zzjz) zzjb()).zza(str, str2, incrementAndGet);
            } catch (Throwable th) {
                this.zzKx.remove(Long.valueOf(incrementAndGet));
            }
        }
    }

    public void zza(String str, boolean z, com.google.android.gms.common.api.zza.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        zzc((com.google.android.gms.common.api.zza.zzb) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        ((zzjz) zzjb()).zzf(str, z);
    }

    public void zzaJ(String str) throws IllegalArgumentException, RemoteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.zzKk) {
            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.zzKk.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((zzjz) zzjb()).zzaO(str);
            } catch (Throwable e) {
                zzKh.zza(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public void zzb(String str, String str2, com.google.android.gms.common.api.zza.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        zzc((com.google.android.gms.common.api.zza.zzb) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        ((zzjz) zzjb()).zzo(str, str2);
    }

    protected String zzcF() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String zzcG() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    public void zzd(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) throws IllegalStateException, RemoteException {
        zze((com.google.android.gms.common.api.zza.zzb) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
        ((zzjz) zzjb()).zzhD();
    }

    public Bundle zzhp() {
        if (this.zzKw == null) {
            return super.zzhp();
        }
        Bundle bundle = this.zzKw;
        this.zzKw = null;
        return bundle;
    }

    protected Bundle zzhq() {
        Bundle bundle = new Bundle();
        zzKh.zzb("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.zzKu, this.zzKv);
        this.zzKj.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzKl);
        this.zzKm = new zzc(this);
        bundle.putParcelable("listener", new BinderWrapper(this.zzKm.asBinder()));
        if (this.zzKu != null) {
            bundle.putString("last_application_id", this.zzKu);
            if (this.zzKv != null) {
                bundle.putString("last_session_id", this.zzKv);
            }
        }
        return bundle;
    }

    public void zzhr() throws IllegalStateException, RemoteException {
        ((zzjz) zzjb()).zzhr();
    }

    public double zzhs() throws IllegalStateException {
        zzhu();
        return this.zzJm;
    }

    protected /* synthetic */ IInterface zzp(IBinder iBinder) {
        return zzO(iBinder);
    }
}
