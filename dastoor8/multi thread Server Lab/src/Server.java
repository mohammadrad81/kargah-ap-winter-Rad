import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * the server class
 * @author Mohammad Heydari Rad
 * @since 2021
 */
public class Server {

    private static ServerSocket serverSocket;
    private static ExecutorService executorService;

    /**
     * the server serves clients in this main
     * @param args nothing
     */
    public static void main(String[] args) {
        try{
            serverSocket = new ServerSocket(9090);
            executorService = Executors.newCachedThreadPool();
            System.out.println("waiting for clients...");
            while (true){
                executorService.execute(new Thread(new ClientHandler(serverSocket.accept())));
                System.out.println("new client joined");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/**
 * the client handler class
 * receives the messages from the client , appends them together , and sends them back
 */
class ClientHandler implements Runnable{
    private Socket socket;
    private boolean clientIsConnected;

    ClientHandler(Socket socket){
        this.socket = socket;
        clientIsConnected = true;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        String clientToHandler = "";
        try{
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            while (clientIsConnected){
                clientToHandler +=" " + (String) objectInputStream.readObject();
                objectOutputStream.writeObject(clientToHandler);
            }

            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
        }catch (EOFException e){
            clientIsConnected = false;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

