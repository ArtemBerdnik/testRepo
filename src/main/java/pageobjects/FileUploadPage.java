package pageobjects;

import interfaces.impl.SimpleButton;
import interfaces.impl.SimpleFileUploadInput;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CustomFieldDecorator;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUploadPage extends AbstractPage {

    @FindBy(css = "#myFile")
    private SimpleFileUploadInput fileNameField;

    @FindBy(css = "#submit-button")
    private SimpleButton submitButton;

    public FileUploadPage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    private static final String EXPECTED_MESSAGE = "Your file has now been uploaded!";

    //==================Methods=================================

    @Step
    public void downloadFile(String fileName) {
        fileNameField.uploadFile(fileName);
        submitButton.click();
    }

    //==================Checks==================================

    @Step
    public void checkFileIsDownloaded() {
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), EXPECTED_MESSAGE);
    }
}
