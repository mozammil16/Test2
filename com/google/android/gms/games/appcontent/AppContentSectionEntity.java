package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
    public static final AppContentSectionEntityCreator CREATOR;
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final String zzFA;
    private final int zzFG;
    private final String zzSy;
    private final ArrayList<AppContentCardEntity> zzadD;
    private final String zzadE;
    private final String zzadl;
    private final ArrayList<AppContentAnnotationEntity> zzadu;
    private final String zzadw;
    private final String zzxV;

    static {
        CREATOR = new AppContentSectionEntityCreator();
    }

    AppContentSectionEntity(int versionCode, ArrayList<AppContentActionEntity> actions, ArrayList<AppContentCardEntity> cards, String contentDescription, Bundle extras, String subtitle, String title, String type, String id, String cardType, ArrayList<AppContentAnnotationEntity> annotations) {
        this.zzFG = versionCode;
        this.mActions = actions;
        this.zzadu = annotations;
        this.zzadD = cards;
        this.zzadE = cardType;
        this.zzadl = contentDescription;
        this.mExtras = extras;
        this.zzFA = id;
        this.zzadw = subtitle;
        this.zzSy = title;
        this.zzxV = type;
    }

    public AppContentSectionEntity(AppContentSection section) {
        int i;
        int i2 = 0;
        this.zzFG = 5;
        this.zzadE = section.zzne();
        this.zzadl = section.zzmJ();
        this.mExtras = section.getExtras();
        this.zzFA = section.getId();
        this.zzadw = section.zzmV();
        this.zzSy = section.getTitle();
        this.zzxV = section.getType();
        List actions = section.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = section.zznd();
        size = actions.size();
        this.zzadD = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.zzadD.add((AppContentCardEntity) ((AppContentCard) actions.get(i)).freeze());
        }
        List zzmT = section.zzmT();
        int size2 = zzmT.size();
        this.zzadu = new ArrayList(size2);
        while (i2 < size2) {
            this.zzadu.add((AppContentAnnotationEntity) ((AppContentAnnotation) zzmT.get(i2)).freeze());
            i2++;
        }
    }

    static int zza(AppContentSection appContentSection) {
        return zzw.hashCode(appContentSection.getActions(), appContentSection.zzmT(), appContentSection.zznd(), appContentSection.zzne(), appContentSection.zzmJ(), appContentSection.getExtras(), appContentSection.getId(), appContentSection.zzmV(), appContentSection.getTitle(), appContentSection.getType());
    }

    static boolean zza(AppContentSection appContentSection, Object obj) {
        if (!(obj instanceof AppContentSection)) {
            return false;
        }
        if (appContentSection == obj) {
            return true;
        }
        AppContentSection appContentSection2 = (AppContentSection) obj;
        return zzw.equal(appContentSection2.getActions(), appContentSection.getActions()) && zzw.equal(appContentSection2.zzmT(), appContentSection.zzmT()) && zzw.equal(appContentSection2.zznd(), appContentSection.zznd()) && zzw.equal(appContentSection2.zzne(), appContentSection.zzne()) && zzw.equal(appContentSection2.zzmJ(), appContentSection.zzmJ()) && zzw.equal(appContentSection2.getExtras(), appContentSection.getExtras()) && zzw.equal(appContentSection2.getId(), appContentSection.getId()) && zzw.equal(appContentSection2.zzmV(), appContentSection.zzmV()) && zzw.equal(appContentSection2.getTitle(), appContentSection.getTitle()) && zzw.equal(appContentSection2.getType(), appContentSection.getType());
    }

    static String zzb(AppContentSection appContentSection) {
        return zzw.zzk(appContentSection).zza("Actions", appContentSection.getActions()).zza("Annotations", appContentSection.zzmT()).zza("Cards", appContentSection.zznd()).zza("CardType", appContentSection.zzne()).zza("ContentDescription", appContentSection.zzmJ()).zza("Extras", appContentSection.getExtras()).zza("Id", appContentSection.getId()).zza("Subtitle", appContentSection.zzmV()).zza("Title", appContentSection.getTitle()).zza("Type", appContentSection.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zznf();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzFA;
    }

    public String getTitle() {
        return this.zzSy;
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
        AppContentSectionEntityCreator.zza(this, out, flags);
    }

    public String zzmJ() {
        return this.zzadl;
    }

    public List<AppContentAnnotation> zzmT() {
        return new ArrayList(this.zzadu);
    }

    public String zzmV() {
        return this.zzadw;
    }

    public List<AppContentCard> zznd() {
        return new ArrayList(this.zzadD);
    }

    public String zzne() {
        return this.zzadE;
    }

    public AppContentSection zznf() {
        return this;
    }
}
