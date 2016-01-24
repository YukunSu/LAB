package src;

import java.util.HashMap;


public class Decrypt {

    public static String decrypt(String s) {
        if(s.length()%2!=0) return null;
        String[] firstLetterSecret = {"2","3","0","1","6","7","4","5", "A", "B","8","9","E","F","C","D"};
        String[] secondLetterSecret = {"A","B","8","9","E","F","C","D","2","3","0","1","6","7","4","5"};
        HashMap<String, String> first = new HashMap<String, String>();
        HashMap<String, String> second = new HashMap<String, String>();
        
        for (int i = 0; i < firstLetterSecret.length; i++) {
            if(i==10){
                first.put(firstLetterSecret[i], "A");
            }else if(i==11){
                first.put(firstLetterSecret[i], "B");
            }else if(i==12){
                first.put(firstLetterSecret[i], "C");
            }else if(i==13){
                first.put(firstLetterSecret[i], "D");
            }else if(i==14){
                first.put(firstLetterSecret[i], "E");
            }else if(i==15){
                first.put(firstLetterSecret[i], "F");
            }else{
                first.put(firstLetterSecret[i], Integer.toString(i));
            }
        }
        
        for (int i = 0; i < secondLetterSecret.length; i++) {
            if(i==10){
                second.put(secondLetterSecret[i], "A");
            }else if(i==11){
                second.put(secondLetterSecret[i], "B");
            }else if(i==12){
                second.put(secondLetterSecret[i], "C");
            }else if(i==13){
                second.put(secondLetterSecret[i], "D");
            }else if(i==14){
                second.put(secondLetterSecret[i], "E");
            }else if(i==15){
                second.put(secondLetterSecret[i], "F");
            }else{
                second.put(secondLetterSecret[i], Integer.toString(i));
            }
        }
        String[] decryptPair = new String [s.length()/2];
        for (int i = 0; i < decryptPair.length; i++) {
            decryptPair[i] = "" + s.charAt(i*2) + s.charAt(i*2+1);
        }
        
        String[] resultHEX = new String[decryptPair.length];
        for (int i = 0; i < resultHEX.length; i++) {
            resultHEX[i] = first.get(""+decryptPair[i].charAt(0)) + second.get(""+decryptPair[i].charAt(1));
        }
        
        for (int i = 0; i < resultHEX.length; i++) {
            System.out.print((char) Integer.parseInt(resultHEX[i], 16));
        }
        return null;
    }

}
