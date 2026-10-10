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


/**
 * Controller for the game view.
 * <p>
 * It responds to the player's actions (mouse clicks and the Enter key),
 * runs the countdown of each level and keeps the screen in sync with
 * the state of the {@link GameSystem} model.
 *
 * @author Juan Camilo Morales
 * @author Nicolas Palacios
 * @version 1.0
 */
public class GameController {

    /** Player who is currently playing. */
    private Player currentPlayer;

    /** Shows the current level. */
    @FXML
    private Label levelLabel;

    /** Shows the word the player has to type. */
    @FXML
    private Label randomWordLabel;

    /** Shows feedback messages and the final summary. */
    @FXML
    private Label resultsLabel;

    /** Shows the time left in the current level. */
    @FXML
    private Label timeLabel;

    /** Shows the player's username. */
    @FXML
    private Label usernameLabel;

    /** Text field where the player types the answer. */
    @FXML
    private TextField wordInputTextField;

    /** Lets the player start a new game. It stays hidden until the game ends. */
    @FXML
    private Button restartBtn;

    /** Model that holds the rules and the state of the current game. */
    private GameSystem game;
    private Timeline timeline;
    private int secondsLeft;

    /** Countdown timer for the current level. */
    private Timer timer;



    /**
     * Initializes the controller once the FXML file has been loaded.
     * <p>
     * It creates the game model and the level timer, and starts the first level.
     * The timer events are handled by an anonymous inner class that extends
     * {@link TimerAdapter}, so only the events the game needs are overridden.
     */
    public void initialize() {
        game = new GameSystem();
        timer = new Timer(new TimerAdapter() {
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

    /**
     * Starts a new game from the first level when the restart button is clicked.
     *
     * @param event the mouse event that triggered the action
     */
    @FXML
    void onMouseClickedRestart(MouseEvent event) {
        game = new GameSystem();
        wordInputTextField.setDisable(false);
        resultsLabel.setText("");
        restartBtn.setVisible(false);
        startLevel();
    }


    /**
     * Starts a new level.
     * <p>
     * It shows the current level and a new random word, clears the text field
     * and restarts the countdown with the time allowed for this level.
     */
    private void startLevel() {
        levelLabel.setText("Nivel: " + game.getLevel());
        randomWordLabel.setText(game.nextWord());
        wordInputTextField.clear();
        timer.start(game.getTimeForLevel());
        wordInputTextField.requestFocus();
    }


    /**
     * Ends the current game.
     * <p>
     * It disables the text field, shows a summary with the completed levels
     * and the remaining time, and displays the restart button.
     *
     * @param won {@code true} if the player completed the maximum level;
     *            {@code false} if the time ran out
     */
    private void endGame(boolean won) {
        wordInputTextField.setDisable(true);
        resultsLabel.setText((won ? "¡Ganaste!" : "Tiempo agotado.")
                + "\nNiveles completados: " + game.getCompletedLevels()
                + "\nTiempo restante: " + timer.getSecondsLeft() + " s");
        restartBtn.setVisible(true);
    }








    /**
     * Validates the player's answer when the validate button is clicked.
     *
     * @param event the mouse event that triggered the action
     */
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

    /**
     * Validates the player's answer when the Enter key is pressed in the text field.
     *
     * @param event the key event that triggered the action
     */
    @FXML
    void onEnterPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            validate(false);
        }
    }


    /**
     * Checks the player's answer and updates the game accordingly.
     * <p>
     * If the answer is correct, the player moves on to the next level,
     * or wins the game if it was the last one.
     * If it is wrong and there is still time left, the player can keep trying.
     * If the time has run out, the game ends.
     *
     * @param timeOut {@code true} if the check was triggered because the time ran out;
     *                {@code false} if the player requested it
     */
    private void validate(boolean timeOut) {
        String userInput = wordInputTextField.getText();
        boolean isCorrect = game.checkAnswer(userInput);

        if (isCorrect ) {
            timer.stop();
            game.upLevel();

            if (game.maxLevelReached()) {
                endGame(true);
            } else {
                resultsLabel.setText("¡Muy bien!");
                startLevel();
            }
        } else if (timeOut) {
            resultsLabel.setText("Tiempo agotado.");
            endGame(false);

        } else {
            resultsLabel.setText("Incorrecto, sigue intentando.");
        }
    }





    /**
     * Returns the player who is currently playing.
     *
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Sets the current player and shows their username on the screen.
     *
     * @param player the player who is about to play
     */
    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
        usernameLabel.setText(currentPlayer.getUsername());
    }

}
