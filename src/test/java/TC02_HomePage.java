import Pages.P01_LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC02_HomePage {
    private WebDriver driver;

    @BeforeMethod
    public void setupDriver(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/index.html");
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void logoutTC(){
        new P01_LoginPage(driver).userName("admin")
                .enterPassword("admin")
                .clickLoginButton()
                .clickInLogout();
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://aa-practice-test-automation.vercel.app/Pages/main.html");
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
