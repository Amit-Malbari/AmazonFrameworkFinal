package utils;

import org.openqa.selenium.By;

public final class DynamicXpathUtils {

    private DynamicXpathUtils(){}

    public static By getModifiedXpath(String xpathToBeAltered, String replacingString){
        return By.xpath(String.format(xpathToBeAltered,replacingString));
    }
}
