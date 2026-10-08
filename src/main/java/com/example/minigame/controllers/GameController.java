package com.example.minigame.controllers;

import com.example.minigame.models.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameController {

    private Player currentPlayer;

    @FXML
    private Label levelLabel;

    @FXML
    private Label randomWordLabel;

    @FXML
    private Label resultsLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField wordInputTextField;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
        usernameLabel.setText(currentPlayer.getUsername());
    }

}
