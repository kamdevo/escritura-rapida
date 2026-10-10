package com.example.minigame.models;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Implementation of {@link AlertBoxInterface} based on JavaFX alerts.
 *
 * @author Juan Camilo Morales
 * @author Nicolas Palacios
 * @version 1.0
 */
public class AlertBox implements AlertBoxInterface {


    /**
     * {@inheritDoc}
     */
    @Override
    public void showAlertBox(String title, String header, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
