package com.google.android.gms.internal;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzgi
public class zzeb extends zzeg {
    static final Set<String> zztg;
    private int zzli;
    private int zzlj;
    private final zzic zzmu;
    private final Object zznh;
    private zzba zzsF;
    private String zzth;
    private boolean zzti;
    private int zztj;
    private int zztk;
    private int zztl;
    private int zztm;
    private final Activity zztn;
    private ImageView zzto;
    private LinearLayout zztp;
    private zzeh zztq;
    private PopupWindow zztr;
    private RelativeLayout zzts;
    private ViewGroup zztt;

    /* renamed from: com.google.android.gms.internal.zzeb.1 */
    class C02101 implements OnClickListener {
        final /* synthetic */ zzeb zztu;

        C02101(zzeb com_google_android_gms_internal_zzeb) {
            this.zztu = com_google_android_gms_internal_zzeb;
        }

        public void onClick(View view) {
            this.zztu.zzm(true);
        }
    }

    static {
        zztg = new HashSet(Arrays.asList(new String[]{"top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"}));
    }

    public zzeb(zzic com_google_android_gms_internal_zzic, zzeh com_google_android_gms_internal_zzeh) {
        super(com_google_android_gms_internal_zzic, "resize");
        this.zzth = "top-right";
        this.zzti = true;
        this.zztj = 0;
        this.zztk = 0;
        this.zzlj = -1;
        this.zztl = 0;
        this.zztm = 0;
        this.zzli = -1;
        this.zznh = new Object();
        this.zzmu = com_google_android_gms_internal_zzic;
        this.zztn = com_google_android_gms_internal_zzic.zzeD();
        this.zztq = com_google_android_gms_internal_zzeh;
    }

