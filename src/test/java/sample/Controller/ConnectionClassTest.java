package sample.Controller;

import junit.framework.TestCase;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionClassTest extends TestCase {


    @Test
    public void testGetConnection() throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        Statement myStatement = connection.createStatement();
        String sql = "INSERT INTO USER VALUES('" + "TESTNAME" + "' , '" + "TESTPASS" + "' , '" + "standarius24@gmail.com" + "' , '" + "2020-04-24" + "')";
        myStatement.executeUpdate(sql);

        ConnectionClass connectionx = new ConnectionClass();
        Connection connectiony = connectionx.getConnection();
        Statement myStatements = connectiony.createStatement();
        ResultSet myResult = myStatements.executeQuery("select * from user");
        boolean test = false;
        while(myResult.next())
        {
            test = myResult.getString("Name").equals("TESTNAME") && myResult.getString("Password").equals("TESTPASS") ;

        }
        assertTrue(test);
    }
}