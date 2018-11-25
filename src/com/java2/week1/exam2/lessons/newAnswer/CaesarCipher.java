package com.java2.week1.exam2.lessons.newAnswer;

public class CaesarCipher {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String shiftedAlphabet;
    private static int mainKey;

    public static void main(String[] args) {
        String input = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        CaesarCipher cipher = new CaesarCipher(15);
        System.out.println(cipher.encrypt(input));

        printMessageEncryptedWithTwoKeys(input, 21, 8);
    }

    private static void printMessageEncryptedWithTwoKeys(String input, int key1, int key2) {
        CaesarCipherTwo cipherTwo = new CaesarCipherTwo(key1, key2);
        System.out.println(cipherTwo.encrypt(input));
    }

    public CaesarCipher(int key){
        shiftedAlphabet = generateShiftedAlphabet(key, ALPHABET);
        mainKey = key;
    }

    public static String decrypt(String input){
        CaesarCipher breaker = new CaesarCipher(26 - mainKey);
        return breaker.encrypt(input);
    }

    public String encrypt(String input) {
        StringBuilder builder = new StringBuilder();
        String alphabet = CaesarCipher.ALPHABET;
        for (int i = 0; i < input.length(); i++) {

            Character c = (char) (input.charAt(i));
            char shiftedChar = cipherChar(alphabet, shiftedAlphabet, c);
            builder.append(shiftedChar);
        }
        return builder.toString();
    }

    public static char cipherChar(String alphabet, String shiftedAlphabet,
                                  Character c) {
        if (!isALetterOfAlphabet(alphabet, c)) {
            return c;
        }
        int positionChar = alphabet.indexOf(Character.toUpperCase(c));
        char shiftedChar = shiftedAlphabet.charAt(positionChar);
        if (Character.isLowerCase(c)) {
            shiftedChar = Character.toLowerCase(shiftedChar);
        }
        return shiftedChar;
    }

    private static boolean isALetterOfAlphabet(String alphabet, Character c) {
        return alphabet.contains(String.valueOf(Character.toUpperCase(c)));
    }

    public static String generateShiftedAlphabet(int key, String alphabet) {
        String shiftedAlphabet = alphabet.substring(key);
        shiftedAlphabet += alphabet.subSequence(0, key);
        return shiftedAlphabet;
    }

    private static String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder builder = new StringBuilder();
        Character ch = ' ';
        String alphabet = CaesarCipher.ALPHABET;
        String shiftedAlphabet1 = generateShiftedAlphabet(key1, alphabet);
        String shiftedAlphabet2 = generateShiftedAlphabet(key2, alphabet);
        for (int i = 0; i < input.length(); i++) {
            Character c = (char) (input.charAt(i));
            if (i % 2 == 0) {
                ch  = cipherChar(alphabet, shiftedAlphabet1, c);
            }else{
                ch = cipherChar(alphabet, shiftedAlphabet2, c);
            }
            builder.append(ch);
        }

        return builder.toString();

    }

}