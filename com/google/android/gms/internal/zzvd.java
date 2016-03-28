package com.google.android.gms.internal;

import com.google.android.gms.internal.zzc.zzf;
import com.google.android.gms.internal.zzc.zzj;
import com.google.android.gms.location.places.Place;
import java.io.IOException;

public interface zzvd {

    public static final class zza extends zzws<zza> {
        public long zzaBK;
        public zzj zzaBL;
        public zzf zzgs;

        public zza() {
            zzug();
        }

        public static zza zzm(byte[] bArr) throws zzwx {
            return (zza) zzwy.zza(new zza(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzvd_zza = (zza) o;
            if (this.zzaBK != com_google_android_gms_internal_zzvd_zza.zzaBK) {
                return false;
            }
            if (this.zzgs == null) {
                if (com_google_android_gms_internal_zzvd_zza.zzgs != null) {
                    return false;
                }
            } else if (!this.zzgs.equals(com_google_android_gms_internal_zzvd_zza.zzgs)) {
                return false;
            }
            if (this.zzaBL == null) {
                if (com_google_android_gms_internal_zzvd_zza.zzaBL != null) {
                    return false;
                }
            } else if (!this.zzaBL.equals(com_google_android_gms_internal_zzvd_zza.zzaBL)) {
                return false;
            }
            return zza((zzws) com_google_android_gms_internal_zzvd_zza);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzgs == null ? 0 : this.zzgs.hashCode()) + ((((int) (this.zzaBK ^ (this.zzaBK >>> 32))) + 527) * 31)) * 31;
            if (this.zzaBL != null) {
                i = this.zzaBL.hashCode();
            }
            return ((hashCode + i) * 31) + zzvL();
        }

        public void zza(zzwr com_google_android_gms_internal_zzwr) throws IOException {
            com_google_android_gms_internal_zzwr.zzb(1, this.zzaBK);
            if (this.zzgs != null) {
                com_google_android_gms_internal_zzwr.zza(2, this.zzgs);
            }
            if (this.zzaBL != null) {
                com_google_android_gms_internal_zzwr.zza(3, this.zzaBL);
            }
            super.zza(com_google_android_gms_internal_zzwr);
        }

        public /* synthetic */ zzwy zzb(zzwq com_google_android_gms_internal_zzwq) throws IOException {
            return zzt(com_google_android_gms_internal_zzwq);
        }

        protected int zzc() {
            int zzc = super.zzc() + zzwr.zzd(1, this.zzaBK);
            if (this.zzgs != null) {
                zzc += zzwr.zzc(2, this.zzgs);
            }
            return this.zzaBL != null ? zzc + zzwr.zzc(3, this.zzaBL) : zzc;
        }

        public zza zzt(zzwq com_google_android_gms_internal_zzwq) throws IOException {
            while (true) {
                int zzvu = com_google_android_gms_internal_zzwq.zzvu();
                switch (zzvu) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Place.TYPE_BANK /*8*/:
                        this.zzaBK = com_google_android_gms_internal_zzwq.zzvw();
                        continue;
                    case Place.TYPE_CAR_RENTAL /*18*/:
                        if (this.zzgs == null) {
                            this.zzgs = new zzf();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzgs);
                        continue;
                    case Place.TYPE_CONVENIENCE_STORE /*26*/:
                        if (this.zzaBL == null) {
                            this.zzaBL = new zzj();
                        }
                        com_google_android_gms_internal_zzwq.zza(this.zzaBL);
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzwq, zzvu)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zza zzug() {
            this.zzaBK = 0;
            this.zzgs = null;
            this.zzaBL = null;
            this.zzaHB = null;
            this.zzaHM = -1;
            return this;
        }
    }
}
