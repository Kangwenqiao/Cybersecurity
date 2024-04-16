package lab2.RSA;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class ServerSide {

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public void generateKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }

    public String signData(String plainText) throws Exception {
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(plainText.getBytes());
        byte[] signature = privateSignature.sign();
        return Base64.getEncoder().encodeToString(signature);
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    // This is a utility method to simulate sending data and signature to a client
    public void sendDataToClient(ClientSide client, String data) throws Exception {
        String signature = signData(data);
        client.receiveData(data, signature, getPublicKey());
    }
}

