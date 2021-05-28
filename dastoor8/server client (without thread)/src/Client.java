import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * the client class
 * @author Mohammad Heydari Rad
 * @since 2021
 */
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        boolean isConnected = false;
        System.out.println("waiting to get connected...");
        while (isConnected == false){
            try{
                Thread.sleep(2000);
                socket = new Socket("localhost" , 9090);
                isConnected = true;
            } catch (UnknownHostException e) {
                isConnected = false;
            } catch (ConnectException e){

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();//never gonna happen
            }

        }
        System.out.println("connected");
        System.out.println("now you can write your text :");

        String input = null;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
           objectOutputStream = new ObjectOutputStream((socket.getOutputStream()));
           objectInputStream = new ObjectInputStream((socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        do {
            input = scanner.nextLine();

            if(input.equals("over")){
                System.out.println("! good bye !");
                break;
            }

            try {
                objectOutputStream.writeObject(input);

                System.out.println(objectInputStream.readObject());
            }catch (SocketException e){
                System.out.println("the server is down");
                System.exit(0);
            }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }while (! input.equals("over"));

        try {
            socket.shutdownInput();
            socket.shutdownOutput();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
