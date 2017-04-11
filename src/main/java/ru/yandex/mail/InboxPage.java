package ru.yandex.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by priymak on 4/11/2017.
 */
public class InboxPage {

    public WebDriver driver;

    public InboxPage(WebDriver driver)
    {
        this.driver = driver;
        Cookie session_id = new Cookie("Session_id", "3:1491899899.5.0.1491899899698:gqQxww:4b.0|230979967.0.2|4:128584.223226.atFLJlaJVMdZPFc-4Q_1zlCAofs");
        Cookie sessionid2 = new Cookie ("sessionid2", "3:1491899899.5.0.1491899899698:gqQxww:4b.1|230979967.0.2|4:128584.265961.dujS8Uou1aLZtUWNgonNZf0pJyw");
        driver.manage().addCookie(session_id);
        driver.manage().addCookie(sessionid2);
    }

    public WebElement firstmessage ()
    {
       return driver.findElement(By.cssSelector(".mail-MessageSnippet-Wrap:not(.is-pinned)')[0]"));
    }
}
