package Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class homeController {
    public Admin.SqliteQueries sqlitequeries=new Admin.SqliteQueries();


    @FXML
    private Button searchbtn;

    public void SearchCheck(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("search.fxml"));
        Stage stage =  (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Bookmate");
        stage.setScene(new Scene(root,640,430));
        stage.show();
    }

    public void AddBook(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addbook.fxml"));
        Stage stage =  (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Bookmate");
        stage.setScene(new Scene(root,640,430));
        stage.show();
    }

}
