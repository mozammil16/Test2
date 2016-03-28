package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.android.gms.tagmanager.DataLayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@zzgi
public class zzeq extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private final zzic zzmu;
    private final MediaController zzuA;
    private final zza zzuB;
    private final VideoView zzuC;
    private long zzuD;
    private String zzuE;

    private static final class zza {
        private final Runnable zzmG;
        private volatile boolean zzuF;

        /* renamed from: com.google.android.gms.internal.zzeq.zza.1 */
        class C02141 implements Runnable {
            private final WeakReference<zzeq> zzuG;
            final /* synthetic */ zzeq zzuH;
            final /* synthetic */ zza zzuI;

            C02141(zza com_google_android_gms_internal_zzeq_zza, zzeq com_google_android_gms_internal_zzeq) {
                this.zzuI = com_google_android_gms_internal_zzeq_zza;
                this.zzuH = com_google_android_gms_internal_zzeq;
                this.zzuG = new WeakReference(this.zzuH);
            }

            public void run() {
                zzeq com_google_android_gms_internal_zzeq = (zzeq) this.zzuG.get();
                if (!this.zzuI.zzuF && com_google_android_gms_internal_zzeq != null) {
                    com_google_android_gms_internal_zzeq.zzdp();
                    this.zzuI.zzdq();
                }
            }
        }

        public zza(zzeq com_google_android_gms_internal_zzeq) {
            this.zzuF = false;
            this.zzmG = new C02141(this, com_google_android_gms_internal_zzeq);
        }

        public void cancel() {
            this.zzuF = true;
            zzhw.zzzG.removeCallbacks(this.zzmG);
        }

        public void zzdq() {
            zzhw.zzzG.postDelayed(this.zzmG, 250);
        }
    }

    public zzeq(Context context, zzic com_google_android_gms_internal_zzic) {
        super(context);
        this.zzmu = com_google_android_gms_internal_zzic;
        this.zzuC = new VideoView(context);
        addView(this.zzuC, new LayoutParams(-1, -1, 17));
        this.zzuA = new MediaController(context);
        this.zzuB = new zza(this);
        this.zzuB.zzdq();
        this.zzuC.setOnCompletionListener(this);
        this.zzuC.setOnPreparedListener(this);
        this.zzuC.setOnErrorListener(this);
    }

    private static void zza(zzic com_google_android_gms_internal_zzic, String str) {
        zza(com_google_android_gms_internal_zzic, str, new HashMap(1));
    }

    public static void zza(zzic com_google_android_gms_internal_zzic, String str, String str2) {
        Object obj = str2 == null ? 1 : null;
        Map hashMap = new HashMap(obj != null ? 2 : 3);
        hashMap.put("what", str);
        if (obj == null) {
            hashMap.put("extra", str2);
        }
        zza(com_google_android_gms_internal_zzic, "error", hashMap);
    }

    private static void zza(zzic com_google_android_gms_internal_zzic, String str, String str2, String str3) {
        Map hashMap = new HashMap(2);
        hashMap.put(str2, str3);
        zza(com_google_android_gms_internal_zzic, str, hashMap);
    }

    private static void zza(zzic com_google_android_gms_internal_zzic, String str, Map<String, String> map) {
        map.put(DataLayer.EVENT_KEY, str);
        com_google_android_gms_internal_zzic.zzb("onVideoEvent", (Map) map);
    }

    public void destroy() {
        this.zzuB.cancel();
        this.zzuC.stopPlayback();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        zza(this.zzmu, "ended");
    }

    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        zza(this.zzmu, String.valueOf(what), String.valueOf(extra));
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        zza(this.zzmu, "canplaythrough", "duration", String.valueOf(((float) this.zzuC.getDuration()) / 1000.0f));
    }

    public void pause() {
        this.zzuC.pause();
    }

    public void play() {
        this.zzuC.start();
    }

    public void seekTo(int timeInMilliseconds) {
        this.zzuC.seekTo(timeInMilliseconds);
    }

    public void zzK(String str) {
        this.zzuE = str;
    }

    public void zzb(MotionEvent motionEvent) {
        this.zzuC.dispatchTouchEvent(motionEvent);
    }

    public void zzdo() {
        if (TextUtils.isEmpty(this.zzuE)) {
            zza(this.zzmu, "no_src", null);
        } else {
            this.zzuC.setVideoPath(this.zzuE);
        }
    }

    public void zzdp() {
        long currentPosition = (long) this.zzuC.getCurrentPosition();
        if (this.zzuD != currentPosition) {
            zza(this.zzmu, "timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
            this.zzuD = currentPosition;
        }
    }

    public void zzu(boolean z) {
        if (z) {
            this.zzuC.setMediaController(this.zzuA);
            return;
        }
        this.zzuA.hide();
        this.zzuC.setMediaController(null);
    }
}
