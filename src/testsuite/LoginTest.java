package testsuite;


import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find username field name enter valid username
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        //find password field and enter valid password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        //find login button and click on login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='submit-button btn_action']"));
        loginButton.click();
        //user click on logon button and verify the text "PRODUCT"
        String expectedMessage = "Products";
        String actualMessage = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //find username field name enter valid username
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        //find password field and enter valid password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        //find login button and click on login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='submit-button btn_action']"));
        loginButton.click();
        //verify that six products are displayed on page
        int displayedSixProductOnPage = 6;
        List<WebElement> actualTotalProductDisplayed = driver.findElements(By.cssSelector("div.inventory_item"));
        Assert.assertEquals(displayedSixProductOnPage,actualTotalProductDisplayed.size());
    }
    @After
    //close the browser
    public void tearDown(){
        // closeBrowser();
      }

}




