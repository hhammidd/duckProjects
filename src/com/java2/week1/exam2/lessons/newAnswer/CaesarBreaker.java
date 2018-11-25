package com.java2.week1.exam2.lessons.newAnswer;

    public class CaesarBreaker {

        private static final char MOST_FREQUENT_LETTER_IN_ENGLISH = 'E';
        private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        public static void main(String[] args) {
            String input = "Top ncmy qkff vi vguv vbg ycpx";
            printDecryptedAndEncryptedMessageWithTwoKeys(input, 2, 20);
            System.out.println(halfOfString(input, 1));
            System.out.println("\n" + "------------------------------------" + "\n" );

            String input3 = "Uybi Gfqgykii Jgziegv Uigeixdiex SmiizzinSei sw klv deec lrpcqrvbw sw fyi jytgvwj yej sivr jiyzxwyc tscprffvrxzsew edsek hzjwiiiex kisltj nmklzr xyi hvtrvkqvrk, azxy iijirvtl kisltj zr sklvv hvtrvkqvrkw ek Uybi, nmkl sklvv mewkmkykij, eeh azxy zruyjxic. Rw av dsmi mexf klv zrwsiqrxzse rkv, xyi jfglw sw jgziegv zw wymwxzrx wvfq xyi hzwtsmiic sw ein zrwsiqrxzse ks xyi gfqgykekmfrrpcc mexvrjmmi xrwb fj tistijwzrx rru rrrppdzrx zrwsiqrxzse.Ni lrzv fykwkeehzrx gvfkiedw me xifqvximt tsdtlxzrx; mexvveik jcjxvqj, rvxnsiozrx, eeh wvglvzxp; fzscsxmtec tsdtlxzrx; qvqfvp jcjxvqj rru dejwzzv ueke qrrrkvqvrk; eeh pveirzrx rru dsuicmek. Klv iijirvtl mexvvvwkw sw fyi wetycxp fzvvceg nmkl xyiji eiirw eeh azxy iijirvtlvv eiirw me fxyii umjgztcmeij jytl ej smfpfkp, iekzrviimek, eeeskitlescsxc, rru vrmmiseqvrkec jgziegvw.GJ Uigx Tysks Av rpjs hf nsio me r eydfvv sw fxyii zqgsixrrk rvvej zrtplhzrx tsdtlxvv kieglzgj rru mmjyrpzdrxzse, wvrjsi eikafvbw, eydiimtec rrrppwzw, jswxneii iekzrviimek, tsdtciomkc xyifvp, eeh vfffxzgj.Klv uigeixdiex mj rvxyrfcc yemhyv zr xyi wpqsmfwzw xyek vbzwkw fvxnivr xyi iuytekmfr kislt eeh xyi vvwveigy wetycxp. Xyi wprvvxc fvxnivr xyid yej sivr e ovc xf klv jytgvwj zr gfrkmeyrpcc vvjfvdmek xyi glvimtycyd rru zrkixvrxzrx iijirvtl eeh iuytekmfr. Klv uigeixdiex mj lwzrx r uyrp egtisrgy ks gfqsmei vvwveigy rru vhlgrxzse. Fimekzrx iijirvtl mexf klv tyivzglplq mj klv sijx arc xf kvrme jxlhvrkw esslx xyi qfwk rhmeegvh xvgyrfpfkp rru ks hzwjidmeeki xyi prxvwk uimicsgqvrkw sw tsdtlxzrx kitlescsxc me jstmvxp.TW Hvtk Glfxf Ni iegfyiexi yehvvxvrhleki wkyuiexj ks kvx mezfpmiu nmkl sekfmek qrnfv vvwveigy gvfnvgkw xyvfyxl xyi G-WLVW gvfkied, yehvvxvrhleki xyijij, Vvwveigy Vbgiimvrti jfv Yehvvxvrhlekij (VVY) jygtfvk, mehvtvruiex wkyumvw, vxt. Wfqv fj slv iogvtkmfrrp jzvjx qrnfvj xvrhleki azxy umjxzrtxzse, aymtl mezfpmij r jmxrzjzgrrk iijirvtl gfqgseiex, rru zr qrrp tejij klv iijirvtl lrw vvwlpkiu zr tlfcmtekmfrj zr pveumek gfrwiiiegvw.Xyi idmeiegv fj slv vvwveigy rru kirgymek jrglpkc mj klv smxkvwk jxiiekkl sw klv uigeixdiex. Deec jrglpkc qvqsiiw lrzv sivr vvgfkemqiu sskl ek lrzzvvjmkc eeh rrxzseec cimicw jfv xyizv iogvpciegv zr vvwveigy, iuytekmfr, rru jiizzgv. Lzkypp mmjmspv, qlpkmumjgztcmeeic tisaitxj rvv sizrx tsehlgkiu, wgsewfvvh fp meimfyj wyehzrx rkvrtmvw.Xyi hvtrvkqvrk gvfzzhvw ee vbkvvqvpp jxzqlprxzrx, tisuytxzzv, eeh jimvrupp vrmmiseqvrk zr xyi jfvd fj gcejwisfq, fjwmti, rru ces jtrgv; gfqgykmek mejiejxiytxlvv; xvetlzrx jygtfvk; eeh kieuyrxv wicpfajlztj rru rwjmjxrrkwymgw. Zx ieespvw jrglpkc eeh wkyuiexj ks etgfqgpzwy klvmi wycp tfxvrkmrp. Klv uigeixdiex mj tsewkvlgkiu ks iegfyiexi merfzrxzzv tscprffvrxzsew edsek xyi wtmvrtij, iekzrviimek, vrmmiseqvrkec jxlhzij, eeh qvhzgzrv.";

            String first = halfOfString(input3, 0);
            String second = halfOfString(input3, 1);

            int fistKey = getKey(first);
            int secondKey = getKey(second);

            printTheTwoKeys(fistKey, secondKey);
            CaesarCipherTwo cipherTwo = new CaesarCipherTwo(fistKey, secondKey);
            System.out.println("Message decrypted: " + cipherTwo.decrypt(input3));
        }

        private static void printTheTwoKeys(int fistKey, int secondKey) {
            System.out.println("FirstKey: " + fistKey);
            System.out.println("SecondKey: " + secondKey);
        }

        private static void printDecryptedAndEncryptedMessageWithTwoKeys(
                String input, int key1, int key2) {
            CaesarCipherTwo cipherTwoKeys = new CaesarCipherTwo(key1, key2);
            String decryptedMessage = cipherTwoKeys.decrypt(input);
            String encryptedMessage = cipherTwoKeys.encrypt(decryptedMessage);
            System.out.println(decryptedMessage);
            System.out.println(encryptedMessage);
        }

        public static int getKey(String s) {
            int[] lettersFrequency = countLetters(s);
            int largestLetterFrequencyIndex = indexOfMax(lettersFrequency);
            int mostFrequentLetterIndex = CaesarBreaker.ALPHABET
                    .indexOf(CaesarBreaker.MOST_FREQUENT_LETTER_IN_ENGLISH);
            int key = largestLetterFrequencyIndex - mostFrequentLetterIndex;
            if (key < 0) {
                key = CaesarBreaker.ALPHABET.length() - Math.abs(key);
            }
            return key;
        }

        public static String halfOfString(String message, int start) {
            String answer = "";
            for (int k = start; k < message.length(); k += 2) {
                answer = answer + message.charAt(k);
            }
            return answer;
        }

        public static int[] countLetters(String word) {
            int[] counts = new int[CaesarBreaker.ALPHABET.length()];

            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (Character.isLetter(letter)) {
                    int letterIndex = CaesarBreaker.ALPHABET
                            .indexOf(Character.toUpperCase(letter));
                    counts[letterIndex]++;
                }
            }

            return counts;
        }

        private static int indexOfMax(int[] lengths) {
            int maxValue = 0;
            int indexMax = 0;
            for (int i = 0; i < lengths.length; i++) {
                if (lengths[i] > maxValue) {
                    maxValue = lengths[i];
                    indexMax = i;
                }
            }
            return indexMax;
        }

}
