package riachs.WEB.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.riachs.WEB.page.contactPage;
import com.riachs.baseTest;

public class contactStepDef extends baseTest{
    contactPage contactpage;
        @When("user click Contact")
        public void userclickContact() throws InterruptedException{
            contactpage = new contactPage(driver);
            contactpage.clickContact();
            contactpage.validationContactPage();
            Thread.sleep(1000);
        }

        @Then("user input Contact Email {string}")
        public void userInputContactEmail(String email) throws InterruptedException{
            contactpage.inputContacEmail(email);
            Thread.sleep(1000);
        }

        @Then("user input Contact Name {string}")
        public void userInputContactName(String name) throws InterruptedException{
            contactpage.inputContactName(name);
            Thread.sleep(1000);
        }

        @And("user input Message {string}")
        public void userInputMessage(String message) throws InterruptedException{
            contactpage.inputMessage(message);
            Thread.sleep(1000);
        }

        @And("user click Send Message")
        public void userClickSendMessage() throws InterruptedException{
            contactpage.sendMessage();
            Thread.sleep(1000);
        }

        @And("user click close")
        public void userClickClose() throws InterruptedException{
            contactpage.closePage();
            Thread.sleep(1000);
        }
}
