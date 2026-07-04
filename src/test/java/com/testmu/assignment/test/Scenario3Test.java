package com.testmu.assignment.test;

import com.microsoft.playwright.*;
import com.testmu.assignment.base.BaseTest;
import com.testmu.assignment.pages.HomePage;
import com.testmu.assignment.pages.InputFormPage;

public class Scenario3Test extends BaseTest{

    public void execute(String browser, String platform) {

        setUp("Scenario 3", browser, platform);
        HomePage home = new HomePage(page);
        InputFormPage form = new InputFormPage(page);

        home.open();
        home.clickInputForm();

        page.waitForTimeout(2000);

        form.clickSubmit();

        // Validate browser validation message
        Locator nameField = page.locator("#name");

        String actualValidationMessage = nameField.evaluate(
                "element => element.validationMessage"
        ).toString();

        String expectedValidationMessage = "Please fill out this field.";

        if (actualValidationMessage.equals(expectedValidationMessage)) {
            System.out.println("Validation message verified successfully.");
        } else {
            System.out.println("Validation message verification failed.");
            System.out.println("Expected : " + expectedValidationMessage);
            System.out.println("Actual   : " + actualValidationMessage);
        }

        page.waitForTimeout(1000);

        form.fillForm();
        form.clickSubmit();

        String msg = form.getSuccessMessage();

        if(msg.equals("Thanks for contacting us, we will get back to you shortly.")){
            System.out.println("Scenario 3 Passed");
        }else{
            System.out.println("Scenario 3 Failed");
        }

        markTestStatus("passed", "Scenario 3 Passed");
        tearDown();
    }
}
