package org.example;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class FHIR_Test {
    public static void main(String[] args) throws Exception {
        // Client credentials
        String clientId = "211";
        String clientSecret = "42b68518672885739268f63d24b5b659";

        // Scope
        String scope = "system/*.*";

        // Create form params
        String formParams =
                "grant_type=client_credentials&client_id=" + clientId
                        + "&client_secret=" + clientSecret
                        + "&scope=" + scope;
        HttpClient client = HttpClient.newHttpClient();

        // Use form params as request body
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://app.azaleahealth.com/fhir/R4/142425/oauth/token")).POST(HttpRequest.BodyPublishers.ofString(formParams)).header("Content-Type", "application/x-www-form-urlencoded").build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        String accessToken = response.body(); /* Store the accessToken to use it future resposes Token is only vaild for 1 hour */
        int length = accessToken.indexOf("access_token") + 15;
        accessToken = accessToken.substring(length, accessToken.length() - 2);


        HttpClient clientA = HttpClient.newHttpClient();


        // Build GET request with access token
        HttpRequest requestA = HttpRequest.newBuilder().header("Authorization", "Bearer " + accessToken)
                .uri(URI.create("https://app.azaleahealth.com/fhir/R4/142425/Patient")).GET().build();


        // Send request
        HttpResponse<String> responseA = clientA.send(requestA, HttpResponse.BodyHandlers.ofString());


        // Handle response
        if (responseA.statusCode() == 200) {
            String patient = responseA.body();

            try{
                BufferedWriter output = new BufferedWriter(new FileWriter("output.json"));
                output.write(patient);
                output.close();
            }catch(IOException e){
                System.out.println(e);
            }

            // Parse FHIR JSON patient resource
            System.out.println(patient);
        } else {
            System.out.println("Error: " + responseA.statusCode());
        }
    }
}