public class Server {
    public static void main(String[] args) {
        try {
            new StartServer().start();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
