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


public class BookingNoStart {


    @Test

    public void startWebDriver() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get("https://www.phptravels.net/thhotels/search/poland/poznan/22-01-2020/25-01-2020/2/0");
        String webTitle = driver.getTitle();
        System.out.print(webTitle);

        boolean verify1 = driver.getTitle().contains("Hotels Results");
        if (verify1) {
            System.out.println(" - You are in Hotels Results Page");
        } else {
            System.out.println(" - You're not in Hotels Results Page");
            driver.quit();
        }

        driver.manage().window().maximize();


        //search results page - źle







        driver.manage().deleteAllCookies();
        driver.close();


    }
}

