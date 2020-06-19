package sample.Controller;

import junit.framework.TestCase;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;


public class BasicCryptoTest extends TestCase {



    @Test
    public void testEncrypt() throws NoSuchAlgorithmException{
        String x = BasicCrypto.encrypt("Test");
        assertTrue(x.equals(BasicCrypto.encrypt("Test")));
    }


}