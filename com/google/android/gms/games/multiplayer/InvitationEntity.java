package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Creator<InvitationEntity> CREATOR;
    private final int zzFG;
    private final String zzaek;
    private final GameEntity zzahV;
    private final int zzajA;
    private final int zzajB;
    private final long zzajw;
    private final int zzajx;
    private final ParticipantEntity zzajy;
    private final ArrayList<ParticipantEntity> zzajz;

    static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
        InvitationEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzde(x0);
        }

        public InvitationEntity zzde(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(zzh.zziX()) || zzh.zzbf(InvitationEntity.class.getCanonicalName())) {
                return super.zzde(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity participantEntity = (ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(2, gameEntity, readString, readLong, readInt, participantEntity, arrayList, -1, 0);
        }
    }

    static {
        CREATOR = new InvitationEntityCreatorCompat();
    }

    InvitationEntity(int versionCode, GameEntity game, String invitationId, long creationTimestamp, int invitationType, ParticipantEntity inviter, ArrayList<ParticipantEntity> participants, int variant, int availableAutoMatchSlots) {
        this.zzFG = versionCode;
        this.zzahV = game;
        this.zzaek = invitationId;
        this.zzajw = creationTimestamp;
        this.zzajx = invitationType;
        this.zzajy = inviter;
        this.zzajz = participants;
        this.zzajA = variant;
        this.zzajB = availableAutoMatchSlots;
    }

    InvitationEntity(Invitation invitation) {
        this.zzFG = 2;
        this.zzahV = new GameEntity(invitation.getGame());
        this.zzaek = invitation.getInvitationId();
        this.zzajw = invitation.getCreationTimestamp();
        this.zzajx = invitation.getInvitationType();
        this.zzajA = invitation.getVariant();
        this.zzajB = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        Object obj = null;
        ArrayList participants = invitation.getParticipants();
        int size = participants.size();
        this.zzajz = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(participantId)) {
                obj = participant;
            }
            this.zzajz.add((ParticipantEntity) participant.freeze());
        }
        zzx.zzb(obj, (Object) "Must have a valid inviter!");
        this.zzajy = (ParticipantEntity) obj.freeze();
    }

    static int zza(Invitation invitation) {
        return zzw.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static boolean zza(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return zzw.equal(invitation2.getGame(), invitation.getGame()) && zzw.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && zzw.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && zzw.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && zzw.equal(invitation2.getInviter(), invitation.getInviter()) && zzw.equal(invitation2.getParticipants(), invitation.getParticipants()) && zzw.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && zzw.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static String zzb(Invitation invitation) {
        return zzw.zzk(invitation).zza("Game", invitation.getGame()).zza("InvitationId", invitation.getInvitationId()).zza("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).zza("InvitationType", Integer.valueOf(invitation.getInvitationType())).zza("Inviter", invitation.getInviter()).zza("Participants", invitation.getParticipants()).zza("Variant", Integer.valueOf(invitation.getVariant())).zza("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        return this.zzajB;
    }

    public long getCreationTimestamp() {
        return this.zzajw;
    }

    public Game getGame() {
        return this.zzahV;
    }

    public String getInvitationId() {
        return this.zzaek;
    }

    public int getInvitationType() {
        return this.zzajx;
    }

    public Participant getInviter() {
        return this.zzajy;
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.zzajz);
    }

    public int getVariant() {
        return this.zzajA;
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

    public void writeToParcel(Parcel dest, int flags) {
        if (zziY()) {
            this.zzahV.writeToParcel(dest, flags);
            dest.writeString(this.zzaek);
            dest.writeLong(this.zzajw);
            dest.writeInt(this.zzajx);
            this.zzajy.writeToParcel(dest, flags);
            int size = this.zzajz.size();
            dest.writeInt(size);
            for (int i = 0; i < size; i++) {
                ((ParticipantEntity) this.zzajz.get(i)).writeToParcel(dest, flags);
            }
            return;
        }
        InvitationEntityCreator.zza(this, dest, flags);
    }
}
