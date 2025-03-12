package org.energy.monitor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.StdErrLog;
import org.energy.monitor.ui.DashboardController;

import javax.xml.crypto.Data;

public class MainApp extends Application {
    private DashboardController dashboardController;
    private EnergyAnalyzer energyAnalyzer;
    private DataReceiver dataReceiver;

    /**
     * Initializes the JavaFX application window and starts the data receiver.
     * @param primaryStage The primary window (Stage) for the app.
     */


    @Override
    public void start(Stage primaryStage) {
        this.dashboardController = new DashboardController(this);
        this.energyAnalyzer = new EnergyAnalyzer(this);
        this.dataReceiver = new DataReceiver(this);

        new Thread(() -> dataReceiver.startServer(8081)).start();
        Scene scene = new Scene(dashboardController.getView(), 800, 600);

        primaryStage.setTitle("Energy Monitor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }


    public EnergyAnalyzer getEnergyAnalyzer() {
        return energyAnalyzer;
    }

    public DashboardController getDashboardController() {
        return dashboardController;
    }
}
