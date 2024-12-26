module org.example.uap {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.uap to javafx.fxml;
    exports org.example.uap;
}