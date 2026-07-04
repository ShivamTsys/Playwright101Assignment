package com.testmu.assignment.pages;

import com.microsoft.playwright.Page;

public class SimpleFormPage {

    private Page page;

    public SimpleFormPage(Page page) {
        this.page = page;
    }

    public void enterMessage(String message) {
        page.getByPlaceholder("Please enter your Message").fill(message);
    }

    public void clickGetCheckedValue() {
        page.locator("#showInput").click();
    }

    public String getDisplayedMessage() {
        return page.locator("#message").textContent();
    }

    public boolean verifyUrl() {
        return page.url().contains("simple-form-demo");
    }
}