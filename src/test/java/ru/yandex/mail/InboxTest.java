package ru.yandex.mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by priymak on 4/11/2017.
 */
public class InboxTest {
    public static WebDriver driver = new ChromeDriver();
    InboxPage inboxPage;
    ViewMessagePage viewMessagePage;


    @BeforeTest
    public void setup ()
    {
        String baseUrl = "http://mail.yandex.ua";
        driver.get(baseUrl);
        inboxPage = new InboxPage(driver);
        viewMessagePage = new ViewMessagePage(driver);
    }



    @Test
    public void testOpenMessage()
    {
        String theme = inboxPage.theme(1).getAttribute("title");
        inboxPage.firstmessage(1).click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        Assert.assertEquals(theme,viewMessagePage.theme().getText() );
    }

    @Test
    public void testAvatarIsVisible()
    {
        WebElement element = inboxPage.avatar(2);
        String attribute = element.getAttribute("style");
        boolean cont = attribute.contains("face-contact");
        Assert.assertTrue(cont);
    }

    @Test
    public void testUndeadIcon()
    {
        inboxPage.unread_icon(0).click();
        Assert.assertTrue();
    }



}
