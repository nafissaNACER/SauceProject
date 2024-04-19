package SauceApp.Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetupTearDown {
    public static WebDriver driver;

    @BeforeMethod
    public void lunchBrowser() {
        String browser = System.getenv("Browser");
        System.out.println("start test");
        //System.setProperty("webdriver.edge.driver", "C:\\toolsDev\\edgedriver_win64\\msedgedriver.exe");
        if(browser.contentEquals("Chrome")){
            driver = new ChromeDriver();
        }else{
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
        System.out.println("fin test");
    }
}
