package riachs.WEB.stepDef;
import com.riachs.baseTest;
import com.riachs.WEB.page.purchasePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;




public class purchaseStepDef extends baseTest {

    purchasePage purchasepage ;

    @And("user click Place Order button")
    public void userClickPlaceOrderButton() throws InterruptedException {
        purchasepage = new purchasePage(driver);
        purchasepage.clickPlaceOrderButton();
        Thread.sleep(1000);
    }

    @And("user input Name {string}")
    public void userInputName(String name) throws InterruptedException {
        purchasepage.inputName(name);
        Thread.sleep(1000);
    }

    @And("user input Country {string}")
    public void userInputCountry(String country) throws InterruptedException {
        purchasepage.inputCountry(country);
        Thread.sleep(1000);
    }

    @And("user input City {string}")
    public void userInputCity(String city) throws InterruptedException{
        purchasepage.inputCity(city);
        Thread.sleep(1000);
    }

    @And("user input Credit card {string}")
    public void userInputCreditCard(String creditCard) throws InterruptedException{
        purchasepage.inputCreditCard(creditCard);
        Thread.sleep(1000);
    }

    @And("user input Month {string}")
    public void userInputMonth(String month) throws InterruptedException{
        purchasepage.inputMonth(month);
        Thread.sleep(1000);
    }

    @And("user input Year {string}")
    public void userInputYear(String year) throws InterruptedException{
        purchasepage.inputYear(year);
        Thread.sleep(1000);
    }

    @Then("user click Purchase button")
    public void userClickPurchaseButton() throws InterruptedException{
        purchasepage.clickPurchaseButton();
        Thread.sleep(1000);
    }

    @Then("transaction sucessfull and get pop up message {string}")
    public void transactionsucessfullandgetpopupmessage(String message) {
        purchasepage.popUpMessageSucessfull(message);
    }

    @Then("get popUpMessage {string}")
    public void getPopUpMessage(String message) {
        purchasepage.popUpMessage(message);
    }

    @And("user click close button in place place order page")
    public void userClickCloseButtonInPlacePlaceOrderPage() {
        purchasepage.clickCloseButtonPurchase();
    }
}
