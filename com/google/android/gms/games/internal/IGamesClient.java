package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.Place;

public interface IGamesClient extends IInterface {

    public static abstract class Stub extends Binder implements IGamesClient {

        private static class Proxy implements IGamesClient {
            private IBinder zzle;

            Proxy(IBinder remote) {
                this.zzle = remote;
            }

            public IBinder asBinder() {
                return this.zzle;
            }

            public PopupLocationInfoParcelable zznk() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesClient");
                    this.zzle.transact(Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_1, obtain, obtain2, 0);
                    obtain2.readException();
                    PopupLocationInfoParcelable zzcY = obtain2.readInt() != 0 ? PopupLocationInfoParcelable.CREATOR.zzcY(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return zzcY;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesClient");
        }

        public static IGamesClient zzaY(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesClient");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesClient)) ? new Proxy(iBinder) : (IGamesClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_1 /*1001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesClient");
                    PopupLocationInfoParcelable zznk = zznk();
                    reply.writeNoException();
                    if (zznk != null) {
                        reply.writeInt(1);
                        zznk.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IGamesClient");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    PopupLocationInfoParcelable zznk() throws RemoteException;
}
