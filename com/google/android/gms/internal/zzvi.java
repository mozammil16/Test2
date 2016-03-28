package com.google.android.gms.internal;

import com.google.android.gms.internal.zzvl.zzc;
import com.google.android.gms.internal.zzvl.zzg;
import com.google.android.gms.tagmanager.zzbf;
import org.json.JSONException;

public final class zzvi {
    public static zzvh zzaBX;

    /* renamed from: com.google.android.gms.internal.zzvi.1 */
    static class C04341 implements zzvh {
        C04341() {
        }

        public Object zzn(byte[] bArr) throws zzg {
            if (bArr == null) {
                throw new zzg("Cannot parse a null byte[]");
            } else if (bArr.length == 0) {
                throw new zzg("Cannot parse a 0 length byte[]");
            } else {
                try {
                    zzc zzdd = zzvf.zzdd(new String(bArr));
                    if (zzdd != null) {
                        zzbf.zzab("The container was successfully parsed from the resource");
                    }
                    return zzdd;
                } catch (JSONException e) {
                    throw new zzg("The resource data is corrupted. The container cannot be extracted from the binary data");
                } catch (zzg e2) {
                    throw new zzg("The resource data is invalid. The container cannot be extracted from the binary data");
                }
            }
        }
    }

    static {
        zzaBX = new C04341();
    }
}
