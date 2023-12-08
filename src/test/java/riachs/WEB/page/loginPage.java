package riachs.WEB.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class loginPage {

    WebDriver driver;

    By buttonLogin = By.cssSelector("#login2");
    By titleLoginPage = By.cssSelector("#logInModalLabel");
    By textBoxUserName = By.cssSelector("[id=\"loginusername\"]");
    By textBoxPassword = By.cssSelector("[id=\"loginpassword\"]");
    By loginButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    By closeLoginButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]");

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ButtonLogIn() {
        driver.findElement(buttonLogin).click();
    }

    public void validationLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement titleLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLoginPage));
        assertTrue(titleLogin.isDisplayed());
        assertEquals("Log in", titleLogin.getText());
    }

    public void LoginWithUsername(String userName) {driver.findElement(textBoxUserName).sendKeys(userName);
    }

    public void LoginWithPassword(String password) {
        driver.findElement(textBoxPassword).sendKeys(password);
    }

    public void ClickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement loginButtonPage = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonPage.click();
    }

    public void ClickcloseButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(closeLoginButton));
        closeButton.click();
    }
}



