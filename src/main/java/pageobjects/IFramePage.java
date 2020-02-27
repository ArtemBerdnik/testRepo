package pageobjects;

import interfaces.impl.*;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CustomFieldDecorator;
import utils.TestUtils;

public class IFramePage extends AbstractPage {

    @FindBy(css = "#frame")
    private SimpleIFrame frame;

    @FindBy(css = "#div-main-nav")
    private SimpleWebList navigationBar;

    @FindBy(xpath = "//p[contains(text(), 'Who Are We?')]//..//..//div[@class='caption']//p")
    private SimpleTextArea whoAreWeText;

    @FindBy(xpath = "//p[contains(text(), 'Who Are We?')]//..//..//div[@class='section-title']")
    private SimpleTextArea whoAreWeTitle;

    @FindBy(css = "#button-find-out-more")
    private SimpleButton findOutMoreButton;

    @FindBy(css = "#myModal .modal-content")
    private SimpleContainer modalPopup;

    private final String POPUP_TITLE = "Welcome to webdriveruniversity.com";
    private final String POPUP_TEXT = "Welcome to webdriveruniversity.com we sell a wide range of electrical goods such as laptops, game consoles, cameras...";

    private final String WHO_ARE_WE_TITLE = "Who Are We?";
    private final String WHO_ARE_WE_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi elit sapien, tempus sit amet hendrerit volutpat, euismod vitae risus. Etiam consequat, sem et vulputate dapibus, diam enim tristique est, vitae porta eros mauris ut orci. Praesent sed velit odio. Ut massa arcu, suscipit viverra molestie at, aliquet a metus. Nullam sit amet tellus dui, ut tincidunt justo. Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

    public IFramePage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    //===============================Methods=======================================//

    @Step
    public void switchToIFrame() {
        frame.switchToMe();
    }

    @Step
    public void clickFindOutMoreButton() {
        findOutMoreButton.click();
        TestUtils.waitForElementToBeVisible(modalPopup, 3);
    }

    @Step
    private void closeModalPopup() {
        modalPopup.findElementsInContainer(".modal-footer button").get(0).getWrappedElement().click();
        TestUtils.waitForElementToBeInvisible(modalPopup, 3);
    }

    //===============================Checks=========================================//

    @Step
    public void verifyWhoAreWeSection() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(modalPopup.findElementsInContainer("h4").get(0).getText(), POPUP_TITLE),
                () -> Assertions.assertEquals(modalPopup.findElementsInContainer("p").get(0).getText(), POPUP_TEXT));
    }

    @Step
    public void verifyModalWindow() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(whoAreWeTitle.getText(), WHO_ARE_WE_TITLE),
                () -> Assertions.assertEquals(whoAreWeText.getText(), WHO_ARE_WE_TEXT));

        closeModalPopup();

        Assertions.assertFalse(modalPopup.isDisplayed());
    }
}
