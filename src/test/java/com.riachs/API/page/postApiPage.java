package com.riachs.API.page;
import com.riachs.endPoint;
import static com.riachs.models.*;

import static com.riachs.baseTest.*;
import com.riachs.baseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import org.assertj.core.api.Assertions;


import java.io.File;
import java.util.Map;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

public class postApiPage {

    String SetURL, globalUserId = null;
    public String goToURL (String url){
        switch (url){
            case "Create Data":
                SetURL = endPoint.dummyapi_create;
                break;
            default:
                System.out.println("input right URL");
        }
        return SetURL;
    }

    public void hitCreateNewUser(){
        res = postCreateUser(SetURL);
        System.out.println(res.getBody().asString());
    }

    public void validatiStatusCode(int status_code){
        assertEquals(status_code, res.getStatusCode());
    }

    public void validBodyCreateUser(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();

        globalUserId = id;

    }

    public void validationJsonSchemaPost(String fileName){
        File JSONFile = baseTest.getJsonSchemaData(fileName);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }


}
