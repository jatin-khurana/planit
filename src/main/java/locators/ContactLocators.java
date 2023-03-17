package locators;

import engine.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactLocators {
    private Utilities utilities;
    WebDriver driver;
    By Forename = By.id("forename");
    By Surname = By.id("surname");
    By Email = By.id("email");
    By Telephone = By.id("telephone");
    By Message = By.id("message");
    By Submit = By.xpath("//a[text()='Submit']");
    By Error = By.cssSelector("div[class='alert alert-error ng-scope']");
    By Success = By.cssSelector("div[class='alert alert-success']");
    By Back = By.xpath("//a[text()='« Back']");

    public ContactLocators(Utilities utilities) {
        this.utilities = utilities;
    }

    public WebElement getForename() {
        utilities.waitForElementToBeVisible(Forename);
        return utilities.getWebDriver().findElement(Forename);
    }

    public WebElement getSurname() {
        return utilities.getWebDriver().findElement(Surname);
    }

    public WebElement getEmail() {
        return utilities.getWebDriver().findElement(Email);
    }

    public WebElement getTelephone() {
        return utilities.getWebDriver().findElement(Telephone);
    }

    public WebElement getMessage() {
        return utilities.getWebDriver().findElement(Message);
    }

    public WebElement getSubmitButton() {
        utilities.waitForElementToBeVisible(Submit);
        return utilities.getWebDriver().findElement(Submit);
    }

    public WebElement getError() {
        return utilities.getWebDriver().findElement(Error);
    }

    public WebElement getSuccess() {
        utilities.waitForElementToBeVisible(Success);
        return utilities.getWebDriver().findElement(Success);
    }

    public WebElement getBack() {
        utilities.waitForElementToBeVisible(Back);
        return utilities.getWebDriver().findElement(Back);
    }


}
