package org.energy.monitor.scenes;

import com.gluonhq.charm.glisten.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.energy.monitor.SceneSwitcher;

public class LoginScene extends SceneE {
    private String[] loginScene = {"Login.fxml", "login.css"};

    private String fxmlFile = "Login.fxml";
    private String cssFile = "login.css";
    private Scene scene;


    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button closeButton;



    @FXML
    private void handleLogin() {
        System.out.println("login button!");
        SceneSwitcher.switchTo("Dashboard");


    }

    @FXML
    @Override
    public void handleClose() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close(); // Close the window
    }

    @FXML
    private void handleUsername() {
        System.out.println("username button!");
    }

    @FXML
    private void handlePassword() {
        System.out.println("pw button!");
    }

    @FXML
    private void initialize() {

    }


    public String getCssFile() {
        return cssFile;
    }

    public String getFxmlFile() {
        return fxmlFile;
    }


}
