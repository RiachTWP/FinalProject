package riachs.WEB.stepDef;

import io.cucumber.java.be.I;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.riachs.baseTest;
import com.riachs.WEB.page.cartPage;
import io.cucumber.java.sl.In;

import java.util.List;


public class cartStepDef extends baseTest {

    cartPage cartpage;


    @Then("user click add to cart button for these product:")
    public void userClickAddToCartButtonForTheseProduct(List<String> products) throws InterruptedException{
        cartpage = new cartPage(driver);
        cartpage.addToCartForTheProduct(products);
        Thread.sleep(1000);
    }

    @Then("user go to the cart page")
    public void userGoToTheCartPage() throws InterruptedException {
        cartpage = new cartPage(driver);
        cartpage.clickCartButton();
        cartpage.validationInCartPage();
        Thread.sleep(1000);
    }

    @And("the cart page should contain:")
    public void theCartPageShouldContain(List<String> products) throws InterruptedException{
        cartpage.validationOfProduct(products);
        Thread.sleep(1000);
    }

    @And("calculated total price is accurate")
    public void CalculatedTotalPriceIsAccurate() throws InterruptedException{
        cartpage.validationTotalPrice();
        Thread.sleep(1000);
    }


    @When("user click add to cart button {int} times for these product:")
    public void userClickAddToCartButtonTimesForTheseProduct(int itemCount, List<String> products) throws InterruptedException{
        cartpage = new cartPage(driver);
        cartpage.addToCartWithSameProduct(itemCount, products);
        Thread.sleep(1000);
    }

    @And("the cart's item count for these product should be {int}")
    public void theCartSItemCountForTheseProductShouldBe(int itemCount, List<String> products) throws InterruptedException{
        cartpage.validationCartPageWithSampeProduct(itemCount, products);
        Thread.sleep(1000);
    }

    @Then("user click delete button for product:")
    public void userClickDeleteButtonForProduct(List<String> products) throws InterruptedException{
        cartpage.deteleProduct(products);
        Thread.sleep(1000);
    }

    @When("user click add to cart button for all product")
    public void userClickAddToCartButtonForAllProduct() throws  InterruptedException{
        cartpage = new cartPage(driver);
        cartpage.addAllProduct();
    }

    @And("the cart should contain all product")
    public void theCartShouldContainAllProduct() throws InterruptedException {
        cartpage.validationALlProducts();
    }

}