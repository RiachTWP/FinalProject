package com.riachs.WEB.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class cartPage {
    WebDriver driver;

    public cartPage(WebDriver driver){this.driver = driver;}

    private By productNameHomePage(String title){
        return By.xpath("//a[contains(text(), '" + title + "') ]"); }
    private By productNameCartPage(String title){
        return By.xpath("//td[contains(text(), '" + title + "')]"); }//*[@id="tbodyid"]/tr/td[2]

    By cartButton = By.cssSelector("[id=\"cartur\"]");
    By cartTitle = By.xpath("//*[@id=\"page-wrapper\"]/div/div[1]/h2");
    By addToCartButton = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    By totalPriceProducts = By.cssSelector("[id=\"totalp\"]");
    By priceCart = By.xpath("//*[@id=\"tbodyid\"]/tr/td[3]");
    By deleteButton = By.xpath(" //*[@id=\"tbodyid\"]/tr/td[4]/a");

    By productDisplayed = By.cssSelector("[class=\"col-lg-4 col-md-6 mb-4\"]");
    By productName = By.xpath("//*[@id=\"tbodyid\"]/div/div/div/h4/a");
    By nextButton = By.cssSelector("[id=\"next2\"]");

    public void addToCartForTheProduct(List<String> products) {
        for (String product : products){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement linkProduct = wait.until(ExpectedConditions.elementToBeClickable(productNameHomePage(product)));
            linkProduct.click();

            WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            addToCart.click();
            wait.until(ExpectedConditions.alertIsPresent()).accept();
            driver.navigate().back();
            driver.navigate().back();
        }
    }

    public void clickCartButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cartButtonElement = wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButtonElement.click();
    }

    public void validationInCartPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cartPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartTitle));
        assertEquals("Products", cartPageElement.getText());
    }

    public void validationOfProduct(List<String> products){
       for (String expectedProduct : products){
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
           WebElement productCartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productNameCartPage(expectedProduct)));
           String actualProduct = productCartElement.getText();
           assertEquals(expectedProduct, actualProduct);
       }
    }

    public void validationTotalPrice(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> priceElements = driver.findElements(priceCart);
        int totalPrice = 0;

        for (WebElement priceElement : priceElements){
            WebElement price = wait.until(ExpectedConditions.visibilityOf(priceElement));
            String productPrice = price.getText();
            int productPrices = Integer.parseInt(productPrice);

            totalPrice += productPrices;
        }
        WebElement totalElements = wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceProducts));
        assertEquals(String.valueOf(totalPrice), totalElements.getText());
    }

    public void addToCartWithSameProduct(int itemCount, List<String> products) {
        for (String product : products){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement linkProduct = wait.until(ExpectedConditions.elementToBeClickable(productNameHomePage(product)));
            linkProduct.click();

            WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            for (int a = 1; a <= itemCount; a++){
                addToCart.click();
                wait.until(ExpectedConditions.alertIsPresent()).accept();
            }
            driver.navigate().back();
            driver.navigate().back();
        }
    }

    public void validationCartPageWithSampeProduct(int itemCount, List<String> products){
        for (String product : products){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(productNameCartPage(product)));
            int productCount = driver.findElements(productNameCartPage(product)).size();
            assertEquals(itemCount, productCount);
        }
    }

    public void deteleProduct(List<String> products) {
        for (String product : products){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(productNameCartPage(product)));
            WebElement listProduct = driver.findElement(productNameCartPage(product));
            WebElement deleteElement = wait.until(ExpectedConditions.elementToBeClickable(listProduct.findElement(deleteButton)));
            deleteElement.click();
        }
    }

    public void addAllProduct() throws InterruptedException{
        Preferences pref = Preferences.userRoot().node("riachs.WEB");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<String> addProducts = new ArrayList<>();
        int totalPages = 2 ;

        for (int page = 1; page <= totalPages; page++){
            Thread.sleep(1000);
            List<WebElement> productElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productDisplayed));
            for (int a = 0; a < productElements.size(); a++){
                Thread.sleep(1000);
                String productIndex = String.valueOf(a+1);
                WebElement linkProduct = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(.//div/div/h4/a)["+productIndex+"]"))));
                String expectedName = linkProduct.getText();
                addProducts.add(expectedName);
                linkProduct.click();

                WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
                addToCart.click();

                wait.until(ExpectedConditions.alertIsPresent()).accept();
                driver.navigate().back();
                driver.navigate().back();

                pref.put("addProducts", String.join("," , addProducts));
            }
            if (page < totalPages){
                WebElement nextElement = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
                nextElement.click();
            }
        }
    }

    public void validationALlProducts() throws InterruptedException {
        Preferences pref = Preferences.userRoot().node("riachs.WEB");
        String[] expectedNames = pref.get("addProducts", null).split(",");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        List<String> productCartPage = new ArrayList<>();
        List<WebElement> productsName = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]")));

        for (WebElement productName : productsName){
            String nameOnCartPage = productName.getText();
            productCartPage.add(nameOnCartPage);
        }

        List<String> failedAssertions = new ArrayList<>();
        for (String expetedname : expectedNames){
            if (!productCartPage.contains(expetedname.trim())){
                failedAssertions.add("product '" + expetedname +"' is not present in cart.");
            }
        }
        Thread.sleep(1000);
        assertTrue(failedAssertions.isEmpty(),"one or more assertion is failed:\b" + String.join("\b", failedAssertions));
    }
}
