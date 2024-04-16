package lab2.RSA;

public class RSASimulation {
    public static void main(String[] args) {
        try {
            ServerSide server = new ServerSide();
            server.generateKeyPair();

            ClientSide client = new ClientSide();

            String data = "202107927Kangwenqiao";
            server.sendDataToClient(client, data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