    private int[] zzcO() {
        if (!zzcQ()) {
            return null;
        }
        if (this.zzti) {
            return new int[]{this.zztj + this.zztl, this.zztk + this.zztm};
        }
        int[] zzh = zzab.zzaM().zzh(this.zztn);
        int[] zzj = zzab.zzaM().zzj(this.zztn);
        int i = zzh[0];
        int i2 = this.zztj + this.zztl;
        int i3 = this.zztk + this.zztm;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.zzli + i2 > i) {
            i2 = i - this.zzli;
        }
        if (i3 < zzj[0]) {
            i3 = zzj[0];
        } else if (this.zzlj + i3 > zzj[1]) {
            i3 = zzj[1] - this.zzlj;
        }
        return new int[]{i2, i3};
    }

    private void zzf(Map<String, String> map) {
        if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
            this.zzli = zzab.zzaM().zzT((String) map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
            this.zzlj = zzab.zzaM().zzT((String) map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
            this.zztl = zzab.zzaM().zzT((String) map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
            this.zztm = zzab.zzaM().zzT((String) map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
            this.zzti = Boolean.parseBoolean((String) map.get("allowOffscreen"));
        }
        String str = (String) map.get("customClosePosition");
        if (!TextUtils.isEmpty(str)) {
            this.zzth = str;
        }
    }

    public void zzb(int i, int i2) {
        synchronized (this.zznh) {
            this.zztj = i;
            this.zztk = i2;
            if (this.zztr != null) {
                int[] zzcO = zzcO();
                if (zzcO != null) {
                    this.zztr.update(zzbe.zzbD().zzb(this.zztn, zzcO[0]), zzbe.zzbD().zzb(this.zztn, zzcO[1]), this.zztr.getWidth(), this.zztr.getHeight());
                    zzd(zzcO[0], zzcO[1]);
                } else {
                    zzm(true);
                }
            }
        }
    }

    void zzc(int i, int i2) {
        if (this.zztq != null) {
            this.zztq.zza(i, i2, this.zzli, this.zzlj);
        }
    }

    boolean zzcN() {
        return this.zzli > -1 && this.zzlj > -1;
    }

    public boolean zzcP() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zztr != null;
        }
        return z;
    }

    boolean zzcQ() {
        int[] zzh = zzab.zzaM().zzh(this.zztn);
        int[] zzj = zzab.zzaM().zzj(this.zztn);
        int i = zzh[0];
        int i2 = zzh[1];
        if (this.zzli < 50 || this.zzli > i) {
            zzhx.zzac("Width is too small or too large.");
            return false;
        } else if (this.zzlj < 50 || this.zzlj > i2) {
            zzhx.zzac("Height is too small or too large.");
            return false;
        } else if (this.zzlj == i2 && this.zzli == i) {
            zzhx.zzac("Cannot resize to a full-screen ad.");
            return false;
        } else {
            if (this.zzti) {
                int i3;
                String str = this.zzth;
                boolean z = true;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            z = false;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        i3 = this.zztl + this.zztj;
                        i2 = this.zztk + this.zztm;
                        break;
                    case CompletionEvent.STATUS_FAILURE /*1*/:
                        i3 = ((this.zztj + this.zztl) + (this.zzli / 2)) - 25;
                        i2 = this.zztk + this.zztm;
                        break;
                    case CompletionEvent.STATUS_CONFLICT /*2*/:
                        i3 = ((this.zztj + this.zztl) + (this.zzli / 2)) - 25;
                        i2 = ((this.zztk + this.zztm) + (this.zzlj / 2)) - 25;
                        break;
                    case CompletionEvent.STATUS_CANCELED /*3*/:
                        i3 = this.zztl + this.zztj;
                        i2 = ((this.zztk + this.zztm) + this.zzlj) - 50;
                        break;
                    case Place.TYPE_AQUARIUM /*4*/:
                        i3 = ((this.zztj + this.zztl) + (this.zzli / 2)) - 25;
                        i2 = ((this.zztk + this.zztm) + this.zzlj) - 50;
                        break;
                    case Place.TYPE_ART_GALLERY /*5*/:
                        i3 = ((this.zztj + this.zztl) + this.zzli) - 50;
                        i2 = ((this.zztk + this.zztm) + this.zzlj) - 50;
                        break;
                    default:
                        i3 = ((this.zztj + this.zztl) + this.zzli) - 50;
                        i2 = this.zztk + this.zztm;
                        break;
                }
                if (i3 < 0 || i3 + 50 > i || r2 < zzj[0] || r2 + 50 > zzj[1]) {
                    return false;
                }
            }
            return true;
        }
    }

    void zzd(int i, int i2) {
        zzb(i, i2 - zzab.zzaM().zzj(this.zztn)[0], this.zzli, this.zzlj);
    }

    public void zze(int i, int i2) {
        this.zztj = i;
        this.zztk = i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzg(java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
        r12 = this;
        r4 = -1;
        r5 = 1;
        r3 = 0;
        r6 = r12.zznh;
        monitor-enter(r6);
        r1 = r12.zztn;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0011;
    L_0x000a:
        r1 = "Not an activity context. Cannot resize.";
        r12.zzH(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
    L_0x0010:
        return;
    L_0x0011:
        r1 = r12.zzmu;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzad();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0023;
    L_0x0019:
        r1 = "Webview is not yet available, size is not set.";
        r12.zzH(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0020:
        r1 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        throw r1;
    L_0x0023:
        r1 = r12.zzmu;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzad();	 Catch:{ all -> 0x0020 }
        r1 = r1.zzpb;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0034;
    L_0x002d:
        r1 = "Is interstitial. Cannot resize an interstitial.";
        r12.zzH(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0034:
        r1 = r12.zzmu;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzeK();	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0043;
    L_0x003c:
        r1 = "Cannot resize an expanded banner.";
        r12.zzH(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0043:
        r12.zzf(r13);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzcN();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0053;
    L_0x004c:
        r1 = "Invalid width and height options. Cannot resize.";
        r12.zzH(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0053:
        r1 = r12.zztn;	 Catch:{ all -> 0x0020 }
        r7 = r1.getWindow();	 Catch:{ all -> 0x0020 }
        if (r7 == 0) goto L_0x0061;
    L_0x005b:
        r1 = r7.getDecorView();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0068;
    L_0x0061:
        r1 = "Activity context is not ready, cannot get window or decor view.";
        r12.zzH(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0068:
        r8 = r12.zzcO();	 Catch:{ all -> 0x0020 }
        if (r8 != 0) goto L_0x0075;
    L_0x006e:
        r1 = "Resize location out of screen or close button is not visible.";
        r12.zzH(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0075:
        r1 = com.google.android.gms.internal.zzbe.zzbD();	 Catch:{ all -> 0x0020 }
        r2 = r12.zztn;	 Catch:{ all -> 0x0020 }
        r9 = r12.zzli;	 Catch:{ all -> 0x0020 }
        r9 = r1.zzb(r2, r9);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.internal.zzbe.zzbD();	 Catch:{ all -> 0x0020 }
        r2 = r12.zztn;	 Catch:{ all -> 0x0020 }
        r10 = r12.zzlj;	 Catch:{ all -> 0x0020 }
        r10 = r1.zzb(r2, r10);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzmu;	 Catch:{ all -> 0x0020 }
        r1 = r1.getWebView();	 Catch:{ all -> 0x0020 }
        r2 = r1.getParent();	 Catch:{ all -> 0x0020 }
        if (r2 == 0) goto L_0x01d5;
    L_0x0099:
        r1 = r2 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x01d5;
    L_0x009d:
        r0 = r2;
        r0 = (android.view.ViewGroup) r0;	 Catch:{ all -> 0x0020 }
        r1 = r0;
        r11 = r12.zzmu;	 Catch:{ all -> 0x0020 }
        r11 = r11.getWebView();	 Catch:{ all -> 0x0020 }
        r1.removeView(r11);	 Catch:{ all -> 0x0020 }
        r1 = r12.zztr;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01ce;
    L_0x00ae:
        r2 = (android.view.ViewGroup) r2;	 Catch:{ all -> 0x0020 }
        r12.zztt = r2;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.internal.zzab.zzaM();	 Catch:{ all -> 0x0020 }
        r2 = r12.zzmu;	 Catch:{ all -> 0x0020 }
        r2 = r2.getWebView();	 Catch:{ all -> 0x0020 }
        r1 = r1.zzh(r2);	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.ImageView;	 Catch:{ all -> 0x0020 }
        r11 = r12.zztn;	 Catch:{ all -> 0x0020 }
        r2.<init>(r11);	 Catch:{ all -> 0x0020 }
        r12.zzto = r2;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzto;	 Catch:{ all -> 0x0020 }
        r2.setImageBitmap(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzmu;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzad();	 Catch:{ all -> 0x0020 }
        r12.zzsF = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.zztt;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzto;	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
    L_0x00dd:
        r1 = new android.widget.RelativeLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.zztn;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.zzts = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.zzts;	 Catch:{ all -> 0x0020 }
        r2 = 0;
        r1.setBackgroundColor(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzts;	 Catch:{ all -> 0x0020 }
        r2 = new android.view.ViewGroup$LayoutParams;	 Catch:{ all -> 0x0020 }
        r2.<init>(r9, r10);	 Catch:{ all -> 0x0020 }
        r1.setLayoutParams(r2);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.internal.zzab.zzaM();	 Catch:{ all -> 0x0020 }
        r2 = r12.zzts;	 Catch:{ all -> 0x0020 }
        r11 = 0;
        r1 = r1.zza(r2, r9, r10, r11);	 Catch:{ all -> 0x0020 }
        r12.zztr = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.zztr;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setOutsideTouchable(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zztr;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setTouchable(r2);	 Catch:{ all -> 0x0020 }
        r2 = r12.zztr;	 Catch:{ all -> 0x0020 }
        r1 = r12.zzti;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01dd;
    L_0x0115:
        r1 = r5;
    L_0x0116:
        r2.setClippingEnabled(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzts;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzmu;	 Catch:{ all -> 0x0020 }
        r2 = r2.getWebView();	 Catch:{ all -> 0x0020 }
        r9 = -1;
        r10 = -1;
        r1.addView(r2, r9, r10);	 Catch:{ all -> 0x0020 }
        r1 = new android.widget.LinearLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.zztn;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.zztp = r1;	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.RelativeLayout$LayoutParams;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.internal.zzbe.zzbD();	 Catch:{ all -> 0x0020 }
        r9 = r12.zztn;	 Catch:{ all -> 0x0020 }
        r10 = 50;
        r1 = r1.zzb(r9, r10);	 Catch:{ all -> 0x0020 }
        r9 = com.google.android.gms.internal.zzbe.zzbD();	 Catch:{ all -> 0x0020 }
        r10 = r12.zztn;	 Catch:{ all -> 0x0020 }
        r11 = 50;
        r9 = r9.zzb(r10, r11);	 Catch:{ all -> 0x0020 }
        r2.<init>(r1, r9);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzth;	 Catch:{ all -> 0x0020 }
        r9 = r1.hashCode();	 Catch:{ all -> 0x0020 }
        switch(r9) {
            case -1364013995: goto L_0x01f6;
            case -1012429441: goto L_0x01e0;
            case -655373719: goto L_0x0201;
            case 1163912186: goto L_0x0217;
            case 1288627767: goto L_0x020c;
            case 1755462605: goto L_0x01eb;
            default: goto L_0x0155;
        };	 Catch:{ all -> 0x0020 }
    L_0x0155:
        r1 = r4;
    L_0x0156:
        switch(r1) {
            case 0: goto L_0x0222;
            case 1: goto L_0x022e;
            case 2: goto L_0x023a;
            case 3: goto L_0x0241;
            case 4: goto L_0x024d;
            case 5: goto L_0x0259;
            default: goto L_0x0159;
        };	 Catch:{ all -> 0x0020 }
    L_0x0159:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
    L_0x0163:
        r1 = r12.zztp;	 Catch:{ all -> 0x0020 }
        r3 = new com.google.android.gms.internal.zzeb$1;	 Catch:{ all -> 0x0020 }
        r3.<init>(r12);	 Catch:{ all -> 0x0020 }
        r1.setOnClickListener(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.zztp;	 Catch:{ all -> 0x0020 }
        r3 = "Close button";
        r1.setContentDescription(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzts;	 Catch:{ all -> 0x0020 }
        r3 = r12.zztp;	 Catch:{ all -> 0x0020 }
        r1.addView(r3, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zztr;	 Catch:{ RuntimeException -> 0x0265 }
        r2 = r7.getDecorView();	 Catch:{ RuntimeException -> 0x0265 }
        r3 = 0;
        r4 = com.google.android.gms.internal.zzbe.zzbD();	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r12.zztn;	 Catch:{ RuntimeException -> 0x0265 }
        r7 = 0;
        r7 = r8[r7];	 Catch:{ RuntimeException -> 0x0265 }
        r4 = r4.zzb(r5, r7);	 Catch:{ RuntimeException -> 0x0265 }
        r5 = com.google.android.gms.internal.zzbe.zzbD();	 Catch:{ RuntimeException -> 0x0265 }
        r7 = r12.zztn;	 Catch:{ RuntimeException -> 0x0265 }
        r9 = 1;
        r9 = r8[r9];	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r5.zzb(r7, r9);	 Catch:{ RuntimeException -> 0x0265 }
        r1.showAtLocation(r2, r3, r4, r5);	 Catch:{ RuntimeException -> 0x0265 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.zzc(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzmu;	 Catch:{ all -> 0x0020 }
        r2 = new com.google.android.gms.internal.zzba;	 Catch:{ all -> 0x0020 }
        r3 = r12.zztn;	 Catch:{ all -> 0x0020 }
        r4 = new com.google.android.gms.ads.AdSize;	 Catch:{ all -> 0x0020 }
        r5 = r12.zzli;	 Catch:{ all -> 0x0020 }
        r7 = r12.zzlj;	 Catch:{ all -> 0x0020 }
        r4.<init>(r5, r7);	 Catch:{ all -> 0x0020 }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x0020 }
        r1.zza(r2);	 Catch:{ all -> 0x0020 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.zzd(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = "resized";
        r12.zzJ(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01ce:
        r1 = r12.zztr;	 Catch:{ all -> 0x0020 }
        r1.dismiss();	 Catch:{ all -> 0x0020 }
        goto L_0x00dd;
    L_0x01d5:
        r1 = "Webview is detached, probably in the middle of a resize or expand.";
        r12.zzH(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01dd:
        r1 = r3;
        goto L_0x0116;
    L_0x01e0:
        r5 = "top-left";
        r1 = r1.equals(r5);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01e8:
        r1 = r3;
        goto L_0x0156;
    L_0x01eb:
        r3 = "top-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01f3:
        r1 = r5;
        goto L_0x0156;
    L_0x01f6:
        r3 = "center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01fe:
        r1 = 2;
        goto L_0x0156;
    L_0x0201:
        r3 = "bottom-left";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0209:
        r1 = 3;
        goto L_0x0156;
    L_0x020c:
        r3 = "bottom-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0214:
        r1 = 4;
        goto L_0x0156;
    L_0x0217:
        r3 = "bottom-right";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x021f:
        r1 = 5;
        goto L_0x0156;
    L_0x0222:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x022e:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x023a:
        r1 = 13;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0241:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x024d:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0259:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0265:
        r1 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0020 }
        r2.<init>();	 Catch:{ all -> 0x0020 }
        r3 = "Cannot show popup window: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0020 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0020 }
        r1 = r2.append(r1);	 Catch:{ all -> 0x0020 }
        r1 = r1.toString();	 Catch:{ all -> 0x0020 }
        r12.zzH(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzts;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzmu;	 Catch:{ all -> 0x0020 }
        r2 = r2.getWebView();	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zztt;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x02a8;
    L_0x028f:
        r1 = r12.zztt;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzto;	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zztt;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzmu;	 Catch:{ all -> 0x0020 }
        r2 = r2.getWebView();	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzmu;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzsF;	 Catch:{ all -> 0x0020 }
        r1.zza(r2);	 Catch:{ all -> 0x0020 }
    L_0x02a8:
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeb.zzg(java.util.Map):void");
    }

    public void zzm(boolean z) {
        synchronized (this.zznh) {
            if (this.zztr != null) {
                this.zztr.dismiss();
                this.zzts.removeView(this.zzmu.getWebView());
                if (this.zztt != null) {
                    this.zztt.removeView(this.zzto);
                    this.zztt.addView(this.zzmu.getWebView());
                    this.zzmu.zza(this.zzsF);
                }
                if (z) {
                    zzJ("default");
                    if (this.zztq != null) {
                        this.zztq.zzam();
                    }
                }
                this.zztr = null;
                this.zzts = null;
                this.zztt = null;
                this.zztp = null;
            }
        }
    }
}
