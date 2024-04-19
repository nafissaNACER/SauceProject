package SauceApp.Pages;


import SauceApp.Utils.BaseTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLogin extends BaseTools {

    private By champsUsername = By.id("user-name");
    private By champsPassword = By.name("password");
    private By boutonLogin = By.id("login-button");
    private By messageErreur = By.xpath("//h3[@data-test='error']");

    WebDriver driver;

    public PageLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void seConnecter(String username, String password) {
        System.out.println("se connecter");
        waitAndSendKeys(driver.findElement(champsUsername), username, 30);
        waitAndSendKeys(driver.findElement(champsPassword), password, 30);
        waitAndClick(driver.findElement(boutonLogin), 30);
    }

    public String verifierMessageErreur() {
        System.out.println("verifier message");
        return driver.findElement(messageErreur).getText();
    }
}
