import java.util.Random;

/**
 * 背景知识
 * 这个凯撒密码简直了噜,看到开头就知道要干啥了,凯撒是第一个发明密码的人,当时靠这个也是席卷欧洲大陆.
 * 后来二战时期,德国靠enigma machine也是各种虐,直到图灵大神成功破译恩格玛机.
 * 
 * 看代码前务必读这个!
 * 凯撒密码是什么呢?现在看来很简单,就是把字母往后移那么几位
 * 
 * 小写a移3位就是小写d
 * 
 * 好,现在就上面这句话把它变成code.给个小写a,移三位,输出个小写d
 * 好,现在想了,这个移三位是什么鬼,神黑鲸了,要是5移三位变个5000,或者0.0005的,就是变个8也是很简单的就写出来了
 * 弄成个字母怎么搞?
 * 那么其实每个字母,每个标点,每个符号,只要从键盘上打出来的东西,都是可以用十进制的数代表的
 * 以前是ASCII CODE就是,256个,现在就是UNI CODE,有很多,因为中文,日文,韩文啊什么的
 * 这个题不用去考虑UNI CODE了,就去这个网址看ASCII CODE的转换 http://www.asciitable.com/
 * 
 * 也就是说什么呢,十进制的数可以和char互相转换,那么就简单了.
 * 把小写a转换成十进制是97,如果要变成小写d的话,移三位就是97+3=100.因为小写d的数字是100.再把100转换成char,就是小写d.
 * 
 * 好,技术问题来了,如何实现int和char之间互相转换?
 * 超简单,就加括号
 * char a = 'a';
 * print(a+3),就是100,这里程序自动替你转换了.如果没有后面的+3你要想print 97就是println((int)a);
 * 如果想要print d就System.out.println((char)(a+3));
 * 
 * 其实到这里这个作业的思路基本就完成了,下面就要考虑一些问题了,比如:
 * 1. 现在单独的char我们已经会转换了,如果是一串char呢,也就是String, 比如"ni hao zhuang bi"
 * 2. 大写的Z加3应该打出来大写的C,我们现在的思路是].如果不明白,自行参考上面链接里的ASCII表.
 * 3. 假设是英文字母表,shift 大于26位怎么办?其实这个算不上什么问题,搞个余数就可以了.
 * 4. 还有一个,上面三个作业里都有提到,但是还是不够严谨,shift应该只针对于26个字母,不然空格+3就变成了#,这应该不是我们想看到的
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
