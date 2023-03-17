package locators;

import engine.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonLocators {
    private Utilities utilities;

    By homeButton = By.id("nav-home");
    By shopButton = By.id("nav-shop");
    By contactButton = By.id("nav-contact");
    By loginButton = By.id("nav-login");
    By cartButton = By.id("nav-cart");
    By noOfItemsInCart = By.xpath("//li[@id='nav-cart']//span");

    public CommonLocators(Utilities utilities) {
        this.utilities = utilities;
    }

    public WebElement getHomeButton() {
        return utilities.getWebDriver().findElement(homeButton);
    }

    public WebElement getShopButton() {
        utilities.waitForElementToBeVisible(shopButton);
        return utilities.getWebDriver().findElement(shopButton);
    }

    public WebElement getContactButton() {
        return utilities.getWebDriver().findElement(contactButton);
    }

    public WebElement getLoginButton() {
        return utilities.getWebDriver().findElement(loginButton);
    }

    public WebElement getCartButton() {
        utilities.waitForElementToBeVisible(shopButton);
        return utilities.getWebDriver().findElement(cartButton);
    }

    public WebElement getNoOfItemsInCart() {
        return utilities.getWebDriver().findElement(noOfItemsInCart);
    }


}
