package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "//*[contains(@id, 'field_email')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(@value, 'Войти в Одноклассники')]")
    private WebElement loginBtn;

    @FindBy (xpath = "//*[@id=\"field_password\"]")
    private WebElement passwdField;

    @FindBy(xpath = "//*[contains(@class, 'input-e login_error')]")
    private WebElement passErr;
    public void inputLogin(String login) {
        loginField.sendKeys(login); }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }

    public void clickLoginBtn() {
        loginBtn.click(); }

    public String getErrMsg(){
        return passErr.getText();
    }

}
