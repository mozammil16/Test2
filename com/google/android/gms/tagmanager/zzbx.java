package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class zzbx implements zzat {
    private static final String zzES;
    private final Context mContext;
    private final String zzEW;
    private long zzEY;
    private final int zzEZ;
    private final zzb zzazq;
    private volatile zzab zzazr;
    private final zzau zzazs;
    private zzlv zzmW;

    class zzb extends SQLiteOpenHelper {
        private boolean zzFa;
        private long zzFb;
        final /* synthetic */ zzbx zzazt;

        zzb(zzbx com_google_android_gms_tagmanager_zzbx, Context context, String str) {
            this.zzazt = com_google_android_gms_tagmanager_zzbx;
            super(context, str, null, 1);
            this.zzFb = 0;
        }

        private void zza(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        private boolean zza(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        zzbf.zzac("Error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                zzbf.zzac("Error querying for table " + str);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.zzFa || this.zzFb + 3600000 <= this.zzazt.zzmW.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.zzFa = true;
                this.zzFb = this.zzazt.zzmW.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.zzazt.mContext.getDatabasePath(this.zzazt.zzEW).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.zzFa = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onCreate(SQLiteDatabase db) {
            zzak.zzam(db.getPath());
        }

        public void onOpen(SQLiteDatabase db) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (zza("gtm_hits", db)) {
                zza(db);
            } else {
                db.execSQL(zzbx.zzES);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    class zza implements com.google.android.gms.tagmanager.zzcw.zza {
        final /* synthetic */ zzbx zzazt;

        zza(zzbx com_google_android_gms_tagmanager_zzbx) {
            this.zzazt = com_google_android_gms_tagmanager_zzbx;
        }

        public void zza(zzap com_google_android_gms_tagmanager_zzap) {
            this.zzazt.zzH(com_google_android_gms_tagmanager_zzap.zzgs());
        }

        public void zzb(zzap com_google_android_gms_tagmanager_zzap) {
            this.zzazt.zzH(com_google_android_gms_tagmanager_zzap.zzgs());
            zzbf.zzab("Permanent failure dispatching hitId: " + com_google_android_gms_tagmanager_zzap.zzgs());
        }

        public void zzc(zzap com_google_android_gms_tagmanager_zzap) {
            long zztj = com_google_android_gms_tagmanager_zzap.zztj();
            if (zztj == 0) {
                this.zzazt.zzd(com_google_android_gms_tagmanager_zzap.zzgs(), this.zzazt.zzmW.currentTimeMillis());
            } else if (zztj + 14400000 < this.zzazt.zzmW.currentTimeMillis()) {
                this.zzazt.zzH(com_google_android_gms_tagmanager_zzap.zzgs());
                zzbf.zzab("Giving up on failed hitId: " + com_google_android_gms_tagmanager_zzap.zzgs());
            }
        }
    }

    static {
        zzES = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    }

    zzbx(zzau com_google_android_gms_tagmanager_zzau, Context context) {
        this(com_google_android_gms_tagmanager_zzau, context, "gtm_urls.db", GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS);
    }

    zzbx(zzau com_google_android_gms_tagmanager_zzau, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.zzEW = str;
        this.zzazs = com_google_android_gms_tagmanager_zzau;
        this.zzmW = zzlx.zzkc();
        this.zzazq = new zzb(this, this.mContext, this.zzEW);
        this.zzazr = new zzcw(new DefaultHttpClient(), this.mContext, new zza(this));
        this.zzEY = 0;
        this.zzEZ = i;
    }

    private void zzH(long j) {
        zzb(new String[]{String.valueOf(j)});
    }

    private SQLiteDatabase zzar(String str) {
        try {
            return this.zzazq.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbf.zzac(str);
            return null;
        }
    }

    private void zzd(long j, long j2) {
        SQLiteDatabase zzar = zzar("Error opening database for getNumStoredHits.");
        if (zzar != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                zzar.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e) {
                zzbf.zzac("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
                zzH(j);
            }
        }
    }

    private void zzg(long j, String str) {
        SQLiteDatabase zzar = zzar("Error opening database for putHit");
        if (zzar != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", Integer.valueOf(0));
            try {
                zzar.insert("gtm_hits", null, contentValues);
                this.zzazs.zzD(false);
            } catch (SQLiteException e) {
                zzbf.zzac("Error storing hit");
            }
        }
    }

    private void zzgy() {
        int zzgA = (zzgA() - this.zzEZ) + 1;
        if (zzgA > 0) {
            List zzM = zzM(zzgA);
            zzbf.zzab("Store full, deleting " + zzM.size() + " hits to make room.");
            zzb((String[]) zzM.toArray(new String[0]));
        }
    }

    public void dispatch() {
        zzbf.zzab("GTM Dispatch running...");
        if (this.zzazr.zzfk()) {
            List zzN = zzN(40);
            if (zzN.isEmpty()) {
                zzbf.zzab("...nothing to dispatch");
                this.zzazs.zzD(true);
                return;
            }
            this.zzazr.zzt(zzN);
            if (zztv() > 0) {
                zzct.zztR().dispatch();
            }
        }
    }

    List<String> zzM(int i) {
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            zzbf.zzac("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase zzar = zzar("Error opening database for peekHitIds.");
        if (zzar == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = zzar.query("gtm_hits", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzbf.zzac("Error in peekHits fetching hitIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            zzbf.zzac("Error in peekHits fetching hitIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.tagmanager.zzap> zzN(int r17) {
        /*
        r16 = this;
        r11 = new java.util.ArrayList;
        r11.<init>();
        r2 = "Error opening database for peekHits";
        r0 = r16;
        r2 = r0.zzar(r2);
        if (r2 != 0) goto L_0x0011;
    L_0x000f:
        r2 = r11;
    L_0x0010:
        return r2;
    L_0x0011:
        r12 = 0;
        r3 = "gtm_hits";
        r4 = 3;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r5 = 1;
        r6 = "hit_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r5 = 2;
        r6 = "hit_first_send_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r13 = 0;
        r14 = "hit_id";
        r10[r13] = r14;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r12 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0171, all -> 0x016b }
        r12.<init>();	 Catch:{ SQLiteException -> 0x0171, all -> 0x016b }
        r3 = r13.moveToFirst();	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        if (r3 == 0) goto L_0x0068;
    L_0x004b:
        r3 = new com.google.android.gms.tagmanager.zzap;	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r4 = 0;
        r4 = r13.getLong(r4);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r6 = 1;
        r6 = r13.getLong(r6);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r8 = 2;
        r8 = r13.getLong(r8);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r3.<init>(r4, r6, r8);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r12.add(r3);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r3 = r13.moveToNext();	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        if (r3 != 0) goto L_0x004b;
    L_0x0068:
        if (r13 == 0) goto L_0x006d;
    L_0x006a:
        r13.close();
    L_0x006d:
        r11 = 0;
        r3 = "gtm_hits";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0169 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0169 }
        r5 = 1;
        r6 = "hit_url";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0169 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x0169 }
        r14 = 0;
        r15 = "hit_id";
        r10[r14] = r15;	 Catch:{ SQLiteException -> 0x0169 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x0169 }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x0169 }
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0169 }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        if (r2 == 0) goto L_0x00c2;
    L_0x009d:
        r4 = r11;
    L_0x009e:
        r0 = r3;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = r0;
        r2 = r2.getWindow();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = r2.getNumRows();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        if (r2 <= 0) goto L_0x00f6;
    L_0x00ac:
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = (com.google.android.gms.tagmanager.zzap) r2;	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2.zzaq(r5);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
    L_0x00ba:
        r2 = r4 + 1;
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        if (r4 != 0) goto L_0x017d;
    L_0x00c2:
        if (r3 == 0) goto L_0x00c7;
    L_0x00c4:
        r3.close();
    L_0x00c7:
        r2 = r12;
        goto L_0x0010;
    L_0x00ca:
        r2 = move-exception;
        r3 = r2;
        r4 = r12;
        r2 = r11;
    L_0x00ce:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x016e }
        r5.<init>();	 Catch:{ all -> 0x016e }
        r6 = "Error in peekHits fetching hitIds: ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x016e }
        r3 = r3.getMessage();	 Catch:{ all -> 0x016e }
        r3 = r5.append(r3);	 Catch:{ all -> 0x016e }
        r3 = r3.toString();	 Catch:{ all -> 0x016e }
        com.google.android.gms.tagmanager.zzbf.zzac(r3);	 Catch:{ all -> 0x016e }
        if (r4 == 0) goto L_0x0010;
    L_0x00ea:
        r4.close();
        goto L_0x0010;
    L_0x00ef:
        r2 = move-exception;
    L_0x00f0:
        if (r12 == 0) goto L_0x00f5;
    L_0x00f2:
        r12.close();
    L_0x00f5:
        throw r2;
    L_0x00f6:
        r5 = "HitString for hitId %d too large.  Hit will be deleted.";
        r2 = 1;
        r6 = new java.lang.Object[r2];	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r7 = 0;
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = (com.google.android.gms.tagmanager.zzap) r2;	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r8 = r2.zzgs();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r6[r7] = r2;	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = java.lang.String.format(r5, r6);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        com.google.android.gms.tagmanager.zzbf.zzac(r2);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        goto L_0x00ba;
    L_0x0114:
        r2 = move-exception;
        r13 = r3;
    L_0x0116:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x015f }
        r3.<init>();	 Catch:{ all -> 0x015f }
        r4 = "Error in peekHits fetching hit url: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x015f }
        r2 = r2.getMessage();	 Catch:{ all -> 0x015f }
        r2 = r3.append(r2);	 Catch:{ all -> 0x015f }
        r2 = r2.toString();	 Catch:{ all -> 0x015f }
        com.google.android.gms.tagmanager.zzbf.zzac(r2);	 Catch:{ all -> 0x015f }
        r3 = new java.util.ArrayList;	 Catch:{ all -> 0x015f }
        r3.<init>();	 Catch:{ all -> 0x015f }
        r4 = 0;
        r5 = r12.iterator();	 Catch:{ all -> 0x015f }
    L_0x013a:
        r2 = r5.hasNext();	 Catch:{ all -> 0x015f }
        if (r2 == 0) goto L_0x0152;
    L_0x0140:
        r2 = r5.next();	 Catch:{ all -> 0x015f }
        r2 = (com.google.android.gms.tagmanager.zzap) r2;	 Catch:{ all -> 0x015f }
        r6 = r2.zztk();	 Catch:{ all -> 0x015f }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x015f }
        if (r6 == 0) goto L_0x015b;
    L_0x0150:
        if (r4 == 0) goto L_0x015a;
    L_0x0152:
        if (r13 == 0) goto L_0x0157;
    L_0x0154:
        r13.close();
    L_0x0157:
        r2 = r3;
        goto L_0x0010;
    L_0x015a:
        r4 = 1;
    L_0x015b:
        r3.add(r2);	 Catch:{ all -> 0x015f }
        goto L_0x013a;
    L_0x015f:
        r2 = move-exception;
    L_0x0160:
        if (r13 == 0) goto L_0x0165;
    L_0x0162:
        r13.close();
    L_0x0165:
        throw r2;
    L_0x0166:
        r2 = move-exception;
        r13 = r3;
        goto L_0x0160;
    L_0x0169:
        r2 = move-exception;
        goto L_0x0116;
    L_0x016b:
        r2 = move-exception;
        r12 = r13;
        goto L_0x00f0;
    L_0x016e:
        r2 = move-exception;
        r12 = r4;
        goto L_0x00f0;
    L_0x0171:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r11;
        goto L_0x00ce;
    L_0x0177:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r12;
        goto L_0x00ce;
    L_0x017d:
        r4 = r2;
        goto L_0x009e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzbx.zzN(int):java.util.List<com.google.android.gms.tagmanager.zzap>");
    }

    void zzb(String[] strArr) {
        boolean z = true;
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase zzar = zzar("Error opening database for deleteHits.");
            if (zzar != null) {
                try {
                    zzar.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    zzau com_google_android_gms_tagmanager_zzau = this.zzazs;
                    if (zzgA() != 0) {
                        z = false;
                    }
                    com_google_android_gms_tagmanager_zzau.zzD(z);
                } catch (SQLiteException e) {
                    zzbf.zzac("Error deleting hits");
                }
            }
        }
    }

    public void zzf(long j, String str) {
        zzgz();
        zzgy();
        zzg(j, str);
    }

    int zzgA() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase zzar = zzar("Error opening database for getNumStoredHits.");
        if (zzar != null) {
            try {
                cursor = zzar.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                zzbf.zzac("Error getting numStoredHits");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    int zzgz() {
        boolean z = true;
        long currentTimeMillis = this.zzmW.currentTimeMillis();
        if (currentTimeMillis <= this.zzEY + 86400000) {
            return 0;
        }
        this.zzEY = currentTimeMillis;
        SQLiteDatabase zzar = zzar("Error opening database for deleteStaleHits.");
        if (zzar == null) {
            return 0;
        }
        int delete = zzar.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzmW.currentTimeMillis() - 2592000000L)});
        zzau com_google_android_gms_tagmanager_zzau = this.zzazs;
        if (zzgA() != 0) {
            z = false;
        }
        com_google_android_gms_tagmanager_zzau.zzD(z);
        return delete;
    }

    int zztv() {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        SQLiteDatabase zzar = zzar("Error opening database for getNumStoredHits.");
        if (zzar == null) {
            return 0;
        }
        int count;
        try {
            Cursor query = zzar.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", null, null, null, null);
            try {
                count = query.getCount();
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e) {
                cursor = query;
                try {
                    zzbf.zzac("Error getting num untried hits");
                    if (cursor == null) {
                        count = 0;
                    } else {
                        cursor.close();
                        count = 0;
                    }
                    return count;
                } catch (Throwable th2) {
                    cursor2 = cursor;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            cursor = null;
            zzbf.zzac("Error getting num untried hits");
            if (cursor == null) {
                cursor.close();
                count = 0;
            } else {
                count = 0;
            }
            return count;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        return count;
    }
}
