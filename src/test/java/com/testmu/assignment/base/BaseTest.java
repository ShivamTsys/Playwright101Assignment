package com.testmu.assignment.base;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.google.gson.JsonObject;
import com.microsoft.playwright.*;
import com.testmu.assignment.utils.Config;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    public void setUp(String testName, String browserName, String platform) {

        playwright = Playwright.create();

        JsonObject capabilities = new JsonObject();
        JsonObject ltOptions = new JsonObject();

        capabilities.addProperty("browserName", browserName);
        capabilities.addProperty("browserVersion", "latest");
        ltOptions.addProperty("platform", platform);
        ltOptions.addProperty("build", "Playwright101 Assignment - " + System.currentTimeMillis());
        ltOptions.addProperty("name", testName);

        ltOptions.addProperty("user", Config.USERNAME);
        ltOptions.addProperty("accessKey", Config.ACCESS_KEY);

        ltOptions.addProperty("video", true);
        ltOptions.addProperty("network", true);
        ltOptions.addProperty("console", true);
        ltOptions.addProperty("visual", true);
        ltOptions.addProperty("screenshots", true);
        ltOptions.addProperty("resolution", "1920x1080");

        capabilities.add("LT:Options", ltOptions);

        String caps = URLEncoder.encode(capabilities.toString(), StandardCharsets.UTF_8);

        BrowserType chromium = playwright.chromium();

        browser = chromium.connect(
            "wss://cdp.lambdatest.com/playwright?capabilities=" + caps);

        context = browser.newContext(
            new Browser.NewContextOptions()
                .setViewportSize(1920, 1080));
        page = context.newPage();
    }

    public void tearDown() {

        browser.close();
        playwright.close();
    }

    public void markTestStatus(String status, String remark) {

    page.evaluate(
        "_ => {}",
        "lambdatest_action: {\"action\":\"setTestStatus\",\"arguments\":{\"status\":\""
                + status
                + "\",\"remark\":\""
                + remark
                + "\"}}"
    );
}
}