package com.riachs.WEB.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.riachs.baseTest;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class homePage {
    By productStoreTitle = By.cssSelector("[id=\"nava\"]");
    By nextButton = By.cssSelector("[id=\"next2\"]");
    By previousButton = By.cssSelector("[id=\"prev2\"]");
    By productDisplayed = By.cssSelector("[class=\"col-lg-4 col-md-6 mb-4\"]");
    By phonesCategoryButton = By.xpath("//div[@class=\"list-group\"]/a[2]");
    By laptopsCategoryButton = By.xpath("/html/body/div[5]/div/div[1]/div/a[3]");
    By monitorsCategoryButton = By.xpath("/html/body/div[5]/div/div[1]/div/a[4]");
    By homeButton = By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a");

    WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    public void userInHomePage() {
        driver.get("https://www.demoblaze.com/");
    }
    public void validateOnHomepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(productStoreTitle));
        assertTrue(title.isDisplayed());
        assertEquals("PRODUCT STORE", title.getText());
    }
    public void clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement nextElement = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextElement.click();
    }

    public void clickPreviousButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement previousElement = wait.until(ExpectedConditions.elementToBeClickable(previousButton));
        previousElement.click();
    }


    //USING UTILS
    public void TheSecondPageProduct() {
        List<String> expectedProductNames = Arrays.asList(
                "Apple monitor 24", "MacBook air", "Dell i7 8gb",
                "2017 Dell 15.6 Inch", "ASUS Full HD", "MacBook Pro"
        );
        baseTest.validateProductPresence(driver, productDisplayed, expectedProductNames);
    }

    public void TheFirstPageProduct() {
        List<String> expectedProductNames = Arrays.asList(
                "Samsung galaxy s6", "Nokia lumia 1520", "Nexus 6", "Samsung galaxy s7",
                "Iphone 6 32gb", "Sony xperia z5", "HTC One M9", "Sony vaio i5", "Sony vaio i7"
        );
        baseTest.validateProductPresence(driver, productDisplayed, expectedProductNames);
    }

    public void ClikPhones() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement nextElement = wait.until(ExpectedConditions.elementToBeClickable(phonesCategoryButton));
        nextElement.click();
    }

    public void ClickLaptops(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement nextElement = wait.until(ExpectedConditions.elementToBeClickable(laptopsCategoryButton));
        nextElement.click();
    }

    public void ClickMonitors(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement nextElement = wait.until(ExpectedConditions.elementToBeClickable(monitorsCategoryButton));
        nextElement.click();
    }

    public void validationProductPhones() {
        List<String> expectedProductNames = Arrays.asList(
                "Samsung galaxy s6", "Nokia lumia 1520", "Nexus 6", "Samsung galaxy s7",
                "Iphone 6 32gb", "Sony xperia z5", "HTC One M9"
        );
        baseTest.validateProductPresence(driver, productDisplayed, expectedProductNames);
    }

    public void validationProductLaptops() {
        List<String> expectedProductNames = Arrays.asList(
                "Sony vaio i5", "Sony vaio i7", "MacBook air",
                "Dell i7 8gb", "2017 Dell 15.6 Inch", "MacBook Pro"
        );
        baseTest.validateProductPresence(driver, productDisplayed, expectedProductNames);
    }

    public void validationProductMonitors() {
        List<String> expectedProductNames = Arrays.asList(
                "Apple monitor 24", "ASUS Full HD"
        );
        baseTest.validateProductPresence(driver, productDisplayed, expectedProductNames);
    }

    public void validationproductinHomepageAndProductDetailPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        int totalOfPages = 2;

        for (int page = 1; page <= totalOfPages; page++){
            Thread.sleep(1000);
            int expectedProductCount = driver.findElements(productDisplayed).size();
            for (int numBlock = 1; numBlock <= expectedProductCount; numBlock++){
                Thread.sleep(1000);
                WebElement linkProduct =  driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div["+ numBlock +"]/div/div/h4/a"));
                String expectedName = linkProduct.getText();
                String expectedPrice = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div["+ numBlock +"]/div/div/h5")).getText();

                linkProduct.click();
                Thread.sleep(1000);

                String actualName = driver.findElement(By.cssSelector("h2.name")).getText();
                String actualPrice = driver.findElement(By.cssSelector("h3.price-container")).getText();
                Thread.sleep(1000);

                assertEquals(expectedName, actualName);
                assertTrue(actualPrice.contains(expectedPrice));
                driver.navigate().back();
            }
            if (page < totalOfPages) {
                WebElement nextPage = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
                nextPage.click();
            }
        }
    }
    public void goToHome() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement homeElement = wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        homeElement.click();
    }
}
