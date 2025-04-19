package main.wifischeduler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoLogin {
    private WebDriver driver;

    public AutoLogin(String driverPath) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        this.driver = new ChromeDriver();
    }

    public String getTotalUse(String url, String username, String password) {
        try {

            driver.get(url);


            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys(username);


            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys(password);


            WebElement signInButton = driver.findElement(By.tagName("button"));
            signInButton.click();


            Thread.sleep(5000);


            WebElement totalUseElement = driver.findElement(By.xpath("//td[contains(text(),'Total Use:')]/following-sibling::td"));
            return totalUseElement.getText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {

            driver.quit();
        }
    }

    public static void main(String[] args) {
        AutoLogin autoLogin = new AutoLogin("F:\\Wifi Scheduler JavaFX\\chromedriver.exe");
        String totalUse = autoLogin.getTotalUse("http://10.220.20.12/index.php/home/login", "ridwankhan", "Ridhan736");

        if (totalUse != null) {
            System.out.println("Total Use: " + totalUse);
        } else {
            System.out.println("Failed to retrieve Total Use.");
        }
    }
}
