package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.Driver;

public class BaseTest {

    protected BaseTest(){}

    @BeforeMethod
    public void startUp(){
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }

}
