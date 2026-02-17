package Automation.testComponent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver initializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")
                        + "\\src\\main\\java\\Framework\\resources\\Gobal.properties");
        prop.load(fis);

        String browser = prop.getProperty("browser")!=null ? prop.getProperty("browser") : System.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();

            // enable headless ONLY if browser contains "headless"
            if (browser.contains("headless")) {
                options.addArguments("--headless=new");
            }

            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void launchApplication() throws IOException {
        driver = initializeDriver();
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ---------- Utilities ----------

    public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
        String jsonContent = FileUtils.readFileToString(
                new File(filepath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(
                jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {});
    }

    public String takeScreenshot(String testCaseName, WebDriver driver) throws IOException {

        if (driver == null) {
            return null;
        }

        String reportDir = System.getProperty("user.dir") + File.separator + "reports";
        File dir = new File(reportDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String path = reportDir + File.separator + testCaseName + ".png";
        FileUtils.copyFile(source, new File(path));

        return path;
    }
}
