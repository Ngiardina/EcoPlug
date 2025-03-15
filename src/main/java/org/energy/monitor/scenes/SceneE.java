package org.energy.monitor.scenes;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.eclipse.jetty.util.log.Log;
import org.energy.monitor.MainApp;

import java.util.ArrayList;

public class SceneE {

    private String fxmlFile;
    private String cssFile;
    private ArrayList<SceneE> sceneEs;


    public SceneE() {

    }



    private void initialize() {

    }
    public void handleClose() {
//        Stage stage = (Stage) closeButton.getScene().getWindow();
//        stage.close(); // Close the window
    }

    // Method to apply hover effect
    protected void applyHoverEffect(Button button) {
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, this::handleMouseEnter);
        button.addEventHandler(MouseEvent.MOUSE_EXITED, this::handleMouseExit);
    }

    // Mouse enter method (hover)
    private void handleMouseEnter(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setStyle("-fx-background-color: #0078D7;");
    }

    // Mouse exit method (leave)
    private void handleMouseExit(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setStyle("-fx-background-color: #333;");
    }


    public String getFxmlFile() {
        return fxmlFile;
    }

    public void setFxmlFile(String fxmlFile) {
        this.fxmlFile = fxmlFile;
    }

    public String getCssFile() {
        return cssFile;
    }

    public void setCssFile(String cssFile) {
        this.cssFile = cssFile;
    }



    public ArrayList<SceneE> getSceneEs() {
        this.sceneEs.add(MainApp.getInstance().getDashboardScene());
        this.sceneEs.add(MainApp.getInstance().getDeviceControlScene());
        this.sceneEs.add(MainApp.getInstance().getLoginScene());
        this.sceneEs.add(MainApp.getInstance().getMonitorScene());
        return this.sceneEs;
    }



}
