package com.example.minigame.models;

/**
 * Represents the player of the game.
 *
 * @author Juan Camilo Morales
 * @author Nicolas Palacios
 * @version 1.0
 */
public class Player {

    /** Name the player entered in the main menu. */
    private String username;

    /**
     * Returns the player's username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the player's username.
     *
     * @param username the name entered by the player
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
