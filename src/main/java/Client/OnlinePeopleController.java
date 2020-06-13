package Client;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OnlinePeopleController extends Application implements Initializable {
    private ListView<String> listview ;
    private static ArrayList<String > chacha = new ArrayList<>();
    private  ObservableList<String> list ;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(OnlinePeopleController.class.getResource("/Client/OnlinePeople.fxml"));

        primaryStage.setTitle("Sclavi online");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void addingpeople(String name)
    {
        chacha.add(name);

    }
    public static void removepeople(String name)
    {
        chacha.remove(name);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list= FXCollections.observableArrayList(chacha);
        listview.setItems(list);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
