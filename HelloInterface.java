

import java.rmi.*;

public interface  HelloInterface  extends Remote{
    public String  say(String msg, int a, int b) throws RemoteException;
}
