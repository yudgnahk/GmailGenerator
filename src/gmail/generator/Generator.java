/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gmail.generator;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author haleduykhang
 */
public class Generator {

    private WebDriver driver;
    private String mainURL;

    public Generator() {

        DesiredCapabilities dc;
        dc = DesiredCapabilities.chrome();
        System.setProperty("http.proxyHost", "107.17.92.18");
        System.setProperty("http.proxyPort", "8080");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-extensions");
        dc.setCapability(ChromeOptions.CAPABILITY, options);
        this.driver = new ChromeDriver(dc);

        this.setMainURL("https://accounts.google.com/SignUp?hl=en");
    }

    public void setMainURL(String mainURL) {
        this.mainURL = mainURL;
        this.driver.get(mainURL);
    }

    public void close() {
        this.driver.quit();
    }

    public void generateGmailAccount(String username, String password,
            String firstname, String lastname, String currentEmail) throws InterruptedException {

        WebElement firstNameElement = driver.findElement(By.id("FirstName"));
        firstNameElement.sendKeys(firstname);

        WebElement lastNameElement = driver.findElement(By.id("LastName"));
        lastNameElement.sendKeys(lastname);

        WebElement usernameElement = driver.findElement(By.id("GmailAddress"));
        usernameElement.sendKeys(username);

        WebElement passwordElement = driver.findElement(By.id("Passwd"));
        passwordElement.sendKeys(password);

        WebElement passwordAgainElement = driver.findElement(By.id("PasswdAgain"));
        passwordAgainElement.sendKeys(password);

        driver.findElement(By.id("BirthMonth")).click();
        driver.findElement(By.id(":2")).click();

        WebElement birthDayElement = driver.findElement(By.id("BirthDay"));
        birthDayElement.sendKeys("27");

        WebElement birthYearElement = driver.findElement(By.id("BirthYear"));
        birthYearElement.sendKeys("1993");

        driver.findElement(By.id("Gender")).click();
        driver.findElement(By.id(":f")).click();

        WebElement recoveryElement = driver.findElement(By.id("RecoveryEmailAddress"));
        birthDayElement.sendKeys(currentEmail);

        WebElement button = driver.findElement(By.id("submitbutton"));
        button.click();

        driver.findElement(By.id("tos-scroll-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("tos-scroll-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("iagreebutton")).click();

    }

}
