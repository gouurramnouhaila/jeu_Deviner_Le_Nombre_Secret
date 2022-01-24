import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class StartServer extends Thread{

    private ServerSocket serverSocket;
    private boolean active = true;

    @Override
    public void run() {
        try {
            // Démarrage du serveur avec le port 1234
            serverSocket = new ServerSocket(1234);

            while (active) {
                Socket socket = serverSocket.accept();
                int random = new Random().nextInt(100);


                new MyThread(socket,random).start();

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
