package lab1;

import java.util.Scanner;

public class CaesarCipher {

    // 加密函数
    // @param text 需要加密的文本
    // @param shift 加密时的偏移量
    // @return 返回加密后的文本
    public static String encrypt(String text, int shift) {
        return caesarCipher(text, shift);
    }

    // 解密函数
    // @param text 需要解密的文本
    // @param shift 解密时的偏移量
    // @return 返回解密后的文本
    public static String decrypt(String text, int shift) {
        return caesarCipher(text, -shift);
    }

    // 通用凯撒密码函数，用于加密和解密
    // @param text 要处理的文本，可以是加密或解密
    // @param shift 偏移量，正数为加密，负数为解密
    // @return 处理后的文本
    private static String caesarCipher(String text, int shift) {
        shift = shift % 26; // 确保偏移量不超过26
        if (shift < 0) {
            shift += 26;  // 如果偏移量为负，转换为相应的正值
        }
        StringBuilder processedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) { // 只处理字母字符
                char base = Character.isUpperCase(character) ? 'A' : 'a'; // 判断是大写还是小写字母
                processedText.append((char) (base + (character - base + shift) % 26));
            } else {
                processedText.append(character);  // 非字母字符保持不变
            }
        }
        return processedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to be encrypted:");
        String plaintext = scanner.nextLine();
        System.out.println("Enter shift key:");
        int key = scanner.nextInt();

        String ciphertext = encrypt(plaintext, key); // 加密文本
        String decryptedtext = decrypt(ciphertext, key); // 解密文本

        System.out.println("Original Text: " + plaintext); // 输出原始文本
        System.out.println("Encrypted Text: " + ciphertext); // 输出加密后的文本
        System.out.println("Decrypted Text: " + decryptedtext); // 输出解密后的文本
    }
}
