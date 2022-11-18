package org.example;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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
        driver.get(ConfProperties.getProperty("loginpage"));

        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
    }
    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @DisplayName("creating an album test")
    @ParameterizedTest
    @ValueSource(strings = { "test1", "test2", "test3" })
    @Disabled //чтобы не насоздавал миллион альбомов...
    public void createAlbumTest(String name) {
        profilePage.toPhotosPage();
        photosPage.startCreatingAlbum();
        photosPage.inputAlbumTitle(name);
        photosPage.createAlbum();
        assumeTrue(photosPage.albumIsEmpty());
    }
}