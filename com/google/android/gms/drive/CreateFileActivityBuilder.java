package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzi;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.internal.zzlz;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private final zzi zzRZ;
    private DriveContents zzSa;
    private boolean zzSb;

    public CreateFileActivityBuilder() {
        this.zzRZ = new zzi(0);
    }

    public IntentSender build(GoogleApiClient apiClient) {
        zzx.zzb(Boolean.valueOf(this.zzSb), (Object) "Must call setInitialDriveContents to CreateFileActivityBuilder.");
        boolean z = apiClient.zza(Drive.SCOPE_FILE) || apiClient.zza(Drive.zzSc);
        zzx.zzb(z, (Object) "The apiClient must have suitable scope to create files");
        if (this.zzSa != null) {
            zzlz.zza(this.zzSa.getParcelFileDescriptor());
            this.zzSa.zzkr();
        }
        return this.zzRZ.build(apiClient);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.zzRZ.zza(folder);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String title) {
        this.zzRZ.zzbx(title);
        return this;
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents driveContents) {
        if (driveContents == null) {
            this.zzRZ.zzbD(1);
        } else if (!(driveContents instanceof zzs)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.zzks()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            this.zzRZ.zzbD(driveContents.zzkq().getRequestId());
            this.zzSa = driveContents;
        }
        this.zzSb = true;
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.zzRZ.zza(metadataChangeSet);
        return this;
    }
}
