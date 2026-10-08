package com.example.minigame.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Timer {

    private Timeline timeline;

    private TimerInterface listener;

    private int secondsLeft;


    /**
     * Creates a timer that notifies the given listener.
     *
     * @param listener the object that receives the timer events
     */
    public Timer(TimerInterface listener){
        this.listener = listener;
        //cada 1 segundo, ejecuta onSecondPassed()
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> onSecondPassed()));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }



    //metodos
    public void start(int seconds) {
        secondsLeft = seconds;
        listener.onSecond(secondsLeft);
        timeline.playFromStart();
    }

    public void stop() {
        timeline.stop();
        listener.onStop();
    }

    //getter
    public int getSecondsLeft() {
        return secondsLeft;
    }


    //cada que pasa un segundo va restand osegundos restantes , asignando el valor al textfield y validando si se acabo el tiempo
    private void onSecondPassed() {
        secondsLeft--;
        listener.onSecond(secondsLeft);

        if (secondsLeft <=0) {
            timeline.stop();
            listener.onTimeOut();
        }
    }







}
