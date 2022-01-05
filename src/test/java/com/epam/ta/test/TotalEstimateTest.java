package com.epam.ta.test;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.page.*;
import com.epam.ta.service.CalculatorDataCreator;
import com.epam.ta.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class TotalEstimateTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
    }

    @Test
    public void totalEstimateEmailTest() {
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .findCalculatorPage()
                .openCalculatorPage()
                .addToEstimate(CalculatorDataCreator.createTestData());
        String calculatorTotalEstimate = calculatorPage.getTotalEstimate();
        String emailTotalEstimate = calculatorPage.getTotalEstimateFromEmail();
        Assert.assertEquals(emailTotalEstimate, calculatorTotalEstimate);
    }

    @AfterMethod(alwaysRun = true)
    public void browserStop() {
        DriverSingleton.closeDriver();
    }
}
