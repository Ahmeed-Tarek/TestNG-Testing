package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    private WebDriver driver;
    private final By userName = By.id("inputUsername");
    private final By password = By.id("inputPassword");
    private final By loginButton = By.id("loginButton");

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_LoginPage userName(String userNameText){

        Utility.senData(driver, userName,userNameText);
        return this;
    }
    public P01_LoginPage enterPassword(String passwordText){

        Utility.senData(driver, password, passwordText);
        return this;
    }
    public P02_HomePage clickLoginButton(){

        Utility.clickOnElement(driver, loginButton);
        return new P02_HomePage(driver);

    }



}
