package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.internal.zziv.zza;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;

public class zziw implements Creator<zza> {
    static void zza(zza com_google_android_gms_internal_zziv_zza, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zza(parcel, 1, com_google_android_gms_internal_zziv_zza.zzFY, i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, com_google_android_gms_internal_zziv_zza.zzFG);
        zzb.zza(parcel, 2, com_google_android_gms_internal_zziv_zza.zzFZ);
        zzb.zza(parcel, 3, com_google_android_gms_internal_zziv_zza.zzGa);
        zzb.zza(parcel, 4, com_google_android_gms_internal_zziv_zza.zzGb);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzT(x0);
    }

    public zza[] zzT(int i) {
        return new zza[i];
    }

    public zza zzp(Parcel parcel) {
        boolean z = false;
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        Account account = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    account = (Account) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzI, Account.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzI);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new zza(i, account, z3, z2, z);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }
}
