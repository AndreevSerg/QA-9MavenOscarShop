package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MainPageHelper;
import pages.RegistrationPageHelper;

public class RegistrationTests extends TestBase{
    String email = "qwer" + System.currentTimeMillis() + "@gmail.com";
    // System.out.println(email);
    String password = "Qwe123123";
    RegistrationPageHelper registrationPageHelper;
    MainPageHelper mainPageHelper;
    String message = "Thanks for registering!";

    @BeforeMethod
    public void initPage(){

        registrationPageHelper = PageFactory.initElements(driver, RegistrationPageHelper.class);
        mainPageHelper = PageFactory.initElements(driver, MainPageHelper.class);
    }

    @Test (priority =1, enabled = false)
    public void registrationTest(){

        mainPageHelper.clickOnLoginOrRegisterLink();
        registrationPageHelper.waitUntilPageIsLoaded();
        registrationPageHelper.fillEmailField(email);
        registrationPageHelper.fillPasswordField(password);
        registrationPageHelper.fillConfirmationPassword(password);
        registrationPageHelper.clickOnRegisterButton();
        Assert.assertTrue(mainPageHelper.successMessageIsDisplayed(), "No message!!");
        Assert.assertTrue(mainPageHelper.successMessageContainsText(message));
    }

    @Test(priority = 2)//, dependsOnMethods = "registrationTest")
    @Parameters({"email", "password"})
    public void loginTest(String email, String password) throws InterruptedException {
        WebElement loginLink = driver.findElement(By.id("login_link"));
        loginLink.click();

        WebElement loginEmailField = driver.findElement(By.xpath("//input[@id='id_login-username']"));

        loginEmailField.sendKeys(email);
        WebElement loginPasswordField = driver.findElement(By.id("id_login-password"));
        loginPasswordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Log In')]"));
        loginButton.click();
        Thread.sleep(5000);
       // loginButton.isDisplayed();
        driver.findElement(By.cssSelector(".alertinner.wicon .icon-ok-sign")).isDisplayed();

    }

}

