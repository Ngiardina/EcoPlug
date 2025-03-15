package org.energy.monitor.scenes;

import javafx.fxml.FXML;
import org.energy.monitor.MainApp;

public class MonitorScene extends SceneE{
    private String[] files = {"Monitor.fxml", "monitor.css"};

    private String fxmlFile = "Monitor.fxml";
    private String cssFile = "monitor.css";





    @FXML
    private void initialize() {

    }
    public String[] getFiles() {
        return files;
    }

    public String getFxmlFile() {
        return fxmlFile;
    }

    public String getCssFile() {
        return cssFile;
    }

}
