package org.energy.monitor;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.energy.monitor.scenes.SceneE;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class SceneSwitcher {


    /**
     * / TRANSIITION TO SceneE object rather than string!!!!
     * And REDUCE Static methods !!!
     */

    private static final HashMap<String, Scene> scenes = new HashMap<>(); // Store all scenes
    private static final HashMap<String, Object> controllers = new HashMap<>(); // Store controllers

    public SceneSwitcher() {
    preloadScenes();
    }

    private static Stage primaryStage;


    private static double lastWidth = 800;  // Default initial width
    private static double lastHeight = 600; // Default initial height
    private static boolean wasMaximized = false;


    private void preloadScenes() {
        try {
            loadScene("Dashboard", "/Dashboard.fxml");
            loadScene("Login", "/Login.fxml");
            loadScene("DeviceController", "/DeviceControl.fxml");
            loadScene("Monitor", "/Monitor.fxml");
            loadScene("Sidebar", "/Sidebar.fxml");

            // Add more scenes as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadScene(String name, String fxmlPath) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        scenes.put(name, new Scene(root)); // Store scene
        controllers.put(name, loader.getController()); // Store controller
    }

    // Set the primary stage when the app starts
    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
        wasMaximized = stage.isMaximized();
        lastWidth = stage.getWidth();
        lastHeight = stage.getHeight();

        // Add a listener to save size changes only if NOT maximized
        primaryStage.maximizedProperty().addListener((obs, oldVal, newVal) -> wasMaximized = newVal);
        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            if (!wasMaximized) lastWidth = newVal.doubleValue();
        });
        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            if (!wasMaximized) lastHeight = newVal.doubleValue();
        });
    }




    public static Object getController(String sceneName) {
        return controllers.get(sceneName);
    }




    public static void switchTo(String sceneName) {
        Scene scene = scenes.get(sceneName);

        if (scene != null) {
            primaryStage.setScene(scene);
            // Force position refresh
            if (wasMaximized) {
                primaryStage.setMaximized(true);
            } else {
                primaryStage.setWidth(lastWidth);
                primaryStage.setHeight(lastHeight);
                primaryStage.setX(primaryStage.getX());
                primaryStage.setY(primaryStage.getY());
            }


            primaryStage.show();

        } else {
            System.err.println("Scene not found: " + sceneName);
        }
    }





    private static void determineSceneProperties(SceneE sceneE, Scene scene, Parent root) {

        if (sceneE.equals(MainApp.getInstance().getDashboardScene())) { //DASHBOARD
            transitionDashboard(sceneE, scene, root);

        } else if (sceneE.equals(MainApp.getInstance().getDeviceControlScene())) { //DEVICE CONTROL
            transitionDeviceControl(sceneE, scene, root);
        } else if (sceneE.equals(MainApp.getInstance().getLoginScene())) { // LOGIN
            transitionLogin(sceneE, scene, root);

        } else if (sceneE.equals(MainApp.getInstance().getMonitorScene())) { // MONITOR
            transitionMonitor(sceneE, scene, root);

        }
    }





    private static void applyStageSize(Scene scene) {
        lastWidth = primaryStage.getWidth();
        lastHeight = primaryStage.getHeight();

        scene.widthProperty().addListener((obs, oldVal, newVal) -> lastWidth = newVal.doubleValue());
        scene.heightProperty().addListener((obs, oldVal, newVal) -> lastHeight = newVal.doubleValue());
    }







    /**
     * If needed override for future, make visibility public:
     */

    private static void transitionDashboard(SceneE sceneE, Scene scene, Parent root) {

        primaryStage.setScene(scene);


    }

    private static void transitionDeviceControl(SceneE sceneE, Scene scene, Parent root) {
        primaryStage.setScene(scene);
    }

    private static void transitionLogin(SceneE sceneE, Scene scene, Parent root) {


        primaryStage.setScene(scene);
    }

    private static void transitionMonitor(SceneE sceneE, Scene scene, Parent root) {
        primaryStage.setScene(scene);
    }


}
