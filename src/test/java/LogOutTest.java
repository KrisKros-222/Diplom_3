import api.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class LogOutTest {
    private static final String URL = "https://stellarburgers.nomoreparties.site/";

    private WebDriver driver;
    private UserSteps user;
    private Response creation;
    MainPage mainPage;
    PersonalAccountPage persAccPage;

    @Before
    public void before() {
        String browser = System.getProperty("browser","chrome");
        driver = DriverFactory.getDriver(browser);

        mainPage = new MainPage(driver);
        persAccPage = new PersonalAccountPage(driver);

        user = new UserSteps(URL);
        creation = user.createUser();
        driver.get(URL);
    }

    @Test
    @DisplayName("Проверка выхода из аккаунта")
    @Description("Необходимо войти в аккаунт и перейти в ЛК, там нажать на кнопку Выйти")
    public void logOutTest() {
        mainPage.personalAccountClick();
        persAccPage.loginFlow(user.getEmail(), user.getPassword());
        mainPage.personalAccountClick();
        persAccPage.logOutButtonClick();
        Assert.assertTrue(persAccPage.isPageDisplayed());
    }

    @After
    public void after() {
        user.getTokenAndDeleteUser(creation);
        driver.quit();
    }
}
