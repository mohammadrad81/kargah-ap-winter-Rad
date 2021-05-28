import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * the client class to send messages to the server and receive them
 * @author Mohammad Heydari Rad
 * @since 2021
 *
 */
public class Client {
    private static Socket socket;

    /**
     * the main class of the
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("waiting to get connected...");
        /*
        trying to get connected (waiting for the server response)
         */
        while (socket == null){
            try{
                Thread.sleep(1000);
                socket = new Socket("127.0.0.1" , 9090);

            }catch (ConnectException e){
                //waiting for server
            }
            catch (UnknownHostException e) {

                // waiting for sever
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("connected");
        System.out.println("please enter your text :");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            String input = null;
            /*
            sending and receiving messages
             */
            do {
                input = scanner.nextLine();
                if(input.equals("over")){
                    System.out.println("end of the program");

                    break;
                }

                objectOutputStream.writeObject(input);

                System.out.println(objectInputStream.readObject());
            }while (!input.equals("over"));


            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
