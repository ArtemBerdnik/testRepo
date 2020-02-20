import base.BaseTest;
import base.TestContext;
import org.junit.jupiter.api.Test;
import pageobjects.FileUploadPage;
import utils.FilesManager;

public class UploadFileTest extends BaseTest {

    private FileUploadPage fileUploadPage = new FileUploadPage(TestContext.getWebDriverManager().getCurrentDriver().getWebDriver());
    private static final String FILE_TO_BE_UPLOADED = FilesManager.getFullPath("testFile.txt");

    @Test
    void checkFileDownloading() {
        homePage.openFileUploadPage();
        fileUploadPage.downloadFile(FILE_TO_BE_UPLOADED);
        fileUploadPage.checkFileIsDownloaded();
    }
}
