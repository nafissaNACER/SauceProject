package SauceApp.Suites;

import SauceApp.Configuration.SetupTearDown;
import SauceApp.DataSet.Constante;
import SauceApp.Pages.PageLogin;
import SauceApp.Pages.PageProduit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteLogin extends SetupTearDown {


    @Test
    public void Test01_loginInvalide(){
        String username="locked_out_user";
        String password="secret_sauce";
        String messageAttendu = "Epic sadface: Sorry, this user has been locked out.";
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.seConnecter(username,password);
        String actuelMessage= pageLogin.verifierMessageErreur();
        Assert.assertEquals(actuelMessage, messageAttendu);
    }

    @Test
    public void Test02_loginValide(){
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.seConnecter(Constante.usernameValide,Constante.passwordValide);
        PageProduit pageProduit = new PageProduit(driver);
        Assert.assertTrue(pageProduit.verifierAccessPageProduct());
    }
}
