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
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.json.simple.JSONValue;

public class FHIR_Test {
    public static void main(String[] args) throws Exception {
        // Client credentials
        String clientId = "211";
        String clientSecret = "42b68518672885739268f63d24b5b659";
        String scope = "system/*.*";
        String formParams = "grant_type=client_credentials&client_id=" + clientId + "&client_secret=" + clientSecret + "&scope=" + scope;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://app.azaleahealth.com/fhir/R4/142425/oauth/token")).POST(HttpRequest.BodyPublishers.ofString(formParams)).header("Content-Type", "application/x-www-form-urlencoded").build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String accessToken = response.body();
        int length = accessToken.indexOf("access_token") + 15;
        accessToken = accessToken.substring(length, accessToken.length() - 2);
        HttpClient clientA = HttpClient.newHttpClient();

        String patientID = "389552";

        String uri = "https://app.azaleahealth.com/fhir/R4/142425/";

        //Request for patient information
        String query = "Patient/"+patientID;

        HttpRequest requestA = HttpRequest.newBuilder().header("Authorization", "Bearer " + accessToken).uri(URI.create(uri + query)).GET().build();
        HttpResponse<String> responseA = clientA.send(requestA, HttpResponse.BodyHandlers.ofString());

        // Handle response
        if (responseA.statusCode() == 200) {
            getPatientInfo(responseA);
        } else System.out.println("Error: " + responseA.statusCode());


//        //request for patient medication info
//        query = "MedicationRequest?subject=" + patientID;
//
//        requestA = HttpRequest.newBuilder().header("Authorization", "Bearer " + accessToken).uri(URI.create(uri + query)).GET().build();
//        responseA = clientA.send(requestA, HttpResponse.BodyHandlers.ofString());
//
//        if (responseA.statusCode() == 200) {
//            getPatientMedInfo(responseA);
//        } else System.out.println("Error: " + responseA.statusCode());
    }

    private static void getPatientMedInfo(HttpResponse<String> responseA) {
        String patient = responseA.body();
        Object s = JSONValue.parse(responseA.body());
        JSONObject jobj = (JSONObject) s;

        JSONArray jarr = (JSONArray) jobj.get("entry");
        Iterator iter = jarr.iterator();
        while(iter.hasNext()){

        }



        //Write response to file
        try{
            BufferedWriter output = new BufferedWriter(new FileWriter("output.json"));
            output.write(patient);
            output.close();
        }catch(IOException e) { System.out.println(e); }
    }

    private static void getPatientInfo(HttpResponse<String> responseA) {
        String patient = responseA.body();
        Object s = JSONValue.parse(responseA.body());
        JSONObject jobj = (JSONObject) s;

        String patientName = getNameFromJSON(jobj);
        String patientBirth = getBirthdateFromJSON(jobj);
        String practitionerName = getPracticionerNameFromJSON(jobj);
        String practitionerRef = getPracticionerRefFromJSON(jobj);
        String organization = getOrganizationFromJSON(jobj);

        System.out.println("PatientName: " + patientName);
        System.out.println("PatientBirthdate: " + patientBirth);
        System.out.println("PractitionerName: " + practitionerName);
        System.out.println("PractitionerRef: " + practitionerRef);
        System.out.println("Organization: " + organization);


        //Write response to file
        try{
            BufferedWriter output = new BufferedWriter(new FileWriter("output.json"));
            output.write(patient);
            output.close();
        }catch(IOException e) { System.out.println(e); }
    }

    public static String getNameFromJSON(JSONObject jobj){
        JSONArray jarr = (JSONArray) jobj.get("name");
        jobj = (JSONObject) jarr.get(0);
        return (String) jobj.get("text");
    }

    public static String getBirthdateFromJSON(JSONObject jobj){
        return (String) jobj.get("birthDate");
    }

    public static String getPracticionerNameFromJSON(JSONObject jobj){
        JSONArray jarr = (JSONArray) jobj.get("generalPractitioner");
        jobj = (JSONObject) jarr.get(0);
        return (String) jobj.get("display");
    }

    public static String getPracticionerRefFromJSON(JSONObject jobj){
        JSONArray jarr = (JSONArray) jobj.get("generalPractitioner");
        jobj = (JSONObject) jarr.get(0);
        return (String) jobj.get("reference");
    }

    public static String getOrganizationFromJSON(JSONObject jobj){
        jobj = (JSONObject) jobj.get("managingOrganization");
        return (String) jobj.get("display");

    }
}