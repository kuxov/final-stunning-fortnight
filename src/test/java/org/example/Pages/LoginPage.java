package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    public LoginPage inputLogin(String login) {
        loginField.sendKeys(login);
    return this;
    }

    public LoginPage inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    return this;}

    public LoginPage clickLoginBtn() {
        loginBtn.click();
    return this;}

    public String getErrMsg(){
        return passErr.getText();
    }

}
