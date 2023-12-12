package com.riachs.API;

import com.riachs.API.page.tagPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class tagStepDef {
    tagPage tagpage;
    public tagStepDef(){this.tagpage = new tagPage();}

    @Given("user go to The URL {string}")
    public void userGoToTheURL(String url) { tagpage.goToTheURL(url);
    }

    @Then("hit api tag users")
    public void hitApiTagUsers() { tagpage.apiTagUsers();
    }

    @Then("validation status of code is equals {int}")
    public void validationStatusOfCodeIsEquals(int statusCode) { tagpage.statusOfCodeIsEquals(statusCode);
    }

    @And("validation all response should be match with {string}")
    public void validationAllResponseShouldBeMatchWith(String fileName) { tagpage.responseShouldBeMatchWith(fileName);

    }
}
