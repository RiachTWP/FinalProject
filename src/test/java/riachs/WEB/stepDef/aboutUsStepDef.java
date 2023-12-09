package riachs.WEB.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import riachs.WEB.page.aboutUsPage;
import riachs.baseTest;

public class aboutUsStepDef extends baseTest{

    aboutUsPage aboutusPage;

    @When("user click about us button")
    public void userClickAboutUsButton() throws InterruptedException{
        aboutusPage = new aboutUsPage(driver);
        aboutusPage.ClickAboutUsButton();
        aboutusPage.validationaboutusPage();
        Thread.sleep(1000);
    }

    @And("user can see video about information company's")
    public void userCanSeeVideoAboutInformationCompanyS() throws InterruptedException {
        aboutusPage.VideoAboutInformationCompanyS();
        Thread.sleep(1000);
    }

    @And("user click close button")
    public void userClickCloseButton() throws InterruptedException {
        aboutusPage = new aboutUsPage(driver);
        aboutusPage.closeAboutUs();
        Thread.sleep(1000);
    }
}
