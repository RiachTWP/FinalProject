package com.riachs;

import com.google.gson.JsonObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.List;
import org.json.JSONObject;

public class baseTest {
    protected static WebDriver driver;
    public static Response res;
    protected void starDriver() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
   }

   public static File getJsonSchemaData(String JSONFile){
       return new File("src/test/java/com/riachs/API/JsonSchema/" + JSONFile);
   }

    public static String generateEmail(){
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "-_.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(8);
        email =temp + "@Testing.com";
        return email;
    }

    public static void validateProductPresence(WebDriver driver, By productDisplayed, List<String> expectedProductName) {
        //VERIFY NUM OF PRODUCT
        List<WebElement> product = driver.findElements(productDisplayed);
        int expectedProductCount = expectedProductName.size();
        assertEquals(expectedProductCount, product.size());

        //VERIFY NAME OF PRODUCT
        for (int numBlock = 1; numBlock <= expectedProductCount; numBlock++) {
            WebElement actualProductName = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[" + numBlock + "]/div/div/h4/a"));
            assertEquals(expectedProductName.get(numBlock - 1), actualProductName.getText());
        }
    }
}
