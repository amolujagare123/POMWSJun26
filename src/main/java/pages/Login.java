package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {


    @FindBy(name = "email")
    WebElement txtUsername;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy (className = "btn-login")
    WebElement btnLogin;

    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setUsername(String username)
    {
        txtUsername.sendKeys(username);
    }

    public void setPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }
}
