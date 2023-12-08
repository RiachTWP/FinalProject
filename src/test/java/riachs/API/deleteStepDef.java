package riachs.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.riachs.API.page.deleteApiPage;

public class deleteStepDef {

    deleteApiPage deleteapiPage;

    public deleteStepDef (){
        this.deleteapiPage = new deleteApiPage();
    }

    @Given("go to url for {string}")
    public void goToUrlFor(String url) {
        deleteapiPage.goToURL(url);
    }

    @And("hit the api post create new users")
    public void hitTheApiPostCreateNewUsers() {
        deleteapiPage.createNewUser();
    }

    @Then("validation status for code is equals {int}")
    public void validationStatusForCodeIsEquals(int statusCode) {
        deleteapiPage.validatinStatusCode(statusCode);
    }

    @Then("validation for response body post create new user")
    public void validationForResponseBodyPostCreateNewUser() {
        deleteapiPage.validationBodyCreateUser();
    }

    @And("hit api delete new")
    public void hitApiDeleteNew() {
        deleteapiPage.hitDeleteUser();
    }

}
