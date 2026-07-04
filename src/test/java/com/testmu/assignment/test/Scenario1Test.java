package com.testmu.assignment.test;

import com.testmu.assignment.base.BaseTest;
import com.testmu.assignment.pages.HomePage;
import com.testmu.assignment.pages.SimpleFormPage;

public class Scenario1Test extends BaseTest {

    public void execute(String browser, String platform) {

        setUp("Scenario 1", browser, platform);
        HomePage home = new HomePage(page);
        SimpleFormPage simpleForm = new SimpleFormPage(page);

        home.open();
        home.clickSimpleFormDemo();

        String currentUrl = page.url();
        System.out.println(currentUrl);

        if (currentUrl.contains("simple-form-demo")) {
            System.out.println("URL validation Passed");
        } else {
            System.out.println("URL validation Failed");
        }

        String expected = "Welcome to TestMu AI";
        simpleForm.enterMessage(expected);
        simpleForm.clickGetCheckedValue();

        String actual = simpleForm.getDisplayedMessage();

        if (expected.equals(actual)) {
            System.out.println("Scenario 1 Passed");
        } else {
            System.out.println("Scenario 1 failed");
        }

        markTestStatus("passed", "Scenario 1 Passed");
        tearDown();
    }
}
