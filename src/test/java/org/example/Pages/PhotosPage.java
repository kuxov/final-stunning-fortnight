package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.Tests.PhotosTest.driver;

public class PhotosPage {
    @FindBy(xpath = "//*[contains(@class, 'button-pro __sec __small')]")
    public WebElement createPhotoAlbum;

    @FindBy(xpath = "//textarea")
    public WebElement textFieldEditor;

    @FindBy(xpath = "//*[@id='hook_FormButton_button_album_create']")
    public WebElement confirm;

    @FindBy(xpath = "//*[contains(@id, 'field_query')]")
    public WebElement searchField;
    public PhotosPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void inputSearchTitle()
    {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys("test2");
    }

    public boolean albumFound()
    {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.xpath("//*[contains(text(), 'test2') and not (contains(@id, 'field_query'))]")));
        return element != null;
    }
    public boolean albumIsEmpty()
    {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.xpath("//*[contains(text(), 'Альбом пуст')]")));
        return element != null;
    }

    public PhotosPage startCreatingAlbum()
    {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(createPhotoAlbum));
        createPhotoAlbum.click();
        return this;
    }

    public PhotosPage inputAlbumTitle(String text)
    {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(textFieldEditor));
        textFieldEditor.sendKeys(text);
        return this;
    }

    public void createAlbum()
    {
        confirm.click();
    }
}