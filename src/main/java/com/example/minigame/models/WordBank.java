package com.example.minigame.models;
import java.util.Random;
public class WordBank {

    private final Random random;

    private String lastWord;

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

    public WordBank() {
        random = new Random();
    }



    public String getRandomWord() {
        String word;
        do {
            word = WORDS[random.nextInt(WORDS.length)];
        } while (word.equals(lastWord));

        lastWord = word;
        return word;

    };
}
