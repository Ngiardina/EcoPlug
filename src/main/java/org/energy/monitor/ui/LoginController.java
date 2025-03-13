package org.energy.monitor.ui;

import com.gluonhq.charm.glisten.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.energy.monitor.SceneSwitcher;
import org.energy.monitor.Utils;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private Button loginButton;
    @FXML private Button closeButton;


    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("password")) {
            System.out.println("Login successful!");
            SceneSwitcher.switchTo("Dashboard.fxml", "dashboard.css"); // Navigate to dashboard
        } else {
            System.out.println("Invalid credentials.");
        }
    }
    @FXML
    private void handleClose() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close(); // Close the window
    }
    private void handleUsername() {

    }
    private void handlePassword() {

    }
    private void initialize() {
        usernameField.setOnMouseClicked(event -> usernameField.setStyle("-fx-border-color: #00ff00;"));
        passwordField.setOnMouseClicked(event -> passwordField.setStyle("-fx-border-color: #00ff00;"));
    }

}
