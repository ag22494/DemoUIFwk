import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * @author: Aakash Gupta
 */
public class TestUI extends TestBase {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = setUpDriver();
    }

    @Test
    public void test() {

    }
}
