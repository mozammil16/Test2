package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.PlusShare;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public class zzgt implements Callable<zzhe> {
    private final Context mContext;
    private final Object zznh;
    private final zzt zzrv;
    private final com.google.android.gms.internal.zzhe.zza zzvN;
    private int zzvR;
    private final zzht zzwV;
    private final zzai zzwW;
    private boolean zzwX;
    private List<String> zzwY;

    public interface zza<T extends com.google.android.gms.internal.zzcn.zza> {
        T zza(zzgt com_google_android_gms_internal_zzgt, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException;
    }

    class zzb {
        final /* synthetic */ zzgt zzxc;
        public zzcv zzxe;

        zzb(zzgt com_google_android_gms_internal_zzgt) {
            this.zzxc = com_google_android_gms_internal_zzgt;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgt.1 */
    class C04011 implements zzcv {
        final /* synthetic */ zzah zzwZ;
        final /* synthetic */ zzb zzxa;
        final /* synthetic */ zzhq zzxb;
        final /* synthetic */ zzgt zzxc;

        C04011(zzgt com_google_android_gms_internal_zzgt, zzah com_google_android_gms_internal_zzah, zzb com_google_android_gms_internal_zzgt_zzb, zzhq com_google_android_gms_internal_zzhq) {
            this.zzxc = com_google_android_gms_internal_zzgt;
            this.zzwZ = com_google_android_gms_internal_zzah;
            this.zzxa = com_google_android_gms_internal_zzgt_zzb;
            this.zzxb = com_google_android_gms_internal_zzhq;
        }

        public void zza(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
            this.zzwZ.zzb("/nativeAdPreProcess", this.zzxa.zzxe);
            try {
                String str = (String) map.get("success");
                if (!TextUtils.isEmpty(str)) {
                    this.zzxb.zzb(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                    return;
                }
            } catch (Throwable e) {
                zzhx.zzb("Malformed native JSON response.", e);
            }
            this.zzxc.zzx(0);
            zzx.zza(this.zzxc.zzdO(), (Object) "Unable to set the ad state error!");
            this.zzxb.zzb(null);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgt.2 */
    class C04022 implements com.google.android.gms.internal.zzht.zza<Drawable> {
        final /* synthetic */ zzgt zzxc;
        final /* synthetic */ boolean zzxd;

        C04022(zzgt com_google_android_gms_internal_zzgt, boolean z) {
            this.zzxc = com_google_android_gms_internal_zzgt;
            this.zzxd = z;
        }

        public Drawable zza(InputStream inputStream) {
            byte[] zzd;
            try {
                zzd = zzlz.zzd(inputStream);
            } catch (IOException e) {
                zzd = null;
            }
            if (zzd == null) {
                this.zzxc.zza(2, this.zzxd);
                return null;
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(zzd, 0, zzd.length);
            if (decodeByteArray != null) {
                return new BitmapDrawable(Resources.getSystem(), decodeByteArray);
            }
            this.zzxc.zza(2, this.zzxd);
            return null;
        }

        public /* synthetic */ Object zzb(InputStream inputStream) {
            return zza(inputStream);
        }

        public Drawable zzdP() {
            this.zzxc.zza(2, this.zzxd);
            return null;
        }

        public /* synthetic */ Object zzdQ() {
            return zzdP();
        }
    }

    public zzgt(Context context, zzt com_google_android_gms_internal_zzt, zzai com_google_android_gms_internal_zzai, zzht com_google_android_gms_internal_zzht, com.google.android.gms.internal.zzhe.zza com_google_android_gms_internal_zzhe_zza) {
        this.zznh = new Object();
        this.mContext = context;
        this.zzrv = com_google_android_gms_internal_zzt;
        this.zzwV = com_google_android_gms_internal_zzht;
        this.zzwW = com_google_android_gms_internal_zzai;
        this.zzvN = com_google_android_gms_internal_zzhe_zza;
        this.zzwX = false;
        this.zzvR = -2;
        this.zzwY = null;
    }

    private com.google.android.gms.internal.zzcn.zza zza(zzah com_google_android_gms_internal_zzah, zza com_google_android_gms_internal_zzgt_zza, JSONObject jSONObject) throws ExecutionException, InterruptedException, JSONException {
        if (zzdO()) {
            return null;
        }
        String[] zzb = zzb(jSONObject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
        this.zzwY = zzb == null ? null : Arrays.asList(zzb);
        com.google.android.gms.internal.zzcn.zza zza = com_google_android_gms_internal_zzgt_zza.zza(this, jSONObject);
        if (zza == null) {
            zzhx.zzZ("Failed to retrieve ad assets.");
            return null;
        }
        zza.zza(new zzcn(this.zzrv, com_google_android_gms_internal_zzah, jSONObject));
        return zza;
    }

    private zzhe zza(com.google.android.gms.internal.zzcn.zza com_google_android_gms_internal_zzcn_zza) {
        int i;
        synchronized (this.zznh) {
            i = this.zzvR;
            if (com_google_android_gms_internal_zzcn_zza == null && this.zzvR == -2) {
                i = 0;
            }
        }
        return new zzhe(this.zzvN.zzyy.zzwn, null, this.zzvN.zzyz.zzst, i, this.zzvN.zzyz.zzsu, this.zzwY, this.zzvN.zzyz.orientation, this.zzvN.zzyz.zzsx, this.zzvN.zzyy.zzwq, false, null, null, null, null, null, 0, this.zzvN.zzlV, this.zzvN.zzyz.zzwH, this.zzvN.zzyv, this.zzvN.zzyw, this.zzvN.zzyz.zzwN, this.zzvN.zzys, i != -2 ? null : com_google_android_gms_internal_zzcn_zza, this.zzvN.zzyy.zzwD);
    }

    private String[] zzb(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    private JSONObject zzc(zzah com_google_android_gms_internal_zzah) throws TimeoutException, JSONException {
        if (zzdO()) {
            return null;
        }
        zzhq com_google_android_gms_internal_zzhq = new zzhq();
        zzb com_google_android_gms_internal_zzgt_zzb = new zzb(this);
        zzcv c04011 = new C04011(this, com_google_android_gms_internal_zzah, com_google_android_gms_internal_zzgt_zzb, com_google_android_gms_internal_zzhq);
        com_google_android_gms_internal_zzgt_zzb.zzxe = c04011;
        com_google_android_gms_internal_zzah.zza("/nativeAdPreProcess", c04011);
        com_google_android_gms_internal_zzah.zza("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.zzvN.zzyz.zzwG));
        return (JSONObject) com_google_android_gms_internal_zzhq.get();
    }

    private zzah zzdN() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        if (zzdO()) {
            return null;
        }
        zzah com_google_android_gms_internal_zzah = (zzah) this.zzwW.zza(this.mContext, this.zzvN.zzyy.zzlP, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html").get();
        com_google_android_gms_internal_zzah.zza(this.zzrv, this.zzrv, this.zzrv, this.zzrv, false, this.zzrv, this.zzrv, null, this.zzrv);
        return com_google_android_gms_internal_zzah;
    }

    public /* synthetic */ Object call() throws Exception {
        return zzdM();
    }

    public Future<Drawable> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        Object string = z ? jSONObject2.getString(PlusShare.KEY_CALL_TO_ACTION_URL) : jSONObject2.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        if (!TextUtils.isEmpty(string)) {
            return this.zzwV.zza(string, new C04022(this, z));
        }
        zza(0, z);
        return new zzhr(null);
    }

    public void zza(int i, boolean z) {
        if (z) {
            zzx(i);
        }
    }

    protected zza zzc(JSONObject jSONObject) throws JSONException {
        if (zzdO()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        if ("2".equals(string)) {
            return new zzgu();
        }
        if ("1".equals(string)) {
            return new zzgv();
        }
        zzx(0);
        return null;
    }

    public zzhe zzdM() {
        try {
            zzah zzdN = zzdN();
            JSONObject zzc = zzc(zzdN);
            return zza(zza(zzdN, zzc(zzc), zzc));
        } catch (CancellationException e) {
            if (!this.zzwX) {
                zzx(0);
            }
            return zza(null);
        } catch (ExecutionException e2) {
            if (this.zzwX) {
                zzx(0);
            }
            return zza(null);
        } catch (InterruptedException e3) {
            if (this.zzwX) {
                zzx(0);
            }
            return zza(null);
        } catch (Throwable e4) {
            zzhx.zzd("Malformed native JSON response.", e4);
            if (this.zzwX) {
                zzx(0);
            }
            return zza(null);
        } catch (Throwable e42) {
            zzhx.zzd("Timeout when loading native ad.", e42);
            if (this.zzwX) {
                zzx(0);
            }
            return zza(null);
        }
    }

    public boolean zzdO() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzwX;
        }
        return z;
    }

    public void zzx(int i) {
        synchronized (this.zznh) {
            this.zzwX = true;
            this.zzvR = i;
        }
    }
}
