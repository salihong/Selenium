package AC_Practice_day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
    /*
    /*...Exercise1...
    Create a new class under Q1 create main method
    Set Path
    Create chrome driver
    Maximize the window
    Open google home page https://www.google.com/.
    On the same class, Navigate to amazon home page https://www.amazon.com/
    Navigate back to google
    Navigate forward to amazon
    Refresh the page
    Close/Quit the browser
    And last step : print "All Ok" on console
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asuma\\IdeaProjects\\com.seleniumTeam105\\src\\test\\drivers\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
            Thread.sleep(1000);
        driver.navigate().to("https://www.amazon.com");

            driver.manage().window().maximize();
            Thread.sleep(1000);

        driver.get("https://www.amazon.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().back();

        driver.navigate().forward();


        driver.close();
        System.out.println("All is OK ");

    }


}
