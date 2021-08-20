module grid {
    requires javafx.controls;
    requires javafx.fxml;

    opens src.grid to javafx.fxml;
    exports src.grid;
}
