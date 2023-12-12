package com.riachs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import static com.riachs.baseTest.generateEmail;


public class models {

    public static RequestSpecification req;

    public static void setUpHeaders(){
        req = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "655648b2a11259de7f99fbfe");
    }
    public static Response getListUsers(String endpoint){
        setUpHeaders();
        return req.when().get(endpoint);
    }

    public static Response getTagUsers(String endpoint){
        setUpHeaders();
        return req.when().get(endpoint);
    }

    public static Response postCreateUser(String endPoint){
        String firstName = "jones";
        String lastName = "kerl";
        String email = generateEmail();

        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);

        setUpHeaders();
        return req.body(payload.toString()).when().post(endPoint);
    }

    public static Response deleteUser(String endPoint, String userId){
        setUpHeaders();
        String finalEndPoint = endPoint + userId;
        return req.when().delete(finalEndPoint);
    }

    public static Response updateUser(String endPoint, String userId){
        setUpHeaders();

        String firstName = "jones rim";
        String lastName = "kerl";

        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);

        String finalEndPoint = endPoint + userId;
        return req.body(payload.toString()).when().put(finalEndPoint);
    }




}
