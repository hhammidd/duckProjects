package com.java2.week1.exam2.lessons.newAnswer;


    public class CaesarCipherTwo {

        private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final int LENGTH_OF_ALPHABET = ALPHABET.length();

        private static String encryptAlphabet1;
        private static String encryptAlphabet2;
        private static String decryptAlphabet1;
        private static String decryptAlphabet2;

        public static void main(String[] args) {
            String input = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
            CaesarCipherTwo cipherTwo = new CaesarCipherTwo(14, 24);
            System.out.println(cipherTwo.decrypt(input));
        }

        public CaesarCipherTwo(int key1, int key2) {
            encryptAlphabet1 = CaesarCipher.generateShiftedAlphabet(key1, ALPHABET);
            encryptAlphabet2 = CaesarCipher.generateShiftedAlphabet(key2, ALPHABET);
            decryptAlphabet1 = CaesarCipher
                    .generateShiftedAlphabet(LENGTH_OF_ALPHABET - key1, ALPHABET);
            decryptAlphabet2 = CaesarCipher
                    .generateShiftedAlphabet(LENGTH_OF_ALPHABET - key2, ALPHABET);
        }

        private String encrypt(String input, String alphabet1, String alphabet2) {
            StringBuilder builder = new StringBuilder();
            Character ch = ' ';
            String alphabet = CaesarCipherTwo.ALPHABET;
            for (int i = 0; i < input.length(); i++) {
                Character c = (char) (input.charAt(i));
                if (i % 2 == 0) {
                    ch = CaesarCipher.cipherChar(alphabet, alphabet1, c);
                } else {
                    ch = CaesarCipher.cipherChar(alphabet, alphabet2, c);
                }
                builder.append(ch);
            }

            return builder.toString();
        }

        public String encrypt(String input) {
            return encrypt(input, encryptAlphabet1, encryptAlphabet2);

        }

        public String decrypt(String input) {
            return encrypt(input, decryptAlphabet1, decryptAlphabet2);
        }

    }

