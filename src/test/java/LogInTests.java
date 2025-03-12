import api.UserSteps;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.PersonalAccountPage;
import pages.RegisterPage;

public class LogInTests {
    private static final String URL = "https://stellarburgers.nomoreparties.site/";
    private String email = "kjkj@yandex.ru";
    private String password = "555656";
    WebDriver driver = new ChromeDriver();

    private UserSteps user;
    private Response creation;

    MainPage mainPage = new MainPage(driver);
    PersonalAccountPage persAccPage = new PersonalAccountPage(driver);
    RegisterPage regPage = new RegisterPage(driver);

    @Before
    public void before() {
        user = new UserSteps(URL);
        creation = user.createUser(email,password,"Sasha");
        driver.get(URL);
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    @Description("")
    public void mainPageLogIn() {
        mainPage.logInButtonClick();
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    @Description("")
    public void personalAccountLogIn() {
        mainPage.personalAccountClick();
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации,")
    @Description("")
    public void registrationFormLogIn() {
        mainPage.personalAccountClick();
        persAccPage.registerButtonClick();
        regPage.toLogInButtonClick();
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    @Description("")
    public void resetPasswordLogIn() {
        mainPage.personalAccountClick();
    }

    @After
    public void after() {
        persAccPage.resetPasswordButtonClick();
        user.getTokenAndDeleteUser(creation);
        driver.quit();
    }
}
