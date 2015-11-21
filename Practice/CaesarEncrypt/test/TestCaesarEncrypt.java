import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class TestCaesarEncrypt {

    @Test
    public void testCase1() {
        String originalMsg = "go Rangers!";
        String encryptedMsg = CaesarEncrypt.caesarEncrypt(originalMsg, 3);
        String expectedMsg = "jr Udqjhuv!";
        assertEquals(expectedMsg, encryptedMsg);
    }
    
    @Test
    public void testCase2() {
        String originalMsg = "go Rangers!";
        String encryptedMsg = CaesarEncrypt.caesarEncrypt(originalMsg, 0);
        String expectedMsg = "go Rangers!";
        assertEquals(expectedMsg, encryptedMsg);
    }
    
    @Test
    public void testCase3() {
        String originalMsg = "go Rangers!";
        String encryptedMsg = CaesarEncrypt.caesarEncrypt(originalMsg, 263);
        String expectedMsg = "jr Udqjhuv!";
        assertEquals(expectedMsg, encryptedMsg);
    }
    
    @Test
    public void testCase4() {
        String originalMsg = "1234@#$%$#^%$     (*){}|";
        String encryptedMsg = CaesarEncrypt.caesarEncrypt(originalMsg, 54);
        String expectedMsg = "1234@#$%$#^%$     (*){}|";
        assertEquals(expectedMsg, encryptedMsg);
    }
    
    @Test
    public void testCase5() {
        String originalMsg = "uvw XYZ";
        String encryptedMsg = CaesarEncrypt.caesarEncrypt(originalMsg, 8);
        String expectedMsg = "cde FGH";
        assertEquals(expectedMsg, encryptedMsg);
    }

}
