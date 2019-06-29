

import java.rmi.*;
import java.rmi.server.*;



public class HelloServer {

    public static void main(String argv[]) {
        try{
            Naming.rebind("Hello", new Hello("Hello world"));
            System.out.println("Hello Server is ready");
        }
        catch (Exception e){
            System.out.println("Hello Server failed : " + e);
        }
    }
}
