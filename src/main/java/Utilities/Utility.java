package Utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class Utility {

    private static String SCREENSHOT_PATH = "test-outputs/Screenshots/";

    /**
     * Utility  Function for Finding, clicking on element after waiting to be clickable
     * @param driver
     * @param locator
     */
    //TODO: Click on any Element
    public static void clickOnElement(WebDriver driver , By locator){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
    //TODO: Send Any Data
    public static void senData(WebDriver driver, By locator, String text){
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }
    //TODO: Selecting from Dropdown menu


    //TODO: Taking ScreenShots
    public static void takingScreenShot(WebDriver driver,String screenShotName) throws IOException {
        File screenSrc = ((TakesScreenshot)driver) .getScreenshotAs(OutputType.FILE);
        File screenDest =new File(SCREENSHOT_PATH+screenShotName+".png");
        FileUtils.copyFile(screenSrc,screenDest);
        // When need add attachment to allure report
        Allure.addAttachment(screenShotName, Files.newInputStream(Path.of(screenDest.getPath())));


    }
    //TODO: General Wait
    //TODO: Uploading File using ROBOT
    //TODO: Time Stamp


}
