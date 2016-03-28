package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.drive.ExecutionOptions;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

public final class zzwr {
    private final ByteBuffer zzaHA;

    public static class zza extends IOException {
        zza(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private zzwr(ByteBuffer byteBuffer) {
        this.zzaHA = byteBuffer;
    }

    private zzwr(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int zzA(int i, int i2) {
        return zziz(i) + zziw(i2);
    }

    public static int zzB(int i, int i2) {
        return zziz(i) + zzix(i2);
    }

    public static int zzN(long j) {
        return zzQ(j);
    }

    public static int zzO(long j) {
        return zzQ(zzS(j));
    }

    public static int zzQ(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long zzS(long j) {
        return (j << 1) ^ (j >> 63);
    }

    private static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < '\u0080') {
            i++;
        }
        int i2 = i;
        i = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= '\u0800') {
                i += zza(charSequence, i2);
                break;
            }
            i2++;
            i = ((127 - charAt) >>> 31) + i;
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    private static int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < '\u0800') {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if ('\ud800' <= charAt && charAt <= '\udfff') {
                    if (Character.codePointAt(charSequence, i3) < ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '\u0080') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '\u0080' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < '\u0800' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | TransportMediator.FLAG_KEY_MEDIA_NEXT);
            } else if ((charAt2 < '\ud800' || '\udfff' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | TransportMediator.FLAG_KEY_MEDIA_NEXT);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | TransportMediator.FLAG_KEY_MEDIA_NEXT);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | TransportMediator.FLAG_KEY_MEDIA_NEXT);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | TransportMediator.FLAG_KEY_MEDIA_NEXT);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | TransportMediator.FLAG_KEY_MEDIA_NEXT);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            zzb(charSequence, byteBuffer);
        }
    }

    public static int zzai(boolean z) {
        return 1;
    }

    public static int zzb(int i, double d) {
        return zziz(i) + zzf(d);
    }

    public static int zzb(int i, zzwy com_google_android_gms_internal_zzwy) {
        return (zziz(i) * 2) + zzd(com_google_android_gms_internal_zzwy);
    }

    public static int zzb(int i, byte[] bArr) {
        return zziz(i) + zzw(bArr);
    }

    public static zzwr zzb(byte[] bArr, int i, int i2) {
        return new zzwr(bArr, i, i2);
    }

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '\u0080') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < '\u0800') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | TransportMediator.FLAG_KEY_MEDIA_NEXT));
            } else if (charAt < '\ud800' || '\udfff' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | TransportMediator.FLAG_KEY_MEDIA_NEXT));
                byteBuffer.put((byte) ((charAt & 63) | TransportMediator.FLAG_KEY_MEDIA_NEXT));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | TransportMediator.FLAG_KEY_MEDIA_NEXT));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | TransportMediator.FLAG_KEY_MEDIA_NEXT));
                        byteBuffer.put((byte) ((toCodePoint & 63) | TransportMediator.FLAG_KEY_MEDIA_NEXT));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int zzc(int i, float f) {
        return zziz(i) + zzg(f);
    }

    public static int zzc(int i, zzwy com_google_android_gms_internal_zzwy) {
        return zziz(i) + zze(com_google_android_gms_internal_zzwy);
    }

    public static int zzc(int i, boolean z) {
        return zziz(i) + zzai(z);
    }

    public static int zzd(int i, long j) {
        return zziz(i) + zzN(j);
    }

    public static int zzd(zzwy com_google_android_gms_internal_zzwy) {
        return com_google_android_gms_internal_zzwy.zzvY();
    }

    public static int zzdM(String str) {
        int zza = zza(str);
        return zza + zziB(zza);
    }

    public static int zze(int i, long j) {
        return zziz(i) + zzO(j);
    }

    public static int zze(zzwy com_google_android_gms_internal_zzwy) {
        int zzvY = com_google_android_gms_internal_zzwy.zzvY();
        return zzvY + zziB(zzvY);
    }

    public static int zzf(double d) {
        return 8;
    }

    public static int zzg(float f) {
        return 4;
    }

    public static int zziB(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int zziD(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int zziw(int i) {
        return i >= 0 ? zziB(i) : 10;
    }

    public static int zzix(int i) {
        return zziB(zziD(i));
    }

    public static int zziz(int i) {
        return zziB(zzxb.zzD(i, 0));
    }

    public static int zzj(int i, String str) {
        return zziz(i) + zzdM(str);
    }

    public static zzwr zzu(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static int zzw(byte[] bArr) {
        return zziB(bArr.length) + bArr.length;
    }

    public void zzC(int i, int i2) throws IOException {
        zziA(zzxb.zzD(i, i2));
    }

    public void zzL(long j) throws IOException {
        zzP(j);
    }

    public void zzM(long j) throws IOException {
        zzP(zzS(j));
    }

    public void zzP(long j) throws IOException {
        while ((-128 & j) != 0) {
            zziy((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | TransportMediator.FLAG_KEY_MEDIA_NEXT);
            j >>>= 7;
        }
        zziy((int) j);
    }

    public void zzR(long j) throws IOException {
        zziy(((int) j) & MotionEventCompat.ACTION_MASK);
        zziy(((int) (j >> 8)) & MotionEventCompat.ACTION_MASK);
        zziy(((int) (j >> 16)) & MotionEventCompat.ACTION_MASK);
        zziy(((int) (j >> 24)) & MotionEventCompat.ACTION_MASK);
        zziy(((int) (j >> 32)) & MotionEventCompat.ACTION_MASK);
        zziy(((int) (j >> 40)) & MotionEventCompat.ACTION_MASK);
        zziy(((int) (j >> 48)) & MotionEventCompat.ACTION_MASK);
        zziy(((int) (j >> 56)) & MotionEventCompat.ACTION_MASK);
    }

    public void zza(int i, double d) throws IOException {
        zzC(i, 1);
        zze(d);
    }

    public void zza(int i, zzwy com_google_android_gms_internal_zzwy) throws IOException {
        zzC(i, 2);
        zzc(com_google_android_gms_internal_zzwy);
    }

    public void zza(int i, byte[] bArr) throws IOException {
        zzC(i, 2);
        zzv(bArr);
    }

    public void zzah(boolean z) throws IOException {
        zziy(z ? 1 : 0);
    }

    public void zzb(byte b) throws IOException {
        if (this.zzaHA.hasRemaining()) {
            this.zzaHA.put(b);
            return;
        }
        throw new zza(this.zzaHA.position(), this.zzaHA.limit());
    }

    public void zzb(int i, float f) throws IOException {
        zzC(i, 5);
        zzf(f);
    }

    public void zzb(int i, long j) throws IOException {
        zzC(i, 0);
        zzL(j);
    }

    public void zzb(int i, String str) throws IOException {
        zzC(i, 2);
        zzdL(str);
    }

    public void zzb(int i, boolean z) throws IOException {
        zzC(i, 0);
        zzah(z);
    }

    public void zzb(zzwy com_google_android_gms_internal_zzwy) throws IOException {
        com_google_android_gms_internal_zzwy.zza(this);
    }

    public void zzc(int i, long j) throws IOException {
        zzC(i, 0);
        zzM(j);
    }

    public void zzc(zzwy com_google_android_gms_internal_zzwy) throws IOException {
        zziA(com_google_android_gms_internal_zzwy.zzvX());
        com_google_android_gms_internal_zzwy.zza(this);
    }

    public void zzc(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzaHA.remaining() >= i2) {
            this.zzaHA.put(bArr, i, i2);
            return;
        }
        throw new zza(this.zzaHA.position(), this.zzaHA.limit());
    }

    public void zzdL(String str) throws IOException {
        try {
            int zziB = zziB(str.length());
            if (zziB == zziB(str.length() * 3)) {
                int position = this.zzaHA.position();
                this.zzaHA.position(position + zziB);
                zza((CharSequence) str, this.zzaHA);
                int position2 = this.zzaHA.position();
                this.zzaHA.position(position);
                zziA((position2 - position) - zziB);
                this.zzaHA.position(position2);
                return;
            }
            zziA(zza(str));
            zza((CharSequence) str, this.zzaHA);
        } catch (BufferOverflowException e) {
            throw new zza(this.zzaHA.position(), this.zzaHA.limit());
        }
    }

    public void zze(double d) throws IOException {
        zzR(Double.doubleToLongBits(d));
    }

    public void zzf(float f) throws IOException {
        zziC(Float.floatToIntBits(f));
    }

    public void zziA(int i) throws IOException {
        while ((i & -128) != 0) {
            zziy((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | TransportMediator.FLAG_KEY_MEDIA_NEXT);
            i >>>= 7;
        }
        zziy(i);
    }

    public void zziC(int i) throws IOException {
        zziy(i & MotionEventCompat.ACTION_MASK);
        zziy((i >> 8) & MotionEventCompat.ACTION_MASK);
        zziy((i >> 16) & MotionEventCompat.ACTION_MASK);
        zziy((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    public void zziu(int i) throws IOException {
        if (i >= 0) {
            zziA(i);
        } else {
            zzP((long) i);
        }
    }

    public void zziv(int i) throws IOException {
        zziA(zziD(i));
    }

    public void zziy(int i) throws IOException {
        zzb((byte) i);
    }

    public void zzv(byte[] bArr) throws IOException {
        zziA(bArr.length);
        zzx(bArr);
    }

    public int zzvJ() {
        return this.zzaHA.remaining();
    }

    public void zzvK() {
        if (zzvJ() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void zzx(byte[] bArr) throws IOException {
        zzc(bArr, 0, bArr.length);
    }

    public void zzy(int i, int i2) throws IOException {
        zzC(i, 0);
        zziu(i2);
    }

    public void zzz(int i, int i2) throws IOException {
        zzC(i, 0);
        zziv(i2);
    }
}
