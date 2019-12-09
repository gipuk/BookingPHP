package BookingTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class BookingTest1 {


    @Test

    public void startWebDriver() {

        WebDriver driver = new ChromeDriver();
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

        //select destination
        driver.findElement(By.cssSelector("[id='s2id_autogen1']")).click();
        driver.findElement(By.cssSelector("[id='select2-drop'] .select2-input")).sendKeys("Poznan");
        //driver.findElement(By.cssSelector("ul.select2-result-sub .select2-result-label .select2-match")).click();
        WebElement obj = wait.until(presenceOfElementLocated(By.cssSelector("ul.select2-result-sub .select2-result-label .select2-match")));
        obj.click();


        //select dates
        driver.findElement(By.cssSelector("[id='checkin']")).click();
        driver.findElement(By.cssSelector("[id='checkin']")).sendKeys("15/01/2020");
        driver.findElement(By.cssSelector("[id=checkout]")).click();
        driver.findElement(By.cssSelector("[id=checkout]")).sendKeys("19/01/2020");

        //click search button
        driver.findElement(By.cssSelector("[class=\"col-md-2 col-xs-12 o1\"]")).click();

        //search results page - źle
        Assert.assertTrue(driver.getTitle().equals("Hotels Listings"));



        driver.manage().deleteAllCookies();
        driver.close();


    }
}

