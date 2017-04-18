package ru.yandex.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by priymak on 4/11/2017.
 */
public class ViewMessagePage
{
    public WebDriver driver;

    public ViewMessagePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement theme ()
    {
       return driver.findElement(By.cssSelector(".mail-Message-Toolbar-Subject_message"));
    }

}
