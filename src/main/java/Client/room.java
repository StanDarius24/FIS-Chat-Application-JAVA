package Client;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class room {
    public static Thread th;
    Socket sock;
    DataOutputStream dos;
    DataInputStream dis;

    @FXML
    public TextField myMsg;
    @FXML
    public TextArea chatLog;

}

