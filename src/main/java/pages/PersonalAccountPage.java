package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.RegisterPage.REG_EMAIL;
import static pages.RegisterPage.REG_PASSWORD;

public class PersonalAccountPage {
    private WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    protected static final By PA_EMAIL = By.className("input pr-6 pl-6 input_type_text input_size_default");
    private static final By PA_PASSWORD = By.className("input pr-6 pl-6 input_type_password input_size_default");
    private static final By LOGIN_BUTTON = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa");
    private static final By REGISTER_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");
    private static final By RESET_PASSWORD_BUTTON = By.xpath(".//a[text()='Восстановить пароль']");

    @Step("Переход на страницу регистрации")
    public void registerButtonClick() {
        new WebDriverWait(driver,3)
                .until(ExpectedConditions.visibilityOfElementLocated(REGISTER_BUTTON));
        driver.findElement(REGISTER_BUTTON).click();
    }

}
