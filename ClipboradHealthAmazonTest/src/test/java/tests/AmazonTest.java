package tests;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AmazonHomePage;
import verify.VerifyAboutInfo;


public class AmazonTest extends BaseTest{
	
	@Test()
    public void amazonItemInfoTest() {
		AmazonHomePage ahp=new AmazonHomePage();
        String itemInfo=ahp.clickAllLink()
        	.clickMenuItem("TV, Appliances, Electronics")
        	.clickMenuItem("Televisions")
        	.checkCheckBox("Samsung")
        	.selectSortBy("Price: High to Low")
        	.itemSelectionByIndex("2")
        	.verifyAboutItemInfo();  
        assertEquals(itemInfo, VerifyAboutInfo.getAboutThisItemText());
    }
}
