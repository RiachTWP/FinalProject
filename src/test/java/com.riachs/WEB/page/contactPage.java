package com.riachs.WEB.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

public class contactPage {

    WebDriver driver;

    By contactButton = By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a");
    By titleContactPage = By.cssSelector("[id=\"exampleModalLabel\"]");
    By textBoxContactEmail = By.cssSelector("[id=\"recipient-email\"]");
    By textBoxContactName = By.cssSelector("[id=\"recipient-name\"]");
    By textBoxMessage = By.cssSelector("[id=\"message-text\"]");
    By sendMessageButton = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]");
    By closeContactButton = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]");

    public contactPage(WebDriver driver){this.driver = driver;}

    public void clickContact() { driver.findElement(contactButton).click();
    }

    public void validationContactPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(titleContactPage));
        assertTrue(titleElement.isDisplayed());
        assertEquals("New message", titleElement.getText());
    }

    public void inputContacEmail(String email) {driver.findElement(textBoxContactEmail).sendKeys(email);}

    public void inputContactName(String name) {driver.findElement(textBoxContactName).sendKeys(name);}

    public void inputMessage(String message) {driver.findElement(textBoxMessage).sendKeys(message);}

    public void sendMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement sendMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sendMessageButton));
        sendMessageElement.click();
    }

    public void closePage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement closePageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(closeContactButton));
        closePageElement.click();
    }

}
