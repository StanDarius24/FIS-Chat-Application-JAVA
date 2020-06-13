package sample.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    String name;
    String message;
    private DataOutputStream dos;

    public DataOutputStream getDos() {
        return dos;
    }
}
