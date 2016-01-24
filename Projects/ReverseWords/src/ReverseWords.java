
public class ReverseWords {
    public static void main(String[] args){
        String temp = "We'd be giving up a booseter and effectively cancelling Taiyang Shen.";
        temp = reverseWords(temp);
        System.out.println(temp);
    }
    
    public static String reverseWords(String s){
        String result = "";
        s=s.trim();
        String[] words = s.split("\\s+");
        String current = "";
        //print(words);
        for(int i=0; i<words.length; i++){
            if(i==0){
                current = reverseFirstWord(words[i]);
            } else if(i==words.length-1){
                current = reverseLastWord(words[i]);
            } else{
                current = reverseSingleString(words[i]);
            }
            //System.out.println(current);
            if(i!=words.length-1)
                result+=current + " ";
            else
                result+=current;
        }
        return result;
    }
    
    private static String reverseLastWord(String a) {
        if(a.length()==1) return a;
        String x = a;
        char[] temp = x.toCharArray();
        int count = 0;
        for(int i=temp.length-1; i>=0; i--){
            if(!Character.isDigit(temp[i])&&!Character.isLetter(temp[i])){
                count++;
            }else{
                break;
            }
        }
        
        String x1 = "";
        String x2 = "";
        for(int i=0; i<temp.length-count; i++){
            x1+=""+temp[i];
        }
        
        for(int i=temp.length-count; i<temp.length; i++){
            x2+=""+temp[i];
        }
        
        x1 = reverseSingleString(x1);
        return x1+x2;
    }

    private static String reverseFirstWord(String b) {
        if(b.length()==1) return b;
        String x = b;
        char[] temp = x.toCharArray();
        int count = 0;
        for(int i=0; i<temp.length; i++){
            if(!Character.isDigit(temp[i])&&!Character.isLetter(temp[i])){
                count++;
            }else{
                break;
            }
        }
        
        String x1 = "";
        String x2 = "";
        for(int i=0; i<count; i++){
            x1+=""+temp[i];
        }
        
        for(int i=count; i<temp.length; i++){
            x2+=""+temp[i];
        }
        
        x2 = reverseSingleString(x2);
        return x1+x2;
    }

    public static String reverseSingleString(String s){
        if(s.length()==1) return s;
        String x = s;
        char[] temp = x.toCharArray();
        for(int i=0; i<temp.length/2; i++){
            char t = temp[i];
            temp[i] = temp[temp.length-i-1];
            temp[temp.length-i-1] = t;
        }
        return new String(temp);
    }
    
    public static void print(String[] ss){
        for(int i=0; i<ss.length; i++){
            System.out.print(ss[i]+"-");
        }
        System.out.println();
    }
}
