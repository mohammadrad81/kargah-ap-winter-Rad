
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * the server class
 * @author Mohammad Heydari Rad
 * @since 2021
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket connectionSocket = null;

        try {
            serverSocket = new ServerSocket(9090);
            System.out.println("server started");
            System.out.println("waiting for a client to join ...");
            connectionSocket = serverSocket.accept();
            System.out.println("client joined");

        } catch (IOException  e) {
            e.printStackTrace();
        }
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(connectionSocket.getOutputStream());
            objectInputStream = new ObjectInputStream(connectionSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        String clientToServerInput = "";
        while (connectionSocket.isConnected()){

            try {
                    clientToServerInput += " " + (String) objectInputStream.readObject();

                objectOutputStream.writeObject(clientToServerInput);
            }catch (SocketException e){
                System.out.println("! the client left the server and the server is shot down !");
            } catch(EOFException e){
                System.out.println("! client left and server is shot down !");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
