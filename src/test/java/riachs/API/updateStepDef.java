package riachs.API;

import com.riachs.API.page.deleteApiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.riachs.API.page.putApiPage;


public class updateStepDef {

    putApiPage putapiPage;
    public updateStepDef (){
        this.putapiPage = new putApiPage();
    }

    @Given("go to The URL {string}")
    public void goToTheURL(String url) { putapiPage.goToURL(url);
    }

    @And("hit api post create new user")
    public void hitApiPostCreateNewUser() { putapiPage.createNewUser();
    }

    @Then("validation for status code is {int}")
    public void validationForStatusCodeIs(int statusCode) { putapiPage.validatinStatusCode(statusCode);
    }

    @Then("validation body post create new user")
    public void validationBodyPostCreateNewUser() { putapiPage.validationBodyCreateUser();
    }

    @And("hit api update data")
    public void hitApiUpdateData() { putapiPage.hitUpdateUser();
    }

    @Then("validation body post update data")
    public void validationBodyPostUpdateData() { putapiPage.validationUpdateData();
    }
}
