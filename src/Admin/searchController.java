package Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class searchController {
    public Admin.SqliteQueries sqlitequeries=new Admin.SqliteQueries();
    @FXML
    private Button homebtn;
    

    public void goTohome(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage stage =  (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Bookmate");
        stage.setScene(new Scene(root,640,430));
        stage.show();
    }


}
