package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login;

public class LoginTest {

    @Test
    public void loginTest()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://amolujagare.com/stockmaster/");

        Login login = new Login(driver);
        login.setUsername("amolujagare@gmail.com");
        login.setPassword("admin123");
        login.clickLogin();
    }
}
