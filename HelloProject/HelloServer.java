

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;



public class HelloServer extends UnicastRemoteObject implements HelloInterface {
    private String message ;
    public HelloServer(String msg) throws RemoteException{
        super(0);
        message = msg;}
    public String say(String m, int a, int b) throws RemoteException {

        String str = "";
        switch(m.charAt(0)){
            case 'a':
                str = "Addition: " + add(a,b);
                break;
            case's':
                str = "Subtraction : "+ sub(a,b);
                break;
            case 'm':
                str = "Multiplication : " + mul(a,b);
                break;
            case 'd':
                str = "Division : " + div(a,b);
                break;
            default:
                str = "Wrong Operation";
        }
        return str;
    }
    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a , int b){
        return a-b;
    }
    public int mul(int a, int b){
        return a*b;
    }
    public int div(int a, int b){
        return a/b;
    }

    public static void main(String[] args) throws  Exception{


        try{
            LocateRegistry.createRegistry(1099);
            System.out.println("java HelloServer created!");
        }catch (RemoteException e){
            System.out.println(e);
            System.out.println("java RMI exists already");
        }

       HelloServer obj2 = new HelloServer("Hello World");
        Naming.rebind("//localhost/HelloSer", obj2);
        System.out.println("Peer-bound in registry");

    }}


