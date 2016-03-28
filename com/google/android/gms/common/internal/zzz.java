package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzz implements Creator<zzy> {
    static void zza(zzy com_google_android_gms_common_internal_zzy, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, com_google_android_gms_common_internal_zzy.zzFG);
        zzb.zza(parcel, 2, com_google_android_gms_common_internal_zzy.getAccount(), i, false);
        zzb.zzc(parcel, 3, com_google_android_gms_common_internal_zzy.getSessionId());
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaM(x0);
    }

    public zzy zzF(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            Account account2;
            int zzg;
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    int i3 = i;
                    account2 = account;
                    zzg = zza.zzg(parcel, zzI);
                    zzI = i3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i2;
                    Account account3 = (Account) zza.zza(parcel, zzI, Account.CREATOR);
                    zzI = i;
                    account2 = account3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    zzI = zza.zzg(parcel, zzI);
                    account2 = account;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    zzI = i;
                    account2 = account;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            account = account2;
            i = zzI;
        }
        if (parcel.dataPosition() == zzJ) {
            return new zzy(i2, account, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public zzy[] zzaM(int i) {
        return new zzy[i];
    }
}
