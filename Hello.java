
import java.rmi.*;
import java.rmi.server.*;


public class Hello extends UnicastRemoteObject implements HelloInterface {
    private String message ;
    public Hello(String msg) throws RemoteException{
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


}

