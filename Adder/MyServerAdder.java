
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;



public class MyServerAdder  extends UnicastRemoteObject implements Adder{

    public MyServerAdder() throws RemoteException{
        super(0);
    }
    public int add(int i, int j){
        return i+j;
    }



    public static void main(String[] args)  throws Exception{
        try{
           LocateRegistry.createRegistry(1099);
            System.out.println("java MyServerAdder created!");
        }catch (RemoteException e){
            System.out.println(e);
            System.out.println("java RMI exists already");
    }

        MyServerAdder obj1 = new MyServerAdder();
        Naming.rebind("//localhost/MyServerAdder", obj1);
        System.out.println("Peer-bound in registry");



}}

