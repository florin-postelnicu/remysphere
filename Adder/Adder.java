
import java.rmi.*;
public interface Adder extends Remote{
    public int add(int i, int j) throws RemoteException;
}
