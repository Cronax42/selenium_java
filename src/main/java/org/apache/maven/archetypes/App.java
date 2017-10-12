package org.apache.maven.archetypes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class testje {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("lmgtfy.com")

        WebElement element = driver.findElement(By.cssSelector("div.search-term-input input"));

        element.sendKeys("hello world Selenium");
        element.submit();

        pagetitle = driver.getTitle();

        System.out.println(pagetitle);
        
        driver.quit();
    }
}