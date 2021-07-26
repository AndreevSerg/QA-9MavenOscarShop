package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductPageHelper extends PageBase{

    @FindBy(className = "image_container")
    List<WebElement> images;

    @FindBy(className = "product_pod" )
    List<WebElement> productList;

    @FindBy (className = "price_color")
    List<WebElement> priceElementList;


    public ProductPageHelper(WebDriver driver){
        super(driver);
    }


    public int getProductCountInBasket() {
        return Integer.parseInt(driver.findElement(By.id("id_form-0-quantity")).getAttribute("Value"));
    }

    public void clickOnViewBasketButton() {
        driver.findElement(By.cssSelector(".btn-group a.btn.btn-default")).click();
    }

    public boolean isItFirstBookPrice(String firstBookPrice, List<WebElement> alertsData) {
        System.out.println(alertsData.get(2).getText());
        return alertsData.get(2).getText().equals(firstBookPrice);
    }

    public boolean isItFirstBookName(String firstBookName, List<WebElement> alertsData) {
        return alertsData.get(0).getText().equals(firstBookName);
    }

    public boolean alertsIsPresent() {
        return driver.findElements(By.className("alert")).size() == 3;
    }

    public void addToBasketFirstBook() {
        productList.get(0).findElement(By.cssSelector("[type=\"submit\"]")).click();
    }

    public boolean isItBooksPage() {
        return driver.findElement(By.className("page-header")).getText().contains("Books");
    }

    public void selectBooksCategory() {
        driver.findElement(By.className("dropdown-submenu")).click();
    }

    public void waitUntilAllBooksIsVisible() {

        waitUntilAllElementsVisible(images, 20);
    }

    public int getBooksCount() {
        return images.size();
    }

    public List<Double> getBookPriceList() {
        List<Double> priceList = new ArrayList<>();
        for (WebElement element: priceElementList){
            priceList.add(Double.parseDouble(element.getText().replaceAll("£", "")));

        }
        return priceList;
    }
}
