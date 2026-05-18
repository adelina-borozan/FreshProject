package tests.UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DemoqaTests {

    private WebDriver driver;

    @AfterMethod
    public void inchideBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void textBoxTest() {
        Reporter.log("Starting textBoxTest", true);
        driver = new ChromeDriver();
        Reporter.log("Chrome browser was opened", true);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        Reporter.log("Navigated to https://demoqa.com/text-box", true);

        String fullNameValue = "Adelina";

        Actions actions = new Actions(driver);

        
        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        WebElement submit = driver.findElement(By.className("btn-primary"));
        Reporter.log("Text box form elements were found", true);

        fullName.sendKeys(fullNameValue);
        Reporter.log("Entered full name: " + fullNameValue, true);
        email.sendKeys("test@itschool.com");
        Reporter.log("Entered email: test@itschool.com", true);
        currentAddress.sendKeys("Timisoara");
        Reporter.log("Entered current address: Timisoara", true);
        permanentAddress.sendKeys("Timis");
        Reporter.log("Entered permanent address: Timis", true);

        actions.scrollToElement(submit).perform();
        Reporter.log("Scrolled to submit button", true);
        submit.click();
        Reporter.log("Clicked submit button", true);


        WebElement output = driver.findElement(By.id("output"));
        Reporter.log("Output section was found", true);



//        Assert.assertTrue(output.isDisplayed());


        String outputName = driver.findElement(By.id("name")).getText();

        System.out.println(outputName);
        Reporter.log("Actual output name: " + outputName, true);

        Assert.assertTrue(outputName.contains(fullNameValue), "Output name nu este corect");
        Reporter.log("Verified output name contains: " + fullNameValue, true);

        Reporter.log("Forcing failure to verify Extent report screenshot and logs", true);
        Assert.assertTrue(false);

    }

    @Test
    public void textBoxTestNegativ() {
        Reporter.log("Starting textBoxTestNegativ", true);
        driver = new ChromeDriver();
        Reporter.log("Chrome browser was opened", true);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        Reporter.log("Navigated to https://demoqa.com/text-box", true);

        Actions actions = new Actions(driver);

        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        WebElement submit = driver.findElement(By.className("btn-primary"));
        Reporter.log("Text box form elements were found", true);

        fullName.sendKeys("Adelina");
        Reporter.log("Entered full name: Adelina", true);
        email.sendKeys("test");
        Reporter.log("Entered invalid email: test", true);
        currentAddress.sendKeys("Timisoara");
        Reporter.log("Entered current address: Timisoara", true);
        permanentAddress.sendKeys("Timis");
        Reporter.log("Entered permanent address: Timis", true);

//        actions.scrollToElement(submit).perform();
        submit.click();
        Reporter.log("Clicked submit button", true);

        String classAttribute = email.getAttribute("class");

        System.out.println(classAttribute);
        Reporter.log("Email class attribute after submit: " + classAttribute, true);
        //comentariu la linia 78

        Assert.assertTrue(classAttribute.contains("field-error"));
        Reporter.log("Verified invalid email field has field-error class", true);

        //acesta este un comentariu

    }
}
