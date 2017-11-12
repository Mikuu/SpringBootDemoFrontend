import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class UITest {
    private String chromeDriverProperty = "webdriver.chrome.driver";
    private String chromeDriverExcutable = "/Users/ariman/Software/selenium/chromedriver/chromedriver";
    private static final String mockServerScenarioResetURL = "http://localhost:3000/__admin/scenarios/reset";

    private String userNameInput = "#uname";
    private String ageInput = "#age";
    private String salaryInput = "#salary";
    private String addButton = "body > div > div > div:nth-child(1) > div.panel-body > div > form > div:nth-child(5) > div > input";

    private String resultName = "body > div > div > div:nth-child(2) > div.panel-body > div > table > tbody > tr > td:nth-child(2)";
    private String resultAge = "body > div > div > div:nth-child(2) > div.panel-body > div > table > tbody > tr > td:nth-child(3)";
    private String resultSalary = "body > div > div > div:nth-child(2) > div.panel-body > div > table > tbody > tr > td:nth-child(4)";

    @BeforeClass
    public static void resetScenario() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(mockServerScenarioResetURL, null);
    }

    @Test
    public void basicTest() throws Exception {
        System.setProperty(chromeDriverProperty, chromeDriverExcutable);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://localhost:8001/SpringDemo");

        driver.findElement(By.cssSelector(userNameInput)).sendKeys("Miku");
        driver.findElement(By.cssSelector(ageInput)).sendKeys("18");
        driver.findElement(By.cssSelector(salaryInput)).sendKeys("18000");

        driver.findElement(By.cssSelector(addButton)).click();

        assertEquals(driver.findElement(By.cssSelector(resultName)).getText(), "Miku");
        assertEquals(driver.findElement(By.cssSelector(resultAge)).getText(), "18");
        assertEquals(driver.findElement(By.cssSelector(resultSalary)).getText(), "18000");

        driver.quit();
    }

}
