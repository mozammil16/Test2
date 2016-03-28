package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public class zzho {
    private final Object zznh;
    private String zzyW;
    private boolean zzzq;
    private boolean zzzr;

    /* renamed from: com.google.android.gms.internal.zzho.1 */
    class C02361 implements Runnable {
        final /* synthetic */ Context zznK;
        final /* synthetic */ zzho zzzs;

        C02361(zzho com_google_android_gms_internal_zzho, Context context) {
            this.zzzs = com_google_android_gms_internal_zzho;
            this.zznK = context;
        }

        public void run() {
            synchronized (this.zzzs.zznh) {
                this.zzzs.zzyW = this.zzzs.zzv(this.zznK);
                this.zzzs.zznh.notifyAll();
            }
        }
    }

    private final class zza extends BroadcastReceiver {
        final /* synthetic */ zzho zzzs;

        private zza(zzho com_google_android_gms_internal_zzho) {
            this.zzzs = com_google_android_gms_internal_zzho;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                this.zzzs.zzzq = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                this.zzzs.zzzq = false;
            }
        }
    }

    public zzho() {
        this.zznh = new Object();
        this.zzzq = true;
        this.zzzr = false;
    }

    private JSONArray zza(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object zza : collection) {
            zza(jSONArray, zza);
        }
        return jSONArray;
    }

    private void zza(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(zzg((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(zzw((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(zza((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(zza((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private void zza(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzg((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, zzw((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, zza((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, zza(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    private JSONObject zzg(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zza(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public String zzS(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public int zzT(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            zzhx.zzac("Could not parse value:" + e);
            return 0;
        }
    }

    public boolean zzU(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, z);
    }

    public String zza(Context context, View view, zzba com_google_android_gms_internal_zzba) {
        String str = null;
        if (((Boolean) zzca.zzqM.get()).booleanValue()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", com_google_android_gms_internal_zzba.width);
                jSONObject2.put("height", com_google_android_gms_internal_zzba.height);
                jSONObject.put("size", jSONObject2);
                jSONObject.put("activity", zzy(context));
                if (!com_google_android_gms_internal_zzba.zzpb) {
                    JSONArray jSONArray = new JSONArray();
                    while (view != null) {
                        ViewParent parent = view.getParent();
                        if (parent != null) {
                            int i = -1;
                            if (parent instanceof ViewGroup) {
                                i = ((ViewGroup) parent).indexOfChild(view);
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("type", parent.getClass().getName());
                            jSONObject3.put("index_of_child", i);
                            jSONArray.put(jSONObject3);
                        }
                        View view2 = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                        view = view2;
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("parents", jSONArray);
                    }
                }
                str = jSONObject.toString();
            } catch (Throwable e) {
                zzhx.zzd("Fail to get view hierarchy json", e);
            }
        }
        return str;
    }

    public String zza(Context context, zzk com_google_android_gms_internal_zzk, String str) {
        if (com_google_android_gms_internal_zzk != null) {
            try {
                Uri parse = Uri.parse(str);
                if (com_google_android_gms_internal_zzk.zzc(parse)) {
                    parse = com_google_android_gms_internal_zzk.zza(parse, context);
                }
                str = parse.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public String zza(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder(AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
        char[] cArr = new char[AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    JSONArray zza(Object[] objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object zza : objArr) {
            zza(jSONArray, zza);
        }
        return jSONArray;
    }

    public void zza(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public void zza(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(zze(context, str));
    }

    public void zza(Context context, String str, List<String> list) {
        for (String com_google_android_gms_internal_zzhu : list) {
            new zzhu(context, str, com_google_android_gms_internal_zzhu).start();
        }
    }

    public void zza(Context context, String str, List<String> list, String str2) {
        for (String com_google_android_gms_internal_zzhu : list) {
            new zzhu(context, str, com_google_android_gms_internal_zzhu, str2).start();
        }
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        zza(context, str, z, httpURLConnection, false);
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, String str2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", str2);
        httpURLConnection.setUseCaches(false);
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", zze(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public boolean zza(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public boolean zza(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    public String zzb(zzic com_google_android_gms_internal_zzic, String str) {
        return zza(com_google_android_gms_internal_zzic.getContext(), com_google_android_gms_internal_zzic.zzeI(), str);
    }

    public void zzc(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        zza(context, str, arrayList);
    }

    public Map<String, String> zzd(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : zzab.zzaO().zze(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String zze(android.content.Context r4, java.lang.String r5) {
        /*
        r3 = this;
        r1 = r3.zznh;
        monitor-enter(r1);
        r0 = r3.zzyW;	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r3.zzyW;	 Catch:{ all -> 0x005e }
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = com.google.android.gms.internal.zzab.zzaO();	 Catch:{ Exception -> 0x0095 }
        r0 = r0.getDefaultUserAgent(r4);	 Catch:{ Exception -> 0x0095 }
        r3.zzyW = r0;	 Catch:{ Exception -> 0x0095 }
    L_0x0015:
        r0 = r3.zzyW;	 Catch:{ all -> 0x005e }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x0067;
    L_0x001d:
        r0 = com.google.android.gms.internal.zzbe.zzbD();	 Catch:{ all -> 0x005e }
        r0 = r0.zzeC();	 Catch:{ all -> 0x005e }
        if (r0 != 0) goto L_0x0061;
    L_0x0027:
        r0 = 0;
        r3.zzyW = r0;	 Catch:{ all -> 0x005e }
        r0 = com.google.android.gms.internal.zzhw.zzzG;	 Catch:{ all -> 0x005e }
        r2 = new com.google.android.gms.internal.zzho$1;	 Catch:{ all -> 0x005e }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x005e }
        r0.post(r2);	 Catch:{ all -> 0x005e }
    L_0x0034:
        r0 = r3.zzyW;	 Catch:{ all -> 0x005e }
        if (r0 != 0) goto L_0x0067;
    L_0x0038:
        r0 = r3.zznh;	 Catch:{ InterruptedException -> 0x003e }
        r0.wait();	 Catch:{ InterruptedException -> 0x003e }
        goto L_0x0034;
    L_0x003e:
        r0 = move-exception;
        r0 = r3.zzet();	 Catch:{ all -> 0x005e }
        r3.zzyW = r0;	 Catch:{ all -> 0x005e }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005e }
        r0.<init>();	 Catch:{ all -> 0x005e }
        r2 = "Interrupted, use default user agent: ";
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r2 = r3.zzyW;	 Catch:{ all -> 0x005e }
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r0 = r0.toString();	 Catch:{ all -> 0x005e }
        com.google.android.gms.internal.zzhx.zzac(r0);	 Catch:{ all -> 0x005e }
        goto L_0x0034;
    L_0x005e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
        throw r0;
    L_0x0061:
        r0 = r3.zzv(r4);	 Catch:{ Exception -> 0x008d }
        r3.zzyW = r0;	 Catch:{ Exception -> 0x008d }
    L_0x0067:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005e }
        r0.<init>();	 Catch:{ all -> 0x005e }
        r2 = r3.zzyW;	 Catch:{ all -> 0x005e }
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r2 = " (Mobile; ";
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r0 = r0.append(r5);	 Catch:{ all -> 0x005e }
        r2 = ")";
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r0 = r0.toString();	 Catch:{ all -> 0x005e }
        r3.zzyW = r0;	 Catch:{ all -> 0x005e }
        r0 = r3.zzyW;	 Catch:{ all -> 0x005e }
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
        goto L_0x000a;
    L_0x008d:
        r0 = move-exception;
        r0 = r3.zzet();	 Catch:{ all -> 0x005e }
        r3.zzyW = r0;	 Catch:{ all -> 0x005e }
        goto L_0x0067;
    L_0x0095:
        r0 = move-exception;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzho.zze(android.content.Context, java.lang.String):java.lang.String");
    }

    public boolean zzes() {
        return this.zzzq;
    }

    String zzet() {
        StringBuffer stringBuffer = new StringBuffer(FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public String zzeu() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public String zzev() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : str + " " + str2;
    }

    protected int[] zzew() {
        return new int[]{0, 0};
    }

    public int[] zzg(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return zzew();
        }
        return new int[]{window.findViewById(16908290).getWidth(), window.findViewById(16908290).getHeight()};
    }

    public Bitmap zzh(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public int[] zzh(Activity activity) {
        int[] zzg = zzg(activity);
        return new int[]{zzbe.zzbD().zzc(activity, zzg[0]), zzbe.zzbD().zzc(activity, zzg[1])};
    }

    public int[] zzi(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return zzew();
        }
        return new int[]{window.findViewById(16908290).getTop(), window.findViewById(16908290).getBottom()};
    }

    public int[] zzj(Activity activity) {
        int[] zzi = zzi(activity);
        return new int[]{zzbe.zzbD().zzc(activity, zzi[0]), zzbe.zzbD().zzc(activity, zzi[1])};
    }

    public int zzk(Activity activity) {
        if (activity == null) {
            zzhx.zzac("Fail to get AdActivity type since it is null");
            return 0;
        }
        zzeo zzb = zzeo.zzb(activity.getIntent());
        if (zzb == null) {
            zzhx.zzac("Fail to get AdOverlayInfo");
            return 0;
        }
        switch (zzb.zzuw) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return 1;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return 2;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return 3;
            default:
                return 0;
        }
    }

    public boolean zzt(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            zzhx.zzac("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            zzhx.zzac(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            zzhx.zzac(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & TransportMediator.FLAG_KEY_MEDIA_NEXT) == 0) {
            zzhx.zzac(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED) == 0) {
            zzhx.zzac(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AdRequest.MAX_CONTENT_URL_LENGTH) == 0) {
            zzhx.zzac(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & Place.TYPE_SUBLOCALITY_LEVEL_2) == 0) {
            zzhx.zzac(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT) != 0) {
            return z;
        }
        zzhx.zzac(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    public boolean zzu(Context context) {
        if (this.zzzr) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new zza(), intentFilter);
        this.zzzr = true;
        return true;
    }

    protected String zzv(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public Builder zzw(Context context) {
        return new Builder(context);
    }

    public JSONObject zzw(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                zza(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    public zzbu zzx(Context context) {
        return new zzbu(context);
    }

    public String zzy(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        List runningTasks = activityManager.getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
            if (!(runningTaskInfo == null || runningTaskInfo.topActivity == null)) {
                return runningTaskInfo.topActivity.getClassName();
            }
        }
        return null;
    }
}
