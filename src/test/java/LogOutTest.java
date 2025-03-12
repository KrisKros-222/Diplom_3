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
    private String email = "kjkj@yandex.ru";
    private String password = "555656";
    WebDriver driver = new ChromeDriver();

    private UserSteps user;
    private Response creation;

    MainPage mainPage = new MainPage(driver);
    PersonalAccountPage persAccPage = new PersonalAccountPage(driver);

    @Before
    public void before() {
        user = new UserSteps(URL);
        creation = user.createUser(email,password,"Sasha");
        driver.get(URL);
    }

    @Test
    @DisplayName("")
    @Description("")
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
