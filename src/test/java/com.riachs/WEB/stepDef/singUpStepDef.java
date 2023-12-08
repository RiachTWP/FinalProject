package com.riachs.WEB.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.riachs.baseTest;
import com.riachs.WEB.page.singUpPage;

public class singUpStepDef extends baseTest {
    protected singUpPage signupPage;


    @When("user click button Sign Up")
    public void userClickButtonSignUp() throws InterruptedException {
        signupPage = new singUpPage(driver);
        signupPage.ClickButtonSignUp();
        signupPage.validationInSingUpMenu();
        Thread.sleep(1000);
    }

    @Then("user input username with {string}")
    public void userInputUsernameWith(String userName) throws InterruptedException {
        signupPage.InputUsernameWith(userName);
        Thread.sleep(1000);
    }

    @Then("user input password with {string}")
    public void userInputPasswordWith(String password) throws InterruptedException{
        signupPage.InputPasswordWith(password);
        Thread.sleep(1000);
    }

    @And("user clik SingUp button")
    public void userClikSingUpButton() throws InterruptedException{
        signupPage.ClikSingUpButton();
        Thread.sleep(1000);
    }

    @And("get message {string}")
    public void getMessage(String message) throws InterruptedException{
        signupPage = new singUpPage(driver);
        signupPage.ValidationMessage(message);
        Thread.sleep(1000);
    }

    @Then("clik close Sign Up button")
    public void clikCloseSignUpButton() throws InterruptedException{
        signupPage.CloseSignUp();
        Thread.sleep(1000);
    }
}
