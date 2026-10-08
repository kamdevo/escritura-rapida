package com.example.minigame.controllers;

import com.example.minigame.models.GameSystem;
import com.example.minigame.models.Player;
import com.example.minigame.models.Timer;
import com.example.minigame.models.TimerAdapter;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


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

    @FXML
    private Button restartBtn;

    private GameSystem game;
    private Timeline timeline;
    private int secondsLeft;
    private Timer timer;



    public void initialize() {
        game = new GameSystem();
        timer = new Timer(new TimerAdapter() {           // ← el nombre de la clase
            @Override
            public void onSecond(int secondsLeft) {
                timeLabel.setText(secondsLeft + " s");
            }

            @Override
            public void onTimeOut() {
                validate(true);
            }
        });
        startLevel();
    }

    @FXML
    void onMouseClickedRestart(MouseEvent event) {
        game = new GameSystem();
        wordInputTextField.setDisable(false);
        resultsLabel.setText("");
        restartBtn.setDisable(true);
        startLevel();
    }


    //iniciar  nivel
    private void startLevel() {
        levelLabel.setText("Nivel: " + game.getLevel());
        randomWordLabel.setText(game.nextWord());
        wordInputTextField.clear();
        timer.start(game.getTimeForLevel());
        wordInputTextField.requestFocus();
    }


    private void endGame(boolean won) {
        wordInputTextField.setDisable(true);
        resultsLabel.setText((won ? "¡Ganaste!" : "Tiempo agotado.")
                + "\nNiveles completados: " + game.getCompletedLevels()
                + "\nTiempo restante: " + timer.getSecondsLeft() + " s");
        restartBtn.setVisible(true);
    }








    @FXML
    void onMouseClickedValidate(MouseEvent event) {
        validate(false);
    }

    // 2. TECLADO: tecla Enter (clase interna)
//    private class EnterKeyHandler implements EventHandler<KeyEvent> {
//        @Override
//        public void handle(KeyEvent event) {
//            if (event.getCode() == KeyCode.ENTER) {
//                validate(false);
//            }
//        }
//    }

    @FXML
    void onEnterPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            validate(false);
        }
    }


    //METODO APRAVALDIAR EQUIVALENCIA

    private void validate(boolean timeOut) {
        String userInput = wordInputTextField.getText();
        boolean isCorrect = game.checkAnswer(userInput);

        if (isCorrect ) {
            timer.stop();
            game.upLevel();

            resultsLabel.setText("¡Muy bien!");
            startLevel();
        } else if (timeOut) {
            resultsLabel.setText("Tiempo agotado.");
            endGame(false);

        } else {
            resultsLabel.setText("incorrecto, sigue intenando.");
        }
    }





    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
        usernameLabel.setText(currentPlayer.getUsername());
    }

}
