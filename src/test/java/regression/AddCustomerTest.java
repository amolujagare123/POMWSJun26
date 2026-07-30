package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddCustomer;
import pages.Customers;
import pages.Dashboard;
import pages.Login;

import java.time.Duration;

public class AddCustomerTest {
    WebDriver driver;
    @BeforeClass
    public void doLogin()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://amolujagare.com/stockmaster/");

        Login login = new Login(driver);
        login.setUsername("amolujagare@gmail.com");
        login.setPassword("admin123");
        login.clickLogin();
    }

    @Test
    public void loginTest()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Dashboard dashboard = new Dashboard(driver);
        dashboard.clickCustomer();

        Customers customers = new Customers(driver);
        customers.clickAddCustomer();

        AddCustomer addCustomer = new AddCustomer(driver);

        addCustomer.enterFullName("Rahul Sharma");
        addCustomer.enterEmail("rahul.sharma@gmail.com");
        addCustomer.enterPhone("9876543210");
        addCustomer.enterCompany("Sharma Technologies");
        addCustomer.enterCreditLimit("5000");
        addCustomer.enterCity("Pune");
        addCustomer.enterCountry("India");
        addCustomer.selectStatus("Active");
        addCustomer.enterAddress("Baner, Pune");
        addCustomer.enterNotes("Customer added using Selenium automation.");
        addCustomer.clickAddCustomer();
    }
}
