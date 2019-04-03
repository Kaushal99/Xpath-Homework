
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SeleniumFirst
{
  protected static WebDriver driver;



    public static void main(String[] args)
    {

        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHMMSS");

        //get current date time with Date()
        Date date = new Date();

        // Now format the date
        String getCurrentDateTime = dateFormat.format(date);

        // Print the Date
        System.out.println(getCurrentDateTime);

        System.setProperty("webdriver.chrome.driver","src\\BrowserDrivers\\chromedriver.exe");


     driver = new ChromeDriver();
      //implicit wait applied to driver instance which will be applied to driver until driver instance
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver to get URL
        driver.get("https://demo.nopcommerce.com/");
        //Register new user by click
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //Enter first name and last name of New User
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Kaushal");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Patel");

        //Enter email detail with date and time for user



        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("patelkaushal99"+ getCurrentDateTime +"@gmail.com");

        //Enter password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Test1234");

        //enter conform passsword
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Test1234");

        //click register button to register successfully
        driver.findElement(By.xpath("//input[@name='register-button']")).click();

        String actualRegistrationSuccessMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();

        //using assert to match expected and actual results ...
        Assert.assertEquals("Your registration completed",actualRegistrationSuccessMessage);


        driver.quit();




    }


}
