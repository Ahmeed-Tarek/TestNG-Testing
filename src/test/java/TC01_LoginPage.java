import Pages.P01_LoginPage;
import Utilities.DataUtil;
import Utilities.Utility;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class TC01_LoginPage {
    private WebDriver driver;
    String fUserName= new Faker().name().username();

    @BeforeMethod(alwaysRun = true)
    public void setupDriver() throws IOException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(DataUtil.getPropertyValue("Environment","LOGIN_URL"));
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }
    // Allure Annotations
    @Description("This Test case verify that user login is successful ")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("E.Ahmed")
    @Link(name = "business Document",url = "www.google.com")
    @Issue("www.google.com")
    @TmsLink("www.jira.com/zephyr/TC50")
    @Epic("Web Panel")
    @Feature("Panel")
    @Story("Valid Login in panel")
    @Test
    public void validLoginTC() throws IOException {
//        new P01_LoginPage(driver).userName("admin")
//                .enterPassword("admin")
//                .clickLoginButton();
        // Need to reading Data from Json File
        new P01_LoginPage(driver).userName(DataUtil.getJsonData("validLoginData", "username"))
                .enterPassword(DataUtil.getJsonData("validLoginData", "password"))
                .clickLoginButton();
        Utility.takingScreenShot(driver,"screenLoginTC");
        Assert.assertEquals(driver.getCurrentUrl(),DataUtil.getPropertyValue("Environment","HOME_URL"));
    }
    @Test
    public void inValidLoginTC() throws IOException {
        new P01_LoginPage(driver).userName(fUserName)
                .enterPassword(DataUtil.getJsonData("validLoginData", "password"))
                .clickLoginButton();
        driver.switchTo().alert().accept();
        Assert.assertNotEquals(driver.getCurrentUrl(),DataUtil.getPropertyValue("Environment","HOME_URL"));
    }
    @AfterMethod(alwaysRun = true)
    public void quit(){
        driver.quit();
    }
}
