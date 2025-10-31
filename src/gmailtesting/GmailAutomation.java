import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GmailAutomation {
    public static void main(String[] args) {
        // Set Chrome driver path (update according to your system)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://mail.google.com/");

            WebElement emailField = driver.findElement(By.id("identifierId"));
            emailField.sendKeys("your-email@gmail.com");

            WebElement nextButton = driver.findElement(By.id("identifierNext"));
            nextButton.click();
            Thread.sleep(2000);

            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("your-password");

            WebElement passwordNextButton = driver.findElement(By.id("passwordNext"));
            passwordNextButton.click();
            Thread.sleep(5000);

            WebElement composeButton = driver.findElement(By.cssSelector(".T-I.T-I-KE.L3"));
            composeButton.click();
            Thread.sleep(2000);

            WebElement toField = driver.findElement(By.name("to"));
            toField.sendKeys("recipient@gmail.com");

            WebElement subjectField = driver.findElement(By.name("subjectbox"));
            subjectField.sendKeys("Test Email via Selenium");

            WebElement bodyField = driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
            bodyField.sendKeys("This is a test email sent using Selenium WebDriver.");

            WebElement sendButton = driver.findElement(By.cssSelector("div[aria-label='Send ‪(Ctrl-Enter)‬']"));
            sendButton.click();

            System.out.println("Email sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}