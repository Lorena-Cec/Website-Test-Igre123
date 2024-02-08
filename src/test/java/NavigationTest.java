import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationTest {
    public WebDriver driver;
    public String testURL = "https://www.igre123.net/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }
    @Test
    public void GamesNavigationTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".categories__nav--left > li:nth-child(1)")).click();
        Thread.sleep(1000);

        String titleName = "Puzzle \uD83D\uDD79\uFE0F Igraj Puzzle besplatno na Igre123";
        String actualTitle = driver.getTitle();

        if(titleName.equals(actualTitle)){
            System.out.println("Navigation to puzzle successfull");
        }
        else{
            System.out.println("Navigation fail");
        }
        driver.navigate().back();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".categories__nav--left > li:nth-child(4)")).click();
        Thread.sleep(1000);

        String titleName2 = "Sudoku igre \uD83D\uDD79\uFE0F Igraj Sudoku igre besplatno na Igre123";
        String actualTitle2 = driver.getTitle();

        if(titleName2.equals(actualTitle2)){
            System.out.println("Navigation to sudoku successfull");
        }
        else{
            System.out.println("Navigation fail");
        }
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}