package factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;
import enums.WaitType;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory(){}

    public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy,WaitType... type){
        WebElement element = null;
        int time = FrameworkConstants.getWaitTimeInSeconds();
        if(type.length!=0 && type[0]==WaitType.LONGWAIT) {
        	time=FrameworkConstants.getLongwaittimeinseconds();
        }
        if(waitStrategy==WaitStrategy.CLICKABLE){
            element= new WebDriverWait(DriverManager.getDriver(), time)
                    .until(ExpectedConditions.elementToBeClickable(by));
        }
        else if(waitStrategy==WaitStrategy.PRESENCE){
           element= new WebDriverWait(DriverManager.getDriver(),time)
            .until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if(waitStrategy==WaitStrategy.VISIBLE){
            element = new WebDriverWait(DriverManager.getDriver(),time)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        return element;
    }

}

