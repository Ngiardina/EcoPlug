package org.energy.monitor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.energy.monitor.scenes.DashboardScene;


import java.io.IOException;

public class Utils {
    // ANSI escape codes for color formatting


    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public  static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m"; // Resets to default color



//    //Scenes
//
//    public static FXMLLoader loader = new FXMLLoader(Utils.class.getResource("/Dashboard.fxml"));
//    public static Parent root; // This actually loads the FXML
//
//    static {
//        try {
//            root = loader.load();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//   public static DashboardScene dashboardScene = loader.getController(); // Gets the injected controller
//
//
//
//
//
//
//
//
//    public Utils() throws IOException {
//    }
}
