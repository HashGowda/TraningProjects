package Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectUsingCustom {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origin=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(co);
    }


    @Test
    public void launch() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.bstackdemo.com/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='sort']//select")).click();
        String option = "Highest to lowest";
        WebElement dropDown = driver.findElement(By.xpath("//select/option[contains(text(), '" + option + "')]"));
        Thread.sleep(2000);
        dropDown.click();
        System.out.println("Selected option is "+dropDown.getText());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
