package com.thoughtworks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FunctionalTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        }

        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() throws Exception {
        //Close the browser
        driver.quit();
    }

    @Test
    public void test_baidu_search() throws Exception {

        // And now use this to visit Baidu
        driver.get("http://www.baidu.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.baidu.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("wd"));

        // Enter something to search for
        element.sendKeys("thoughtworks");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Wait for the page to load, timeout after 5 seconds
        new WebDriverWait(driver, 5).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("thoughtworks");
            }
        });

        // Should see: "thoughtworks"
        System.out.println("Page title is: " + driver.getTitle());
        assertThat(driver.getTitle(), is("thoughtworks_百度搜索"));
    }
}
