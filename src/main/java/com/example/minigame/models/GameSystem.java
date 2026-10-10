package com.example.minigame.models;

/**
 * Holds the rules and the state of a "Fast Writing" game.
 * <p>
 * It keeps track of the word the player has to type and the number of
 * levels completed in a row, and works out how much time each level gets.
 * This class has no dependency on the user interface.
 *
 * @author Juan Camilo Morales
 * @author Nicolas Palacios
 * @author Juan Camilo Pinzon
 * @version 1.0
 */
public class GameSystem {

    /** Time allowed for the first levels, in seconds. */
    private static int INITIAL_TIME = 20;

    /** Shortest time a level can have, in seconds. */
    private static int MIN_TIME = 2;

    /** Seconds taken off the level time each time the difficulty goes up. */
    private static int TIME_DECREASE = 2;

    /** Number of completed levels needed for the difficulty to go up. */
    private static int LEVELS_PER_DECREASE = 5;

    /** Number of completed levels needed to win the game. */
    private static int MAX_LEVEL = 50;

    /** Word the player has to type in the current level. */
    private String currentWord;

    /** Source of the random words. */
    private WordBank wordBank;

    /** Number of levels completed in a row. */
    private int completedLevels;



    /**
     * Creates a new game that starts at level 1.
     */
    public GameSystem() {
        wordBank = new WordBank();
        completedLevels = 0;
    }

    /**
     * Checks whether the answer matches the current word exactly.
     * <p>
     * The comparison is case-sensitive and takes spaces, accents
     * and punctuation into account.
     *
     * @param answer the text typed by the player
     * @return {@code true} if the answer is correct; {@code false} otherwise
     */
    public boolean checkAnswer(String answer) {
        return currentWord != null && currentWord.equals(answer);
    }



    /**
     * Picks a new random word for the current level.
     *
     * @return the word the player has to type
     */
    public String nextWord() {
        currentWord = wordBank.getRandomWord();
        return currentWord;
    }

    /**
     * Tells whether the player has completed the maximum level.
     *
     * @return {@code true} if the player has won the game; {@code false} otherwise
     */
    public boolean maxLevelReached() {
        return completedLevels >= MAX_LEVEL;
    }


    /**
     * Returns the time allowed for the current level.
     * <p>
     * Each level starts with 20 seconds, and the time drops by 2 seconds
     * every 5 completed levels, down to a minimum of 2 seconds.
     *
     * @return the time for the current level, in seconds
     */
    public int getTimeForLevel() {
        int decreases = completedLevels / LEVELS_PER_DECREASE;
        int time = INITIAL_TIME - decreases * TIME_DECREASE;
        return Math.max(MIN_TIME, time);
    }




    /**
     * Moves the player up one level.
     */
    public void upLevel() {
        completedLevels++;
    }

    /**
     * Returns the level the player is currently on.
     *
     * @return the current level, starting at 1
     */
    public int getLevel() {
        return completedLevels + 1;
    }


    /**
     * Returns the word of the current level.
     *
     * @return the current word, or {@code null} if no word has been picked yet
     */
    public String getCurrentWord() {
        return currentWord;
    }

    /**
     * Returns the number of levels completed in a row.
     *
     * @return the completed levels
     */
    public int getCompletedLevels() {
        return completedLevels;
    }






}
