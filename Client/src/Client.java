import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Socket socket;

    public static void main(String[] args) {
        try {
            socket = new Socket("localhost",1234);
        }catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            Scanner scanner = new Scanner(System.in);

            while (true) {

                System.out.println(in.readLine());
                String nbr = scanner.next();
                out.println(nbr);

                String serverMsg = in.readLine();
                System.out.println("SERVER : "+serverMsg);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
