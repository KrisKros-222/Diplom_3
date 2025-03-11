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
    WebDriver driver = new ChromeDriver();

    MainPage mainPage = new MainPage(driver);
    PersonalAccountPage persAccPage = new PersonalAccountPage(driver);
    RegisterPage register = new RegisterPage(driver);

    @Before
    public void before() {
        driver.get(URL);
        mainPage.personalAccountClick();
        persAccPage.registerButtonClick();
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("")
    public void successfulRegistration() {
        register.fillRegForm("Vasya","VVV678@yandex.ru","56983892");
    }

    @Test
    @DisplayName("")
    @Description("")
    public void registrationWithIncorrectPassword() {
        register.wrongRegistration("Vasya","VVV678@yandex.ru","111");
        Assert.assertTrue(register.isErrorMessageDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
