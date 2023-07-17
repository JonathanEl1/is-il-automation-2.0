package base;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import config.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Listeners({ScreenShooter.class})
public class BaseTest extends WebDriverConfig {

    final String CHROME_DRIVER_PATH = "C:\\Users\\adminIroads\\Downloads\\chromedriver_win32\\chromedriver.exe";
    //TODO: need to change the url to be in the Test Suite xml
    final String URL = "https://dev2-is-il.creatio.com";

    @BeforeSuite
    public void setupSuite() {
        SelenideLogger.addListener("AllureListener",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
                        .enableLogs(LogType.CLIENT, Level.FINE)
                        .enableLogs(LogType.SERVER, Level.FINE));
    }

    @BeforeTest
    @Parameters({"url"})
    public void setupTest(String url) {
        Map<String, Object> prefs = new HashMap<>();
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("disable-infobars");

        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterTest
    public void afterTest() {
        closeWebDriver();
    }

    @AfterSuite
    public void tearDown() {
        closeWebDriver();
    }
}
