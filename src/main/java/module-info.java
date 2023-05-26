module com.elevatorgame.elevatorgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.elevatorgame.elevatorgame to javafx.fxml;
    exports com.elevatorgame.elevatorgame;
}