package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object zzahN;
    private Handler zzahO;
    private boolean zzahP;
    private HashMap<String, AtomicInteger> zzahQ;
    private int zzahR;

    /* renamed from: com.google.android.gms.games.internal.events.EventIncrementCache.1 */
    class C01721 implements Runnable {
        final /* synthetic */ EventIncrementCache zzahS;

        C01721(EventIncrementCache eventIncrementCache) {
            this.zzahS = eventIncrementCache;
        }

        public void run() {
            this.zzahS.zzog();
        }
    }

    public EventIncrementCache(Looper looper, int flushIntervalMillis) {
        this.zzahN = new Object();
        this.zzahO = new Handler(looper);
        this.zzahQ = new HashMap();
        this.zzahR = flushIntervalMillis;
    }

    private void zzog() {
        synchronized (this.zzahN) {
            this.zzahP = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.zzahN) {
            for (Entry entry : this.zzahQ.entrySet()) {
                zzs((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.zzahQ.clear();
        }
    }

    protected abstract void zzs(String str, int i);

    public void zzz(String str, int i) {
        synchronized (this.zzahN) {
            if (!this.zzahP) {
                this.zzahP = true;
                this.zzahO.postDelayed(new C01721(this), (long) this.zzahR);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.zzahQ.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzahQ.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
