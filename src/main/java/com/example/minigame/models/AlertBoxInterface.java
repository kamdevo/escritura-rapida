package com.example.minigame.models;

/**
 * Defines the dialog boxes used to show messages to the player.
 *
 * @author Juan Camilo Morales
 * @author Nicolas Palacios
 * @version 1.0
 */
public interface AlertBoxInterface {


    /**
     * Shows an information dialog and waits until the player closes it.
     *
     * @param title   the title of the window
     * @param header  the header text
     * @param message the message to show
     */
    public void showAlertBox(String title, String header, String message);

}
