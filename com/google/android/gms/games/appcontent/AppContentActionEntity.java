package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity implements SafeParcelable, AppContentAction {
    public static final AppContentActionEntityCreator CREATOR;
    private final Bundle mExtras;
    private final String zzFA;
    private final int zzFG;
    private final ArrayList<AppContentConditionEntity> zzadk;
    private final String zzadl;
    private final AppContentAnnotationEntity zzadm;
    private final String zzadn;
    private final String zzxV;

    static {
        CREATOR = new AppContentActionEntityCreator();
    }

    AppContentActionEntity(int versionCode, ArrayList<AppContentConditionEntity> conditions, String contentDescription, Bundle extras, String type, String id, AppContentAnnotationEntity annotation, String overflowText) {
        this.zzFG = versionCode;
        this.zzadm = annotation;
        this.zzadk = conditions;
        this.zzadl = contentDescription;
        this.mExtras = extras;
        this.zzFA = id;
        this.zzadn = overflowText;
        this.zzxV = type;
    }

    public AppContentActionEntity(AppContentAction action) {
        this.zzFG = 5;
        this.zzadm = (AppContentAnnotationEntity) action.zzmH().freeze();
        this.zzadl = action.zzmJ();
        this.mExtras = action.getExtras();
        this.zzFA = action.getId();
        this.zzadn = action.zzmK();
        this.zzxV = action.getType();
        List zzmI = action.zzmI();
        int size = zzmI.size();
        this.zzadk = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzadk.add((AppContentConditionEntity) ((AppContentCondition) zzmI.get(i)).freeze());
        }
    }

    static int zza(AppContentAction appContentAction) {
        return zzw.hashCode(appContentAction.zzmH(), appContentAction.zzmI(), appContentAction.zzmJ(), appContentAction.getExtras(), appContentAction.getId(), appContentAction.zzmK(), appContentAction.getType());
    }

    static boolean zza(AppContentAction appContentAction, Object obj) {
        if (!(obj instanceof AppContentAction)) {
            return false;
        }
        if (appContentAction == obj) {
            return true;
        }
        AppContentAction appContentAction2 = (AppContentAction) obj;
        return zzw.equal(appContentAction2.zzmH(), appContentAction.zzmH()) && zzw.equal(appContentAction2.zzmI(), appContentAction.zzmI()) && zzw.equal(appContentAction2.zzmJ(), appContentAction.zzmJ()) && zzw.equal(appContentAction2.getExtras(), appContentAction.getExtras()) && zzw.equal(appContentAction2.getId(), appContentAction.getId()) && zzw.equal(appContentAction2.zzmK(), appContentAction.zzmK()) && zzw.equal(appContentAction2.getType(), appContentAction.getType());
    }

    static String zzb(AppContentAction appContentAction) {
        return zzw.zzk(appContentAction).zza("Annotation", appContentAction.zzmH()).zza("Conditions", appContentAction.zzmI()).zza("ContentDescription", appContentAction.zzmJ()).zza("Extras", appContentAction.getExtras()).zza("Id", appContentAction.getId()).zza("OverflowText", appContentAction.zzmK()).zza("Type", appContentAction.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzmL();
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzFA;
    }

    public String getType() {
        return this.zzxV;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentActionEntityCreator.zza(this, out, flags);
    }

    public AppContentAnnotation zzmH() {
        return this.zzadm;
    }

    public List<AppContentCondition> zzmI() {
        return new ArrayList(this.zzadk);
    }

    public String zzmJ() {
        return this.zzadl;
    }

    public String zzmK() {
        return this.zzadn;
    }

    public AppContentAction zzmL() {
        return this;
    }
}
