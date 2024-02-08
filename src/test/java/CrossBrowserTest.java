import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CrossBrowserTest {
    public WebDriver driver;
    public String testURL = "https://www.igre123.net/";

    @BeforeMethod
    @Parameters("browser")
    public void setupTest(String browser) throws Exception{
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.navigate().to(testURL);
        }
        else if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.navigate().to(testURL);
        }
        else{
            throw new Exception("Browser is not correct");
        }
    }

    @Test
    public void GamesBrowserTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"desktopBody\"]/header/div/nav[2]/ul/li[1]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("txtEmail")).sendKeys("testiranje123");
        Thread.sleep(2000);
        driver.findElement(By.id("txtPassword")).sendKeys("TESTIRANJE123"); //password: testiranje123
        Thread.sleep(2000);
        driver.findElement(By.name("btnLogin")).click();

        String titleName = "Prijava na Igre123.net";
        String actualTitle = driver.getTitle();

        if(titleName.equals(actualTitle)){
            System.out.println("Login data is case sensitive");
        }
        else{
            System.out.println("Login data is not case sensitive");
        }
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
