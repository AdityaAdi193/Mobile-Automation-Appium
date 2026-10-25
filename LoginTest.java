package com.qa.tests;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import com.qa.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void verifyProductsScreenIsDisplayed() {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(30));

        // Step 1: Enter username
        WebElement username = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("test-Username")
            )
        );
        username.sendKeys("standard_user");

        // Step 2: Enter password
        WebElement password = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("test-Password")
            )
        );
        password.sendKeys("secret_sauce");

        // Step 3: Click the Login button
        WebElement loginButton = wait.until(
            ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("test-LOGIN")
            )
        );
        loginButton.click();

        // Step 4: Verify the Products screen
        WebElement productsHeading = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("test-PRODUCTS")
            )
        );

        Assert.assertTrue(
            productsHeading.isDisplayed(),
            "Products screen should be displayed after login"
        );

        System.out.println(
            "PASS: Login successful; Products screen displayed."
        );
    }
}
