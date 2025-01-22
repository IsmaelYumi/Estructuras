module modelo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens modelo to javafx.fxml;
    opens Controllers to javafx.fxml;
    exports modelo;
    exports Controllers;
}
