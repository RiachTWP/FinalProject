package com.riachs.WEB.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import com.riachs.baseTest;

import java.util.Objects;

public class cucumberHooks extends baseTest {
    String tagsRunning = null;

    @Before
    public void beforeTest(Scenario scenario) {
        System.out.println("Before Test");
        String[] tags = scenario.getSourceTagNames().toArray(new String[0]);
        tagsRunning = tags[0];
        if (Objects.equals(tagsRunning, "@WEB")) {
            starDriver();
        }

    }

    @After
    public void afterTest() {
        System.out.println("After Test");
        if (Objects.equals(tagsRunning, "@WEB")) {
            driver.quit();
        }
    }
}
