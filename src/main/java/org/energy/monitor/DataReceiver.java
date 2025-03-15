package org.energy.monitor;

import org.energy.monitor.models.EnergyData;

import static spark.Spark.*;

public class DataReceiver {



    /**
     * Starts the Spark web server to receive data on the specified port.
     * @param port The port number to run the server on.
     */

    private MainApp main;

    public DataReceiver(MainApp main) {
        this.main = main;
    }




    public  void startServer(int port) {
        port(port); //opens server at http://localhost:8081

        // POST endpoint for receiving data
        post("/data", (req, res) -> { // listens for POST requests, watches for data sent to /data
            String jsonData = req.body();
            System.out.println(Utils.GREEN +"Received Data: " + Utils.RED + jsonData + Utils.RESET);




            // Send received data to EnergyAnalyzer for processing
           main.getEnergyAnalyzer().analyzeData(jsonData);


            res.status(200); // Return HTTP 200 OK status
            return "Data received!";
        });

        System.out.println( Utils.YELLOW + "Server running on http://localhost:" + port + Utils.RESET);
    }
}