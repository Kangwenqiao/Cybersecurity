package lab2.DES;

public class DESEuse {
    public static void main(String[] args) {
        try {
            DESEncryptionTool encryptionTool = new DESEncryptionTool();
            String plainText = "202107927KangWenqiao";
            String encrypted = encryptionTool.encrypt(plainText);
            String decrypted = encryptionTool.decrypt(encrypted);

            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
