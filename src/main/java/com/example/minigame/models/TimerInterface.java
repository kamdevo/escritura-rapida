package com.example.minigame.models;

public interface TimerInterface {

    /**
     * Called every second while the timer is running.
     *
     * @param secondsLeft the remaining seconds
     */
    void onSecond(int secondsLeft);

    /**
     * Called when the remaining time reaches zero.
     */
    void onTimeOut();

    /**
     * Called when the timer is stopped before reaching zero.
     */
    void onStop();
}
