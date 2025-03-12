import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.MainPage;
import pages.PersonalAccountPage;
import pages.RegisterPage;

public class RegistrationTests {
    private static final String URL = "https://stellarburgers.nomoreparties.site/";

    WebDriver driver;
    MainPage mainPage;
    PersonalAccountPage persAccPage;
    RegisterPage register;

    @Before
    public void before() {
        //System.setProperty("webdriver.chrome.driver","C:\\Program Files\\WebDriver\\bin\\yandexdriver-win64\\yandexdriver.exe");
        driver = new ChromeDriver();

        mainPage = new MainPage(driver);
        persAccPage = new PersonalAccountPage(driver);
        register = new RegisterPage(driver);

        driver.get(URL);
        mainPage.personalAccountClick();
        persAccPage.registerButtonClick();
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Для успешной регистрации нужно заполнить все обязательные поля и нажать на Зарегистрироваться")
    public void successfulRegistration() {
        register.fillRegForm("Vasya","VVV678@yandex.ru","56983892");
    }

    @Test
    @DisplayName("Появлении ошибки при вводе некорректного пароля")
    @Description("Ввести в поле Пароль значение длиной менее 6 символов")
    public void registrationWithIncorrectPassword() {
        register.wrongRegistration("Vasya","VVV678@yandex.ru","111");
        Assert.assertTrue(register.isErrorMessageDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}