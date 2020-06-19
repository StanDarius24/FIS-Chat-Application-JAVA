package sample.Client;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class MessageFormatTest {

    public MessageFormat msg;
    @Before
    public void setup()
    {
    msg = new MessageFormat();
    msg.setName("TESTNAME");
    msg.setMessage("TESTMSG");
    }

    @Test
    public void getName() {
        assertTrue(msg.getName().equals("TESTNAME"));
    }

    @Test
    public void setName() {
    msg.setName("TESTINGSETNAME");
    assertTrue(msg.getName().equals("TESTINGSETNAME"));
    }

    @Test
    public void getMessage() {
        assertTrue(msg.getName().equals("TESTNAME"));
    }

    @Test
    public void setMessage() {
        msg.setMessage("TESTINGMSG");
        assertTrue(msg.getMessage().equals("TESTINGMSG"));
    }
}