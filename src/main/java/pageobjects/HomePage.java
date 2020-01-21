package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.TestUtils;

import static enums.CaptionsForSectionsInHomePage.CONTACT_US;
import static enums.CaptionsForSectionsInHomePage.LOGIN_PORTAL;

public class HomePage extends AbstractPage{

    @FindBy(css = "#nav-title")
    private WebElement homeButton;

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


    //===========================Assertions================================//
    public void verifyTextForLoginFormSection() {
        verifyTextInElement(loginPortalSectionCaption, LOGIN_PORTAL.getName());
        TestUtils.takeScreenshot(driver);
    }
    public void verifyTextForContactUsSection() {
        verifyTextInElement(contactUsSectionCaption, CONTACT_US.getName());
        TestUtils.takeScreenshot(driver);
    }


}
