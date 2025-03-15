package org.energy.monitor;

import javafx.application.Application;

import javafx.stage.Stage;
import org.energy.monitor.scenes.*;


import java.io.IOException;

public class MainApp extends Application {

    /** Don't Intensively use Singleton Instance !
                                                     */
    private static MainApp instance;
    public MainApp() {
        instance = this; // Assign the instance when JavaFX creates it
    }

    public static MainApp getInstance() {
        return instance; // Return the singleton instance
    }





    private EnergyAnalyzer energyAnalyzer;
    private DataReceiver dataReceiver;
    private SceneE sceneE;
    private boolean isLoggedIn = false;
    private SceneSwitcher sceneSwitcher;


    private DeviceControlScene deviceControlScene;
    private LoginScene loginScene;
    private MonitorScene monitorScene;
    private Sidebar sidebar;
    private DashboardScene dashboardScene;


    private static Stage primaryStage;





    /**
     * Initializes the JavaFX application window and starts the data receiver.
     * @param primaryStage The primary window (Stage) for the app.
     */


    @Override
    public void start(Stage primaryStage) throws Exception {

        this.sceneE = new SceneE();
        this.dashboardScene= new DashboardScene();
        this.deviceControlScene = new DeviceControlScene();
        this.loginScene = new LoginScene();
        this.monitorScene = new MonitorScene();
        this.sidebar = new Sidebar();
        this.sceneSwitcher = new SceneSwitcher();



        this.energyAnalyzer = new EnergyAnalyzer(this);


        this.dataReceiver = new DataReceiver(this);

        new Thread(() -> dataReceiver.startServer(8081)).start();



        if (!isLoggedIn) {
            SceneSwitcher.setPrimaryStage(primaryStage);
            SceneSwitcher.switchTo("Login"); // Start with the login screen

        } else {
            SceneSwitcher.setPrimaryStage(primaryStage);
            SceneSwitcher.switchTo("Dashboard"); // Start with the dashboard scene
        }


    }



    public static void main(String[] args) {
        launch(args);
    }


    public EnergyAnalyzer getEnergyAnalyzer() {
        return energyAnalyzer;
    }



    public SceneE getSceneE() {
        return sceneE;
    }

    public LoginScene getLoginScene() {
        return loginScene;
    }

    public DeviceControlScene getDeviceControlScene() {
        return deviceControlScene;
    }

    public MonitorScene getMonitorScene() {
        return monitorScene;
    }

    public Sidebar getSidebar() {
        return sidebar;
    }

    public DashboardScene getDashboardScene() {
        return dashboardScene;
    }

    public void setDashboardScene(DashboardScene dashboardScene) {
        this.dashboardScene = dashboardScene;
    }
}
