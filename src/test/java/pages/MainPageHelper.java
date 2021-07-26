package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MainPageHelper extends PageBase{
    @FindBy(css = "button.btn.btn-default[type=\"submit\"]")
    WebElement submitLangButton;
    @FindBy(className = "btn-group")
    WebElement basketButton;
    @FindBy(name = "language")
    WebElement langButton;
    @FindBy (css = "button.btn.btn-default[type=\"submit\"]")
    WebElement goButton;

    public MainPageHelper (WebDriver driver){
        super(driver);
    }

    public String getViewBasketButtonText() {
        String text = basketButton.getText();
        return text;
    }

    public void clickOnGoButton() {

        submitLangButton.click();
    }

    public Select selectLanguage(String lang) {
        Select langDropDown = new Select(langButton);
        // langDropDown.selectByIndex(2);
        //langDropDown.selectByVisibleText(lang);
        //langDropDown.deselectByVisibleText("suomi");
        langDropDown.selectByValue(lang);
        System.out.println(langDropDown.getAllSelectedOptions().get(0));
        return langDropDown;
    }

    public void waitUntilTextChanged(){

        waitUntilAllElementContainsText("Выполнить", goButton, 20);

    }

    public void selectBooksCategory() {
        driver.findElement(By.className("dropdown-submenu")).click();
    }

    public void clickOnLoginOrRegisterLink() {
        WebElement loginLink = driver.findElement(By.id("login_link"));
        loginLink.click();
    }

    public boolean successMessageIsDisplayed() {
        driver.findElement(By.className("alertinner")).isDisplayed();
        return true;
    }

    public boolean successMessageContainsText(String message) {
        return driver.findElement(By.className("alertinner")).getText().contains(message);
    }
}
