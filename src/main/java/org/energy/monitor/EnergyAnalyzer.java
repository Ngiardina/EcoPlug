package org.energy.monitor;

import javafx.application.Platform;

import org.json.JSONObject;

public class EnergyAnalyzer {

    /**
     * Analyzes incoming JSON-formatted energy data.
     * @param jsonData The JSON string representing energy data.
     */
    private MainApp main;


    public EnergyAnalyzer(MainApp main) {
        this.main = main;
    }


    public void analyzeData(String jsonData) {

        try {
            JSONObject jsonObject = new JSONObject(jsonData);


            /**
             * `    Manual Parsing,POST must match these names
             *      missing key in POST will default to 0V or 0A respectively
             *
             */


            double voltage = jsonObject.optDouble("voltage", 0.0);
            double current = jsonObject.optDouble("current", 0.0);

            double powerUsage = voltage * current;
//            if (listener != null) {
//                listener.onVoltageUpdate(voltage);
//                listener.onCurrentUpdate(current);
//                listener.onPowerUpdate(powerUsage);
//            }
            Platform.runLater(() -> {
                MainApp.getInstance().getDashboardScene().updateVoltage(voltage);
                MainApp.getInstance().getDashboardScene().updateCurrent(current);
                MainApp.getInstance().getDashboardScene().updatePower(powerUsage);
            });








            if (powerUsage > 500) {
                System.out.println("⚠️" + Utils.RED + "High power consumption detected: " + powerUsage + Utils.GREEN +" W" + Utils.RESET);
            } else {
                System.out.println("✅" +Utils.RED +  "Power consumption is normal: " + powerUsage + Utils.RED + " W" +Utils.RESET);
            }

        } catch (Exception e) {
            System.out.println("❌" + Utils.RED + "Error parsing JSON data: " + e.getMessage() +Utils.RESET);
        }
    }
}