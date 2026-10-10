package com.example.minigame.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Countdown timer for the levels of the game.
 * <p>
 * Once started, it counts down one second at a time and notifies its
 * listener every second. When the time reaches zero, it stops by itself
 * and reports the time out.
 *
 * @author Juan Camilo Morales
 * @author Nicolas Palacios
 * @author Juan Camilo Pinzon
 * @version 1.0
 * @see TimerInterface
 * @see TimerAdapter
 */
public class Timer {

    /** JavaFX animation that runs {@code onSecondPassed()} once per second. */
    private Timeline timeline;

    /** Object that is notified about the timer events. */
    private TimerInterface listener;

    /** Seconds left in the current countdown. */
    private int secondsLeft;


    /**
     * Creates a timer that reports its events to the given listener.
     * The countdown does not begin until {@link #start(int)} is called.
     *
     * @param listener the object that will be notified about the timer events
     */
    public Timer(TimerInterface listener){
        this.listener = listener;
        //cada 1 segundo, ejecuta onSecondPassed()
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> onSecondPassed()));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }



    /**
     * Starts a new countdown from the given number of seconds.
     * If a countdown was already running, it starts over.
     *
     * @param seconds the initial time, in seconds
     */
    public void start(int seconds) {
        secondsLeft = seconds;
        listener.onSecond(secondsLeft);
        timeline.playFromStart();
    }

    /**
     * Stops the countdown before it reaches zero and notifies the listener.
     */
    public void stop() {
        timeline.stop();
        listener.onStop();
    }

    /**
     * Returns the number of seconds left in the countdown.
     *
     * @return the remaining seconds
     */
    public int getSecondsLeft() {
        return secondsLeft;
    }


    /**
     * Takes one second off the countdown and notifies the listener.
     * When the time reaches zero, the timer stops and reports the time out.
     */
    private void onSecondPassed() {
        secondsLeft--;
        listener.onSecond(secondsLeft);

        if (secondsLeft <=0) {
            timeline.stop();
            listener.onTimeOut();
        }
    }







}
