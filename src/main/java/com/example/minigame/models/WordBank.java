package com.example.minigame.models;
import java.util.Random;

/**
 * Stores the words used in the game and hands them out at random.
 * <p>
 * It never returns the same word twice in a row.
 *
 * @author Juan Camilo Morales
 * @author Nicolas Palacios
 * @author Juan Camilo Pinzon
 * @version 1.0
 */
public class WordBank {

    /** Random number generator used to pick the words. */
    private final Random random;

    /** Last word returned, kept to avoid repeating it. */
    private String lastWord;

    /** Words the player may have to type. */
    private static final String[] WORDS = {
            "casa",
            "house",
            "gato",
            "cat",
            "perro",
            "dog",
            "agua",
            "water",
            "libro",
            "book",
            "mesa",
            "table",
            "escuela",
            "school",
            "amigo",
            "friend",
            "computadora",
            "computer",
            "teclado",
            "keyboard",
            "ventana",
            "window",
            "juego",
            "game",
            "musica",
            "music",
            "planeta",
            "planet",
            "bicicleta",
            "bicycle",
            "mariposa",
            "butterfly"
    };

    /**
     * Creates a new word bank.
     */
    public WordBank() {
        random = new Random();
    }



    /**
     * Returns a random word, different from the previous one.
     *
     * @return a random word
     */
    public String getRandomWord() {
        String word;
        do {
            word = WORDS[random.nextInt(WORDS.length)];
        } while (word.equals(lastWord));

        lastWord = word;
        return word;

    };
}
