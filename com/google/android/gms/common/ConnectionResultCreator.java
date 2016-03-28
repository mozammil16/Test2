package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class ConnectionResultCreator implements Creator<ConnectionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(ConnectionResult connectionResult, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, connectionResult.zzFG);
        zzb.zzc(parcel, 2, connectionResult.getErrorCode());
        zzb.zza(parcel, 3, connectionResult.getResolution(), i, false);
        zzb.zzH(parcel, zzK);
    }

    public ConnectionResult createFromParcel(Parcel parcel) {
        int i = 0;
        int zzJ = zza.zzJ(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzI, PendingIntent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new ConnectionResult(i2, i, pendingIntent);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public ConnectionResult[] newArray(int size) {
        return new ConnectionResult[size];
    }
}
