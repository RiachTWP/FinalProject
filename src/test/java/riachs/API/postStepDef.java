package riachs.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import riachs.API.page.postApiPage;
import io.cucumber.java.en.When;
import riachs.models;

import java.util.Map;

public class postStepDef {

    postApiPage postapiPage;

    public postStepDef (){this.postapiPage = new postApiPage();}

    @Given("go to the URL {string}")
    public void goToTheURL(String url) {
        postapiPage.goToURL(url);
    }

    @And("hit api post create new users")
    public void hitApiPostCreateNewUsers() {
        postapiPage.hitCreateNewUser();
    }

    @Then("validation for status code is equals {int}")
    public void validationForStatusCodeIsEquals(int statusCode) {
        postapiPage.validatiStatusCode(statusCode);
    }

    @Then("validation response body post create new user")
    public void validationResponseBodyPostCreateNewUser() {
        postapiPage.validBodyCreateUser();
    }

    @Then("validation responses json with JSONSchema {string}")
    public void validationResponsesJsonWithJSONSchema(String fileName) {
        postapiPage.validationJsonSchemaPost(fileName);
    }


}
