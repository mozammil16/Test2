package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

public class zzk {
    private String zzkU;
    private String zzkV;
    private String zzkW;
    private String[] zzkX;
    private zzg zzkY;

    public zzk(zzg com_google_android_gms_internal_zzg) {
        this.zzkU = "googleads.g.doubleclick.net";
        this.zzkV = "/pagead/ads";
        this.zzkW = "ad.doubleclick.net";
        this.zzkX = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
        this.zzkY = com_google_android_gms_internal_zzg;
    }

    private Uri zza(Uri uri, Context context, String str, boolean z) throws zzl {
        try {
            boolean zza = zza(uri);
            if (zza) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzl("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzl("Query parameter already exists: ms");
            }
            String zza2 = z ? this.zzkY.zza(context, str) : this.zzkY.zza(context);
            return zza ? zzb(uri, "dc_ms", zza2) : zza(uri, "ms", zza2);
        } catch (UnsupportedOperationException e) {
            throw new zzl("Provided Uri is not in a valid state");
        }
    }

    private Uri zza(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri zzb(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append(";").append(uri2.substring(indexOf + 1)).toString());
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str).append("=").append(str2).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
    }

    public zzg zzC() {
        return this.zzkY;
    }

    public Uri zza(Uri uri, Context context) throws zzl {
        try {
            return zza(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new zzl("Provided Uri is not in a valid state");
        }
    }

    public void zza(MotionEvent motionEvent) {
        this.zzkY.zza(motionEvent);
    }

    public boolean zza(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.zzkW);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean zzb(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.zzkX) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean zzc(Uri uri) {
        return zzb(uri) && uri.getPath().endsWith("/aclk");
    }
}
