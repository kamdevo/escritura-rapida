package com.example.minigame;

import com.example.minigame.views.MenuView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class of the JavaFX application.
 * <p>
 * It starts the game by opening the main menu.
 *
 * @author Juan Camilo Morales
 * @author Nicolas Palacios
 * @version 1.0
 * @see MenuView
 */
public class HelloApplication extends Application {

    /**
     * Starts the application and shows the main menu.
     *
     * @param stage the primary stage provided by JavaFX; it is not used,
     *              since each view creates its own window
     * @throws IOException if the menu view cannot be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 320);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();


        MenuView menuView = MenuView.getInstance();
        menuView.show();
    }
}
