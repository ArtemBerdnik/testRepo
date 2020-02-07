package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LoggerManager;
import utils.TestUtils;

import static enums.CaptionsForSectionsInHomePage.CONTACT_US;
import static enums.CaptionsForSectionsInHomePage.LOGIN_PORTAL;

public class HomePage extends AbstractPage{

    @FindBy(css = "#nav-title")
    private WebElement homeButton;

    @FindBy(css = "#contact-us")
    private WebElement contactUsPage;

    @FindBy(css = "#button-clicks")
    private WebElement buttonClicksPage;

    @FindBy(css = "#to-do-list")
    private WebElement toDoListPage;

    @FindBy(css = "[href ='Accordion/index.html']")
    private WebElement accordionPage;

    @FindBy(css = "#udemy-promo-video")
    private WebElement promoVideo;

    @FindBy(css = "#play-icon-title")
    private WebElement playVideoButton;

    @FindBy(css = "#contact-us")
    private WebElement contactUsButton;

    @FindBy(css = "#contact-us .section-title")
    private WebElement contactUsSectionHeader;

    @FindBy(css = "#contact-us .caption p")
    private WebElement contactUsSectionCaption;

    @FindBy(css = "#login-portal")
    private WebElement loginPortalButton;

    @FindBy(css = "#login-portal .section-title")
    private WebElement loginPortalSectionHeader;

    @FindBy(css = "#login-portal .caption p")
    private WebElement loginPortalSectionCaption;

    //===========================Methods===================================//

    @Step
    public void openLoginPortalPage() {
        TestUtils.clickAndSwitchToNewTab(driver, loginPortalButton);
        LoggerManager.info("Opened Login Portal Page");
    }

    @Step
    public void openContactUsPage() {
        TestUtils.clickAndSwitchToNewTab(driver, contactUsPage);
        LoggerManager.info("Opened Contact Us Page");
    }

    @Step
    public void openButtonsClickPage() {
        TestUtils.clickAndSwitchToNewTab(driver, buttonClicksPage);
        LoggerManager.info("Opened Button Clicks Page");
    }

    @Step
    public void openToDoListPage() {
        TestUtils.clickAndSwitchToNewTab(driver, toDoListPage);
        LoggerManager.info("Opened To Do List Page");
    }

    @Step
    public void openAccordionPage() {
        TestUtils.clickAndSwitchToNewTab(driver, accordionPage);
        LoggerManager.info("Opened Accordion Page");
    }


    //===========================Assertions================================//

    @Step
    public void verifyTextForLoginFormSection() {
        verifyTextInElement(loginPortalSectionCaption, LOGIN_PORTAL.getName());
        LoggerManager.info("Caption is " + loginPortalSectionCaption.getText());
        TestUtils.takeScreenshot(driver);
    }

    @Step
    public void verifyTextForContactUsSection() {
        verifyTextInElement(contactUsSectionCaption, CONTACT_US.getName());
        LoggerManager.info("Caption is " + contactUsSectionCaption.getText());
        TestUtils.takeScreenshot(driver);
    }


}
