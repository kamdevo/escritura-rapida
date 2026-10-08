package com.example.minigame.models;

public class GameSystem {

    private static int INITIAL_TIME = 20;
    private static int MIN_TIME = 2;
    private static int TIME_DECREASE = 2;
    private static int LEVELS_PER_DECREASE = 5;
    private static int MAX_LEVEL = 50;
    private String currentWord;
    private WordBank wordBank;
    private int completedLevels;



    public GameSystem() {
        wordBank = new WordBank();
        completedLevels = 0;
    }

    public String nextWord() {
        currentWord = wordBank.getRandomWord();
        return currentWord;
    }


    /**
     * Calculates the time available for the current level.
     * Every 5 completed levels the time decreases by 2 seconds,
     * down to a minimum of 2 seconds.
     *
     * @return the time for the current level, in seconds
     */
    public int getTimeForLevel() {
        int decreases = completedLevels / LEVELS_PER_DECREASE;
        int time = INITIAL_TIME - decreases * TIME_DECREASE;
        return Math.max(MIN_TIME, time);
    }




    public void upLevel() {
        completedLevels++;
    }

    public int getLevel() {
        return completedLevels + 1;
    }


    public String getCurrentWord() {
        return currentWord;
    }

    public int getCompletedLevels() {
        return completedLevels;
    }






}
