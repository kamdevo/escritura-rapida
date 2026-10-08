package com.example.minigame.controllers;

import com.example.minigame.models.GameSystem;
import com.example.minigame.models.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;


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
//
//    private GameSystem game;
//
//
//    public void initialize() {
//        GameSystem game = new GameSystem();
//    }
//




//    @FXML
//    void onMouseClickedValidate(MouseEvent event) {
//        validate(false);
//    }
//
//    void validate(boolean timeOut) {
//        String userInput = wordInputTextField.getText();
//        boolean isCorrect = game.checkAnswer(userInput);
//
//        if (isCorrect ) {
//            game.upLevel();
//            resultsLabel.setText("Correcto");
//        } else if (timeOut) {
//            resultsLabel.setText("Tiempo agotado");
//        } else {
//            resultsLabel.setText("incorrecto");
//        }
//    }


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
        usernameLabel.setText(currentPlayer.getUsername());
    }

}
