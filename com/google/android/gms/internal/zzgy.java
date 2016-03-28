package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.Future;

@zzgi
public final class zzgy {
    zzic zzmu;
    private final Object zznh;
    public final zzcv zzxA;
    private String zzxv;
    private String zzxw;
    private zzhq<zzha> zzxx;
    zzia<zzah> zzxy;
    public final zzcv zzxz;

    /* renamed from: com.google.android.gms.internal.zzgy.1 */
    class C04081 implements zzcv {
        final /* synthetic */ zzgy zzxB;

        C04081(zzgy com_google_android_gms_internal_zzgy) {
            this.zzxB = com_google_android_gms_internal_zzgy;
        }

        public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
            synchronized (this.zzxB.zznh) {
                if (this.zzxB.zzxx.isDone()) {
                } else if (this.zzxB.zzxv.equals(map.get("request_id"))) {
                    zzha com_google_android_gms_internal_zzha = new zzha(1, map);
                    zzhx.zzac("Invalid " + com_google_android_gms_internal_zzha.getType() + " request error: " + com_google_android_gms_internal_zzha.zzdU());
                    this.zzxB.zzxx.zzb(com_google_android_gms_internal_zzha);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgy.2 */
    class C04092 implements zzcv {
        final /* synthetic */ zzgy zzxB;

        C04092(zzgy com_google_android_gms_internal_zzgy) {
            this.zzxB = com_google_android_gms_internal_zzgy;
        }

        public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
            synchronized (this.zzxB.zznh) {
                if (this.zzxB.zzxx.isDone()) {
                    return;
                }
                zzha com_google_android_gms_internal_zzha = new zzha(-2, map);
                if (this.zzxB.zzxv.equals(com_google_android_gms_internal_zzha.getRequestId())) {
                    String url = com_google_android_gms_internal_zzha.getUrl();
                    if (url == null) {
                        zzhx.zzac("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (url.contains("%40mediation_adapters%40")) {
                        String replaceAll = url.replaceAll("%40mediation_adapters%40", zzhk.zza(com_google_android_gms_internal_zzic.getContext(), (String) map.get("check_adapters"), this.zzxB.zzxw));
                        com_google_android_gms_internal_zzha.setUrl(replaceAll);
                        zzhx.zzab("Ad request URL modified to " + replaceAll);
                    }
                    this.zzxB.zzxx.zzb(com_google_android_gms_internal_zzha);
                    return;
                }
                zzhx.zzac(com_google_android_gms_internal_zzha.getRequestId() + " ==== " + this.zzxB.zzxv);
            }
        }
    }

    public zzgy(String str, String str2) {
        this.zznh = new Object();
        this.zzxx = new zzhq();
        this.zzxz = new C04081(this);
        this.zzxA = new C04092(this);
        this.zzxw = str2;
        this.zzxv = str;
    }

    public void zza(zzic com_google_android_gms_internal_zzic) {
        this.zzmu = com_google_android_gms_internal_zzic;
    }

    public zzia<zzah> zzdR() {
        return this.zzxy;
    }

    public Future<zzha> zzdS() {
        return this.zzxx;
    }

    public void zzdT() {
        if (this.zzmu != null) {
            this.zzmu.destroy();
            this.zzmu = null;
        }
    }

    public void zze(zzia<zzah> com_google_android_gms_internal_zzia_com_google_android_gms_internal_zzah) {
        this.zzxy = com_google_android_gms_internal_zzia_com_google_android_gms_internal_zzah;
    }
}
