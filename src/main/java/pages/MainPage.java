package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By CONSTRUCTOR = By.xpath(".//p[text()='Конструктор']");
    private static final By LOGO = By.className("AppHeader_header__logo__2D0X2");
    private static final By PERSONAL_ACCOUNT = By.xpath("//*[@id=\"root\"]/div/header/nav/a");
    private static final By LOG_IN_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    private static final By BURGER_CONSTRUCTOR = By.className("BurgerIngredients_ingredients__1N8v2");
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

    @Step("")
    public void logInButtonClick() {
        driver.findElement(LOG_IN_BUTTON).click();
    }

    @Step("")
    public void constructorButtonClick() {
        driver.findElement(CONSTRUCTOR).click();
    }

    @Step("")
    public void logoClick() {
        driver.findElement(LOGO).click();
    }

    @Step("")
    public boolean isConstructorDisplayed() {
        constructorButtonClick();
        WebElement constructor = new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(BURGER_CONSTRUCTOR));
        return constructor.isDisplayed();
    }

    @Step("")
    public boolean isLogoWork() {
        logoClick();
        WebElement constructor = new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(BURGER_CONSTRUCTOR));
        return constructor.isDisplayed();
    }

    @Step
    public void bunsClick(){
        driver.findElement(BUNS).click();
    }

    @Step
    public void sauceClick(){
        driver.findElement(SAUCE).click();
    }

    @Step
    public void fillingClick(){
        driver.findElement(FILLING).click();
    }

    @Step("")
    public boolean isBunsElementDisplayed() {
        bunsClick();
        WebElement element = new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(BUNS_ELEMENT));
        return element.isDisplayed();
    }

    @Step("")
    public boolean isSauceElementDisplayed() {
        sauceClick();
        WebElement element = new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(SAUCE_ELEMENT));
        return element.isDisplayed();
    }

    @Step("")
    public boolean isFillingElementDisplayed() {
        fillingClick();
        WebElement element = new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(FILLING_ELEMENT));
        return element.isDisplayed();
    }
}