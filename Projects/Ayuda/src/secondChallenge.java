package src;

public class secondChallenge {

    private static int offset = 0;
    // reference letters for base64 encoding
    static String ref = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    static char[] refArray = ref.toCharArray();

    // encoded message to be decoded
    static String message = "dFSnl6WcqKdbrbKts6V7YmWHrbuqs2mYur6/t8JwtcG4x8N9y3jOzcB81MPBgNTWxNLJx9nM3IrM343i19WR6djWle3g5OWa3uvr5O7y7qL386Xu8PW3rKvf7gIEAvXzDLT+Cbf5uQEKCwG+AwEawhcTxRkWFB8PyxwiKCkcFiXh4g==";
    static char[] messageArray = message.toCharArray();

    static boolean endFlag = false;

    public static void main(String[] args) {
    // turn message to its binary representation
    String binaryString = encodedStringToBinary();
    String[] binarySplit = binaryString.split("(?<=\\G.{8})");
    System.out.println(binaryString);
    for (int i = 0; i < binarySplit.length; i++) {
        System.out.println(binarySplit[i]);
        if (i<binarySplit.length) {
        System.out.print(binaryStringtoChar(binarySplit[i]));
        } 
    }
    }

    /**
     * loops through the message and changes every character to its binary
     * equivalent and concatenates them.
     * 
     * @return a string of concatenated binaries
     */
    public static String encodedStringToBinary() {
    String binaryString = "";
    for (int i = 0; i < messageArray.length; i++) {
        //System.out.println(messageArray[i] + "   " + charToBinary(messageArray[i]));
        binaryString += charToBinary(messageArray[i]);
    }
    return binaryString;
    }

    /**
     * Changes a given character to its base64 binary number equivalent
     * 
     * @param messageChar
     *            a base64 character
     * @return the binary equivalent of the parameter
     */
    public static String charToBinary(char messageChar) {
    String binary;
    for (int i = 0; i < refArray.length; i++) {
        if (messageChar == refArray[i]) {
        // get the base64 number for the char
        binary = Integer.toBinaryString(i);
        //System.out.println(messageChar + "   " + i + "   " + binary);
        // for padding
        while (binary.length() < 6) {
            binary = "0" + binary;
        }
        return binary;
        }
    }
    
    return "";
    }

    /**
     * Changes binary strings to characters using ASCII values and a location
     * offset
     * 
     * @param binaryString
     *            a string representing a binary ASCII value
     * @return a decoded character
     */
    public static char binaryStringtoChar(String binaryString) {

    int number = Integer.parseInt(binaryString, 2);
    number -= offset;
    offset = (offset + 1) % 42;
    char decodedChar = (char) number;
    if(number<0){
        return ' ';
    }
    return decodedChar;
    }

}
