package com.example.minigame;

import javafx.application.Application;

/**
 * Entry point of the application.
 * <p>
 * It simply delegates the startup to {@link HelloApplication}.
 *
 * @author Juan Camilo Morales
 * @author Nicolas Palacios
 * @author Juan Camilo Pinzon
 * @version 1.0
 */
public class Launcher {

    /**
     * Launches the JavaFX application.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        Application.launch(HelloApplication.class, args);
    }
}
