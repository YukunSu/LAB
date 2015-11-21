import java.util.Random;

/**
 * ����֪ʶ
 * ������������ֱ����,������ͷ��֪��Ҫ��ɶ��,�����ǵ�һ�������������,��ʱ�����Ҳ��ϯ��ŷ�޴�½.
 * ������սʱ��,�¹���enigma machineҲ�Ǹ���Ű,ֱ��ͼ�����ɹ�����������.
 * 
 * ������ǰ��ض����!
 * ����������ʲô��?���ڿ����ܼ�,���ǰ���ĸ��������ô��λ
 * 
 * Сдa��3λ����Сдd
 * 
 * ��,���ھ�������仰�������code.����Сдa,����λ,�����Сдd
 * ��,��������,�������λ��ʲô��,��ھ���,Ҫ��5����λ���5000,����0.0005��,���Ǳ��8Ҳ�Ǻܼ򵥵ľ�д������
 * Ū�ɸ���ĸ��ô��?
 * ��ô��ʵÿ����ĸ,ÿ�����,ÿ������,ֻҪ�Ӽ����ϴ�����Ķ���,���ǿ�����ʮ���Ƶ��������
 * ��ǰ��ASCII CODE����,256��,���ھ���UNI CODE,�кܶ�,��Ϊ����,����,���İ�ʲô��
 * ����ⲻ��ȥ����UNI CODE��,��ȥ�����ַ��ASCII CODE��ת�� http://www.asciitable.com/
 * 
 * Ҳ����˵ʲô��,ʮ���Ƶ������Ժ�char����ת��,��ô�ͼ���.
 * ��Сдaת����ʮ������97,���Ҫ���Сдd�Ļ�,����λ����97+3=100.��ΪСдd��������100.�ٰ�100ת����char,����Сдd.
 * 
 * ��,������������,���ʵ��int��char֮�以��ת��?
 * ����,�ͼ�����
 * char a = 'a';
 * print(a+3),����100,��������Զ�����ת����.���û�к����+3��Ҫ��print 97����println((int)a);
 * �����Ҫprint d��System.out.println((char)(a+3));
 * 
 * ��ʵ�����������ҵ��˼·�����������,�����Ҫ����һЩ������,����:
 * 1. ���ڵ�����char�����Ѿ���ת����,�����һ��char��,Ҳ����String, ����"ni hao zhuang bi"
 * 2. ��д��Z��3Ӧ�ô������д��C,�������ڵ�˼·��].���������,���вο������������ASCII��.
 * 3. ������Ӣ����ĸ��,shift ����26λ��ô��?��ʵ����㲻��ʲô����,��������Ϳ�����.
 * 4. ����һ��,����������ҵ�ﶼ���ᵽ,���ǻ��ǲ����Ͻ�,shiftӦ��ֻ�����26����ĸ,��Ȼ�ո�+3�ͱ����#,��Ӧ�ò��������뿴����
 * 
 * @author Yukun
 *
 */
public class CaesarEncrypt {
    private static final int ALPHABET = 26;
    public static void main(String[] args){
       String msg = "go Rangers!";
       System.out.println(caesarEncrypt(msg, 3));
       System.out.println(caesarDecrypt("jr Udqjhuv!", 3));
       System.out.println(crackCipher("jr Udqjhuv!", 8));
       System.out.println(caesarDecrypt("cde FGH", 8));
       System.out.println(permuteEncrypt(msg));
       System.out.println(permuteEncrypt("Aaa!@$#%#$@ZzzzBCNQutrun*()"));
   }

    public static String caesarEncrypt(String inputMsg, int shift){
        String encryptedMsg = "";
        int realShift = shift % ALPHABET; //Solve issue 3
        for(int i=0; i<inputMsg.length(); i++){ //Solve issue 1
            char encryptedChar = ' ';
            char originalChar = inputMsg.charAt(i);
            if(Character.isLetter(originalChar)){ //Solve issue 4
                if(Character.isUpperCase(originalChar)){
                    if((int)originalChar + realShift > (int)'Z'){ //Solve issue 2
                        encryptedChar = (char)(originalChar + realShift - ALPHABET);
                    }else {
                        encryptedChar = (char)(originalChar + realShift);
                    }
                }else {
                    if((int)originalChar + realShift > (int)'z'){ //Solve issue 2
                        encryptedChar = (char)(originalChar + realShift - ALPHABET);
                    }else {
                        encryptedChar = (char)(originalChar + realShift);
                    }
                }
            }else{
                encryptedChar = inputMsg.charAt(i);
            }
            encryptedMsg += Character.toString(encryptedChar);
        }
        return encryptedMsg;
   }
    
    public static String caesarDecrypt(String inputMsg, int shift){
        return caesarEncrypt(inputMsg, ALPHABET - shift%26);
    }
    
    public static String crackCipher(String encoded, int numberLetters){
        int countWords = -1;
        String decryptedMsg = encoded; //May initialize as an empty string also
        for(int i=0; i<numberLetters; i++){
            String result = caesarDecrypt(encoded, i);
            int tempCountWords = SentenceChecker.countEnglishWords(result);
            if(tempCountWords > countWords){
                decryptedMsg = result;
                countWords = tempCountWords;
            }
        }
        return decryptedMsg;
    }
    
    public static void shuffle(char[] msg){
        Random generator = new Random(12345);
        for(int i=0; i<Math.pow(msg.length, 4); i++){
            int n = generator.nextInt(msg.length);
            int m = generator.nextInt(msg.length);
            //System.out.println(i + " " + n + " " + m);
            char temp = msg[n];
            msg[n] = msg[m];
            msg[m] = temp;
        }
    }
    
    public static char[] getPermutation(){
        char[] array = new char[ALPHABET];
        char a = 'A';
        for(int i=0; i<array.length; i++){
            array[i] = (char)(a + i);
        }
        printCharArray(array);
        shuffle(array);
        printCharArray(array);
        return array;
    }
    
    public static String permuteEncrypt(String inputMsg){
        String encryptedMsg = "";
        char[] mappingArray = getPermutation();
        for(int i=0; i<inputMsg.length(); i++){
            char encryptedChar = ' ';
            char originalChar = inputMsg.charAt(i);
            if(Character.isLetter(originalChar)){
                if(Character.isUpperCase(originalChar)){
                    encryptedChar = mappingArray[originalChar - 'A'];
                } else{
                    encryptedChar = Character.toLowerCase(mappingArray[originalChar - 'a']);
                }
            }else{
                encryptedChar = inputMsg.charAt(i);
            }
            encryptedMsg += Character.toString(encryptedChar);
        }
        return encryptedMsg;
    }
    
    private static void printCharArray(char[] a){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
