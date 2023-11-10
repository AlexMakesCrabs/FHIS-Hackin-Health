package org.example;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
public class FHIR_Test {
    public static void main(String[] args) throws Exception {
        // Client credentials
        String clientId = "CLIENT_ID";
        String clientSecret = "CLIENT_SECRET";
        // Scope
        String scope = "system/*.*";
        // Create form params
        String formParams =
                "grant_type=client_credentials&client_id=" + clientId
                        + "&client_secret=" + clientSecret
                        + "&scope=" + scope;
        HttpClient client = HttpClient.newHttpClient();

        // Use form params as request body
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://app.azaleahealth.com/fhir/R4/142421/oauth/token")).POST(HttpRequest.BodyPublishers.ofString(formParams)).header("Content-Type", "application/x-www-form-urlencoded").build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String accessToken = response.body(); /* Store the accessToken to use it future resposes Token is only vaild for 1 hour */
        //String accessToken = "AccessToken";// Create client to send GET request


        HttpClient clientA = HttpClient.newHttpClient();


        // Build GET request with access token
        HttpRequest requestA = HttpRequest.newBuilder().header("Authorization", "Bearer " + accessToken).uri(URI.create("https://app.azaleahealth.com/fhir/R4/142421/Patient/389 258")).GET().build();


        // Send request
        HttpResponse<String> responseA = clientA.send(requestA,
                HttpResponse.BodyHandlers.ofString());


        // Handle response
        if (responseA.statusCode() == 200) {
            String patient = responseA.body();


            // Parse FHIR JSON patient resource
            System.out.println(patient);
        } else {
            System.out.println("Error: " + responseA.statusCode());
        }
    }
}