package com.example.minigame.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuView extends Stage {

    public MenuView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/com/example/minigame/menu-view.fxml")
        );
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        setTitle("Minijuego Escritura rapida  - Bienvenido");
        setScene(scene);
        setResizable(false);
    }

    public static MenuView getInstance() throws IOException {
        if (MenuViewHolder.INSTANCE == null) {
            MenuViewHolder.INSTANCE = new MenuView();
        }
        return MenuViewHolder.INSTANCE;
    }

    private static class MenuViewHolder {
        private static MenuView INSTANCE = null;
    }
}
