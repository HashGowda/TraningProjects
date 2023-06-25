package BrowserStack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceTest extends BrowserStackBaseTest {

    public void doLogin(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test(priority = 1)
    public void checkInventoryItemTest(){
        doLogin();
        Assert.assertTrue(driver.findElements(By.xpath("(//div[@class='inventory_item'])[1]")).size() == 6);
    }

    @Test(priority = 2)
    public void checkAddToCartButtonTest(){
        doLogin();
        Assert.assertTrue(driver.findElements(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).size()==6);
    }
}
