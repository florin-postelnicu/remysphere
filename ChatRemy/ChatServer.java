
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;
import java.util.*;

public class ChatServer extends UnicastRemoteObject implements ChatInterface{

    public String name;
    public ChatInterface client=null;

    public ChatServer(String n)  throws RemoteException {
        super(0);
        this.name=n;
    }
    public String getName() throws RemoteException {
        return this.name;
    }

    public void setClient(ChatInterface c){
        client=c;
    }

    public ChatInterface getClient(){
        return client;
    }

    public void send(String s) throws RemoteException{
        System.out.println(s);
    }

    public static void main (String[] argv) {
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("java RMI registry created");

            Scanner s=new Scanner(System.in);
            System.out.println("Enter Your name and press Enter:");
            String name=s.nextLine().trim();

            ChatServer server = new ChatServer(name);

            Naming.rebind("rmi://localhost/ChatServer", server);

            System.out.println("[System] Chat Remote Object is ready:");

            while(true){
                String msg=s.nextLine().trim();
                if (server.getClient()!=null){
                    ChatInterface client=server.getClient();
                    msg="["+server.getName()+"] "+msg;
                    client.send(msg);
                }
            }

        }catch (Exception e) {
            System.out.println("[System] Server failed: " + e);
        }

    }
}