package pageobjects;

import interfaces.impl.SimpleButton;
import interfaces.impl.SimpleTextArea;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CustomFieldDecorator;
import utils.LoggerManager;
import utils.TestUtils;

public class AccordionPage extends AbstractPage {

    @FindBy(css = "#manual-testing-accordion")
    private SimpleButton manualTestingAccordion;

    @FindBy(css = "#manual-testing-description")
    private SimpleTextArea testUnderManualTestingAccordion;

    @FindBy(css = "#cucumber-accordion")
    private SimpleButton cucumberAccordion;

    @FindBy(css = "#cucumber-testing-description")
    private SimpleTextArea textUnderCucumberAccordion;

    @FindBy(css = "#automation-accordion")
    private SimpleButton automationTestingAccordion;

    @FindBy(css = "#automation-testing-description")
    private SimpleTextArea textUnderAutomationTestingAccordion;

    @FindBy(css = "#click-accordion")
    private SimpleButton clickingAccordion;

    @FindBy(css = "#timeout")
    private SimpleTextArea textUnderClickingAccordion;

    @FindBy(css = "[id='text-appear-box']")
    private SimpleTextArea messageAboutLoading;

    private final String MESSAGE_UNDER_MANUAL_ACCORDION = "Manual testing has for some time been the most popular way to test code. For this method, the tester plays an important role of end user and verifies that all the features of the application work correctly. Manual testing however is on the decline. Companies and developers have realised the efficiency, accuracy and cost savings that is possible by adopting the use of automation testing.";
    private final String MESSAGE_UNDER_CUCUMBER_ACCORDION = "Cucumber (BDD) simplifies the requirement capturing process. Requirements can be captured, broken down and simplified effortlessly; making the captured requirements readable to anyone within the organisation and in turn providing the required details and backbone to develop accurate test cases also known as ‘Feature Files’.";
    private final String MESSAGE_UNDER_AUTOMATION_ACCORDION = "Automation testing has been steadily grown in popularity these past few years thanks to the time/ cost savings and efficiency that it offers. Companies throughout the world have or plan to use automation testing to rapidly speed up their test capabilities. Automation test engineers are in great demand and offer an average salary of £45,000+ (2018). Now is a great time to learn about automation test engineering and this course has been carefully developed to slowly introduce you from the basics, all the way to building advanced frameworks.";
    private final String MESSAGE_UNDER_CLICKING_ACCORDION = "This text has appeared after 5 seconds!";
    private final String MESSAGE_ABOUT_COMPLETED_LOADING = "LOADING COMPLETE.";

    public AccordionPage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    //================================Methods====================================

    @Step
    public void clickManualAccordion() {
        manualTestingAccordion.click();
        LoggerManager.info("manual accordion is clicked");
    }

    @Step
    public void clickCucumberAccordion() {
        cucumberAccordion.click();
        LoggerManager.info("cucumber accordion is clicked");

    }

    @Step
    public void clickAutomationAccordion() {
        automationTestingAccordion.click();
        LoggerManager.info("automation accordion is clicked");

    }

    @Step
    public void clickAccordionWithDelay() {
        TestUtils.waitForElementToHaveSpecificText(messageAboutLoading, MESSAGE_ABOUT_COMPLETED_LOADING, 10);
        clickingAccordion.click();
        LoggerManager.info("click accordion is clicked");
    }

    //================================Checks====================================

    @Step
    public void checkTextUnderManualAccordion() {
        verifyTextInElement(testUnderManualTestingAccordion, MESSAGE_UNDER_MANUAL_ACCORDION);
    }

    @Step
    public void checkTextUnderAutomationAccordion() {
        verifyTextInElement(textUnderAutomationTestingAccordion, MESSAGE_UNDER_AUTOMATION_ACCORDION);
    }

    @Step
    public void checkTextUnderCucumberAccordion() {
        verifyTextInElement(textUnderCucumberAccordion, MESSAGE_UNDER_CUCUMBER_ACCORDION);
    }

    @Step
    public void checkTextUnderClickingAccordion() {
        verifyTextInElement(textUnderClickingAccordion, MESSAGE_UNDER_CLICKING_ACCORDION);
    }
}
