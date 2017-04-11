package ru.yandex.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by priymak on 4/10/2017.
 */
public class LoginPageTest {

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
    public void testPhonePromo ()
    {
        loginPage.phone_field().click();
        loginPage.phone_field().sendKeys("380000000000");
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
        loginPage.captcha_field().sendKeys("a");
        Assert.assertTrue(loginPage.promo_button().isEnabled());
    }
    @Test
    public void testIosDownloadLink()
    {
      Assert.assertEquals("https://appmetrica.yandex.com/serve/600845704272901013?source=hostroot_desktop",loginPage.ios_download_link().getAttribute("href"));
    }

    @Test
    public void testAndroidDownloadLink()
    {
        Assert.assertEquals("https://appmetrica.yandex.com/serve/96329419219606291?source=hostroot_desktop",loginPage.android_download_link().getAttribute("href"));
    }

}


