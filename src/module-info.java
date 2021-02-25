module main {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires org.junit.jupiter.api;
    requires junit;
    exports main;
    opens main to javafx.graphics;
}
