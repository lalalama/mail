package ru.yandex.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by priymak on 4/10/2017.
 */
public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement login()
    {
        return driver.findElement(By.cssSelector("#nb-1 > span > input"));
    }

    public WebElement pass()
    {
        return driver.findElement(By.cssSelector("#nb-2 > span > input"));
    }


    public WebElement enter_button()
    {
        return driver.findElement(By.cssSelector(".nb-group-start"));
    }


    public WebElement phone_field()
    {
        return driver.findElement(By.cssSelector("#nb-4 > span._nb-input-content > input"));
    }

    public WebElement promo_button()
    {
        return driver.findElement(By.cssSelector("#nb-5"));
    }

    public WebElement captcha_field ()
    {
        return driver.findElement(By.cssSelector("#nb-6"));
    }

    public WebElement ios_download_link()
    {
        return driver.findElement(By.cssSelector("body > div.b-page.b-page_uk > div.new-right > div > div > div.left-panel > div.market > div:nth-child(2) > a"));
    }

    public WebElement android_download_link()
    {
        return driver.findElement(By.cssSelector("body > div.b-page.b-page_uk > div.new-right > div > div > div.left-panel > div.market > div:nth-child(1) > a"));
    }

}
