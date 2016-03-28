package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;

public final class zzko {
    public static final Api<NoOptions> API;
    public static final zzc<zzks> zzGR;
    private static final zzb<zzks, NoOptions> zzGS;
    public static final zzkp zzQy;

    /* renamed from: com.google.android.gms.internal.zzko.1 */
    static class C04161 implements zzb<zzks, NoOptions> {
        C04161() {
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public /* synthetic */ zza zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzc(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzks zzc(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzks(context, looper, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static {
        zzGR = new zzc();
        zzGS = new C04161();
        API = new Api(zzGS, zzGR, new Scope[0]);
        zzQy = new zzkq();
    }
}
