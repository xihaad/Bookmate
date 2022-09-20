package Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class addbookController {

    public Admin.SqliteQueries sqlitequeries = new Admin.SqliteQueries();
    @FXML
    private Button choosefilebtn;

    @FXML
    private ListView listview;

    @FXML
    private TextField bookname;

    @FXML
    private TextField authorname;

    @FXML
    private TextField genre;

    @FXML
    private TextField description;

    @FXML
    private Label successbookinsert;



    public void ButtonAction(ActionEvent event){
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        if(selectedFile != null) {
            listview.getItems().add(selectedFile.getAbsoluteFile());
        } else {
            System.out.println("file is not valid");
        }
    }


    public void goTohome(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage stage =  (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Bookmate");
        stage.setScene(new Scene(root,640,430));
        stage.show();
    }



    public void SubmitBookInfo(ActionEvent event) throws IOException {



        if (bookname.getText() != null && authorname.getText() != null && genre.getText() != null && description.getText() != null   ) {
            if (sqlitequeries.AddBook(bookname.getText(), authorname.getText(),genre.getText(),description.getText()  )) {
                successbookinsert.setText("Successfully Data Inserted");

            } else {
                successbookinsert.setText("Successfully Data Not Inserted");
            }
        } else {
            successbookinsert.setText("Field Empty");
        }
    }


}
