package riachs.WEB.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import com.riachs.baseTest;

public class cucumberHooks extends baseTest {
    @Before
    public void beforeTest(){
        System.out.println("Before Test");
        starDriver();
    }
    @After
    public void afterTest(){
        System.out.println("After Test");
        driver.quit();
    }
}
