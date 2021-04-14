package DemoTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTestNGTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(chromeOptions);
        driver.get("https://www.google.com/");
    }

    @Test(priority = 1, groups = "regression")
    public void testCase1() {
    WebElement searchText = driver.findElement(By.name("q"));
    searchText.sendKeys("Selenium Java");
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
        searchText.click();
    }

    @Test(priority = 2, groups = "smoke")
    public void testCase2(){
    String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Google");
    }

    @Test(priority = 3, groups = "smoke")
    public void testCase3(){
       boolean b = driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
    }

    @AfterMethod
    public void tearDown(){
    driver.quit();
    }
}
