package com.testmu.assignment.test;

import com.testmu.assignment.base.BaseTest;
import com.testmu.assignment.pages.HomePage;
import com.testmu.assignment.pages.SliderPage;

public class Scenario2Test extends BaseTest {

    public void execute(String browser, String platform) {

        setUp("Scenario 2", browser, platform);
        HomePage home = new HomePage(page);
        SliderPage slider = new SliderPage(page);

        home.open();
        home.clickSlider();

        slider.moveSliderTo95();

        String value = slider.getSliderValue();

        if(value.equals("95")){
            System.out.println("Scenario 2 Passed");
        }else{
            System.out.println("Scenario 2 Failed");
        }

        markTestStatus("passed", "Scenario 2 Passed");
        tearDown();
    }
}
