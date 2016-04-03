import java.util.LinkedList;
import java.util.List;


public class LetterCombinationOfPhoneNumber {

    public static void main(String[] args) {
        List<String> r = letterCombinations("23");
        for(String s : r){
            System.out.println(s);
        }
    }
    
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.length()==0){
            return ans;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
    
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            System.out.println("i: " + i);
            System.out.println("x: " + x);
            System.out.println("ans.peek().length(): " + ans.peek().length());
            while(ans.peek().length()==i){
                String t = ans.remove();
                System.out.println("t: " + t);
                for(char s : mapping[x].toCharArray()){
                    System.out.println("t+s: " + (t+s));
                    ans.add(t+s);
                }
                System.out.println("After ans.peek(): " + ans.peek());
            }
        }
        return ans;
    }

}
