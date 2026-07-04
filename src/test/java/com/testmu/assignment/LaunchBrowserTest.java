package com.testmu.assignment;

import com.microsoft.playwright.*;

public class LaunchBrowserTest {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();

            page.navigate("https://www.testmuai.com/selenium-playground/");

            System.out.println(page.title());

            page.waitForTimeout(5000);

            browser.close();
        }
    }
}