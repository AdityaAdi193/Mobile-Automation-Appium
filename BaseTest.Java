package com.qa.base;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        String appPath =
            "C:\\Users\\adity\\OneDrive\\Documents\\AppiumProject\\Apps\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";

        if (!Files.exists(Path.of(appPath))) {
            throw new IllegalStateException(
                "APK not found: " + appPath);
        }

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Emulator");
        options.setApp(appPath);

        options.setCapability("appium:appWaitActivity", "*");
        options.setCapability("appium:appWaitDuration", 60000);

        driver = new AndroidDriver(
            new URL("http://127.0.0.1:4723"), options);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
