package riachs.API;

import riachs.endPoint;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import riachs.API.page.getApiPage;
import io.cucumber.java.en.When;

import java.util.Map;

import static riachs.baseTest.res;
import static riachs.models.req;
import static org.hamcrest.core.IsNull.notNullValue;


public class getStepDef {

    getApiPage getapiPage;

    public getStepDef(){this.getapiPage = new getApiPage();}

    @Given("go to URL {string}")
    public void goToURL(String url) {
            getapiPage.setUpURL(url);
    }

    @Then("hit api get users")
    public void hitApiGetUsers() {
        getapiPage.hitGetListUsers();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int status_code) {
        getapiPage.validationStatusCode(status_code);
    }

    @And("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String FileName) {
        getapiPage.validationJsonSchemaFile(FileName);
    }

    @And("the limit and the page should be set to their default values")
    public void theLimitAndThePageShouldBeSetToTheirDefaultValues() { getapiPage.theLimitAndThePageShouldBeDefaultValues();
    }

    @Given("go to URL {string} with id {string}")
    public void goToURLWithId(String url, String id) { getapiPage.goToURLWithId(url, id);
    }

    @And("validation the body contain important detail")
    public void validationTheBodyContainImportantDetail() {getapiPage.bodyContainImportantDetail();}


    @And("response body contain :")
    public void responseBodyContain(Map<String, String> expectedValues) { getapiPage.bodyContain(expectedValues);
    }
}
