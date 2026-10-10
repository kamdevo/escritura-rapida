package com.example.minigame.controllers;


import com.example.minigame.models.AlertBox;
import com.example.minigame.models.Player;
import com.example.minigame.views.GameView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * Controller for the main menu view.
 * <p>
 * It reads the username, creates the {@link Player}
 * and opens the game window.
 *
 * @author Juan Camilo Morales
 * @author Nicolas Palacios
 * @author Juan Camilo Pinzon
 * @version 1.0
 */
public class MenuController {

    /** Text field where the player enters their username. */
    @FXML
    private TextField usernameTextField;

    /**
     * Starts the game when the play button is clicked.
     * <p>
     * It creates the player with the given username, passes it to the
     * game controller and switches from the menu to the game window.
     * If the username is empty, an alert asks the player to fill it in
     * and the game does not start.
     *
     * @param event the mouse event that triggered the action
     */
    @FXML
    void onMouseClickedPlayBtn(MouseEvent event) {
        String username = usernameTextField.getText();

        if (username.isEmpty()) {
            AlertBox alertBox = new AlertBox();
            alertBox.showAlertBox(
                    "Escritura rapida - Nombre de usuario",
                    "Nombre de usuario",
                    "Debes diligenciar tu nombre de usuario.");
            return;
        }

        Player player = new Player();
        player.setUsername(username);

        GameView gameView = null;
        try {
            gameView = GameView.getInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GameController gameController = gameView.getController();
        gameController.setCurrentPlayer(player);

        gameView.show();

        usernameTextField.getScene().getWindow().hide();
    }

}
