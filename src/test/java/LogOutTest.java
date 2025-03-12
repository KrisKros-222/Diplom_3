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

public class LogOutTest {
    private static final String URL = "https://stellarburgers.nomoreparties.site/";
    private String email = "kjkjo@yandex.ru";
    private String password = "5556756";

    WebDriver driver;
    private UserSteps user;
    private Response creation;
    MainPage mainPage;
    PersonalAccountPage persAccPage;

    @Before
    public void before() {
        //System.setProperty("webdriver.chrome.driver","C:\\Program Files\\WebDriver\\bin\\yandexdriver-win64\\yandexdriver.exe");
        driver = new ChromeDriver();

        mainPage = new MainPage(driver);
        persAccPage = new PersonalAccountPage(driver);

        user = new UserSteps(URL);
        creation = user.createUser(email,password,"Sasha");
        driver.get(URL);
    }

    @Test
    @DisplayName("Проверка выхода из аккаунта")
    @Description("Необходимо войти в аккаунт и перейти в ЛК, там нажать на кнопку Выйти")
    public void logOutTest() {
        mainPage.personalAccountClick();
        persAccPage.loginFlow(email,password);
        mainPage.personalAccountClick();
        persAccPage.logOutButtonClick();
    }

    @After
    public void after() {
        user.getTokenAndDeleteUser(creation);
        driver.quit();
    }
}
