package com.epam.ta.steps;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.model.CalculatorData;
import com.epam.ta.page.EmailServicePage;
import com.epam.ta.page.GoogleCloudCalculatorPage;
import com.epam.ta.page.InboxEmailPage;
import org.openqa.selenium.WebDriver;

public class GoogleCloudCalculatorSteps {

    private final WebDriver driver;
    private final GoogleCloudCalculatorPage calculatorPage;

    public GoogleCloudCalculatorSteps(GoogleCloudCalculatorPage calculatorPage) {
        this.driver = DriverSingleton.getDriver();
        this.calculatorPage = calculatorPage;
    }

    public void addToEstimate(CalculatorData data) {
        calculatorPage.selectTabComputeEngine();
        calculatorPage.setNumberOfInstance(data.getInstances());
        calculatorPage.selectOS(data.getOs());
        calculatorPage.selectVMClass(data.getVmClass());
        calculatorPage.selectMachineSeries(data.getSeries());
        calculatorPage.selectInstanceType(data.getInstanceType());
        calculatorPage.setAddGPUsCheckBox();
        calculatorPage.selectGPUType(data.getGpuType());
        calculatorPage.selectNumberOfGPUs(data.getNumberOfGPUs());
        calculatorPage.selectSSDSize(data.getSsd());
        calculatorPage.selectLocation(data.getLocation());
        calculatorPage.selectCommittedUsage(data.getCommittedUsage());
        calculatorPage.addConfigurationToEstimate();
    }

    public String getTotalEstimateFromEmail() {
        String calculatorPageHandle = DriverSingleton.switchToNewTab();
        InboxEmailPage inboxEmailPage = new EmailServicePage(driver)
                .openPage()
                .createRandomEmail()
                .openInboxEmailPage();
        String email = inboxEmailPage.getEmail();
        String emailPage = DriverSingleton.switchToTab(calculatorPageHandle);
        calculatorPage.switchToCalculatorFrame();
        calculatorPage.sendEmail(email);
        DriverSingleton.switchToTab(emailPage);
        return inboxEmailPage.getTotalEstimate();
    }
}
