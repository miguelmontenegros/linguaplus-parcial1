module co.edu.uniquindio.linguaplus {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.linguaplus.app to javafx.fxml, javafx.graphics;
    exports co.edu.uniquindio.linguaplus.app;

    opens co.edu.uniquindio.linguaplus.controlador to javafx.fxml;
    exports co.edu.uniquindio.linguaplus.controlador;

    opens co.edu.uniquindio.linguaplus.modelo to javafx.base;
    exports co.edu.uniquindio.linguaplus.modelo;
}