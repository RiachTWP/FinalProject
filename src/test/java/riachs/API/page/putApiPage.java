package riachs.API.page;

import riachs.endPoint;
import io.restassured.path.json.JsonPath;

import static riachs.baseTest.res;
import static riachs.models.updateUser;
import static riachs.models.postCreateUser;
import static org.assertj.core.api.Assertions.assertThat;
import static riachs.models.*;
import static riachs.baseTest.*;
import static org.assertj.core.api.Assertions.assertThat;

import riachs.baseTest;
import io.restassured.path.json.JsonPath;

public class putApiPage {
    String setURL,  globalUserId = null;
    public String goToURL(String url){
        switch (url){
            case "Create Data":
                setURL = endPoint.dummyapi_create;
                break;
            default:
                System.out.println("input the right URL");
        }
        return setURL;
    }

    public void createNewUser(){
        res = postCreateUser(setURL);
    }

    public void validatinStatusCode(int status_code){assertThat(res.statusCode()).isEqualTo(status_code);}

    public void validationBodyCreateUser(){
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

    public void hitUpdateUser(){
        res = updateUser(endPoint.dummyapi_user,globalUserId);
        System.out.println(res.getBody().asString());
    }
    public void validationUpdateData() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
    }
}
