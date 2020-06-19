package sample.Client;

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
    public JSONObject js;

    public TextField myMsg;

    public TextArea chatLog;

    public room() {
        try {

            sock = new Socket(data.ip, data.port);
            dos = new DataOutputStream(sock.getOutputStream());
            dis = new DataInputStream(sock.getInputStream());

            dos.writeUTF(data.name);

            th = new Thread(this::run);

            th.start();

        } catch(IOException E) {
            E.printStackTrace();
        }

    }

    public void onClickSend() {
        try {
            String msg = myMsg.getText();

            //String json = "{" + " 'name' : '" + data.name + "', 'message' : '" + msg + "'" + "}";

           js = new JSONObject();
            js.put("name", data.name);
            js.put("message", msg);

            String json = js.toJSONString();


            System.out.println(json);

            dos.writeUTF(json);
            myMsg.setText("");
            myMsg.requestFocus();

        } catch(IOException E) {
            E.printStackTrace();
        }

    }

    public void buttonPressed(KeyEvent e) {
        if(e.getCode().toString().equals("ENTER"))
        {
            onClickSend();
        }
    }

    private void run() {
        try {

            JSONParser parser = new JSONParser();

            while (true) {
                String newMsgJson = dis.readUTF();

                System.out.println("RE : " + newMsgJson);
                MessageFormat newMsg = new MessageFormat();

                Object obj = parser.parse(newMsgJson);
                JSONObject msg = (JSONObject) obj;

                newMsg.setName((String) msg.get("name"));
                newMsg.setMessage((String) msg.get("message"));

                chatLog.appendText(newMsg.getName() + " : " + newMsg.getMessage() + "\n");
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

    }
}

