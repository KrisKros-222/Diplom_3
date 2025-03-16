import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.*;

public class RegistrationTests {
    private static final String URL = "https://stellarburgers.nomoreparties.site/";

    private WebDriver driver;
    MainPage mainPage;
    PersonalAccountPage persAccPage;
    RegisterPage register;

    @Before
    public void before() {
        String browser = System.getProperty("browser","chrome");
        driver = DriverFactory.getDriver(browser);

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
    public void successfulRegistrationTest() {
        register.fillRegForm();
        Assert.assertTrue(register.isPersonalAccountAppear());
    }

    @Test
    @DisplayName("Появлении ошибки при вводе некорректного пароля")
    @Description("Ввести в поле Пароль значение длиной менее 6 символов")
    public void registrationWithIncorrectPasswordTest() {
        register.wrongRegistration();
        Assert.assertTrue(register.isErrorMessageDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}