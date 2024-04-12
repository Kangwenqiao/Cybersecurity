package lab1;

import java.util.Scanner;

public class VigenereCipher {

    // 加密函数
    public static String encrypt(String text, String key) {
        return vigenereCipher(text, key, true);
    }

    // 解密函数
    public static String decrypt(String text, String key) {
        return vigenereCipher(text, key, false);
    }

    // 维吉尼亚密码通用函数，用于加密和解密
    private static String vigenereCipher(String text, String key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        text = text.toLowerCase(); // 将文本转换为小写以统一处理
        key = key.toLowerCase();   // 将密钥也转为小写
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                int base = 'a';
                if (encrypt) {
                    // 加密逻辑: 将当前字符和密钥字符相加后对26取模，再加上基准'a'得到新字符
                    result.append((char) ((c + key.charAt(j) - 2 * base) % 26 + base));
                } else {
                    // 解密逻辑: 将当前字符减去密钥字符，加上26后对26取模，再加上基准'a'得到原字符
                    result.append((char) ((c - key.charAt(j) + 26) % 26 + base));
                }
                j = ++j % key.length(); // 更新密钥索引，循环使用密钥
            } else {
                result.append(c);  // 非字母字符不变，直接添加到结果中
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key:");
        String key = scanner.nextLine();
        System.out.println("Enter the text to encrypt:");
        String original = scanner.nextLine();

        String encrypted = encrypt(original, key);  // 加密
        String decrypted = decrypt(encrypted, key);  // 解密

        System.out.println("Original Text: " + original);  // 显示原文
        System.out.println("Encrypted Text: " + encrypted);  // 显示加密后的文本
        System.out.println("Decrypted Text: " + decrypted);  // 显示解密后的文本

        scanner.close();
    }
}
