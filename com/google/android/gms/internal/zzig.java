package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;

@zzgi
public class zzig extends WebChromeClient {
    private final zzic zzmu;

    /* renamed from: com.google.android.gms.internal.zzig.1 */
    static class C02421 implements OnCancelListener {
        final /* synthetic */ JsResult zzAl;

        C02421(JsResult jsResult) {
            this.zzAl = jsResult;
        }

        public void onCancel(DialogInterface dialog) {
            this.zzAl.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzig.2 */
    static class C02432 implements OnClickListener {
        final /* synthetic */ JsResult zzAl;

        C02432(JsResult jsResult) {
            this.zzAl = jsResult;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.zzAl.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzig.3 */
    static class C02443 implements OnClickListener {
        final /* synthetic */ JsResult zzAl;

        C02443(JsResult jsResult) {
            this.zzAl = jsResult;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.zzAl.confirm();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzig.4 */
    static class C02454 implements OnCancelListener {
        final /* synthetic */ JsPromptResult zzAm;

        C02454(JsPromptResult jsPromptResult) {
            this.zzAm = jsPromptResult;
        }

        public void onCancel(DialogInterface dialog) {
            this.zzAm.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzig.5 */
    static class C02465 implements OnClickListener {
        final /* synthetic */ JsPromptResult zzAm;

        C02465(JsPromptResult jsPromptResult) {
            this.zzAm = jsPromptResult;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.zzAm.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzig.6 */
    static class C02476 implements OnClickListener {
        final /* synthetic */ JsPromptResult zzAm;
        final /* synthetic */ EditText zzAn;

        C02476(JsPromptResult jsPromptResult, EditText editText) {
            this.zzAm = jsPromptResult;
            this.zzAn = editText;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.zzAm.confirm(this.zzAn.getText().toString());
        }
    }

    /* renamed from: com.google.android.gms.internal.zzig.7 */
    static /* synthetic */ class C02487 {
        static final /* synthetic */ int[] zzAo;

        static {
            zzAo = new int[MessageLevel.values().length];
            try {
                zzAo[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzAo[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzAo[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zzAo[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                zzAo[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public zzig(zzic com_google_android_gms_internal_zzic) {
        this.zzmu = com_google_android_gms_internal_zzic;
    }

    private static void zza(Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new C02443(jsResult)).setNegativeButton(17039360, new C02432(jsResult)).setOnCancelListener(new C02421(jsResult)).create().show();
    }

    private static void zza(Context context, Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(str);
        View editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new C02476(jsPromptResult, editText)).setNegativeButton(17039360, new C02465(jsPromptResult)).setOnCancelListener(new C02454(jsPromptResult)).create().show();
    }

    private final Context zzc(WebView webView) {
        if (!(webView instanceof zzic)) {
            return webView.getContext();
        }
        zzic com_google_android_gms_internal_zzic = (zzic) webView;
        Context zzeD = com_google_android_gms_internal_zzic.zzeD();
        return zzeD == null ? com_google_android_gms_internal_zzic.getContext() : zzeD;
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof zzic) {
            zzel zzeF = ((zzic) webView).zzeF();
            if (zzeF == null) {
                zzhx.zzac("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                zzeF.close();
                return;
            }
        }
        zzhx.zzac("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (C02487.zzAo[consoleMessage.messageLevel().ordinal()]) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                zzhx.zzZ(str);
                break;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                zzhx.zzac(str);
                break;
            case CompletionEvent.STATUS_CANCELED /*3*/:
            case Place.TYPE_AQUARIUM /*4*/:
                zzhx.zzaa(str);
                break;
            case Place.TYPE_ART_GALLERY /*5*/:
                zzhx.zzY(str);
                break;
            default:
                zzhx.zzaa(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
        WebViewTransport webViewTransport = (WebViewTransport) resultMsg.obj;
        WebView webView = new WebView(view.getContext());
        webView.setWebViewClient(this.zzmu.zzeG());
        webViewTransport.setWebView(webView);
        resultMsg.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, QuotaUpdater quotaUpdater) {
        long j = 5242880 - totalUsedQuota;
        if (j <= 0) {
            quotaUpdater.updateQuota(currentQuota);
            return;
        }
        if (currentQuota == 0) {
            if (estimatedSize > j || estimatedSize > 1048576) {
                estimatedSize = 0;
            }
        } else if (estimatedSize == 0) {
            estimatedSize = Math.min(Math.min(131072, j) + currentQuota, 1048576);
        } else {
            if (estimatedSize <= Math.min(1048576 - currentQuota, j)) {
                currentQuota += estimatedSize;
            }
            estimatedSize = currentQuota;
        }
        quotaUpdater.updateQuota(estimatedSize);
    }

    public final void onHideCustomView() {
        zzel zzeF = this.zzmu.zzeF();
        if (zzeF == null) {
            zzhx.zzac("Could not get ad overlay when hiding custom view.");
        } else {
            zzeF.zzdc();
        }
    }

    public final boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
        return zza(zzc(webView), url, message, null, result, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String url, String message, JsResult result) {
        return zza(zzc(webView), url, message, null, result, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String url, String message, JsResult result) {
        return zza(zzc(webView), url, message, null, result, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String url, String message, String defaultValue, JsPromptResult result) {
        return zza(zzc(webView), url, message, defaultValue, null, result, true);
    }

    public final void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota, QuotaUpdater quotaUpdater) {
        long j = 131072 + spaceNeeded;
        if (5242880 - totalUsedQuota < j) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        zza(view, -1, customViewCallback);
    }

    protected final void zza(View view, int i, CustomViewCallback customViewCallback) {
        zzel zzeF = this.zzmu.zzeF();
        if (zzeF == null) {
            zzhx.zzac("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzeF.zza(view, customViewCallback);
        zzeF.setRequestedOrientation(i);
    }

    protected boolean zza(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            if (z) {
                zza(context, builder, str2, str3, jsPromptResult);
            } else {
                zza(builder, str2, jsResult);
            }
        } catch (Throwable e) {
            zzhx.zzd("Fail to display Dialog.", e);
        }
        return true;
    }
}
