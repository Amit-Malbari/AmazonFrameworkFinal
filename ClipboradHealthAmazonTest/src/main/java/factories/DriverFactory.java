package factories;

import java.net.MalformedURLException;

import java.net.URL;
import java.util.Collections;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadPropertyFile;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver getDriver() throws MalformedURLException {
        WebDriver driver = null;
        String runmode = (System.getProperty("RUNMODE") != null)?System.getProperty("RUNMODE"):ReadPropertyFile.getValue(ConfigProperties.RUNMODE);
        String browser = (System.getProperty("BROWSER") != null)?System.getProperty("BROWSER"):ReadPropertyFile.getValue(ConfigProperties.BROWSER);

        if (browser.equalsIgnoreCase("chrome")) {
            if (runmode.equalsIgnoreCase("remote")) {
            	DesiredCapabilities capabilities = new DesiredCapabilities();
            	capabilities.setCapability("browserName", BrowserType.CHROME);
            	capabilities.setCapability("selenoid:options", Map.<String, Object>of(
            	    "enableVNC", true,
            	    "enableVideo", true
            	));
                driver = new RemoteWebDriver(new URL(FrameworkConstants.getSeleniumGridUrl()), capabilities);
            } else if (runmode.equalsIgnoreCase("local")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions(); 
                options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
                driver = new ChromeDriver(options);
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (runmode.equalsIgnoreCase("remote")) {
            	DesiredCapabilities capabilities = new DesiredCapabilities();
            	capabilities.setCapability("browserName", BrowserType.FIREFOX);
            	capabilities.setCapability("selenoid:options", Map.<String, Object>of(
            	    "enableVNC", true,
            	    "enableVideo", true
            	));
                driver = new RemoteWebDriver(new URL(FrameworkConstants.getSeleniumGridUrl()), capabilities);
            } else if (runmode.equalsIgnoreCase("local")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }
}
