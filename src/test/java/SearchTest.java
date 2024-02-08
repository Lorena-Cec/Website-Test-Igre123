import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SearchTest {
    public WebDriver driver;
    public String testURL = "https://www.igre123.net/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }
    @Test
    public void GamesSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]")).click();
        Thread.sleep(1000);
        WebElement searchBar = driver.findElement(By.id("txtSearch"));
        searchBar.sendKeys("Fishing");
        Thread.sleep(1000);
        searchBar.submit();
        Thread.sleep(5000);
        String firstResultText = driver.findElement(By.xpath("//*[@id=\"desktopBody\"]/main/div/div/section/div/div[1]/a/h3")).getText();
        System.out.println(firstResultText);
        Assert.assertTrue(firstResultText.contains("Fishing"));
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}