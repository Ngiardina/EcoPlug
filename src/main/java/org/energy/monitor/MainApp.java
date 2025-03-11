package org.energy.monitor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.energy.monitor.ui.DashboardController;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        DashboardController dashboard = new DashboardController();
        Scene scene = new Scene(dashboard.getView(), 800, 600);

        primaryStage.setTitle("Energy Monitor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
       DataReceiver.startServer();
        launch(args);
    }
}
