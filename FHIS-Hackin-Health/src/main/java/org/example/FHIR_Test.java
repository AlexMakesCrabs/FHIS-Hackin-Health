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


        //String accessToken = response.body(); /* Store the accessToken to use it future resposes Token is only vaild for 1 hour */
        String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIyMTEiLCJqdGkiOiI3YzlhYWI2NjNhNzQzZDExYWEzZWIzZjJmZjU2MTIwODY3YzBhMGI3N2RiYjU3ZmRhMGVjODU0NDI4MTkyZmYzYjcwMjE5YWU1ZTIwN2I4MCIsImlhdCI6MTY5OTY1MDk5Ni4zODc3NjYsIm5iZiI6MTY5OTY1MDk5Ni4zODc3NywiZXhwIjoxNjk5NjU0NTk2LjM3NzE0Niwic3ViIjoiIiwic2NvcGVzIjp7InN5c3RlbS8qLioiOiJzeXN0ZW0vKi4qIiwidGVuYW50LzE0MjQyNSI6InRlbmFudC8xNDI0MjUifX0.Miz5ahuDOLNKw-6q_HYCgEXUyExsyO1Lsl_pvrR0OP6rfyeZI24hWj2XIHdGo92d0ya0CnC5lGrktpc5pBzmmIvk-Tqrb4MEivlP2loold8sPvMAjdhnEY4GiCyt__t13gwvmA7kYOXYe6Byh0XhWYEmrgWi9UqdIMV6jmmidm5JQey3vtvVVn69cyC6JWJ4w7FxhIgdUUPsKOSkLRvbIxV71-omd2W67I25xB_n6YsIebGRH2m_OHumZtYKejv_x-O11sqoXDnyvtzNyEICRyQGClTntKHqO3MPJyIPCQATxO2bv_sIdHem12Pl1ZcvJerRIbZi9jLAzo29QD0L9XxmjC9ZgKHc-8aVEywetye7yT0MkptsBxVqERIXJIMtNEOijORVNK1b1ZP0MVl-a8nDsk7xUhHcrZCaq2xMo03ObITZpZ97OOCbm1pPAfMH44nG_dbMa6ZfY_bIgtk8dI-vqyxeAHrvl_N8LNYPuaejt-oEp1_ypEuW15w4rhbRJujDL8-NGLyvT194agNwNMhTKlyVVg7xNLv-92QhDAbMOMq5yHCrj2Tf09Y53l1OlYmJUHW5Zm3ixV6xnCZP5f7YQjo4_FAdX5_X9E_rTcd_CZhesZR2BEnDabjYtnlKfUPvYdAQftaR4vwSBLTGM3PwX9brg7sDQMTwAfMXjio";// Create client to send GET request


        HttpClient clientA = HttpClient.newHttpClient();


        // Build GET request with access token
        HttpRequest requestA = HttpRequest.newBuilder().header("Authorization", "Bearer " + accessToken)
                .uri(URI.create("https://app.azaleahealth.com/fhir/R4/142425/Patient")).GET().build();


        // Send request
        HttpResponse<String> responseA = clientA.send(requestA, HttpResponse.BodyHandlers.ofString());


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