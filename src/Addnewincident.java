import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Addnewincident {
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
    public void testAddnewincident() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys("john@example.com");
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("commit")).click();
        assertEquals("×\nSigned in successfully.", driver.findElement(By.xpath("//div[2]/div/div/div")).getText());
        try {
            assertEquals("Test Incident", driver.findElement(By.linkText("Test Incident")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Investigate incident report", driver.findElement(By.xpath("//tr[4]/td[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Test Incident")).click();
        try {
            assertEquals("Incident Investigation : Test Incident", driver.findElement(By.cssSelector("h3")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("incident_investigation_investigator_comments")).clear();
        driver.findElement(By.id("incident_investigation_investigator_comments")).sendKeys("Comment1");
        driver.findElement(By.id("incident_investigation_self_disclosure_required")).click();
        driver.findElement(By.id("incident_investigation_patient_disclosure_required")).click();
        driver.findElement(By.name("save_and_complete")).click();
        try {
            assertEquals("Final Approval", driver.findElement(By.xpath("//tr[5]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("John Smith", driver.findElement(By.xpath("//table[2]/tbody/tr/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Charlie Smith", driver.findElement(By.xpath("//table[2]/tbody/tr[5]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Completed", driver.findElement(By.xpath("//td[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        assertEquals("Comment1", driver.findElement(By.xpath("//td[4]")).getText());
        try {
            assertEquals("No", driver.findElement(By.xpath("//td[5]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Yes", driver.findElement(By.xpath("//td[6]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("No", driver.findElement(By.xpath("//td[7]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Yes", driver.findElement(By.xpath("//td[8]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("John Smith")).click();
        driver.findElement(By.linkText("Logout")).click();
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
