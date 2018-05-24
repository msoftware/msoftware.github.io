// Generated with go/better-aidl
package androidx.test.orchestrator.callback;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;
import java.lang.Override;
import java.lang.String;
import javax.annotation.Generated;

/**
 * Defines an interface for remote {@link Instrumentation} service to speak to the
 * {@link AndroidTestOrchestrator]
 */
@Generated("//java/com/google/android:aidl")
public interface OrchestratorCallback extends IInterface {
  /**
   * Remote instrumentations, when given the parameter listTestsForOrchestrator, must add each test
   * they wish executed to AndroidTestOrchestrator before terminating.
   */
  void addTest(String test) throws RemoteException;

  /**
   * Remote instrumentations should pass a notification along to AndroidTestOrchestrator whenever they get a
   * notification of test progress.  Use {@link OrchestratorService} constants to determine the notification
   * type.
   */
  void sendTestNotification(Bundle bundle) throws RemoteException;

  abstract class Stub extends BaseStub implements OrchestratorCallback {
    private static final String DESCRIPTOR = "androidx.test.orchestrator.callback.OrchestratorCallback";

    static final int TRANSACTION_addTest = IBinder.FIRST_CALL_TRANSACTION + 0;

    static final int TRANSACTION_sendTestNotification = IBinder.FIRST_CALL_TRANSACTION + 1;

    public Stub() {
      super(DESCRIPTOR);
    }

    public static OrchestratorCallback asInterface(IBinder obj) {
      if (obj == null) {
        return null;
      }
      IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (iin instanceof OrchestratorCallback) {
        return (OrchestratorCallback) iin;
      }
      return new Proxy(obj);
    }

    @Override
    protected boolean dispatchTransaction(int code, Parcel data, Parcel reply, int flags) throws
        RemoteException {
      switch (code) {
        case TRANSACTION_addTest: {
          String test = data.readString();
          addTest(test);
          break;
        }
        case TRANSACTION_sendTestNotification: {
          Bundle bundle = Codecs.createParcelable(data, Bundle.CREATOR);
          sendTestNotification(bundle);
          break;
        }
        default: {
          return false;
        }
      }
      reply.writeNoException();
      return true;
    }

    public static class Proxy extends BaseProxy implements OrchestratorCallback {
      Proxy(IBinder remote) {
        super(remote, DESCRIPTOR);
      }

      @Override
      public void addTest(String test) throws RemoteException {
        Parcel data = obtainAndWriteInterfaceToken();
        data.writeString(test);
        transactAndReadExceptionReturnVoid(TRANSACTION_addTest, data);
      }

      @Override
      public void sendTestNotification(Bundle bundle) throws RemoteException {
        Parcel data = obtainAndWriteInterfaceToken();
        Codecs.writeParcelable(data, bundle);
        transactAndReadExceptionReturnVoid(TRANSACTION_sendTestNotification, data);
      }
    }
  }
}
