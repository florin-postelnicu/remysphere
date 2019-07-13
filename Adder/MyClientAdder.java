



import java.rmi.Naming;


public class MyClientAdder {
    public static void main(String[] args) throws Exception {
        try{
            Adder obj1 = (Adder)Naming.lookup("rmi://localhost/MyServerAdder");
            System.out.println((obj1.add(34,56)));
        }catch(Exception e){
            System.out.println("e :" + e);
        }
    }
}
