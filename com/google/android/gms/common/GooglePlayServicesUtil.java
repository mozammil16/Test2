package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompatExtras;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.C0133R;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.internal.zzlu;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.location.places.Place;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class GooglePlayServicesUtil {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 7095000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean zzLD;
    public static boolean zzLE;
    private static int zzLF;
    private static final Object zzLG;

    private static class zza extends Handler {
        private final Context zznk;

        zza(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.zznk = context.getApplicationContext();
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zznk);
                    if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                        GooglePlayServicesUtil.zza(isGooglePlayServicesAvailable, this.zznk);
                    }
                default:
                    Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + msg.what);
            }
        }
    }

    static {
        zzLD = false;
        zzLE = false;
        zzLF = -1;
        zzLG = new Object();
    }

    private GooglePlayServicesUtil() {
    }

    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode) {
        return getErrorDialog(errorCode, activity, requestCode, null);
    }

    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode, OnCancelListener cancelListener) {
        return zza(errorCode, activity, null, requestCode, cancelListener);
    }

    protected static int getErrorNotificationId(int errorCode) {
        switch (errorCode) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return 10436;
            default:
                return 39789;
        }
    }

    public static PendingIntent getErrorPendingIntent(int errorCode, Context context, int requestCode) {
        Intent zzan = zzan(errorCode);
        return zzan == null ? null : PendingIntent.getActivity(context, requestCode, zzan, DriveFile.MODE_READ_ONLY);
    }

    public static String getErrorString(int errorCode) {
        switch (errorCode) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return "SUCCESS";
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return "SERVICE_MISSING";
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return "SERVICE_DISABLED";
            case Place.TYPE_AQUARIUM /*4*/:
                return "SIGN_IN_REQUIRED";
            case Place.TYPE_ART_GALLERY /*5*/:
                return "INVALID_ACCOUNT";
            case Place.TYPE_ATM /*6*/:
                return "RESOLUTION_REQUIRED";
            case Place.TYPE_BAKERY /*7*/:
                return "NETWORK_ERROR";
            case Place.TYPE_BANK /*8*/:
                return "INTERNAL_ERROR";
            case Place.TYPE_BAR /*9*/:
                return "SERVICE_INVALID";
            case Place.TYPE_BEAUTY_SALON /*10*/:
                return "DEVELOPER_ERROR";
            case Place.TYPE_BICYCLE_STORE /*11*/:
                return "LICENSE_CHECK_FAILED";
            case Place.TYPE_CAMPGROUND /*16*/:
                return "API_UNAVAILABLE";
            default:
                return "UNKNOWN_ERROR_CODE";
        }
    }

    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Builder().scheme("android.resource").authority(GOOGLE_PLAY_SERVICES_PACKAGE).appendPath("raw").appendPath("oss_notice").build());
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream == null) {
                return next;
            }
            openInputStream.close();
            return next;
        } catch (NoSuchElementException e) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        } catch (Exception e2) {
            return null;
        } catch (Throwable th) {
            if (openInputStream != null) {
                openInputStream.close();
            }
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext(GOOGLE_PLAY_SERVICES_PACKAGE, 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication(GOOGLE_PLAY_SERVICES_PACKAGE);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static int isGooglePlayServicesAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (!zze.zzPq) {
            try {
                context.getResources().getString(C0133R.string.common_google_play_services_unknown_issue);
            } catch (Throwable th) {
                Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
            }
        }
        if (!zze.zzPq) {
            zzJ(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64);
            zzc zzhP = zzc.zzhP();
            if (!zzlu.zzbd(packageInfo.versionCode) && !zzlu.zzQ(context)) {
                try {
                    if (zzhP.zza(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 64), zzaq.zzLC) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (zzhP.zza(packageInfo, zzhP.zza(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 64), zzaq.zzLC)) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                    return 9;
                }
            } else if (zzhP.zza(packageInfo, zzaq.zzLC) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (zzlu.zzbb(packageInfo.versionCode) < zzlu.zzbb(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires 7095000 but found " + packageInfo.versionCode);
                return 2;
            }
            try {
                return !packageManager.getApplicationInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 0).enabled ? 3 : 0;
            } catch (NameNotFoundException e2) {
                Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                e2.printStackTrace();
                return 1;
            }
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    public static boolean isUserRecoverableError(int errorCode) {
        switch (errorCode) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
            case CompletionEvent.STATUS_CONFLICT /*2*/:
            case CompletionEvent.STATUS_CANCELED /*3*/:
            case Place.TYPE_BAR /*9*/:
                return true;
            default:
                return false;
        }
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode) {
        return showErrorDialogFragment(errorCode, activity, requestCode, null);
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode, OnCancelListener cancelListener) {
        return showErrorDialogFragment(errorCode, activity, null, requestCode, cancelListener);
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, Fragment fragment, int requestCode, OnCancelListener cancelListener) {
        boolean z = false;
        Dialog zza = zza(errorCode, activity, fragment, requestCode, cancelListener);
        if (zza == null) {
            return z;
        }
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
        }
        if (z) {
            SupportErrorDialogFragment.newInstance(zza, cancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), GMS_ERROR_DIALOG);
        } else if (zzme.zzkd()) {
            ErrorDialogFragment.newInstance(zza, cancelListener).show(activity.getFragmentManager(), GMS_ERROR_DIALOG);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
        return true;
    }

    public static void showErrorNotification(int errorCode, Context context) {
        if (zzlu.zzQ(context) && errorCode == 2) {
            errorCode = 42;
        }
        if (zzh(context, errorCode) || zzi(context, errorCode)) {
            zzK(context);
        } else {
            zza(errorCode, context);
        }
    }

    public static void zzI(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            Intent zzan = zzan(isGooglePlayServicesAvailable);
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + isGooglePlayServicesAvailable);
            if (zzan == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", zzan);
        }
    }

    private static void zzJ(Context context) {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), TransportMediator.FLAG_KEY_MEDIA_NEXT);
        } catch (Throwable e) {
            Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.version");
            if (i != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected 7095000 but found " + i + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
            }
            return;
        }
        throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
    }

    private static void zzK(Context context) {
        Handler com_google_android_gms_common_GooglePlayServicesUtil_zza = new zza(context);
        com_google_android_gms_common_GooglePlayServicesUtil_zza.sendMessageDelayed(com_google_android_gms_common_GooglePlayServicesUtil_zza.obtainMessage(1), 120000);
    }

    public static void zzL(Context context) {
        try {
            ((NotificationManager) context.getSystemService("notification")).cancel(10436);
        } catch (SecurityException e) {
        }
    }

    private static String zzM(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo applicationInfo;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    private static Dialog zza(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        AlertDialog.Builder builder;
        Intent zzan;
        OnClickListener com_google_android_gms_common_internal_zzg;
        CharSequence zzf;
        if (zzlu.zzQ(activity) && i == 2) {
            i = 42;
        }
        if (zzme.zzkg()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new AlertDialog.Builder(activity, 5);
                if (builder == null) {
                    builder = new AlertDialog.Builder(activity);
                }
                builder.setMessage(zze(activity, i));
                if (onCancelListener != null) {
                    builder.setOnCancelListener(onCancelListener);
                }
                zzan = zzan(i);
                com_google_android_gms_common_internal_zzg = fragment != null ? new zzg(activity, zzan, i2) : new zzg(fragment, zzan, i2);
                zzf = zzf(activity, i);
                if (zzf != null) {
                    builder.setPositiveButton(zzf, com_google_android_gms_common_internal_zzg);
                }
                switch (i) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        return null;
                    case CompletionEvent.STATUS_FAILURE /*1*/:
                        return builder.setTitle(C0133R.string.common_google_play_services_install_title).create();
                    case CompletionEvent.STATUS_CONFLICT /*2*/:
                        return builder.setTitle(C0133R.string.common_google_play_services_update_title).create();
                    case CompletionEvent.STATUS_CANCELED /*3*/:
                        return builder.setTitle(C0133R.string.common_google_play_services_enable_title).create();
                    case Place.TYPE_AQUARIUM /*4*/:
                    case Place.TYPE_ATM /*6*/:
                        return builder.create();
                    case Place.TYPE_ART_GALLERY /*5*/:
                        Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
                        return builder.setTitle(C0133R.string.common_google_play_services_invalid_account_title).create();
                    case Place.TYPE_BAKERY /*7*/:
                        Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
                        return builder.setTitle(C0133R.string.common_google_play_services_network_error_title).create();
                    case Place.TYPE_BANK /*8*/:
                        Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
                        return builder.create();
                    case Place.TYPE_BAR /*9*/:
                        Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
                        return builder.setTitle(C0133R.string.common_google_play_services_unsupported_title).create();
                    case Place.TYPE_BEAUTY_SALON /*10*/:
                        Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
                        return builder.create();
                    case Place.TYPE_BICYCLE_STORE /*11*/:
                        Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
                        return builder.create();
                    case Place.TYPE_CAMPGROUND /*16*/:
                        Log.e("GooglePlayServicesUtil", "One of the API components you attempted to connect to is not available.");
                        return builder.create();
                    case Place.TYPE_CAR_DEALER /*17*/:
                        Log.e("GooglePlayServicesUtil", "The specified account could not be signed in.");
                        return builder.setTitle(C0133R.string.common_google_play_services_sign_in_failed_title).create();
                    case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                        return builder.setTitle(C0133R.string.common_android_wear_update_title).create();
                    default:
                        Log.e("GooglePlayServicesUtil", "Unexpected error code " + i);
                        return builder.create();
                }
            }
        }
        builder = null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(zze(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        zzan = zzan(i);
        if (fragment != null) {
        }
        zzf = zzf(activity, i);
        if (zzf != null) {
            builder.setPositiveButton(zzf, com_google_android_gms_common_internal_zzg);
        }
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return null;
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return builder.setTitle(C0133R.string.common_google_play_services_install_title).create();
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return builder.setTitle(C0133R.string.common_google_play_services_update_title).create();
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return builder.setTitle(C0133R.string.common_google_play_services_enable_title).create();
            case Place.TYPE_AQUARIUM /*4*/:
            case Place.TYPE_ATM /*6*/:
                return builder.create();
            case Place.TYPE_ART_GALLERY /*5*/:
                Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
                return builder.setTitle(C0133R.string.common_google_play_services_invalid_account_title).create();
            case Place.TYPE_BAKERY /*7*/:
                Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
                return builder.setTitle(C0133R.string.common_google_play_services_network_error_title).create();
            case Place.TYPE_BANK /*8*/:
                Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
                return builder.create();
            case Place.TYPE_BAR /*9*/:
                Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
                return builder.setTitle(C0133R.string.common_google_play_services_unsupported_title).create();
            case Place.TYPE_BEAUTY_SALON /*10*/:
                Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
                return builder.create();
            case Place.TYPE_BICYCLE_STORE /*11*/:
                Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
                return builder.create();
            case Place.TYPE_CAMPGROUND /*16*/:
                Log.e("GooglePlayServicesUtil", "One of the API components you attempted to connect to is not available.");
                return builder.create();
            case Place.TYPE_CAR_DEALER /*17*/:
                Log.e("GooglePlayServicesUtil", "The specified account could not be signed in.");
                return builder.setTitle(C0133R.string.common_google_play_services_sign_in_failed_title).create();
            case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                return builder.setTitle(C0133R.string.common_android_wear_update_title).create();
            default:
                Log.e("GooglePlayServicesUtil", "Unexpected error code " + i);
                return builder.create();
        }
    }

    private static void zza(int i, Context context) {
        zza(i, context, null);
    }

    private static void zza(int i, Context context, String str) {
        Notification build;
        Resources resources = context.getResources();
        CharSequence zzg = zzg(context, i);
        CharSequence string = resources.getString(C0133R.string.common_google_play_services_error_notification_requested_by_msg, new Object[]{zzM(context)});
        PendingIntent errorPendingIntent = getErrorPendingIntent(i, context, 0);
        if (zzlu.zzQ(context)) {
            zzx.zzN(zzme.zzkh());
            build = new Notification.Builder(context).setSmallIcon(C0133R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new BigTextStyle().bigText(zzg + " " + string)).addAction(C0133R.drawable.common_full_open_on_phone, resources.getString(C0133R.string.common_open_on_phone), errorPendingIntent).build();
        } else {
            Notification notification = new Notification(17301642, resources.getString(C0133R.string.common_google_play_services_notification_ticker), System.currentTimeMillis());
            notification.flags |= 16;
            if (VERSION.SDK_INT >= 21) {
                notification.flags |= FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED;
            } else if (VERSION.SDK_INT >= 19) {
                notification.extras.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
            }
            notification.setLatestEventInfo(context, zzg, string, errorPendingIntent);
            build = notification;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (str != null) {
            notificationManager.notify(str, getErrorNotificationId(i), build);
        } else {
            notificationManager.notify(getErrorNotificationId(i), build);
        }
    }

    public static boolean zza(Context context, int i, String str) {
        if (zzme.zzkj()) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zza(Resources resources) {
        if (resources == null) {
            return false;
        }
        return (zzme.zzkd() && ((resources.getConfiguration().screenLayout & 15) > 3)) || zzb(resources);
    }

    public static Intent zzan(int i) {
        switch (i) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return zzo.zzbl(GOOGLE_PLAY_SERVICES_PACKAGE);
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return zzo.zzbj(GOOGLE_PLAY_SERVICES_PACKAGE);
            case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                return zzo.zzjl();
            default:
                return null;
        }
    }

    public static boolean zzb(PackageManager packageManager) {
        synchronized (zzLG) {
            if (zzLF == -1) {
                try {
                    if (zzc.zzhP().zza(packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64), zzb.zzLv[1]) != null) {
                        zzLF = 1;
                    } else {
                        zzLF = 0;
                    }
                } catch (NameNotFoundException e) {
                    zzLF = 0;
                }
            }
        }
        return zzLF != 0;
    }

    @Deprecated
    public static boolean zzb(PackageManager packageManager, String str) {
        return zzc.zzhP().zzb(packageManager, str);
    }

    private static boolean zzb(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        return zzme.zzkf() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
    }

    public static boolean zzc(PackageManager packageManager) {
        return zzb(packageManager) || !zzhO();
    }

    public static boolean zzd(Context context, int i) {
        return zza(context, i, GOOGLE_PLAY_SERVICES_PACKAGE) && zzb(context.getPackageManager(), GOOGLE_PLAY_SERVICES_PACKAGE);
    }

    public static String zze(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return zza(context.getResources()) ? resources.getString(C0133R.string.common_google_play_services_install_text_tablet) : resources.getString(C0133R.string.common_google_play_services_install_text_phone);
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return resources.getString(C0133R.string.common_google_play_services_update_text);
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return resources.getString(C0133R.string.common_google_play_services_enable_text);
            case Place.TYPE_ART_GALLERY /*5*/:
                return resources.getString(C0133R.string.common_google_play_services_invalid_account_text);
            case Place.TYPE_BAKERY /*7*/:
                return resources.getString(C0133R.string.common_google_play_services_network_error_text);
            case Place.TYPE_BAR /*9*/:
                return resources.getString(C0133R.string.common_google_play_services_unsupported_text);
            case Place.TYPE_CAMPGROUND /*16*/:
                return resources.getString(C0133R.string.commono_google_play_services_api_unavailable_text);
            case Place.TYPE_CAR_DEALER /*17*/:
                return resources.getString(C0133R.string.common_google_play_services_sign_in_failed_text);
            case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                return resources.getString(C0133R.string.common_android_wear_update_text);
            default:
                return resources.getString(C0133R.string.common_google_play_services_unknown_issue);
        }
    }

    public static String zzf(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return resources.getString(C0133R.string.common_google_play_services_install_button);
            case CompletionEvent.STATUS_CONFLICT /*2*/:
            case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                return resources.getString(C0133R.string.common_google_play_services_update_button);
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return resources.getString(C0133R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }

    public static String zzg(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return resources.getString(C0133R.string.f3x8f024ee1);
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return resources.getString(C0133R.string.common_google_play_services_notification_needs_update_title);
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return resources.getString(C0133R.string.common_google_play_services_needs_enabling_title);
            case Place.TYPE_ART_GALLERY /*5*/:
                return resources.getString(C0133R.string.common_google_play_services_invalid_account_text);
            case Place.TYPE_BAKERY /*7*/:
                return resources.getString(C0133R.string.common_google_play_services_network_error_text);
            case Place.TYPE_BAR /*9*/:
                return resources.getString(C0133R.string.common_google_play_services_unsupported_text);
            case Place.TYPE_CAMPGROUND /*16*/:
                return resources.getString(C0133R.string.commono_google_play_services_api_unavailable_text);
            case Place.TYPE_CAR_DEALER /*17*/:
                return resources.getString(C0133R.string.common_google_play_services_sign_in_failed_text);
            case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                return resources.getString(C0133R.string.common_android_wear_notification_needs_update_text);
            default:
                return resources.getString(C0133R.string.common_google_play_services_unknown_issue);
        }
    }

    private static boolean zzg(Context context, String str) {
        if (zzme.zzkl()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        try {
            if (context.getPackageManager().getApplicationInfo(str, AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD).enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean zzh(Context context, int i) {
        return i == 1 ? zzg(context, GOOGLE_PLAY_SERVICES_PACKAGE) : false;
    }

    public static boolean zzhO() {
        return zzLD ? zzLE : "user".equals(Build.TYPE);
    }

    public static boolean zzi(Context context, int i) {
        return i == 9 ? zzg(context, GOOGLE_PLAY_STORE_PACKAGE) : false;
    }
}
