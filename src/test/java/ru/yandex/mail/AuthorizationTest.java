package ru.yandex.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by priymak on 4/10/2017.
 */
public class AuthorizationTest {

    public static WebDriver driver = new ChromeDriver();
    LoginPage loginPage;

    @BeforeTest
    public void setup ()
    {
        String baseUrl = "http://mail.yandex.ua";
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testAuth()
    {
        loginPage.login().sendKeys("testnix1");
        loginPage.pass().sendKeys("gfhjkm13");
        loginPage.enter_button().click();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
        Assert.assertEquals("http://www.yandex.ua/", driver.findElement(By.cssSelector(".mail-Logo-Yandex")).getAttribute("href"));
    }
}
