package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by dmezdrea on 8/6/2015.
 */
public class ShopMania {

    private WebDriver driver;

    @FindBy(id = "autocomplete_prod")
    private WebElement searchFD;

    @FindBy(xpath = "//*[@id='main_col']/div/ul[1]/li[4]/a")
    private WebElement categoryPhone;

    @FindBy(xpath = "//ul/li[1]/div[3]/p[1]/a")
    private WebElement checkPrice;

    @FindBy(xpath = "//option[@value='price']")
    private WebElement sortPret;


    public ShopMania(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.shopmania.ro");
    }

    public void cauta(String phone) {
        searchFD.sendKeys(phone);
        searchFD.submit();
        categoryPhone.click();
        checkPrice.click();
        sortPret.click();
    }

    public void numara(){
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@itemprop='offers']")));

        List<WebElement> v_ct = driver.findElements(By.xpath("//li[@itemprop='offers']"));
        System.out.println("Numarul de magazine disponibile este: " + v_ct.size());
    }

    public void afiseazaDetalii(){

        WebElement price;
        WebElement shop;
        price = driver.findElement(By.xpath(".//ul[1]/li/div[2]/div[3]/p[1]/a"));
        shop = driver.findElement(By.xpath(".//*[@id='product_offers_container']/ul[1]/li/div[2]/div[2]/p[1]/a"));
        price.getText();
        shop.getAttribute("title");
        System.out.println("Pretul minim este: " + price.getText() + "  Magazinul ieftin este: " + shop.getAttribute("title"));
    }

    public void verify(){
        WebElement maxPrice;
        WebElement maxShop;
        maxPrice = driver.findElement(By.xpath(".//*[@id='product_offers_container']/ul[55]/li[2]/div[2]/div[3]/p[1]/a"));
        maxShop = driver.findElement(By.xpath(".//*[@id='product_offers_container']/ul[55]/li[2]/div[2]/div[2]/p/a"));
        //maxPrice.getText();
        String price = maxPrice.getText();
        assertTrue(price.contains("2.108,63 RON"));
        maxShop.getAttribute("title");
        System.out.println("Pretul maxim este: " + price + " Magazinul de lux este: " + maxShop.getAttribute("title"));


    }
}
