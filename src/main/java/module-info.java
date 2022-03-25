module edu.ntnu.idatt2001.trym.cardgame.cardgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens edu.ntnu.idatt2001.trym.cardgame.cardgame to javafx.fxml;
    exports edu.ntnu.idatt2001.trym.cardgame.cardgame;
}