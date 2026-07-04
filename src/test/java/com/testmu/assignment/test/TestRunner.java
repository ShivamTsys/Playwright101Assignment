package com.testmu.assignment.test;

public class TestRunner {

    public static void main(String[] args) throws InterruptedException  {

         Thread chrome = new Thread(() -> {

            new Scenario1Test().execute("Chrome", "Windows 11");
            new Scenario2Test().execute("Chrome", "Windows 11");
            new Scenario3Test().execute("Chrome", "Windows 11");

        });

        Thread firefox = new Thread(() -> {

            new Scenario1Test().execute("pw-firefox", "Windows 11");
            new Scenario2Test().execute("pw-firefox", "Windows 11");
            new Scenario3Test().execute("pw-firefox", "Windows 11");

        });

        chrome.start();
        firefox.start();

        chrome.join();
        firefox.join();

    }
}