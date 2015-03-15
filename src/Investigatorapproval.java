import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Investigatorapproval {
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
    public void testInvestigatorapproval() throws Exception {
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
        driver.findElement(By.xpath("//table[@id='DataTables_Table_5']/thead/tr/th/div[2]/a/span")).click();
        driver.findElement(By.id("incident_title")).clear();
        driver.findElement(By.id("incident_title")).sendKeys("My_Test");
        driver.findElement(By.id("incident_persons_involved_ids")).click();
        driver.findElement(By.id("incident_description")).clear();
        driver.findElement(By.id("incident_description")).sendKeys("Testing123");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("(//input[@id='employee_id'])[13]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("(//input[@id='employee_id'])[13]")).click();
        // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
        driver.findElement(By.cssSelector("feildset > input[name=\"commit\"]")).click();
        driver.findElement(By.id("incident_reported_anonymously_true")).click();
        driver.findElement(By.name("commit")).click();
        assertEquals("×\nIncident was reported successfully.", driver.findElement(By.xpath("//div[2]/div/div/div")).getText());
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
            assertEquals("Ready For Assignment", driver.findElement(By.xpath("//tr[5]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Yes", driver.findElement(By.xpath("//tr[12]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//a[contains(@href, '/my/tasks')]")).click();
        driver.findElement(By.linkText("My_Test")).click();
        driver.findElement(By.id("incident_incident_investigators_attributes_0_user_id")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.cssSelector(".modal"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//input[@value=\"John Smith\"]")).click();
        driver.findElement(By.xpath("//form[@data-behavior='employee-list-selector']/feildset/input[@name=\"commit\"]")).click();
        driver.findElement(By.id("incident_investigation_due_date")).clear();
        driver.findElement(By.id("incident_investigation_due_date")).sendKeys("12-10-2015");
        driver.findElement(By.id("incident_final_approver_id")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.cssSelector(".modal"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value=\"Charlie Smith\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//form[@data-behavior='employee-list-selector']/feildset/input[@name=\"commit\"]")).click();
        driver.findElement(By.name("commit")).click();
        assertEquals("×\nIncident was successfully assigned.", driver.findElement(By.xpath("//div[2]/div/div/div")).getText());
        try {
            assertEquals("Investigation", driver.findElement(By.xpath("//tr[5]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("John Smith", driver.findElement(By.xpath("//table[2]/tbody/tr/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Investigation", driver.findElement(By.xpath("//td[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Charlie Smith", driver.findElement(By.xpath("//table[2]/tbody/tr[5]/td")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Sam Smith")).click();
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
