package com.example.minigame.controllers;


import com.example.minigame.models.AlertBox;
import com.example.minigame.models.Player;
import com.example.minigame.views.GameView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MenuController {

    @FXML
    private TextField usernameTextField;

    @FXML
    void onMouseClickedPlayBtn(MouseEvent event) {
        String username = usernameTextField.getText();

        if (username.isEmpty()) {
            AlertBox alertBox = new AlertBox();
            alertBox.showAlertBox(
                    "Escritura rapida - Nombre de usuario",
                    "Nombre de usuario",
                    "Debes diligenciar tu nombre de usuario.");
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
