import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyThread extends Thread{

    private Socket socket;
    private String gagant;
    private int nombreSecret;
    private boolean fin = false;


    public MyThread(Socket socket,int nombreSecret) {
        this.socket = socket;
        this.nombreSecret = nombreSecret;

    }
    @Override
    public void run() {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

            while (true) {

                System.out.println("client "+socket.getRemoteSocketAddress().toString()+" est connecté");
                out.println("Devinez le nombre secret...?");


                int nbr = Integer.parseInt(in.readLine());


                if(!fin) {
                    if(nbr > nombreSecret) {
                        out.println("Votre nombre "+nbr+" est supérieur de le nombre secret");
                    }else if(nbr < nombreSecret) {
                        out.println("Votre nombre  "+nbr+" est inférieur de le nombre secret");
                    }else {
                        out.println("BRAVO vous avez gagné ...");
                        System.out.println("BRAVO Au gagnant "+socket.getRemoteSocketAddress().toString());
                        fin = true;
                    }
                }else {
                    out.println("Le jeu terminé...");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
