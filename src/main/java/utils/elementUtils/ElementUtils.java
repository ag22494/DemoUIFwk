package utils.elementUtils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 *  @author : Aakash Gupta
 */
public class ElementUtils {

    WebDriverWait wait = null;

    public void selectDropDownByVisibleText(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    public void selectDropDownByValue(WebElement element, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

    public void selectDropDownByIndex(WebElement element, int index) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }

    public void selectCheckbox(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        boolean checkstatus;
        checkstatus = element.isSelected();
        if (!checkstatus)
            element.click();
    }

    public void unselectCheckbox(WebElement element) {
        boolean checkstatus;
        wait.until(ExpectedConditions.elementToBeClickable(element));
        checkstatus = element.isSelected();
        if (checkstatus)
            element.click();

    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeys(WebElement element, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    public boolean isEnabled(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Boolean state = false;
        state = element.isEnabled();
        return state;
    }

    public void sendKeysWithoutClear(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    public void sendKeys(WebElement element, int value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(String.valueOf(value));
    }

    public void sendKeys(WebElement element, boolean value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(String.valueOf(value));
    }

    public String getAttribute(WebElement element, String attributeName) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute(attributeName);
    }

    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public boolean validateUrl(String url) {
        return wait.until(ExpectedConditions.urlContains(url));
    }

    public boolean isElementPresent(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    public boolean isElementClickable(WebElement element) {
        boolean clickable;
        clickable = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
        return clickable;
    }

    public boolean isDisplayed(WebElement element) {
        try {
            //isElementPresent(element);
            if(element.isDisplayed())
                return element.isDisplayed();
        }catch (NoSuchElementException ex) {
            return false;
        }
        return false;
    }

}
