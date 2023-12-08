package com.riachs.WEB.stepDef;

import com.riachs.WEB.page.homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import com.riachs.baseTest;
import io.cucumber.java.en.When;

public class homeStepdef extends baseTest {


    homePage HomePage;
    @Then("user is on homepage")
    public void userIsOnHomepage() throws InterruptedException{
        HomePage = new homePage(driver);
        HomePage.userInHomePage();
        Thread.sleep(1000);
    }

    @And("will direct go back to homepage")
    public void willDirectGoBackToHomepage() throws InterruptedException {
        HomePage = new homePage(driver);
        HomePage.validateOnHomepage();
        Thread.sleep(1000);
    }

    @And("user click Next button")
    public void userClickNextButton() throws InterruptedException{
        HomePage.clickNextButton();
        Thread.sleep(1000);
    }

    @When("user click Previous button")
    public void userClickPreviousButton() throws InterruptedException{
        HomePage.clickPreviousButton();
        Thread.sleep(1000);
    }

    @Then("the all product in first page displayed")
    public void theallproductinfirstpagedisplayed() throws InterruptedException{
        HomePage = new homePage(driver);
        HomePage.TheFirstPageProduct();
        Thread.sleep(1000);
    }

    @Then("the all product in second page displayed")
    public void theallproductinsecondpagedisplayed() throws InterruptedException {
        HomePage.TheSecondPageProduct();
        Thread.sleep(1000);
    }

    @Then("user will be directed back to the all product in first page displayed")
    public void userwillbedirectedbacktotheallproductinfirstpagedisplayed() throws InterruptedException {
        HomePage.backFirstPageProduct();
        Thread.sleep(1000);
    }

    @Then("user click Phones category")
    public void userclickPhonescategory() throws InterruptedException{
        HomePage.ClikPhones();
        Thread.sleep(1000);
    }

    @Then("user click Laptops category")
    public void userClickLaptopsCategory() throws InterruptedException{
        HomePage.ClickLaptops();
        Thread.sleep(1000);
    }

    @Then("user click Monitors category")
    public void userClickMonitorsCategory() throws InterruptedException{
        HomePage.ClickMonitors();
        Thread.sleep(1000);
    }

    @And("show the all product Phones")
    public void showTheAllProductPhones() throws InterruptedException{
        HomePage.validationProductPhones();
        Thread.sleep(1000);
    }

    @And("show the all product Laptops")
    public void showTheAllProductLaptops() throws InterruptedException {
        HomePage.validationProductLaptops();
        Thread.sleep(1000);
    }

    @And("show the all product Monitors")
    public void showTheAllProductMonitors() throws InterruptedException {
        HomePage.validationProductMonitors();
        Thread.sleep(1000);
    }

    @And("click the product in home page and validate the product in product detail page")
    public void clickTheProductInHomePageAndValidateTheProductInProductDetailPage() throws InterruptedException{
        HomePage.validationproductinHomepageAndProductDetailPage();
        Thread.sleep(1000);
    }

    @And("user click Home button")
    public void userClickHomeButton() throws InterruptedException{
        HomePage.goToHome();
        Thread.sleep(1000);
    }
}
