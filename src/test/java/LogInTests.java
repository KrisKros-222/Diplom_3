import api.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;

public class LogInTests {
    private static final String URL = "https://stellarburgers.nomoreparties.site/";

    private WebDriver driver;
    private UserSteps user;
    private Response creation;
    MainPage mainPage;
    PersonalAccountPage persAccPage;
    RegisterPage regPage;
    ResetPasswordPage resetPage;

    @Before
    public void before() {
        String browser = System.getProperty("browser","chrome");
        driver = DriverFactory.getDriver(browser);

        mainPage = new MainPage(driver);
        persAccPage = new PersonalAccountPage(driver);
        regPage = new RegisterPage(driver);
        resetPage = new ResetPasswordPage(driver);

        user = new UserSteps(URL);
        creation = user.createUser();
        driver.get(URL);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    @Description("При нажатии происходит переход в ЛК, в котором можно ввести данные аккаунта")
    public void mainPageLogInTest() {
        mainPage.logInButtonClick();
        persAccPage.loginFlow(user.getEmail(), user.getPassword());
        Assert.assertTrue(mainPage.isConstructorDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("При нажатии происходит переход в ЛК, в котором можно ввести данные аккаунта")
    public void personalAccountLogInTest() {
        mainPage.personalAccountClick();
        persAccPage.loginFlow(user.getEmail(), user.getPassword());
        Assert.assertTrue(mainPage.isConstructorDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации,")
    @Description("При нажатии происходит переход в ЛК, в котором можно ввести данные аккаунта")
    public void registrationFormLogInTest() {
        mainPage.personalAccountClick();
        persAccPage.registerButtonClick();
        regPage.toLogInButtonClick();
        persAccPage.loginFlow(user.getEmail(), user.getPassword());
        Assert.assertTrue(mainPage.isConstructorDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("При нажатии происходит переход в ЛК, в котором можно ввести данные аккаунта")
    public void resetPasswordLogInTest() {
        mainPage.personalAccountClick();
        persAccPage.resetPasswordButtonClick();
        resetPage.loginButtonClick();
        persAccPage.loginFlow(user.getEmail(), user.getPassword());
        Assert.assertTrue(mainPage.isConstructorDisplayed());
    }

    @After
    public void after() {
        user.getTokenAndDeleteUser(creation);
        driver.quit();
    }
}
