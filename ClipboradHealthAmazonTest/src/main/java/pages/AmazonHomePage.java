package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;
import enums.WaitType;
import utils.DynamicXpathUtils;

public final class AmazonHomePage extends BasePage {

	private final By allLink = By.className("hm-icon-label");
	private final By sortBy = By.id("s-result-sort-select");
	private final By aboutItem = By.xpath("//div[@id='feature-bullets']/h1");
	private final By aboutItemDetails = By.xpath("//div[@id='feature-bullets']/ul");
	/*
	 * private final By tvAppliancesElectronics =
	 * By.linkText("TV, Appliances, Electronics"); private final By televisions =
	 * By.linkText("Televisions");
	 */
	
	private static final String MENUITEM="//div[@id='hmenu-content']//*[text()='%s']";
	private static final String CHECKBOX="//div[@id='s-refinements']//span[text()='%s']/preceding-sibling::div//input";
	private static final String ITEM="(//div[@class='a-section aok-relative s-image-square-aspect'])[%s]";
	
    public AmazonHomePage clickAllLink(){
        click(allLink, WaitStrategy.CLICKABLE,"All Hamburger Icon");
        return this;
    }
    
    
    //merged the below functions into single function
	/*
	 * public AmazonHomePage clickTvAppliancesElectronics() {
	 * scrollToElement(tvAppliancesElectronics,WaitStrategy.CLICKABLE);
	 * click(tvAppliancesElectronics,WaitStrategy.
	 * CLICKABLE,"TV, Appliances, Electronics Link"); return this; }
	 * 
	 * public AmazonHomePage clickTelevisions() {
	 * scrollToElement(televisions,WaitStrategy.CLICKABLE);
	 * click(televisions,WaitStrategy.CLICKABLE,"Televisions Link"); return this; }
	 */
    
    public AmazonHomePage clickMenuItem(String menuItemName) {
    	scrollToElement(DynamicXpathUtils.getModifiedXpath(MENUITEM, menuItemName));
    	click(DynamicXpathUtils.getModifiedXpath(MENUITEM, menuItemName),WaitStrategy.CLICKABLE, menuItemName+" Link");
    	return this;
    }
    
    public AmazonHomePage checkCheckBox(String filter) {
    	refreshPage();
    	scrollToElement(DynamicXpathUtils.getModifiedXpath(CHECKBOX, filter));
    	clickByJs(DynamicXpathUtils.getModifiedXpath(CHECKBOX, filter),WaitStrategy.VISIBLE, filter+" checkbox");
    	return this;
    }
    
    public AmazonHomePage selectSortBy(String sortByValue) {
    	refreshPage();
    	scrollToTop();
    	selectDropDownByVisibleText(sortBy, sortByValue, WaitStrategy.VISIBLE, WaitType.LONGWAIT,"Sort By: dropdown");
    	return this;
    }
    
    public AmazonHomePage itemSelectionByIndex(String itemByIndex) {
    	refreshPage();
    	scrollToElement(DynamicXpathUtils.getModifiedXpath(ITEM, itemByIndex));
    	clickByJs(DynamicXpathUtils.getModifiedXpath(ITEM, itemByIndex),WaitStrategy.CLICKABLE, "Item Selection");
    	return this;
    }
    
    
    public String verifyAboutItemInfo() {
    	switchToChildWindow();
    	scrollToElement(aboutItem);
    	return (getText(aboutItem, WaitStrategy.VISIBLE)+"\n"+getText(aboutItemDetails, WaitStrategy.VISIBLE)).replaceAll("(\r\n|\n)", "<br />");
    }
    
    
}
