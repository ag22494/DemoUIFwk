package utils.driverUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class DriverUtils {

    WebDriver webDriver;
    String parentWindowHandler = null;
    String subWindowHandler = null;

    public void getUrl(String url) {
        webDriver.get(url);
    }

    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
    }

    public String getTitle() {
        return webDriver.getTitle();

    }

    public String getAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void switchToPopUp() {

        Set<String> handles = webDriver.getWindowHandles(); // get all window
        // handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        webDriver.switchTo().window(subWindowHandler); // switch to popup window
    }

    public void clickBrowserBack() {
        webDriver.navigate().back();
    }

    public void switchToParentFromPopup() {
        webDriver.switchTo().window(parentWindowHandler);
    }

    public void acceptAlert() {
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
    }





}
