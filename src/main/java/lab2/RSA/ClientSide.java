package lab2.RSA;

import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class ClientSide {

    public void receiveData(String data, String signature, PublicKey publicKey) throws Exception {
        if (verifySignature(data, signature, publicKey)) {
            System.out.println("Signature verified: Data is intact and sender is authenticated.");
        } else {
            System.out.println("Signature verification failed: Data might be corrupted or sender is not authenticated.");
        }
    }

    public boolean verifySignature(String plainText, String signature, PublicKey publicKey) throws Exception {
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(publicKey);
        publicSignature.update(plainText.getBytes());
        byte[] signatureBytes = Base64.getDecoder().decode(signature);
        return publicSignature.verify(signatureBytes);
    }
}
