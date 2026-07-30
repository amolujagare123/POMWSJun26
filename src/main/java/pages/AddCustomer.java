package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer {

    @FindBy(id = "f_name")
    WebElement txtFullName;

    @FindBy(id = "f_email")
    WebElement txtEmail;

    @FindBy(id = "f_phone")
    WebElement txtPhone;

    @FindBy(id = "f_company")
    WebElement txtCompany;

    @FindBy(id = "f_credit")
    WebElement txtCreditLimit;

    @FindBy(name = "city")
    WebElement txtCity;

    @FindBy(name = "country")
    WebElement txtCountry;

    @FindBy(name = "status")
    WebElement ddlStatus;

    @FindBy(name = "address")
    WebElement txtAddress;

    @FindBy(name = "notes")
    WebElement txtNotes;

    @FindBy(className = "btn-primary")
    WebElement btnAddCustomer;

    public AddCustomer(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterFullName(String name) {
        txtFullName.sendKeys(name);
    }

    public void enterEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void enterPhone(String phone) {
        txtPhone.sendKeys(phone);
    }

    public void enterCompany(String company) {
        txtCompany.sendKeys(company);
    }

    public void enterCreditLimit(String creditLimit) {
        txtCreditLimit.clear();
        txtCreditLimit.sendKeys(creditLimit);
    }

    public void enterCity(String city) {
        txtCity.sendKeys(city);
    }

    public void enterCountry(String country) {
        txtCountry.sendKeys(country);
    }

    public void selectStatus(String status) {
        Select select = new Select(ddlStatus);
        select.selectByVisibleText(status);
    }

    public void enterAddress(String address) {
        txtAddress.sendKeys(address);
    }

    public void enterNotes(String notes) {
        txtNotes.sendKeys(notes);
    }

    public void clickAddCustomer() {
        btnAddCustomer.click();
    }
}