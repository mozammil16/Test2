package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameNotificationBuffer extends AbstractDataBuffer<GameNotification> {
    public /* synthetic */ Object get(int x0) {
        return zzeR(x0);
    }

    public GameNotification zzeR(int i) {
        return new GameNotificationRef(this.zzMd, i);
    }
}
