/**
 * Module of the "Fast Writing" game.
 * <p>
 * It requires JavaFX and opens the main and controller packages
 * to the FXML loader, so it can create the controllers and inject
 * their {@code @FXML} fields.
 */
module com.example.minigame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.minigame to javafx.fxml;
    exports com.example.minigame;
    opens com.example.minigame.controllers to javafx.fxml;
    exports com.example.minigame.controllers;
}