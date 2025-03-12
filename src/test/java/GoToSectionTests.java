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

public class GoToSectionTests {
    private static final String URL = "https://stellarburgers.nomoreparties.site/";
    WebDriver driver = new ChromeDriver();

    MainPage mainPage = new MainPage(driver);
    PersonalAccountPage persAccPage = new PersonalAccountPage(driver);

    @Before
    public void before() {
        driver.get(URL);
    }

    @Test
    @DisplayName("переход по клику на «Личный кабинет».")
    @Description("")
    public void goToPersonalAccount() {
        mainPage.personalAccountClick();
        Assert.assertTrue(persAccPage.isPageDisplayed());
    }

    @Test
    @DisplayName("переход по клику на «Конструктор»")
    @Description("")
    public void goToConstructor() {
        mainPage.personalAccountClick();
        Assert.assertTrue(mainPage.isConstructorDisplayed());
    }

    @Test
    @DisplayName("переход по клику и на логотип Stellar Burgers")
    @Description("")
    public void goToLogo() {
        mainPage.personalAccountClick();
        Assert.assertTrue(mainPage.isLogoWork());
    }

    @Test
    @DisplayName("переходы к разделу «Булки»")
    @Description("")
    public void goToBuns() {
        mainPage.fillingClick();
        Assert.assertTrue(mainPage.isBunsElementDisplayed());
    }

    @Test
    @DisplayName("переходы к разделу «Соусы»")
    @Description("")
    public void goToSauce() {
        mainPage.fillingClick();
        Assert.assertTrue(mainPage.isSauceElementDisplayed());
    }

    @Test
    @DisplayName("переходы к разделу «Начинки»")
    @Description("")
    public void goToFilling() {
        mainPage.fillingClick();
        Assert.assertTrue(mainPage.isFillingElementDisplayed());
    }

    @After
    public void after() {
        driver.quit();
    }
}
