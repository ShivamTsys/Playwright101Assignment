package com.testmu.assignment.pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;

public class InputFormPage {

    private Page page;

    public InputFormPage(Page page){
        this.page = page;
    }

    public void clickSubmit(){

        Locator submitButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Submit"));
        submitButton.scrollIntoViewIfNeeded();
        submitButton.click();

    }

    public void fillForm(){

        page.locator("#name").fill("John Doe");
        page.locator("#inputEmail4").fill("john@test.com");
        page.locator("#inputPassword4").fill("Password123");
        page.locator("#company").fill("Test Company");            
        page.locator("#websitename").fill("https://example.com");

        Locator country = page.locator("select[name='country']");
        country.selectOption(new SelectOption().setLabel("United States"));
        
        page.locator("#inputCity").fill("New York");
        page.locator("#inputAddress1").fill("123 Main Street");
        page.locator("#inputAddress2").fill("Apartment 101");
        page.locator("#inputState").fill("New York");
        page.locator("#inputZip").fill("10001");
    }

    public String getSuccessMessage(){

        return page.locator(".success-msg").textContent().trim();

    }
}