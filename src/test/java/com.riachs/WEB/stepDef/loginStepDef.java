package com.riachs.WEB.stepDef;

import com.riachs.WEB.page.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.riachs.baseTest;
import io.cucumber.java.sl.In;

public class loginStepDef extends baseTest {


    protected loginPage LoginPage;


    @When("user click button Log in")
    public void userClickButtonLogIn() throws InterruptedException{
        LoginPage = new loginPage(driver);
        LoginPage.ButtonLogIn();
        LoginPage.validationLoginPage();
        Thread.sleep(1000);

    }

    @And("user login with username {string}")
    public void userLoginWithUsername(String userName) throws InterruptedException{
        LoginPage.LoginWithUsername(userName);
        Thread.sleep(1000);
    }

    @And("user login with password {string}")
    public void userLoginWithPassword(String password) throws InterruptedException{
        LoginPage.LoginWithPassword(password);
        Thread.sleep(1000);
    }

    @When("user click login button")
    public void userClickLoginButton() throws InterruptedException {
        LoginPage.ClickLoginButton();
        Thread.sleep(1000);
    }

    @Then("click close button")
    public void clickCloseButton() throws InterruptedException{
        LoginPage.ClickcloseButton();
        Thread.sleep(1000);
    }

    @When("user already login")
    public void userAlreadyLogin() throws InterruptedException{
        LoginPage = new loginPage(driver);
        Thread.sleep(1000);
        LoginPage.ButtonLogIn();
        Thread.sleep(1000);
        LoginPage.validationLoginPage();
        LoginPage.LoginWithUsername("sulaiman234");
        LoginPage.LoginWithPassword("sulaiman234");
        Thread.sleep(1000);
        LoginPage.ClickLoginButton();
        Thread.sleep(1000);
    }
}



