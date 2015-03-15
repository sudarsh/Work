import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Verifyfapproval {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://7atlis.bigbinary.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testVerifyfapproval() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys("sam@example.com");
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("commit")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.linkText("American Indian Health & Services"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.linkText("American Indian Health & Services")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//table[@id='DataTables_Table_5']/tbody/tr[last()]/td/a"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//table[@id='DataTables_Table_5']/tbody/tr[last()]/td/a")).click();
        try {
            assertEquals("My_Test", driver.findElement(By.cssSelector("td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Testing123", driver.findElement(By.xpath("//tr[2]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Sudarsh Ms", driver.findElement(By.xpath("//tr[3]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Yes", driver.findElement(By.xpath("//tr[12]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Completed", driver.findElement(By.xpath("//tr[5]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Test", driver.findElement(By.xpath("//table[4]/tbody/tr/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Final Approver Name", driver.findElement(By.xpath("//table[2]/tbody/tr[5]/th")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // ERROR: Caught exception [ERROR: Unsupported command [getEval |  | ]]
        driver.findElement(By.linkText("Sam Smith")).click();
        driver.findElement(By.linkText("Logout")).click();
        try {
            assertEquals("×\nSigned out successfully.", driver.findElement(By.xpath("//div[2]/div/div/div")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
