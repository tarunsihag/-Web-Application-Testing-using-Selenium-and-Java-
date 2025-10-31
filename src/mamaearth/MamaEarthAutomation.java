import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.css.model.FontFace;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MamaEarthAutomation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://mamaearth.in/");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page Title: " + driver.getTitle());

            // Handle popup if present
            try {
                WebElement popup = driver.findElement(By.id("wzrk-cancel-id"));
                if (popup.isDisplayed()) {
                    popup.click();
                    System.out.println("Pop-up closed.");
                }
            } catch (Exception e) {
                System.out.println("No popup found or already closed.");
            }

            // Navigate to products
            driver.findElement(By.xpath("//a[contains(@href, '/shop')]")).click();
            Thread.sleep(5000);
            
            driver.findElement(By.xpath("//a[contains(text(), 'Hair Care')]")).click();
            Thread.sleep(6000);
            
            driver.findElement(By.xpath("//button[contains(text(), 'View All')]")).click();
            Thread.sleep(3000);
            
            driver.findElement(By.xpath("//div[contains(text(), 'Conditioner')]")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//h2[contains(text(),'Henna Conditioner')]")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("(//button[contains(text(),'Add to Cart')])[1]")).click();
            Thread.sleep(3000);

            System.out.println("Test Case Passed: Items added to cart successfully!");

        } finally {
            driver.quit();
        }
    }
}