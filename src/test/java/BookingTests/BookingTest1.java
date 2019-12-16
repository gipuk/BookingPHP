package BookingTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class BookingTest1 {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 20);

    @BeforeAll

    public void beforeAll() {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get("https://phptravels.net");
        String webTitle = driver.getTitle();
        System.out.print(webTitle);

        boolean verify1 = driver.getTitle().contains("PHPTRAVELS | Travel Technology Partner");
        if (verify1) {
            System.out.println(" - You are in PHPTravels Main Page");
        } else {
            System.out.println(" - You're not in PHPTravels Main Page");
            driver.quit();
        }

        driver.manage().window().maximize();

        //login to account
        driver.findElement(By.cssSelector("[class=\"dropdown dropdown-login dropdown-tab\"]")).click();
        driver.findElement(By.cssSelector("[class=\"dropdown-item active tr\"]")).click();
        driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys("user@phptravels.com");
        driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys("demouser");
        driver.findElement(By.cssSelector(".btn-block.loginbtn")).click();
        driver.get("https://phptravels.net");
    }

     @AfterAll
     public void afterAll() {
        driver.close();
     }

    @Test
    public void startWebDriver() {

        //login to account
        driver.findElement(By.cssSelector("[class=\"dropdown dropdown-login dropdown-tab\"]")).click();
        driver.findElement(By.cssSelector("[class=\"dropdown-item active tr\"]")).click();
        driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys("user@phptravels.com");
        driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys("demouser");
        driver.findElement(By.cssSelector(".btn-block.loginbtn")).click();
        driver.get("https://phptravels.net");

        //select destination
        driver.findElement(By.cssSelector("[id='s2id_autogen1']")).click();
        driver.findElement(By.cssSelector("[id='select2-drop'] .select2-input")).sendKeys("Poznan");
        //driver.findElement(By.cssSelector("ul.select2-result-sub .select2-result-label .select2-match")).click();
        WebElement obj = wait.until(presenceOfElementLocated(By.cssSelector("ul.select2-result-sub .select2-result-label .select2-match")));
        obj.click();

        //select dates
        driver.findElement(By.cssSelector("[id='checkin']")).click();
        driver.findElement(By.cssSelector("[id='checkin']")).sendKeys("15/02/2020");
        driver.findElement(By.cssSelector("[id=checkout]")).click();
        driver.findElement(By.cssSelector("[id=checkout]")).sendKeys("19/02/2020");

        //select 3 Adults
        driver.findElement(By.cssSelector("[value='2']")).isDisplayed();
        driver.findElement(By.cssSelector("div.o2 > div > div.form-icon-left > div > span >.bootstrap-touchspin-up")).click();

        //select 1 Child
        driver.findElement(By.cssSelector("[name='children']")).isDisplayed();
        driver.findElement(By.cssSelector("div.\\30 1 > div > div > div > span >.bootstrap-touchspin-up")).click();

        //click search button
        driver.findElement(By.cssSelector("[class=\"col-md-2 col-xs-12 o1\"]")).click();

        //search results page - źle
        Assert.assertTrue(driver.getTitle().equals("Hotels Results"));

    }
}

