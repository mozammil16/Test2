package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import java.util.List;

public class zzc implements Creator<ParcelableEvent> {
    static void zza(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int zzK = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, parcelableEvent.zzFG);
        zzb.zza(parcel, 2, parcelableEvent.zzyL, false);
        zzb.zza(parcel, 3, parcelableEvent.zzWZ, false);
        zzb.zzb(parcel, 4, parcelableEvent.zzXh, false);
        zzb.zza(parcel, 5, parcelableEvent.zzXi);
        zzb.zza(parcel, 6, parcelableEvent.zzXc, false);
        zzb.zza(parcel, 7, parcelableEvent.zzXl, false);
        zzb.zza(parcel, 8, parcelableEvent.zzXm, i, false);
        zzb.zza(parcel, 9, parcelableEvent.zzXn, i, false);
        zzb.zza(parcel, 10, parcelableEvent.zzXo, i, false);
        zzb.zza(parcel, 11, parcelableEvent.zzXp, i, false);
        zzb.zza(parcel, 12, parcelableEvent.zzXq, i, false);
        zzb.zza(parcel, 13, parcelableEvent.zzXr, i, false);
        zzb.zza(parcel, 14, parcelableEvent.zzXs, i, false);
        zzb.zza(parcel, 15, parcelableEvent.zzXt, i, false);
        zzb.zza(parcel, 17, parcelableEvent.zzXk);
        zzb.zza(parcel, 16, parcelableEvent.zzXj);
        zzb.zza(parcel, 18, parcelableEvent.zzXu, i, false);
        zzb.zzH(parcel, zzK);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcU(x0);
    }

    public ParcelableEvent zzbA(Parcel parcel) {
        int zzJ = zza.zzJ(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str3 = null;
        String str4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
        ObjectChangedDetails objectChangedDetails = null;
        FieldChangedDetails fieldChangedDetails = null;
        while (parcel.dataPosition() < zzJ) {
            int zzI = zza.zzI(parcel);
            switch (zza.zzaP(zzI)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzI);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_AQUARIUM /*4*/:
                    list = zza.zzC(parcel, zzI);
                    break;
                case Place.TYPE_ART_GALLERY /*5*/:
                    z = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_ATM /*6*/:
                    str3 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BAKERY /*7*/:
                    str4 = zza.zzo(parcel, zzI);
                    break;
                case Place.TYPE_BANK /*8*/:
                    textInsertedDetails = (TextInsertedDetails) zza.zza(parcel, zzI, TextInsertedDetails.CREATOR);
                    break;
                case Place.TYPE_BAR /*9*/:
                    textDeletedDetails = (TextDeletedDetails) zza.zza(parcel, zzI, TextDeletedDetails.CREATOR);
                    break;
                case Place.TYPE_BEAUTY_SALON /*10*/:
                    valuesAddedDetails = (ValuesAddedDetails) zza.zza(parcel, zzI, ValuesAddedDetails.CREATOR);
                    break;
                case Place.TYPE_BICYCLE_STORE /*11*/:
                    valuesRemovedDetails = (ValuesRemovedDetails) zza.zza(parcel, zzI, ValuesRemovedDetails.CREATOR);
                    break;
                case Place.TYPE_BOOK_STORE /*12*/:
                    valuesSetDetails = (ValuesSetDetails) zza.zza(parcel, zzI, ValuesSetDetails.CREATOR);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    valueChangedDetails = (ValueChangedDetails) zza.zza(parcel, zzI, ValueChangedDetails.CREATOR);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    referenceShiftedDetails = (ReferenceShiftedDetails) zza.zza(parcel, zzI, ReferenceShiftedDetails.CREATOR);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    objectChangedDetails = (ObjectChangedDetails) zza.zza(parcel, zzI, ObjectChangedDetails.CREATOR);
                    break;
                case Place.TYPE_CAMPGROUND /*16*/:
                    z2 = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_CAR_DEALER /*17*/:
                    z3 = zza.zzc(parcel, zzI);
                    break;
                case Place.TYPE_CAR_RENTAL /*18*/:
                    fieldChangedDetails = (FieldChangedDetails) zza.zza(parcel, zzI, FieldChangedDetails.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzI);
                    break;
            }
        }
        if (parcel.dataPosition() == zzJ) {
            return new ParcelableEvent(i, str, str2, list, z, z2, z3, str3, str4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails, objectChangedDetails, fieldChangedDetails);
        }
        throw new zza.zza("Overread allowed size end=" + zzJ, parcel);
    }

    public ParcelableEvent[] zzcU(int i) {
        return new ParcelableEvent[i];
    }
}
