import org.openqa.selenium.By;
import org.testng.annotations.Test;
import parent.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HerokkuTest extends BaseTest {
    @Test
    public void loginPagePasswordError () {
        browser.get("https://the-internet.herokuapp.com/login");
        browser.findElement(By.xpath("//*[@name='username']")).sendKeys("tomsmith");
        browser.findElement(By.xpath("//*[@name='password']")).sendKeys("Sup");
        browser.findElement(By.xpath("//*[@class='radius']")).click();
        assertEquals(browser.findElement(By.xpath("//div[@class='flash error']")).getText(), "Your password is invalid!\n×");
    }

    @Test
    public void loginPageUsernameError () {
        browser.get("https://the-internet.herokuapp.com/login");
        browser.findElement(By.xpath("//*[@name='username']")).sendKeys("tom");
        browser.findElement(By.xpath("//*[@name='password']")).sendKeys("SuperSecretPassword!");
        browser.findElement(By.xpath("//*[@class='radius']")).click();
        assertEquals(browser.findElement(By.xpath("//div[@class='flash error']")).getText(), "Your username is invalid!\n×");
    }

    @Test
    public void loginPageCorrect() {
        browser.get("https://the-internet.herokuapp.com/login");
        browser.findElement(By.xpath("//*[@name='username']")).sendKeys("tomsmith");
        browser.findElement(By.xpath("//*[@name='password']")).sendKeys("SuperSecretPassword!");
        browser.findElement(By.xpath("//*[@class='radius']")).click();
        boolean logoutBtnIsPresent = browser.findElement(By.xpath("//*[@class='button secondary radius']")).isDisplayed();
        assertTrue(logoutBtnIsPresent);
    }
}
