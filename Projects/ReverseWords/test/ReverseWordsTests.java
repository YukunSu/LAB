import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class ReverseWordsTests {

    @Test
    public void test1() {
        String test = "a";
        String actual = ReverseWords.reverseWords(test);
        String expected = "a";
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void test2() {
        String test = "ab";
        String actual = ReverseWords.reverseWords(test);
        String expected = "ba";
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void test3() {
        String test = "a a";
        String actual = ReverseWords.reverseWords(test);
        String expected = "a a";
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void test4() {
        String test = "^ ^ ^ $$";
        String actual = ReverseWords.reverseWords(test);
        String expected = "^ ^ ^ $$";
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void test5() {
        String test = "\"'abc cde.'\"";
        String actual = ReverseWords.reverseWords(test);
        String expected = "\"'cba edc.'\"";
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void test6() {
        String test = "\"'Yes? oh. NO!'\"";
        String actual = ReverseWords.reverseWords(test);
        String expected = "\"'?seY .ho ON!'\"";
        Assert.assertEquals(expected, actual);
    }

}
