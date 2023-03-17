package engine;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

public class Core {

    public static WebDriver driver;
    public String data;
    public Properties properties;

    @Before(order = 0)
    public void setTags(Scenario scenario) {
        Collection<String> tags = scenario.getSourceTagNames();
        for (String tag : tags) {
            if (tag.contains("@Data")) {
                data = tag.split("=")[1];
            }
        }
    }

    @Before(order = 1)
    public void loadProperties() {
        FileReader reader;
        try {
            reader = new FileReader(data);
            properties = new Properties();
            try {
                properties.load(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("loadProperties = " + properties.getProperty("URL"));
        System.out.println("loadProperties = " + properties.getProperty("BROWSER"));
    }

    @Before(order = 2)
    public void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote--allow-origins=*");
        options = new ChromeOptions();
        options.setHeadless(false);
        options.addArguments("--start-maximized");
        options.merge(caps);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Before(order = 3)
    public void navigateToURL() {
        driver.get(properties.getProperty("URL"));
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }


}
