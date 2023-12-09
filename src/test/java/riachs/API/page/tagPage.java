package riachs.API.page;

import riachs.baseTest;
import riachs.endPoint;
import io.cucumber.java.en.And;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

import static riachs.baseTest.res;
import static riachs.models.getListUsers;
import static riachs.models.getTagUsers;
import static org.junit.Assert.assertEquals;

public class tagPage {

    String setURL;
    public String goToTheURL(String url) {
        switch (url){
            case "Get Tag":
                setURL = endPoint.dummyapi_tag;
                break;
            default:
                System.out.println("input the right URL");
        }
        return setURL;
    }

    public void apiTagUsers() {res = getTagUsers(setURL);}

    public void statusOfCodeIsEquals(int statusCode) {assertEquals(statusCode, res.getStatusCode());}

    public void responseShouldBeMatchWith(String fileName) {
        File JSONFile = baseTest.getJsonSchemaData(fileName);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }
}
