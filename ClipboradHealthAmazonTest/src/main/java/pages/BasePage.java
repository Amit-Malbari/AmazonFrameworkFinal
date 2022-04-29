package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import driver.DriverManager;
import enums.WaitStrategy;
import enums.WaitType;
import factories.ExplicitWaitFactory;
import reports.ExtentLogger;

public class BasePage {

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy,String elementName){
        ExplicitWaitFactory.performExplicitWait(by,waitStrategy).sendKeys(value);
        ExtentLogger.pass(value +" is entered in the "+elementName);
    }

    protected void click(By by,WaitStrategy waitStrategy,String elementName){
        ExplicitWaitFactory.performExplicitWait(by,waitStrategy).click();
        ExtentLogger.pass(elementName +" is clicked");
    }
    
    protected void selectDropDownByVisibleText(By by,String visibleText,WaitStrategy waitStrategy,WaitType waitType ,String elementName){
        Select select=new Select(ExplicitWaitFactory.performExplicitWait(by,waitStrategy,waitType));
        select.selectByVisibleText(visibleText);
        ExtentLogger.pass(elementName +" is selected");
    }

    protected String getText(By by,WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by,waitStrategy);
        return DriverManager.getDriver().findElement(by).getText();
    }
    
    protected void scrollToElement(By by){
    	WebElement element=ExplicitWaitFactory.performExplicitWait(by,WaitStrategy.PRESENCE);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", element); 
    }
    
    protected void refreshPage(){
    	DriverManager.getDriver().navigate().refresh();
    }
    
    protected void scrollToTop(){
    	((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollTo(0, 0);"); 
    }
    
    protected void clickByJs(By by,WaitStrategy waitStrategy,String elementName){
    	WebElement element=ExplicitWaitFactory.performExplicitWait(by,waitStrategy);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);
        ExtentLogger.pass(elementName +" is clicked");
    }
    
    protected void switchToChildWindow() {
    	String mainWindowHandle = DriverManager.getDriver().getWindowHandle();
        Set<String> allWindowHandles = DriverManager.getDriver().getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                	DriverManager.getDriver().switchTo().window(ChildWindow);
            }
        }
    }
}
