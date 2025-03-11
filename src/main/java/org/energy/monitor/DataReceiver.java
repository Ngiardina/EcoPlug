package org.energy.monitor;

import static spark.Spark.*;

public class DataReceiver {
    public static void startServer() {
        port(8081);

        post("/data", (req, res) -> {
            String jsonData = req.body();
            System.out.println("Received Data: " + jsonData);

            // Send data for analysis
            EnergyAnalyzer.analyzeData(jsonData);

            res.status(200);
            return "Data received!";
        });

        System.out.println("Server running on http://localhost:8080");
    }
}
