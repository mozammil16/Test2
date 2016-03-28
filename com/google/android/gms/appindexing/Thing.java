package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.PlusShare;

public class Thing {
    final Bundle zzGJ;

    public static class Builder {
        final Bundle zzGK;

        public Builder() {
            this.zzGK = new Bundle();
        }

        public Thing build() {
            return new Thing(this.zzGK);
        }

        public Builder put(String key, Thing value) {
            zzx.zzl(key);
            if (value != null) {
                this.zzGK.putParcelable(key, value.zzGJ);
            }
            return this;
        }

        public Builder put(String key, String value) {
            zzx.zzl(key);
            if (value != null) {
                this.zzGK.putString(key, value);
            }
            return this;
        }

        public Builder setDescription(String description) {
            put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, description);
            return this;
        }

        public Builder setId(String id) {
            if (id != null) {
                put("id", id);
            }
            return this;
        }

        public Builder setName(String name) {
            zzx.zzl(name);
            put("name", name);
            return this;
        }

        public Builder setType(String type) {
            put("type", type);
            return this;
        }

        public Builder setUrl(Uri url) {
            zzx.zzl(url);
            put(PlusShare.KEY_CALL_TO_ACTION_URL, url.toString());
            return this;
        }
    }

    Thing(Bundle propertyBundle) {
        this.zzGJ = propertyBundle;
    }

    public Bundle zzgZ() {
        return this.zzGJ;
    }
}
