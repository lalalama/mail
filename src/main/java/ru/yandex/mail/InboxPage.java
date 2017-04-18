package ru.yandex.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by priymak on 4/11/2017.
 */
public class InboxPage {

    public WebDriver driver;

    public InboxPage(WebDriver driver)
    {
        this.driver = driver;
        driver.manage().deleteAllCookies();
        Cookie yandex_login = new Cookie("yandex_login", "testnix1");
        Cookie session_id = new Cookie("Session_id", "3:1491899899.5.0.1491899899698:gqQxww:4b.0|230979967.0.2|4:128584.223226.atFLJlaJVMdZPFc-4Q_1zlCAofs");
        Cookie sessionid2 = new Cookie ("sessionid2", "3:1491899899.5.0.1491899899698:gqQxww:4b.1|230979967.0.2|4:128584.265961.dujS8Uou1aLZtUWNgonNZf0pJyw");
        driver.manage().addCookie(yandex_login);
        driver.manage().addCookie(session_id);
        driver.manage().addCookie(sessionid2);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);


        Set<Cookie> cookiesForCurrentURL = driver.manage().getCookies();
        for (Cookie cookie : cookiesForCurrentURL) {
            System.out.println(" Cookie Name - " + cookie.getName()
                    + " Cookie Value - "  + cookie.getValue());
        }
    }

    public WebElement firstmessage (int index)
    {
      return driver.findElement(By.cssSelector(".mail-MessageSnippet-Wrap:nth-child(" + index +")"));
    }


    public WebElement theme (int index)
    {
        return driver.findElement(By.cssSelector(".mail-MessageSnippet-Item_subject:nth-child(" + index + ") > span"));
    }

    public WebElement avatar (int index)
    {
       List<WebElement> avatars = driver.findElements(By.cssSelector(".mail-User-Picture_with_link"));
       return avatars.get(index);
    }

    public WebElement unread_icon (int index)
    {
        List<WebElement> undead_icons = driver.findElements(By.cssSelector(".toggles-svgicon-on-active"));
        return undead_icons.get(index);
    }

}
