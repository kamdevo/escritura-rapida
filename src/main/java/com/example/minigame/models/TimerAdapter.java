package com.example.minigame.models;

/**
 * Adapter for {@link TimerInterface} with empty implementations of all its methods.
 * <p>
 * Subclasses only need to override the events they actually care about.
 *
 * @author Juan Camilo Morales
 * @author Nicolas Palacios
 * @version 1.0
 */
public  abstract  class TimerAdapter implements TimerInterface  {

    /**
     * {@inheritDoc}
     * <p>
     * This implementation does nothing.
     */
    @Override
    public void onSecond(int secondsLeft) {

    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation does nothing.
     */
    @Override
    public void onTimeOut() {

    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation does nothing.
     */
    @Override
    public void onStop() {

    }

}
