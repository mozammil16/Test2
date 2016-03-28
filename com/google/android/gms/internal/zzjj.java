package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class zzjj implements AppIndexApi, zzjd {

    @Deprecated
    private static final class zza implements ActionResult {
        private zzjj zzGG;
        private PendingResult<Status> zzGH;
        private Action zzGI;

        zza(zzjj com_google_android_gms_internal_zzjj, PendingResult<Status> pendingResult, Action action) {
            this.zzGG = com_google_android_gms_internal_zzjj;
            this.zzGH = pendingResult;
            this.zzGI = action;
        }

        public PendingResult<Status> end(GoogleApiClient apiClient) {
            String packageName = apiClient.getContext().getPackageName();
            zzjb zza = zzji.zza(this.zzGI, System.currentTimeMillis(), packageName, 3);
            return this.zzGG.zza(apiClient, zza);
        }

        public PendingResult<Status> getPendingResult() {
            return this.zzGH;
        }
    }

    private static abstract class zzb<T extends Result> extends com.google.android.gms.common.api.zza.zza<T, zzjh> {
        public zzb(GoogleApiClient googleApiClient) {
            super(zzim.zzFC, googleApiClient);
        }

        protected abstract void zza(zzje com_google_android_gms_internal_zzje) throws RemoteException;

        protected final void zza(zzjh com_google_android_gms_internal_zzjh) throws RemoteException {
            zza(com_google_android_gms_internal_zzjh.zzgY());
        }
    }

    private static final class zzd extends zzjg<Status> {
        public zzd(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(Status status) {
            this.zzGC.zzd(status);
        }
    }

    private static abstract class zzc<T extends Result> extends zzb<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected Status zzb(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzjj.1 */
    class C08021 extends zzc<Status> {
        final /* synthetic */ String zzGD;
        final /* synthetic */ zzjb[] zzGE;
        final /* synthetic */ zzjj zzGF;

        C08021(zzjj com_google_android_gms_internal_zzjj, GoogleApiClient googleApiClient, String str, zzjb[] com_google_android_gms_internal_zzjbArr) {
            this.zzGF = com_google_android_gms_internal_zzjj;
            this.zzGD = str;
            this.zzGE = com_google_android_gms_internal_zzjbArr;
            super(googleApiClient);
        }

        protected void zza(zzje com_google_android_gms_internal_zzje) throws RemoteException {
            com_google_android_gms_internal_zzje.zza(new zzd(this), this.zzGD, this.zzGE);
        }
    }

    public static Intent zza(String str, Uri uri) {
        zzb(str, uri);
        List pathSegments = uri.getPathSegments();
        String str2 = (String) pathSegments.get(0);
        Builder builder = new Builder();
        builder.scheme(str2);
        if (pathSegments.size() > 1) {
            builder.authority((String) pathSegments.get(1));
            for (int i = 2; i < pathSegments.size(); i++) {
                builder.appendPath((String) pathSegments.get(i));
            }
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return new Intent("android.intent.action.VIEW", builder.build());
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Action action, int i) {
        String packageName = googleApiClient.getContext().getPackageName();
        return zza(googleApiClient, zzji.zza(action, System.currentTimeMillis(), packageName, i));
    }

    private static void zzb(String str, Uri uri) {
        if ("android-app".equals(uri.getScheme())) {
            String host = uri.getHost();
            if (str == null || str.equals(host)) {
                List pathSegments = uri.getPathSegments();
                if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                    throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
                }
                return;
            }
            throw new IllegalArgumentException("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
        }
        throw new IllegalArgumentException("AppIndex: The URI scheme must be 'android-app' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
    }

    public static void zze(List<AppIndexingLink> list) {
        if (list != null) {
            for (AppIndexingLink appIndexingLink : list) {
                zzb(null, appIndexingLink.appIndexingUrl);
            }
        }
    }

    public ActionResult action(GoogleApiClient apiClient, Action action) {
        return new zza(this, zza(apiClient, action, 0), action);
    }

    public PendingResult<Status> end(GoogleApiClient apiClient, Action action) {
        return zza(apiClient, action, 3);
    }

    public PendingResult<Status> start(GoogleApiClient apiClient, Action action) {
        return zza(apiClient, action, 0);
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Intent viewIntent, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        String packageName = apiClient.getContext().getPackageName();
        zze(outLinks);
        return zza(apiClient, new zzjb(packageName, viewIntent, title, webUrl, null, outLinks));
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        String packageName = apiClient.getContext().getPackageName();
        zzb(packageName, appIndexingUrl);
        return view(apiClient, activity, zza(packageName, appIndexingUrl), title, webUrl, (List) outLinks);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Intent viewIntent) {
        zzjb com_google_android_gms_internal_zzjb = new zzjb(zzjb.zza(apiClient.getContext().getPackageName(), viewIntent), System.currentTimeMillis(), 3);
        return zza(apiClient, com_google_android_gms_internal_zzjb);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Uri appUri) {
        return viewEnd(apiClient, activity, zza(apiClient.getContext().getPackageName(), appUri));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, zzjb... com_google_android_gms_internal_zzjbArr) {
        return googleApiClient.zza(new C08021(this, googleApiClient, googleApiClient.getContext().getPackageName(), com_google_android_gms_internal_zzjbArr));
    }
}
