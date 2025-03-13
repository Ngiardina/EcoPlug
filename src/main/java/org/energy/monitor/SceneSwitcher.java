package org.energy.monitor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class SceneSwitcher {
    private static Stage primaryStage;

    // Set the primary stage when the app starts
    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    // Method to switch scenes
    public static void switchTo(String fxmlFile, String cssFile) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneSwitcher.class.getResource("/" + fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            scene.getStylesheets().add(Objects.requireNonNull(SceneSwitcher.class.getResource("/" + cssFile)).toExternalForm());
            if (Objects.equals(fxmlFile, "Login.fxml") && Objects.equals(cssFile, "login.css")) {
                AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
                AtomicReference<Double> yOffset = new AtomicReference<>((double) 0);
                scene.setFill(Color.TRANSPARENT);
                primaryStage.initStyle(StageStyle.TRANSPARENT);
                root.setOnMousePressed(event -> {

                    xOffset.set(event.getSceneX());
                    yOffset.set(event.getSceneY());
                });

                root.setOnMouseDragged(event -> {
                    primaryStage.setX(event.getScreenX() - xOffset.get());
                    primaryStage.setY(event.getScreenY() - yOffset.get());
                });
            }

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading scene: " + fxmlFile);
        }
    }
}
