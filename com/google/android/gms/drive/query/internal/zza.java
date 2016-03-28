package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zza implements Creator<ComparisonFilter> {
    static void zza(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, comparisonFilter.zzFG);
        zzb.zza(parcel, 1, comparisonFilter.zzWw, i, false);
        zzb.zza(parcel, 2, comparisonFilter.zzWx, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcC(x0);
    }

    public ComparisonFilter zzbj(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int zzJ = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < zzJ) {
            int i2;
            MetadataBundle metadataBundle2;
            Operator operator2;
            int zzI = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    Operator operator3 = (Operator) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzI, Operator.CREATOR);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    metadataBundle2 = (MetadataBundle) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzI, MetadataBundle.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    operator2 = operator;
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzI);
                    metadataBundle2 = metadataBundle3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzI);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == zzJ) {
            return new ComparisonFilter(i, operator, metadataBundle);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public ComparisonFilter[] zzcC(int i) {
        return new ComparisonFilter[i];
    }
}
