package com.testmu.assignment.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SliderPage {

    private Page page;

    public SliderPage(Page page) {
        this.page = page;
    }

    public void moveSliderTo95() {

        Locator slider = page.locator("input.sp__range").nth(2);
            page.waitForTimeout(1000);
        
            slider.fill("95");
    }

    public String getSliderValue() {
        return page.locator("#rangeSuccess").textContent();
    }
}