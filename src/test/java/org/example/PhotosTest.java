package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class PhotosTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static PhotosPage photosPage;
    public static WebDriver driver;

    @BeforeEach
    public void setup()  {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        photosPage = new PhotosPage(driver);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("loginpage")); }
    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void createAlbumTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();

        profilePage.toPhotosPage();

        photosPage.startCreatingAlbum();
        photosPage.inputAlbumTitle("test");
        photosPage.createAlbum();

        assumeTrue(photosPage.albumIsEmpty());
    }
}