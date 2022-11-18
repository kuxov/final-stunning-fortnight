package org.example.Pages;
import org.example.Utils.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ProfilePage {
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[contains(@class, 'html5-upload-link')]")
    private WebElement uploadPhotoBtn;
    @FindBy(xpath = "//*[contains(text(), 'Фото')]")
    private WebElement goToPhotos;
    @FindBy(xpath = "//*[contains(text(), 'Установить')]")
    private WebElement confirmProfilePicUpload;
    @FindBy(xpath = "//*[contains(@class, 'tico ellip')]")
    private WebElement userMenu;
    public String getUserName() {
        String userName = userMenu.getText();
        return userName; }

    public void toPhotosPage() {
         new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(goToPhotos));
        goToPhotos.click(); }

    public void uploadPhoto()
    {
        uploadPhotoBtn.sendKeys(ConfProperties.getProperty("path_to_pic"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(confirmProfilePicUpload));
        confirmProfilePicUpload.click();
    }

    public boolean checkIfPhotoUploaded()
    {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.xpath("//*[contains(@id, 'viewImageLinkId')]")));
        return element != null;
    }

}
