package com.riachs.WEB.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class purchasePage {

    WebDriver driver;
    public purchasePage(WebDriver driver){this.driver = driver;}

    By placeOrderButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    By textBoxName = By.cssSelector("[id=\"name\"]");
    By textBoxCountry = By.cssSelector("[id=\"country\"]");
    By textBoxCity = By.cssSelector("[id=\"city\"]");
    By textBoxCreditCard = By.xpath("//*[@id=\"card\"]");
    By textBoxMonth = By.cssSelector("[id=\"month\"]");
    By textBoxYear = By.cssSelector("[id=\"year\"]");
    By purchaseButton = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    By closeButtonPurchase = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]");
    By notificationSucess = By.xpath("/html/body/div[10]/h2");
    By okButtonPurchaseSucess = By.xpath("/html/body/div[10]/div[7]/div/button");

    public void clickPlaceOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement placeOrderButtonElement = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        placeOrderButtonElement.click();
    }

    public void inputName(String name) {driver.findElement(textBoxName).sendKeys(name);}

    public void inputCountry(String country) {driver.findElement(textBoxCountry).sendKeys(country);}

    public void inputCity(String city) {driver.findElement(textBoxCity).sendKeys(city);}

    public void inputCreditCard(String creditCard) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement creditCardField = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxCreditCard));
        creditCardField.sendKeys(creditCard);}

    public void inputMonth(String month) {driver.findElement(textBoxMonth).sendKeys(month);}

    public void inputYear(String year) { WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement yearField = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxYear));
        yearField.sendKeys(year);}

    public void clickPurchaseButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement purchaseButtonElement = wait.until(ExpectedConditions.elementToBeClickable(purchaseButton));
        purchaseButtonElement.click();
    }

    public void clickCloseButtonPurchase() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement closeButtonPurchaseElement = wait.until(ExpectedConditions.elementToBeClickable(closeButtonPurchase));
        closeButtonPurchaseElement.click();
    }

    public void popUpMessage(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        assertEquals(message, alert.getText());
    }

    public void popUpMessageSucessfull(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement sucessMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationSucess));
        assertTrue(sucessMessageElement.isDisplayed());
        assertEquals(message, sucessMessageElement.getText());

        driver.findElement(okButtonPurchaseSucess).click();
    }



}
