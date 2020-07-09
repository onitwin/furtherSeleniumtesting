package logInTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest {


//    @Test
//    public void LoginTest(){
//        //set up driver
//        System.out.println("START login test ");
//        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
//        WebDriver driver=new ChromeDriver();
//
//        //access test page
//        String url="http://the-internet.herokuapp.com/login"; // can be be input manually but this allows us to update test more easily
//        driver.get(url);
//        System.out.println("Page opened");
//
//        //find username box and enter incorrect username
//        WebElement username=driver.findElement(By.id("username"));
//        username.sendKeys("jimbob");
//
//        //find password box and enter password
//        WebElement password=driver.findElement(By.id("password"));
//        password.sendKeys("SuperSecretPassword!");
//
//        //find submit button and click
//        WebElement submit=driver.findElement(By.className("radius"));
//        submit.click();
//
//        //error message should appear- locate and return text value- assert using test
//        WebElement errorMessage=driver.findElement(By.className("error"));
//        String expectedText="Your username is invalid!";
//        String actualText=errorMessage.getText();
//        Assert.assertTrue(actualText.contains("Your username is invalid!"),"actual text does not include requested text");
//
//
//
//
//        //timeout to ensure I can see  effect
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//        //ensure page is closed
//        driver.quit();
//        System.out.println("Page closed successfully");
//
//    }

    @Test
    public void incorrectUsernametest(){
        System.out.println("START incorrect username test ");
        //Create driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver=new ChromeDriver();


        //open test page
        String url="http://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened");

        //maximise browser window
        driver.manage().window().maximize();

        //enter username
        WebElement username=driver.findElement(By.id("username"));
        username.sendKeys("wrongname");

        //enter password
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        //click log in button
        WebElement logInButton=driver.findElement(By.tagName("button"));
        logInButton.click();


        WebElement errorMessage=driver.findElement(By.id("flash"));
        String expectedErrorMessage="Your username is invalid!";
        String actualErrorMessage=errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.contains("Your username is invalid!"),"actual text does not include requested text");

        driver.quit();
        System.out.println("END of incorrect username test ");
    }


}
