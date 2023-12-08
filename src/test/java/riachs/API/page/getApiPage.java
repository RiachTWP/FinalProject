package riachs.API.page;
import com.riachs.endPoint;
import static com.riachs.models.*;
import static com.riachs.baseTest.*;
import com.riachs.baseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.io.File;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;


public class getApiPage{
    String setURL ;
    private String userId1;
    private String userId2;
    private String userId3;
    private String userId4;

    public String setUpURL (String url){
        switch (url){
            case "Dummy API List":
                setURL = endPoint.dummyapi_list;
                break;
            default:
                System.out.println("input the right URL");
        }
        return setURL;
    }

    public void hitGetListUsers(){
        res = getListUsers(setURL);
    }

    public void validationStatusCode(int status_code){
        assertEquals(status_code, res.getStatusCode());
    }


    public String goToURLWithId(String url, String userId) {
        switch (url){
            case "Dummy API List by Id" :
                setURL = endPoint.dummyapi_user + userId;
                break;
            default:
                System.out.println("input the right URL");
        }
        return setURL;
    }

    public void bodyContainImportantDetail() {
        res.then().body("id", notNullValue());
        res.then().body("firstName", notNullValue());
        res.then().body("lastName", notNullValue());
        res.then().body("email", notNullValue());
    }

    public void bodyContain(Map<String, String> expectedValues) {
        for (Map.Entry<String, String> entry : expectedValues.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();

            String actualValue = res.path(key).toString();
            assertThat(actualValue, equalTo(value));
        }
    }

    public void validationJsonSchemaFile(String FileName){
        File JSONFile = baseTest.getJsonSchemaData(FileName);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void theLimitAndThePageShouldBeDefaultValues() {
        res.then().assertThat().body("limit", Matchers.equalTo(20));
        res.then().assertThat().body("page", Matchers.equalTo(0));
    }
}
