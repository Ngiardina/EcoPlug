package org.energy.monitor;
import org.junit.jupiter.api.Test;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Deprecated
public class DataReceiverTest {

    @Test
    void testDataReceiver() throws Exception {
        // Sample JSON data that mimics what your devices would send
        String jsonData = "{" +
                "\"current\": 2.5, "
                +
                "\"voltage\": 230"
                +
                "}";

        // Step 1: Create a URL object for the endpoint
        URL url = new URL("http://localhost:8081/data");

        // Step 2: Open an HTTP connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Step 3: Set the HTTP method to POST
        connection.setRequestMethod("POST");

        // Step 4: Indicate that we're sending JSON data
        connection.setRequestProperty("Content-Type", "application/json");

        // Step 5: Enable sending data through the connection
        connection.setDoOutput(true);

        // Step 6: Write the sample data to the request body
        try (OutputStream os = connection.getOutputStream()) {
            os.write(jsonData.getBytes());
        }

        // Step 7: Get the response code
        int responseCode = connection.getResponseCode();

        // Step 8: Assert that the response is 200 OK

        assertEquals(200, responseCode, "DataReceiver should respond with HTTP 200 OK");
    }
}