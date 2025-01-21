module modelo {
    requires javafx.controls;
    requires javafx.fxml;

    opens modelo to javafx.fxml;
    opens Controllers to javafx.fxml;
    exports modelo;
    exports Controllers;
}
