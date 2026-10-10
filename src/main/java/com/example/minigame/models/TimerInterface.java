package com.example.minigame.models;

/**
 * Defines the events reported by the {@link Timer}.
 * <p>
 * Classes that only care about some of these events can extend
 * {@link TimerAdapter} instead of implementing this interface directly.
 *
 * @author Juan Camilo Morales
 * @author Nicolas Palacios
 * @version 1.0
 */
public interface TimerInterface {

    /**
     * Called when the countdown starts and then once every second.
     *
     * @param secondsLeft the seconds left in the countdown
     */
    void onSecond(int secondsLeft);

    /**
     * Called when the countdown reaches zero.
     */
    void onTimeOut();

    /**
     * Called when the countdown is stopped before reaching zero.
     */
    void onStop();
}
