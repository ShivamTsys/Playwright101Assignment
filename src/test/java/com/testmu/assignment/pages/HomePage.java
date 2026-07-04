package com.testmu.assignment.pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void open() {
        page.navigate("https://www.testmuai.com/selenium-playground/");
    }

    public void clickSimpleFormDemo() {
        Locator link = page.locator("a[href*='simple-form-demo']").first();
        link.scrollIntoViewIfNeeded();
        link.click();
    }

    public void clickSlider() {
        page.getByText("Drag & Drop Sliders").click();
    }

    public void clickInputForm() {
        page.getByText("Input Form Submit").click();
    }
}