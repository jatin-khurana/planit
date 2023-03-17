package engine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
    Core core;

    public Utilities() {
        this.core = new Core();
    }

    public WebDriver getWebDriver() {
        return core.driver;
    }

    public void waitForElementToBeVisible(By ele) {
        WebDriverWait w = new WebDriverWait(core.driver, 20);
        w.until(ExpectedConditions.visibilityOfElementLocated(ele));
    }

    public void sleep(long i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
