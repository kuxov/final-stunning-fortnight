package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeEach
   public void setup()  {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("loginpage")); }

    @AfterEach
    public void teardown(){
        driver.quit();
    }
    @Test
    public void invalidPassTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd("123456");
        loginPage.clickLoginBtn();
        assertEquals("Неправильно указан логин и/или пароль", loginPage.getErrMsg());
        }
    @Test
    public void loginTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        String user = profilePage.getUserName();
        assertEquals("technoPol20 technoPol20", user);
        }
}