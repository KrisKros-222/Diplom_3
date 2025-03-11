package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By REGISTRATION_FORM = By.className("Auth_form__3qKeq mb-20");
    public static final By REG_NAME = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    public static final By REG_EMAIL = By.cssSelector("#root > div > main > div > form > fieldset:nth-child(2) > div > div > input");
    public static final By REG_PASSWORD = By.xpath(".//input[@type = 'password']");
    public static final By TO_REGISTER_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    public static final By TO_LOG_IN_BUTTON = By.className("Auth_link__1fOlj");
    private static final By ERROR_MESSAGE = By.xpath(".//p[@class = 'input__error text_type_main-default']");

    @Step("")
    public void inputName(String name) {
        driver.findElement(REG_NAME).click();
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(REG_NAME));
        driver.findElement(REG_NAME).sendKeys(name);
    }

    @Step("")
    public void inputEmail(String email) {
        driver.findElement(REG_EMAIL).click();
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(REG_EMAIL));
        driver.findElement(REG_EMAIL).sendKeys(email);
    }

    @Step("")
    public void inputPassword(String password) {
        driver.findElement(REG_PASSWORD).click();
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(REG_PASSWORD));
        driver.findElement(REG_PASSWORD).sendKeys(password);
    }

    @Step("")
    public void inputIncorrectPassword(String wrongPass) {
        driver.findElement(REG_PASSWORD).click();
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(REG_PASSWORD));
        driver.findElement(REG_PASSWORD).sendKeys(wrongPass);
    }

    @Step("")
    public void regButtonClick() {
        driver.findElement(TO_REGISTER_BUTTON).click();
    }

    @Step
    public boolean isErrorMessageDisplayed() {
        WebElement error = new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        return error.isDisplayed();
    }

    public void fillRegForm(String name, String email, String password) {
        inputName(name);
        inputEmail(email);
        inputPassword(password);
        regButtonClick();
    }

    public void wrongRegistration(String name, String email, String wrongPass) {
        inputName(name);
        inputEmail(email);
        inputIncorrectPassword(wrongPass);
        regButtonClick();
        isErrorMessageDisplayed();
    }

}
