

import java.rmi.Naming;
public class HelloClient {

        public static void main(String args[]) {
            try {
                if(args.length < 0) {
                    System.err.println("usage: java HelloClient string ...\n");
                    System.exit(1);
                }
                HelloInterface hello = (HelloInterface)Naming.lookup("//localhost/HelloSer");
//                System.out.println(hello.say(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                System.out.println(hello.say( "a",27,33));
            }
            catch (Exception e){
                System.out.println("HelloClient exception  :" + e);
            }
        }
    }

