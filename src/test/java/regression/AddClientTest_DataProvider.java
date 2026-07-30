package regression;

import Pages.AddClient;
import Pages.Login;
import Pages.Menu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static util.ForDataProvider.getMyData;

public class AddClientTest_DataProvider {
    WebDriver driver;
    @BeforeClass
    public void doLogin()
    {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/ip");

        Login login = new Login (driver);
        login.setUsername("ava116k@gmail.com");
        login.setPassword("admin123");
        login.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }

    @Test (dataProvider="getData")
    public void addClient(String clientName, String clientSurname, String language, String streetAddress,
                          String streetAddressCont, String city, String state, String zipCode, String country,
                          String phoneNumber, String faxNumber, String mobileNumber, String emailAddress,
                          String webAddress, String gender, String birthdate, String vatId, String taxesCode, String Expected, String xpathActual)
    {
        Menu menu=new Menu(driver);
        menu.clickAddClient();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        AddClient addClient=new AddClient(driver);
        addClient.setClientName(clientName);
        addClient.setClientSurname(clientSurname);
        addClient.setLanguage(language);
        addClient.setStreetAddress(streetAddress);
        addClient.setStreetAddressCont(streetAddressCont);
        addClient.setCity(city);
        addClient.setState(state);
        addClient.setZipCode(zipCode);
        addClient.setCountry(country);
        addClient.setPhoneNumber(phoneNumber);
        addClient.setFaxNumber(faxNumber);
        addClient.setMobileNumber(mobileNumber);
        addClient.setEmailAddress(emailAddress);
        addClient.setWebAddress(webAddress);
        addClient.setGender(gender);
        addClient.setBirthdate(birthdate);//MM/DD/YYYY
        addClient.setVatId(vatId);
        addClient.setTaxesCode(taxesCode);
        addClient.clickSave();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        String actual ="";
                try{
                    actual=driver.findElement(By.xpath(xpathActual)).getText();
                    } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        System.out.println("expected ="+Expected);
        System.out.println("actual = "+actual);
        Assert.assertEquals(actual,Expected,"Incorrect or no error message");
    }

        @DataProvider
    public Object [][] getData() throws IOException {
            return getMyData("data/ClientTestData-1.xlsx","ClientData");
        }


}
