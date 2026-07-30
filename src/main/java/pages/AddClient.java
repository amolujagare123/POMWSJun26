package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

    WebDriver driver;

    //-------------------- Personal Information --------------------
    @FindBy(id="client_active")
    WebElement chkActive;
    @FindBy(id="client_name")
    WebElement txtClientName;
    @FindBy(id="client_surname")
    WebElement txtClientSurname;
    //-----------Language---------------
    @FindBy(id="select2-client_language-container")
    WebElement languageContainer;
    @FindBy(xpath="//input[@aria-label='Search']")
    WebElement searchBox;

    //-------------------- Address --------------------
    @FindBy(id="client_address_1")
    WebElement txtStreetAddress;
    @FindBy(id="client_address_2")
    WebElement txtStreetAddressCont;
    @FindBy(id="client_city")
    WebElement txtCity;
    @FindBy(id="client_state")
    WebElement txtState;
    @FindBy(id="client_zip")
    WebElement txtZipCode;
    //-----------Country---------------
    @FindBy(id="select2-client_country-container")
    WebElement countryContainer;

    //-------------------- Contact Information --------------------
    @FindBy(id="client_phone")
    WebElement txtPhoneNumber;
    @FindBy(id="client_fax")
    WebElement txtFaxNumber;
    @FindBy(id="client_mobile")
    WebElement txtMobileNumber;
    @FindBy(id="client_email")
    WebElement txtEmailAddress;
    @FindBy(id="client_web")
    WebElement txtWebAddress;

    //-----------Gender---------------
    @FindBy(id="select2-client_gender-container")
    WebElement genderContainer;
    //-----------Birthdate---------------
    @FindBy(id="client_birthdate")
    WebElement txtBirthdate;
    @FindBy(xpath="//span[@class='input-group-addon']//i[contains(@class,'fa-calendar')]")
    WebElement calendarIcon;

    //-------------------- Taxes Information --------------------
    @FindBy(id="client_vat_id")
    WebElement txtVatId;
    @FindBy(id="client_tax_code")
    WebElement txtTaxesCode;

    //-------------------- Page actions --------------------
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement btnSave;
    @FindBy(xpath = "//a[normalize-space()='Cancel']")
    WebElement btnCancel;

    //We will create a constructor which is used to initialize an object
    //it has same name as Java class file name. It is method with no return type
    //for accessibility we will make it public
    public AddClient(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    //-------------------- Personal Information methods --------------------
    public void setClientActive(boolean active)
    {
        if(chkActive.isSelected() != active)
        {
            chkActive.click();
        }
    }
    public void setClientName(String clientName)
    {
        txtClientName.sendKeys(clientName);
    }
    public void setClientSurname(String clientSurname)
    {
        txtClientSurname.sendKeys(clientSurname);
    }
    public void setLanguage(String language)
    {
        languageContainer.click();
        searchBox.sendKeys(language);
        driver.findElement(By.xpath("//span[@id='select2-client_language-container']")).click();
    }

    //-------------------- Address methods --------------------
    public void setStreetAddress(String streetAddress)
    {
        txtStreetAddress.sendKeys(streetAddress);
    }
    public void setStreetAddressCont(String streetAddressCont)
    {
        txtStreetAddressCont.sendKeys(streetAddressCont);
    }
    public void setCity(String city)
    {
        txtCity.sendKeys(city);
    }
    public void setState(String state)
    {
        txtState.sendKeys(state);
    }
    public void setZipCode(String zipCode)
    {
        txtZipCode.sendKeys(zipCode);
    }
    public void setCountry(String country)
    {
        countryContainer.click();
        searchBox.sendKeys(country);
        driver.findElement(By.xpath("//span[@id='select2-client_country-container']")).click();
    }

    //-------------------- Contact Information methods --------------------
    public void setPhoneNumber(String phoneNumber)
    {
        txtPhoneNumber.sendKeys(phoneNumber);
    }
    public void setFaxNumber(String faxNumber)
    {
        txtFaxNumber.sendKeys(faxNumber);
    }
    public void setMobileNumber(String mobileNumber)
    {
        txtMobileNumber.sendKeys(mobileNumber);
    }
    public void setEmailAddress(String emailAddress)
    {
        txtEmailAddress.sendKeys(emailAddress);
    }
    public void setWebAddress(String webAddress)
    {
        txtWebAddress.sendKeys(webAddress);
    }

    //-------------------- Personal Information (Gender) method --------------------
    public void setGender(String gender)
    {
        genderContainer.click();
        driver.findElement(By.xpath("//li[contains(@class,'select2-results__option')][normalize-space()='"+gender+"']")).click();
    }
    //-------------------- Personal Information (Birthdate) method --------------------
    public void setBirthdate(String day)
    {
        //calendarIcon.click();
        //driver.findElement(By.xpath("//td[@class='day' and text()='"+day+"']")).click();
       //String jsCode="setAttribute('value','01/01/2001)";
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+day+"')",txtBirthdate);
    }

    //-------------------- Taxes Information methods --------------------
    public void setVatId(String vatId)
    {
        txtVatId.sendKeys(vatId);
    }
    public void setTaxesCode(String taxesCode)
    {
        txtTaxesCode.sendKeys(taxesCode);
    }

    //-------------------- Page action methods --------------------
    public void clickSave()
    {
        btnSave.click();
    }
    public void clickCancel()
    {
        btnCancel.click();
    }

}
