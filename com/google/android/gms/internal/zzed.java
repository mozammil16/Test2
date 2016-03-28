package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C0133R;
import java.util.Map;

@zzgi
public class zzed extends zzeg {
    private final Context mContext;
    private final Map<String, String> zzsZ;

    /* renamed from: com.google.android.gms.internal.zzed.1 */
    class C02111 implements OnClickListener {
        final /* synthetic */ String zztx;
        final /* synthetic */ String zzty;
        final /* synthetic */ zzed zztz;

        C02111(zzed com_google_android_gms_internal_zzed, String str, String str2) {
            this.zztz = com_google_android_gms_internal_zzed;
            this.zztx = str;
            this.zzty = str2;
        }

        public void onClick(DialogInterface dialog, int which) {
            try {
                ((DownloadManager) this.zztz.mContext.getSystemService("download")).enqueue(this.zztz.zzf(this.zztx, this.zzty));
            } catch (IllegalStateException e) {
                this.zztz.zzH("Could not store picture.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzed.2 */
    class C02122 implements OnClickListener {
        final /* synthetic */ zzed zztz;

        C02122(zzed com_google_android_gms_internal_zzed) {
            this.zztz = com_google_android_gms_internal_zzed;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.zztz.zzH("User canceled the download.");
        }
    }

    public zzed(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
        super(com_google_android_gms_internal_zzic, "storePicture");
        this.zzsZ = map;
        this.mContext = com_google_android_gms_internal_zzic.zzeD();
    }

    public void execute() {
        if (this.mContext == null) {
            zzH("Activity context is not available");
        } else if (zzab.zzaM().zzx(this.mContext).zzbR()) {
            String str = (String) this.zzsZ.get("iurl");
            if (TextUtils.isEmpty(str)) {
                zzH("Image url cannot be empty.");
            } else if (URLUtil.isValidUrl(str)) {
                String zzG = zzG(str);
                if (zzab.zzaM().zzU(zzG)) {
                    Builder zzw = zzab.zzaM().zzw(this.mContext);
                    zzw.setTitle(zzab.zzaP().zzc(C0133R.string.store_picture_title, "Save image"));
                    zzw.setMessage(zzab.zzaP().zzc(C0133R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                    zzw.setPositiveButton(zzab.zzaP().zzc(C0133R.string.accept, "Accept"), new C02111(this, str, zzG));
                    zzw.setNegativeButton(zzab.zzaP().zzc(C0133R.string.decline, "Decline"), new C02122(this));
                    zzw.create().show();
                    return;
                }
                zzH("Image type not recognized: " + zzG);
            } else {
                zzH("Invalid image url: " + str);
            }
        } else {
            zzH("Feature is not supported by the device.");
        }
    }

    String zzG(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    Request zzf(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        zzab.zzaO().zza(request);
        return request;
    }
}
