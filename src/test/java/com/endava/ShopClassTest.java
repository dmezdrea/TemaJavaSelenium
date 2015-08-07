package com.endava;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dmezdrea on 8/6/2015.
 */
public class ShopClassTest {

    ShopMania page;
    WebDriver driver;

    @Before
    public void before(){
        driver = new FirefoxDriver();
        page = PageFactory.initElements(driver,ShopMania.class);

    }

    @After
    public void after(){
        driver.close();
    }

    @Test
    public void test(){
        page.cauta("galaxy s5");
        page.numara();
        page.afiseazaDetalii();
        page.verify();
    }

}
