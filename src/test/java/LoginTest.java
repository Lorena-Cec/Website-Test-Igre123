import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    public WebDriver driver;
    public String testURL = "https://www.igre123.net/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }
    @Test
    public void GamesLoginTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"desktopBody\"]/header/div/nav[2]/ul/li[1]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("txtEmail")).sendKeys("testiranje123");
        Thread.sleep(1000);
        driver.findElement(By.id("txtPassword")).sendKeys("testiranje123");
        Thread.sleep(1000);
        driver.findElement(By.name("btnLogin")).click();

        String titleName = "Igre i Igrice - Igraj besplatno na Igre123";
        String actualTitle = driver.getTitle();

        if(titleName.equals(actualTitle)){
            System.out.println("Login successfull");
        }
        else{
            System.out.println("Login fail");
        }
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
