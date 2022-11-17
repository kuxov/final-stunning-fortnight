package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.PhotosTest.driver;

public class ProfilePage {
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[contains(text(), 'Фото')]")
    private WebElement goToPhotos;
    @FindBy(xpath = "//*[contains(@class, 'tico ellip')]")
    private WebElement userMenu;
    public String getUserName() {
        String userName = userMenu.getText();
        return userName; }

    public void toPhotosPage() {
         new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(goToPhotos));
        goToPhotos.click(); }
}
