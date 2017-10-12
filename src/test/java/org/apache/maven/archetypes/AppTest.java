package org.apache.maven.archetypes;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest {

    @Test
    public void Test () {
        System.setProperty("webdriver.chrome.driver", "/home/sean/projects/selenium_java/src/main/resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://lmgtfy.com");

        driver.findElement(By.cssSelector("div.search-term-input input")).sendKeys("hello world Selenium");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(By.cssSelector("div.panel-success")).isDisplayed();
            }
        });

        String generatedUrl = driver.findElement(By.cssSelector("input[ng-model='link.url']")).getAttribute("value");

        String expectedUrl = "http://lmgtfy.com/?q=hello+world+Selenium";

        assertEquals(expectedUrl, generatedUrl);

        driver.quit();
    }
}
