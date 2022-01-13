package com.epam.ta.test;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.model.CalculatorData;
import com.epam.ta.page.*;
import com.epam.ta.service.CalculatorDataCreator;
import com.epam.ta.steps.GoogleCloudCalculatorSteps;
import com.epam.ta.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TotalEstimateTest {

    private WebDriver driver;
    private static final String CALCULATOR_SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
    }

    @Test
    public void totalEstimateEmailTest() {
        CalculatorData data = CalculatorDataCreator.createTestData();
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage(CALCULATOR_SEARCH_QUERY)
                .openCalculatorPage();
        GoogleCloudCalculatorSteps googleCloudCalculatorSteps = new GoogleCloudCalculatorSteps(calculatorPage);
        googleCloudCalculatorSteps.addToEstimate(data);
        String calculatorTotalEstimate = calculatorPage.getTotalEstimate();
        String emailTotalEstimate = googleCloudCalculatorSteps.getTotalEstimateFromEmail();
        Assert.assertTrue(calculatorTotalEstimate.contains(emailTotalEstimate));
    }

    @AfterMethod(alwaysRun = true)
    public void browserStop() {
        DriverSingleton.closeDriver();
    }
}
