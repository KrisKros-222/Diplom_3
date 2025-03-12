package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {
    private WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    protected static final By PA_EMAIL = By.xpath(".//input[@name='name']");
    private static final By PA_PASSWORD = By.xpath(".//input[@type='password']");
    private static final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    private static final By REGISTER_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");
    private static final By RESET_PASSWORD_BUTTON = By.xpath(".//a[text()='Восстановить пароль']");
    private static final By LOG_OUT_BUTTON = By.xpath(".//button[@type='button']");

    @Step("Переход на страницу регистрации")
    public void registerButtonClick() {
        new WebDriverWait(driver,3)
                .until(ExpectedConditions.visibilityOfElementLocated(REGISTER_BUTTON));
        driver.findElement(REGISTER_BUTTON).click();
    }

    @Step("Ввод почты в поле Email")
    public void inputEmail(String email) {
        driver.findElement(PA_EMAIL).click();
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(PA_EMAIL));
        driver.findElement(PA_EMAIL).sendKeys(email);
    }

    @Step("Ввод пароля в поле Пароль")
    public void inputPassword(String password) {
        driver.findElement(PA_PASSWORD).click();
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(PA_PASSWORD));
        driver.findElement(PA_PASSWORD).sendKeys(password);
    }

    @Step("Нажатие на кнопку Войти")
    public void logInButtonClick() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void loginFlow(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        logInButtonClick();
    }

    @Step("Нажатие на кнопку Восстановление пароля")
    public void resetPasswordButtonClick() {
        driver.findElement(RESET_PASSWORD_BUTTON).click();
    }

    @Step("Нажатие на кнопку Выйти")
    public void logOutButtonClick() {
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(LOG_OUT_BUTTON));
        driver.findElement(LOG_OUT_BUTTON);
    }

    @Step("Проверка отображения Личного кабинета")
    public boolean isPageDisplayed() {
        WebElement emailField = new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(PA_EMAIL));
        return emailField.isDisplayed();
    }

}
