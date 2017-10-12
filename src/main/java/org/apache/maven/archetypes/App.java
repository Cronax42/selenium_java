package org.apache.maven.archetypes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    public static void main(String[] args) {
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

        String generatedUrl = driver.findElement(By.cssSelector("input[ng-model='link.url']")).getText();

        //String expectedUrl = "http://lmgtfy.com/?q=hello+world+Selenium";

        String expectedUrl = "bla";

        assert generatedUrl.equals(expectedUrl);

        driver.quit();
    }
}