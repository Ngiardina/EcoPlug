package org.energy.monitor.scenes;

import javafx.fxml.FXML;
import org.energy.monitor.MainApp;

public class DeviceControlScene extends SceneE {

    private String[] files = {"DeviceControl.fxml", "deviceControl.css"};

    private String fxmlFile = "DeviceControl.fxml";
    private String cssFile = "deviceControl.css";







    public String[] getFiles() {
        return files;
    }

    public String getFxmlFile() {
        return fxmlFile;
    }

    public String getCssFile() {
        return cssFile;
    }

    @FXML
    private void initialize() {

    }
}

