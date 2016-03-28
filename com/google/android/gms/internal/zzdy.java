package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@zzgi
public final class zzdy<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzdt zzsS;

    /* renamed from: com.google.android.gms.internal.zzdy.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ zzdy zzsV;
        final /* synthetic */ ErrorCode zzsW;

        AnonymousClass10(zzdy com_google_android_gms_internal_zzdy, ErrorCode errorCode) {
            this.zzsV = com_google_android_gms_internal_zzdy;
            this.zzsW = errorCode;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdFailedToLoad(zzdz.zza(this.zzsW));
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy.1 */
    class C01981 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C01981(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdClicked();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy.2 */
    class C01992 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C01992(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdOpened();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy.3 */
    class C02003 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C02003(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdLoaded();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy.4 */
    class C02014 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C02014(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdClosed();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy.5 */
    class C02025 implements Runnable {
        final /* synthetic */ zzdy zzsV;
        final /* synthetic */ ErrorCode zzsW;

        C02025(zzdy com_google_android_gms_internal_zzdy, ErrorCode errorCode) {
            this.zzsV = com_google_android_gms_internal_zzdy;
            this.zzsW = errorCode;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdFailedToLoad(zzdz.zza(this.zzsW));
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy.6 */
    class C02036 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C02036(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdLeftApplication();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy.7 */
    class C02047 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C02047(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdOpened();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy.8 */
    class C02058 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C02058(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdLoaded();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdy.9 */
    class C02069 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C02069(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdClosed();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    public zzdy(zzdt com_google_android_gms_internal_zzdt) {
        this.zzsS = com_google_android_gms_internal_zzdt;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onClick.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdClicked();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClicked.", e);
                return;
            }
        }
        zzhx.zzac("onClick must be called on the main UI thread.");
        zzhw.zzzG.post(new C01981(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onDismissScreen.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdClosed();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzhx.zzac("onDismissScreen must be called on the main UI thread.");
        zzhw.zzzG.post(new C02014(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzhx.zzY("Adapter called onDismissScreen.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdClosed();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzhx.zzac("onDismissScreen must be called on the main UI thread.");
        zzhw.zzzG.post(new C02069(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, ErrorCode errorCode) {
        zzhx.zzY("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdFailedToLoad(zzdz.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzhx.zzac("onFailedToReceiveAd must be called on the main UI thread.");
        zzhw.zzzG.post(new C02025(this, errorCode));
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode) {
        zzhx.zzY("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdFailedToLoad(zzdz.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzhx.zzac("onFailedToReceiveAd must be called on the main UI thread.");
        zzhw.zzzG.post(new AnonymousClass10(this, errorCode));
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onLeaveApplication.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzhx.zzac("onLeaveApplication must be called on the main UI thread.");
        zzhw.zzzG.post(new C02036(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzhx.zzY("Adapter called onLeaveApplication.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzhx.zzac("onLeaveApplication must be called on the main UI thread.");
        zzhw.zzzG.post(new Runnable() {
            final /* synthetic */ zzdy zzsV;

            {
                this.zzsV = r1;
            }

            public void run() {
                try {
                    this.zzsV.zzsS.onAdLeftApplication();
                } catch (Throwable e) {
                    zzhx.zzd("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onPresentScreen.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdOpened();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzhx.zzac("onPresentScreen must be called on the main UI thread.");
        zzhw.zzzG.post(new C02047(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzhx.zzY("Adapter called onPresentScreen.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdOpened();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzhx.zzac("onPresentScreen must be called on the main UI thread.");
        zzhw.zzzG.post(new C01992(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onReceivedAd.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzhx.zzac("onReceivedAd must be called on the main UI thread.");
        zzhw.zzzG.post(new C02058(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzhx.zzY("Adapter called onReceivedAd.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzhx.zzac("onReceivedAd must be called on the main UI thread.");
        zzhw.zzzG.post(new C02003(this));
    }
}
