package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrelloTests {
    WebDriver driver;
    String password1 = "CFDSGvcds!v43_4";

    String login = "forusant@gmail.com";
    String password = "Fioletoviy_19";
    String boardTitle = "QA_Haifa_9";
    String listTitle = "dfghfgdh";

    @BeforeMethod
    public void open() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://trello.com");

      /*  driver.findElement(By.cssSelector("[class = 'btn btn-sm btn-link text-primary']")).click();
        Thread.sleep(2000);

        WebElement emailLogin = driver.findElement(By.xpath("//input[@id='user']"));
        emailLogin.click();
        emailLogin.sendKeys("andreev.s@gmail.com");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.click();
        password.sendKeys(password1);
        password.submit();
*/
    }
    @Test
    public void test() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(3000);
        Select languageDropdownMenu = new Select(driver.findElement(By.id("language-picker")));
        languageDropdownMenu.selectByValue("en");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".text-primary")).click();
        Thread.sleep(3000);
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys(login);
        Thread.sleep(3000);
        driver.findElement(By.id("login")).click();
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys(password);
        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.id("login-submit"));
        loginButton.click();
        Thread.sleep(15000);

        WebElement chooseBoard = driver.findElement(By.xpath("(//div[@title='"+boardTitle+"'])"));
        chooseBoard.click();
        Thread.sleep(5000);
        WebElement addAnotherList = driver.findElement(By.cssSelector("div.js-add-list"));
        addAnotherList.click();
        Thread.sleep(3000);
        WebElement listTitleField = driver.findElement(By.cssSelector("input.list-name-input"));
        listTitleField.sendKeys(listTitle);
        Thread.sleep(3000);
        WebElement addListButton = driver.findElement(By.cssSelector("input.js-save-edit"));
        addListButton.click();
        Thread.sleep(3000);

        WebElement menuButton = driver.findElement(By.cssSelector(".js-fill-board-menu"));
        System.out.println("Attribute " + menuButton.getAttribute("hide"));


    }

     @AfterMethod
     public void close(){
        driver.quit();
    }

}
