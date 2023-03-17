package locators;

import engine.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPageLocators {
    private Utilities utilities;

    public By Total = By.cssSelector("strong[class='total ng-binding']");
    By CartTable = By.cssSelector("table[class='table table-striped cart-items']");

    public CartPageLocators(Utilities utilities) {
        this.utilities = utilities;
    }

    public WebElement getItemPriceFromCart(String itemName) {
        return utilities.getWebDriver().findElement(By.xpath("//td[contains(text(),'" + itemName + "')]/following-sibling::td[1]"));
    }

    public WebElement getQuantityOfAnItemFromCart(String itemName) {
        return utilities.getWebDriver().findElement(By.xpath("//td[contains(text(),'" + itemName + "')]/following-sibling::td[2]/input"));
    }

    public WebElement getTotalPriceOfAnItem(String itemName) {
        return utilities.getWebDriver().findElement(By.xpath("//td[contains(text(),'" + itemName + "')]/following-sibling::td[3]"));
    }

    public WebElement getTotal() {
        utilities.waitForElementToBeVisible(Total);
        return utilities.getWebDriver().findElement(Total);
    }


}
