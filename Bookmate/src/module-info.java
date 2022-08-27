module LoginPage {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    opens User;
    opens Admin;
}