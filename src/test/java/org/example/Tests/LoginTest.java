package org.example.Tests;
import org.example.Utils.ConfProperties;
import org.example.Pages.LoginPage;
import org.example.Pages.ProfilePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeEach
   public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("loginpage"));

        loginPage
                .inputLogin(ConfProperties.getProperty("login"));
    }
    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    @DisplayName("invalid password auth test")
    public void invalidPassTest() {
        loginPage
                .inputPasswd(ConfProperties.getProperty("invalid_pass"))
                .clickLoginBtn();
        assertEquals("Неправильно указан логин и/или пароль", loginPage.getErrMsg());
        }
    @Test
    @DisplayName("valid username and password auth test")
    public void loginTest() {
        loginPage
                .inputPasswd(ConfProperties.getProperty("password"))
                .clickLoginBtn();
        String user = profilePage.getUserName();
        assertEquals(ConfProperties.getProperty("bot"), user);
        }

    @Test
    @DisplayName("upload photo test")
    public void updPhotoTest() {
        loginPage
                .inputPasswd(ConfProperties.getProperty("password"))
                .clickLoginBtn();
        profilePage.uploadPhoto();
        assumeTrue(profilePage.checkIfPhotoUploaded());
    }
}