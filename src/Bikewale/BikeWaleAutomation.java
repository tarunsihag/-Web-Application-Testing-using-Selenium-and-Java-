import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BikeWaleAutomation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://www.bikewale.com/");
            Thread.sleep(2000);

            // City selection
            driver.findElement(By.xpath("//div[contains(@class, 'location-selector')]")).click();
            System.out.println("Clicked on Select City");

            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@placeholder='Search city']")).sendKeys("Jalandhar");

            Thread.sleep(1000);
            driver.findElement(By.xpath("//li[contains(text(), 'Jalandhar')]")).click();
            System.out.println("City selected: Jalandhar");
            
            Thread.sleep(3000);

            // Brand selection
            driver.findElement(By.xpath("//div[contains(text(), 'TVS')]")).click();
            System.out.println("Brand selected: TVS");

            // Navigation
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[contains(text(), 'Top Comparisons')]")).click();
            System.out.println("Navigated to Top Comparisons");

            driver.findElement(By.xpath("//a[contains(text(),'Reviews')]")).click();
            System.out.println("Navigated to Reviews");

            driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
            System.out.println("Navigated to Home");

            driver.findElement(By.xpath("//a[contains(text(),'New Launches')]")).click();
            System.out.println("Navigated to New Launches");

            // Filter by body style
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[contains(text(),'Body Style')]")).click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[contains(text(),'Cruiser')]")).click();
            System.out.println("Selected body style: Cruiser");

            // Select bike
            Thread.sleep(2000);
            WebElement bike = driver.findElement(By.xpath("(//a[contains(@class,'bike')])[1]"));
            System.out.println("Selected Bike: " + bike.getText());
            bike.click();
            
            System.out.println("Test Case Passed: Bike selected successfully!");

        } finally {
            driver.quit();
        }
    }
}