package AC_Practice_day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q1_kiwi {



    // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
    // Sectiginiz dil ve para birimini dogrulayin

    // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
    // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
    // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
    // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void Test01(){
        // https://www.kiwi.com sayfasina gidin
        driver.get("https://www.kiwi.com");
        // Cookies i kabul edin
        WebElement cookies=driver.findElement(By.xpath("//div[text()='Kabul et']"));
            cookies.click();
        // Kayfa basliginin "kiwi" icerdigini test edin
       Assert.assertTrue(driver.getTitle().contains("Kiwi"));
        // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
        WebElement dilsecimi= driver.findElement(By.xpath("//*[text()='TRY']"));
        dilsecimi.click();
        WebElement selectWebElemeti= driver.findElement(By.xpath("//select[@data-test='LanguageSelect']"));
        Select select=new Select(selectWebElemeti);
        select.selectByValue("tr");

        WebElement currencyElementi=driver.findElement(By.xpath("//select[@data-test='CurrencySelect']"));
        Select select1=new Select(currencyElementi);
        select1.selectByVisibleText("Turkish lira - TRY");

        WebElement saveButton= driver.findElement(By.xpath("//button[@data-test='SubmitRegionalSettingsButton']"));
        saveButton.click();

        // Ucus secenegi olarak tek yon secelim
        WebElement tekYonMenu= driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContentChildren__StyledButtonPrimitiveContentChildren-sc-1m4y8u8-0 jLcmiD'])[10]"));
        tekYonMenu.click();
        WebElement kalkis=driver.findElement(By.xpath("[//div[@class='SearchFieldstyled__SearchFieldLabel-sc-1f3jsso-4 dTMkOh'])[1]"));
            kalkis.click();

            WebElement varis= driver.findElement(By.xpath("(//div[@class='SearchFieldstyled__SearchFieldLabel-sc-1f3jsso-4 dTMkOh'])[2]"));
                varis.sendKeys("Kayseri");
    }
}
