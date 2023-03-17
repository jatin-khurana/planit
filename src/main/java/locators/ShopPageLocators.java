package locators;

import engine.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShopPageLocators {
    private Utilities utilities;

    By catalog = By.cssSelector("div[class='products ng-scope']");

    public WebElement getItemPrice(String itemName) {
        return utilities.getWebDriver().findElement(By.xpath("//h4[text()='" + itemName + "']/..//span[@class='product-price ng-binding']"));
    }

    public WebElement getBuyItem(String itemName) {
        utilities.waitForElementToBeVisible(catalog);
        return utilities.getWebDriver().findElement(By.xpath("//h4[text()='" + itemName + "']/..//a[text()='Buy']"));
    }

    public ShopPageLocators(Utilities utilities) {
        this.utilities = utilities;
    }

}
