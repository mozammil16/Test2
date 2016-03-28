package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

public interface AppContentCard extends Parcelable, Freezable<AppContentCard> {
    List<AppContentAction> getActions();

    String getDescription();

    Bundle getExtras();

    String getId();

    String getTitle();

    String getType();

    List<AppContentCondition> zzmI();

    String zzmJ();

    List<AppContentAnnotation> zzmT();

    int zzmU();

    String zzmV();

    int zzmW();
}
