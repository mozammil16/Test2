package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
    private static final String[] zzaiP;
    private final int zzLs;
    private final HashMap<String, Integer> zzaiQ;

    public static final class Builder {
        private int zzLs;
        private HashMap<String, Integer> zzaiQ;

        public Builder() {
            this.zzaiQ = new HashMap();
            this.zzLs = 0;
        }

        public Builder zzA(String str, int i) {
            if (RequestUpdateResultOutcome.isValid(i)) {
                this.zzaiQ.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public Builder zzeU(int i) {
            this.zzLs = i;
            return this;
        }

        public RequestUpdateOutcomes zzoO() {
            return new RequestUpdateOutcomes(this.zzaiQ, null);
        }
    }

    static {
        zzaiP = new String[]{"requestId", "outcome"};
    }

    private RequestUpdateOutcomes(int statusCode, HashMap<String, Integer> outcomeMap) {
        this.zzLs = statusCode;
        this.zzaiQ = outcomeMap;
    }

    public static RequestUpdateOutcomes zzW(DataHolder dataHolder) {
        Builder builder = new Builder();
        builder.zzeU(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int zzax = dataHolder.zzax(i);
            builder.zzA(dataHolder.zzc("requestId", i, zzax), dataHolder.zzb("outcome", i, zzax));
        }
        return builder.zzoO();
    }

    public Set<String> getRequestIds() {
        return this.zzaiQ.keySet();
    }

    public int getRequestOutcome(String requestId) {
        zzx.zzb(this.zzaiQ.containsKey(requestId), "Request " + requestId + " was not part of the update operation!");
        return ((Integer) this.zzaiQ.get(requestId)).intValue();
    }
}
