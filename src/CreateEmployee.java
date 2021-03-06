
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;

public class CreateEmployee {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

        public static void main () {
            System.out.println("ivide");
        }

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://7atlis.bigbinary.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCreateEmployee() throws Exception {
        driver.get("http://7atlis.bigbinary.com/");
        assertEquals("Please Sign in", driver.findElement(By.cssSelector("h2")).getText());
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys("sam@example.com");
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("commit")).click();
        assertEquals("×\nSigned in successfully.", driver.findElement(By.xpath("//div[2]/div/div/div")).getText());
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.linkText("American Indian Health & Services"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        assertEquals("American Indian Health & Services", driver.findElement(By.linkText("American Indian Health & Services")).getText());
        driver.findElement(By.linkText("American Indian Health & Services")).click();
        driver.findElement(By.xpath("//table[@id='DataTables_Table_1']/thead/tr/th/div[2]/a/span")).click();
        assertEquals("Add New Employee", driver.findElement(By.cssSelector("h3")).getText());
        assertEquals("Personal Information", driver.findElement(By.cssSelector("h4")).getText());
        driver.findElement(By.id("employee_email")).clear();

        Random randomGenerator = new Random();
        int empNum = randomGenerator.nextInt(100);

        driver.findElement(By.id("employee_email")).sendKeys("emp_" + empNum + "@gmail.com");
        driver.findElement(By.id("employee_first_name")).clear();
        driver.findElement(By.id("employee_first_name")).sendKeys("emp_" + empNum);
        driver.findElement(By.id("employee_last_name")).clear();
        driver.findElement(By.id("employee_last_name")).sendKeys("last_name");
        driver.findElement(By.name("commit")).click();
        assertEquals("Employer Related Information", driver.findElement(By.xpath("//form[@id='new_employee']/feildset/div[2]/h3")).getText());
        driver.findElement(By.id("employee_employee_number")).clear();
        driver.findElement(By.id("employee_employee_number")).sendKeys(String.valueOf(empNum));
        driver.findElement(By.name("commit")).click();
        assertEquals("AAPC Member Details", driver.findElement(By.xpath("//form[@id='new_employee']/feildset/div[3]/div/h3")).getText());
        driver.findElement(By.name("commit")).click();
        assertEquals("Provider Details", driver.findElement(By.xpath("//form[@id='new_employee']/feildset/div[4]/div/h3")).getText());
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.name("commit")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.linkText("emp_" + empNum))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        assertEquals("×\nEmployee emp_" + empNum + " was created", driver.findElement(By.xpath("//div[2]/div/div/div")).getText());
        driver.findElement(By.linkText("Sam Smith")).click();
        driver.findElement(By.linkText("Logout")).click();
        assertEquals("×\nSigned out successfully.", driver.findElement(By.xpath("//div[2]/div/div/div")).getText());
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
}