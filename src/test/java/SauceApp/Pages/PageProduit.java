package SauceApp.Pages;

import SauceApp.Utils.BaseTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageProduit extends BaseTools {
    private By sousTitleProduit = By.xpath("//span[@data-test='title']");

    WebDriver driver;
    public PageProduit(WebDriver driver){
        this.driver= driver;
    }

    public Boolean verifierAccessPageProduct(){
        WebElement title= waitElementToBeVisible(driver.findElement(sousTitleProduit),40);
        return title.isDisplayed();
    }

}
