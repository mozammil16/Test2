package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzbi implements Creator<SetDrivePreferencesRequest> {
    static void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, setDrivePreferencesRequest.zzFG);
        zzb.zza(parcel, 2, setDrivePreferencesRequest.zzUT, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcn(x0);
    }

    public SetDrivePreferencesRequest zzaU(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        DrivePreferences drivePreferences = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    drivePreferences = (DrivePreferences) zza.zza(parcel, zzI, DrivePreferences.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new SetDrivePreferencesRequest(i, drivePreferences);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public SetDrivePreferencesRequest[] zzcn(int i) {
        return new SetDrivePreferencesRequest[i];
    }
}
