import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class GamePlayTest {
    public WebDriver driver;
    public String testURL = "https://www.igre123.net/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }
    @Test
    public void GamesPlayTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"desktopBody\"]/main/div/section[1]/div/div[1]/a/img")).click();
        Thread.sleep(5000);

        driver.switchTo().frame("html5-game-frame");
        WebElement canvas = waitForElementToBeLoaded(By.id("canvasMain"));
        Thread.sleep(5000);
        Assert.assertTrue(canvas.isDisplayed());
    }
    private WebElement waitForElementToBeLoaded(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}