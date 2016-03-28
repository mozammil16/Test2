package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzgi
public class zzhq<T> implements Future<T> {
    private final Object zznh;
    private boolean zzsg;
    private T zzzt;
    private boolean zzzu;

    public zzhq() {
        this.zznh = new Object();
        this.zzzt = null;
        this.zzzu = false;
        this.zzsg = false;
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        if (!mayInterruptIfRunning) {
            return false;
        }
        synchronized (this.zznh) {
            if (this.zzzu) {
                return false;
            }
            this.zzsg = true;
            this.zzzu = true;
            this.zznh.notifyAll();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.zznh) {
            if (!this.zzzu) {
                try {
                    this.zznh.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzsg) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.zzzt;
        }
        return t;
    }

    public T get(long timeout, TimeUnit unit) throws TimeoutException {
        T t;
        synchronized (this.zznh) {
            if (!this.zzzu) {
                try {
                    long toMillis = unit.toMillis(timeout);
                    if (toMillis != 0) {
                        this.zznh.wait(toMillis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.zzzu) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.zzsg) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.zzzt;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzsg;
        }
        return z;
    }

    public boolean isDone() {
        boolean z;
        synchronized (this.zznh) {
            z = this.zzzu;
        }
        return z;
    }

    public void zzb(T t) {
        synchronized (this.zznh) {
            if (this.zzzu) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            }
            this.zzzu = true;
            this.zzzt = t;
            this.zznh.notifyAll();
        }
    }
}
