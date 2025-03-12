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
import pages.ResetPasswordPage;

public class LogInTests {
    private static final String URL = "https://stellarburgers.nomoreparties.site/";
    private String email = "kjkjoj@yandex.ru";
    private String password = "5558656";

    WebDriver driver;
    private UserSteps user;
    private Response creation;
    MainPage mainPage;
    PersonalAccountPage persAccPage;
    RegisterPage regPage;
    ResetPasswordPage resetPage;

    @Before
    public void before() {
        //System.setProperty("webdriver.chrome.driver","C:\\Program Files\\WebDriver\\bin\\yandexdriver-win64\\yandexdriver.exe");
        driver = new ChromeDriver();

        mainPage = new MainPage(driver);
        persAccPage = new PersonalAccountPage(driver);
        regPage = new RegisterPage(driver);
        resetPage = new ResetPasswordPage(driver);

        user = new UserSteps(URL);
        creation = user.createUser(email,password,"Sasha");
        driver.get(URL);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    @Description("При нажатии происходит переход в ЛК, в котором можно ввести данные аккаунта")
    public void mainPageLogIn() {
        mainPage.logInButtonClick();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("При нажатии происходит переход в ЛК, в котором можно ввести данные аккаунта")
    public void personalAccountLogIn() {
        mainPage.personalAccountClick();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации,")
    @Description("При нажатии происходит переход в ЛК, в котором можно ввести данные аккаунта")
    public void registrationFormLogIn() {
        mainPage.personalAccountClick();
        persAccPage.registerButtonClick();
        regPage.toLogInButtonClick();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("При нажатии происходит переход в ЛК, в котором можно ввести данные аккаунта")
    public void resetPasswordLogIn() {
        mainPage.personalAccountClick();
        persAccPage.resetPasswordButtonClick();
        resetPage.loginButtonClick();
    }

    @After
    public void after() {
        persAccPage.loginFlow(email,password);
        user.getTokenAndDeleteUser(creation);
        driver.quit();
    }
}
