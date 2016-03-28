package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.List;

public class AccountChangeEventsResponseCreator implements Creator<AccountChangeEventsResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(AccountChangeEventsResponse accountChangeEventsResponse, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, accountChangeEventsResponse.zzHe);
        zzb.zzc(parcel, 2, accountChangeEventsResponse.zzmv, false);
        zzb.zzH(parcel, zzK);
    }

    public AccountChangeEventsResponse createFromParcel(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    list = zza.zzc(parcel, zzI, AccountChangeEvent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new AccountChangeEventsResponse(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public AccountChangeEventsResponse[] newArray(int size) {
        return new AccountChangeEventsResponse[size];
    }
}
