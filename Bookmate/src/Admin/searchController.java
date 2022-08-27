package Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class searchController {
    public Admin.SqliteQueries sqlitequeries=new Admin.SqliteQueries();
    @FXML
    private Button homebtn;
    @FXML
    private Button searchbtn;

    @FXML
    private TextField txtbookname;

    @FXML
    private Label bookname;

    @FXML
    private Label authorname;

    @FXML
    private Label description;





//    public void SearchBook(ActionEvent event)
//    {
//        // String text1=txtusername.getText();
//        // String text2=txtpassword.getText();
//        //  if((text1.isEmpty() || text1.trim().isEmpty() || text2.isEmpty() || text2.trim().isEmpty())){
//        try{
//            if(!txtbookname.getText().isEmpty())
//            {
//                ResultSet resultSet = sqlitequeries.SearchData(txtbookname.getText());
//
//                if ( resultSet != null)
//                {
//                    bookname.setText(resultSet.getString("name"));
////                    authorname.setText(query.getSrinng());
////                    description.setText(query.getSting());
//                }
//
//
//
//            }
//            else {
//               // mylabel1.setText("Invalid Username and Password");
//            }
//        }catch (SQLException e)
//        {
//            e.printStackTrace();
//            //  mylabel1.setText("Invalid Username and Password");
//        }
//    }


    public void SearchBook(ActionEvent event) throws SQLException {
//        bookname.setText("Airin");
          ResultSet resultSet = sqlitequeries.SearchData(txtbookname.getText());
          bookname.setText("resultSet");
    }


    public void goTohome(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage stage =  (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Bookmate");
        stage.setScene(new Scene(root,640,430));
        stage.show();
    }


}
