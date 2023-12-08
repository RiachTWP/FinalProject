package riachs.WEB.page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class singUpPage {

    WebDriver driver;

    public singUpPage(WebDriver driver){this.driver = driver;}

    By singUpMenu = By.cssSelector("[id=\"signin2\"]");
    By signUpTitle = By.xpath("//*[@id=\"signInModalLabel\"]");
    By userNameTextBox = By.cssSelector("[id=\"sign-username\"]");
    By passwordTextBox = By.cssSelector("[id=\"sign-password\"]");
    By singUpButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
    By closeSignUpButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[1]");


    public void ClickButtonSignUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement signUpMenu = wait.until(ExpectedConditions.elementToBeClickable(singUpMenu));
        signUpMenu.click();
    }
    public void validationInSingUpMenu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpTitle));
        assertTrue(title.isDisplayed());
        assertEquals("Sign up", title.getText());
    }

    public void InputUsernameWith(String userName) {driver.findElement(userNameTextBox).sendKeys(userName);
    }

    public void InputPasswordWith(String password) {driver.findElement(passwordTextBox).sendKeys(password);
    }

    public void ClikSingUpButton() {  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement signupElement = wait.until(ExpectedConditions.elementToBeClickable(singUpButton));
        signupElement.click();
    }

    public void ValidationMessage(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        assertEquals(message, alert.getText());
        alert.accept();
    }

    public void CloseSignUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement closeElement = wait.until(ExpectedConditions.elementToBeClickable(closeSignUpButton));
        closeElement.click();
    }
}
