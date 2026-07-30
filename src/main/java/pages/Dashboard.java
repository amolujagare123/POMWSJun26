package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

    @FindBy(partialLinkText = "Customers")
    WebElement lnkCustomer;

    public Dashboard(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void clickCustomer()
    {
        lnkCustomer.click();
    }
}
