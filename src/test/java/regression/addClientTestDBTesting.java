package regression;

import Pages.AddClient;
import Pages.Login;
import Pages.Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;

import static util.Conversion.getFullFormCountry;
import static util.Conversion.getGender;
import static util.ForDataProvider.getMyData;

public class addClientTestDBTesting {
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
                          String webAddress, String gender, String birthdate, String vatId, String taxesCode) throws ClassNotFoundException, SQLException {



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

        ArrayList<String> expected = new ArrayList<String>();
        expected.add(clientName);
        expected.add(clientSurname);
        //expected.add(language.toLowerCase());
        expected.add(language);
        expected.add(streetAddress);
        expected.add(streetAddressCont);
        expected.add(city);
        expected.add(state);
        expected.add(zipCode);
        expected.add(country);
        expected.add(phoneNumber);
        expected.add(faxNumber);
        expected.add(mobileNumber);
        expected.add(emailAddress);
        expected.add(webAddress);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(vatId);
        expected.add(taxesCode);

        Class.forName("com.mysql.jdbc.Driver");
        String username="root";
        String password="root";;
        String url="jdbc:mysql://localhost:3306/ip";
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st= con.createStatement();
        String sql="select * from ip_clients where client_name= '"+clientName+"'";
        ResultSet rs=st.executeQuery(sql);
        ArrayList<String>actual=new ArrayList<>();
        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));
            actual.add(getFullFormCountry(rs.getString("client_country")));
            actual.add(getGender(rs.getString("client_phone")));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_gender"));
            actual.add(rs.getString("client_birthdate"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected);


    }

        @DataProvider
    public Object [][] getData() throws IOException {
            return getMyData("data/ClientTestData.xlsx","DBTesting");
        }


}
