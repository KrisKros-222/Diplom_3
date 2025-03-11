package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.PersonalAccountPage.PA_EMAIL;

public class MainPage {
    private WebDriver driver;
    private static final String URL = "https://stellarburgers.nomoreparties.site/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By CONSTRUCTOR = By.xpath(".//p[text()='Конструктор']");
    private static final By LOGO = By.className("AppHeader_header__logo__2D0X2");
    private static final By PERSONAL_ACCOUNT = By.xpath("//*[@id=\"root\"]/div/header/nav/a");
    private static final By LOG_IN_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    private static final By BUNS = By.xpath(".//span[text()='Булки']");
    private static final By BUNS_ELEMENT = By.xpath(".//img[@alt='Флюоресцентная булка R2-D3']");
    private static final By SAUCE = By.xpath(".//span[text()='Соусы']");
    private static final By SAUCE_ELEMENT = By.xpath(".//img[@alt='Соус Spicy-X']");
    private static final By FILLING = By.xpath(".//span[text()='Начинки']");
    private static final By FILLING_ELEMENT = By.xpath(".//img[@alt='Мясо бессмертных моллюсков Protostomia']");

    @Step("Переход в Личный кабинет")
    public void personalAccountClick() {
        driver.findElement(PERSONAL_ACCOUNT).click();

    }


}
