package org.energy.monitor;

import com.google.gson.Gson;
import org.energy.monitor.models.EnergyData;

public class EnergyAnalyzer {

    public static void analyzeData(String jsonData) {
        Gson gson = new Gson();
        EnergyData data = gson.fromJson(jsonData, EnergyData.class);

        double powerUsage = data.getCurrent() * data.getVoltage();

        if (powerUsage > 500) {
            System.out.println("⚠️ High power consumption detected: " + powerUsage + "W");
        } else {
            System.out.println("✅ Power consumption is normal: " + powerUsage + "W");
        }
    }
}
