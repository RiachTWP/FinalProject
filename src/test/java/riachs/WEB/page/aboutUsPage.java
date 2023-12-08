package riachs.WEB.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class aboutUsPage {

    WebDriver driver;

    By buttonAboutUsMenu = By.xpath("//*[@id=\"navbarExample\"]/ul/li[3]/a");
    By titleAboutUs = By.cssSelector("[id=\"videoModalLabel\"]");
    By videoProfileCompany = By.xpath("//*[@id=\"example-video\"]/div[1]");
    By closeButtonAbousUs = By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button");

    public aboutUsPage(WebDriver driver) {this.driver = driver;}

    public void ClickAboutUsButton() {driver.findElement(buttonAboutUsMenu).click();
    }
    public void validationaboutusPage (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement elementAboutUs = wait.until(ExpectedConditions.visibilityOfElementLocated(titleAboutUs));
        assertTrue(elementAboutUs.isDisplayed());
        assertEquals("About us", elementAboutUs.getText());
    }
    public void VideoAboutInformationCompanyS() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement videoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(videoProfileCompany));
        assertTrue(videoElement.isDisplayed());
    }

    public void closeAboutUs(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(closeButtonAbousUs));
        close.click();

    }
}
