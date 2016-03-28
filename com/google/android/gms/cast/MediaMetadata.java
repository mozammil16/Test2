package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private static final String[] zzIZ;
    private static final zza zzJa;
    private final List<WebImage> zzIn;
    private final Bundle zzJb;
    private int zzJc;

    private static class zza {
        private final Map<String, String> zzJd;
        private final Map<String, String> zzJe;
        private final Map<String, Integer> zzJf;

        public zza() {
            this.zzJd = new HashMap();
            this.zzJe = new HashMap();
            this.zzJf = new HashMap();
        }

        public String zzaE(String str) {
            return (String) this.zzJd.get(str);
        }

        public String zzaF(String str) {
            return (String) this.zzJe.get(str);
        }

        public int zzaG(String str) {
            Integer num = (Integer) this.zzJf.get(str);
            return num != null ? num.intValue() : MediaMetadata.MEDIA_TYPE_GENERIC;
        }

        public zza zzb(String str, String str2, int i) {
            this.zzJd.put(str, str2);
            this.zzJe.put(str2, str);
            this.zzJf.put(str, Integer.valueOf(i));
            return this;
        }
    }

    static {
        zzIZ = new String[]{null, "String", "int", "double", "ISO-8601 date String"};
        zzJa = new zza().zzb(KEY_CREATION_DATE, "creationDateTime", MEDIA_TYPE_PHOTO).zzb(KEY_RELEASE_DATE, "releaseDate", MEDIA_TYPE_PHOTO).zzb(KEY_BROADCAST_DATE, "originalAirdate", MEDIA_TYPE_PHOTO).zzb(KEY_TITLE, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, MEDIA_TYPE_MOVIE).zzb(KEY_SUBTITLE, "subtitle", MEDIA_TYPE_MOVIE).zzb(KEY_ARTIST, "artist", MEDIA_TYPE_MOVIE).zzb(KEY_ALBUM_ARTIST, "albumArtist", MEDIA_TYPE_MOVIE).zzb(KEY_ALBUM_TITLE, "albumName", MEDIA_TYPE_MOVIE).zzb(KEY_COMPOSER, "composer", MEDIA_TYPE_MOVIE).zzb(KEY_DISC_NUMBER, "discNumber", MEDIA_TYPE_TV_SHOW).zzb(KEY_TRACK_NUMBER, "trackNumber", MEDIA_TYPE_TV_SHOW).zzb(KEY_SEASON_NUMBER, "season", MEDIA_TYPE_TV_SHOW).zzb(KEY_EPISODE_NUMBER, "episode", MEDIA_TYPE_TV_SHOW).zzb(KEY_SERIES_TITLE, "seriesTitle", MEDIA_TYPE_MOVIE).zzb(KEY_STUDIO, "studio", MEDIA_TYPE_MOVIE).zzb(KEY_WIDTH, "width", MEDIA_TYPE_TV_SHOW).zzb(KEY_HEIGHT, "height", MEDIA_TYPE_TV_SHOW).zzb(KEY_LOCATION_NAME, "location", MEDIA_TYPE_MOVIE).zzb(KEY_LOCATION_LATITUDE, "latitude", MEDIA_TYPE_MUSIC_TRACK).zzb(KEY_LOCATION_LONGITUDE, "longitude", MEDIA_TYPE_MUSIC_TRACK);
    }

    public MediaMetadata() {
        this(MEDIA_TYPE_GENERIC);
    }

    public MediaMetadata(int mediaType) {
        this.zzIn = new ArrayList();
        this.zzJb = new Bundle();
        this.zzJc = mediaType;
    }

    private void zza(JSONObject jSONObject, String... strArr) {
        try {
            int length = strArr.length;
            for (int i = MEDIA_TYPE_GENERIC; i < length; i += MEDIA_TYPE_MOVIE) {
                String str = strArr[i];
                if (this.zzJb.containsKey(str)) {
                    switch (zzJa.zzaG(str)) {
                        case MEDIA_TYPE_MOVIE /*1*/:
                        case MEDIA_TYPE_PHOTO /*4*/:
                            jSONObject.put(zzJa.zzaE(str), this.zzJb.getString(str));
                            break;
                        case MEDIA_TYPE_TV_SHOW /*2*/:
                            jSONObject.put(zzJa.zzaE(str), this.zzJb.getInt(str));
                            break;
                        case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                            jSONObject.put(zzJa.zzaE(str), this.zzJb.getDouble(str));
                            break;
                        default:
                            break;
                    }
                }
            }
            for (String str2 : this.zzJb.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.zzJb.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    private boolean zza(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !zza((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private void zzb(JSONObject jSONObject, String... strArr) {
        Set hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (!"metadataType".equals(str)) {
                    String zzaF = zzJa.zzaF(str);
                    if (zzaF == null) {
                        Object obj = jSONObject.get(str);
                        if (obj instanceof String) {
                            this.zzJb.putString(str, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.zzJb.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.zzJb.putDouble(str, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(zzaF)) {
                        try {
                            Object obj2 = jSONObject.get(str);
                            if (obj2 != null) {
                                switch (zzJa.zzaG(zzaF)) {
                                    case MEDIA_TYPE_MOVIE /*1*/:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        }
                                        this.zzJb.putString(zzaF, (String) obj2);
                                        break;
                                    case MEDIA_TYPE_TV_SHOW /*2*/:
                                        if (!(obj2 instanceof Integer)) {
                                            break;
                                        }
                                        this.zzJb.putInt(zzaF, ((Integer) obj2).intValue());
                                        break;
                                    case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                                        if (!(obj2 instanceof Double)) {
                                            break;
                                        }
                                        this.zzJb.putDouble(zzaF, ((Double) obj2).doubleValue());
                                        break;
                                    case MEDIA_TYPE_PHOTO /*4*/:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        }
                                        if (zzkh.zzaQ((String) obj2) == null) {
                                            break;
                                        }
                                        this.zzJb.putString(zzaF, (String) obj2);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    private void zzf(String str, int i) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int zzaG = zzJa.zzaG(str);
        if (zzaG != i && zzaG != 0) {
            throw new IllegalArgumentException("Value for " + str + " must be a " + zzIZ[i]);
        }
    }

    public void addImage(WebImage image) {
        this.zzIn.add(image);
    }

    public void clear() {
        this.zzJb.clear();
        this.zzIn.clear();
    }

    public void clearImages() {
        this.zzIn.clear();
    }

    public boolean containsKey(String key) {
        return this.zzJb.containsKey(key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) other;
        return zza(this.zzJb, mediaMetadata.zzJb) && this.zzIn.equals(mediaMetadata.zzIn);
    }

    public Calendar getDate(String key) {
        zzf(key, MEDIA_TYPE_PHOTO);
        String string = this.zzJb.getString(key);
        return string != null ? zzkh.zzaQ(string) : null;
    }

    public String getDateAsString(String key) {
        zzf(key, MEDIA_TYPE_PHOTO);
        return this.zzJb.getString(key);
    }

    public double getDouble(String key) {
        zzf(key, MEDIA_TYPE_MUSIC_TRACK);
        return this.zzJb.getDouble(key);
    }

    public List<WebImage> getImages() {
        return this.zzIn;
    }

    public int getInt(String key) {
        zzf(key, MEDIA_TYPE_TV_SHOW);
        return this.zzJb.getInt(key);
    }

    public int getMediaType() {
        return this.zzJc;
    }

    public String getString(String key) {
        zzf(key, MEDIA_TYPE_MOVIE);
        return this.zzJb.getString(key);
    }

    public boolean hasImages() {
        return (this.zzIn == null || this.zzIn.isEmpty()) ? false : true;
    }

    public int hashCode() {
        int i = 17;
        for (String str : this.zzJb.keySet()) {
            i *= 31;
            i = this.zzJb.get(str).hashCode() + i;
        }
        return (i * 31) + this.zzIn.hashCode();
    }

    public Set<String> keySet() {
        return this.zzJb.keySet();
    }

    public void putDate(String key, Calendar value) {
        zzf(key, MEDIA_TYPE_PHOTO);
        this.zzJb.putString(key, zzkh.zza(value));
    }

    public void putDouble(String key, double value) {
        zzf(key, MEDIA_TYPE_MUSIC_TRACK);
        this.zzJb.putDouble(key, value);
    }

    public void putInt(String key, int value) {
        zzf(key, MEDIA_TYPE_TV_SHOW);
        this.zzJb.putInt(key, value);
    }

    public void putString(String key, String value) {
        zzf(key, MEDIA_TYPE_MOVIE);
        this.zzJb.putString(key, value);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.zzJc);
        } catch (JSONException e) {
        }
        zzkh.zza(jSONObject, this.zzIn);
        String[] strArr;
        switch (this.zzJc) {
            case MEDIA_TYPE_GENERIC /*0*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_ARTIST;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                zza(jSONObject, strArr);
                break;
            case MEDIA_TYPE_MOVIE /*1*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_STUDIO;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                zza(jSONObject, strArr);
                break;
            case MEDIA_TYPE_TV_SHOW /*2*/:
                zza(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                break;
            case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                break;
            case MEDIA_TYPE_PHOTO /*4*/:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                break;
            default:
                zza(jSONObject, new String[MEDIA_TYPE_GENERIC]);
                break;
        }
        return jSONObject;
    }

    public void zzd(JSONObject jSONObject) {
        clear();
        this.zzJc = MEDIA_TYPE_GENERIC;
        try {
            this.zzJc = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        zzkh.zza(this.zzIn, jSONObject);
        String[] strArr;
        switch (this.zzJc) {
            case MEDIA_TYPE_GENERIC /*0*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_ARTIST;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                zzb(jSONObject, strArr);
            case MEDIA_TYPE_MOVIE /*1*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_STUDIO;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                zzb(jSONObject, strArr);
            case MEDIA_TYPE_TV_SHOW /*2*/:
                zzb(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
            case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                zzb(jSONObject, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
            case MEDIA_TYPE_PHOTO /*4*/:
                zzb(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
            default:
                zzb(jSONObject, new String[MEDIA_TYPE_GENERIC]);
        }
    }
}
