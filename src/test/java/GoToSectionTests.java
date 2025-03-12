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
    WebDriver driver;

    MainPage mainPage;
    PersonalAccountPage persAccPage;

    @Before
    public void before() {
        //System.setProperty("webdriver.chrome.driver","C:\\Program Files\\WebDriver\\bin\\yandexdriver-win64\\yandexdriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        persAccPage = new PersonalAccountPage(driver);
        driver.get(URL);
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет».")
    @Description("При клике на кнопку Личный кабинет происходит переход в ЛК")
    public void goToPersonalAccount() {
        mainPage.personalAccountClick();
        Assert.assertTrue(persAccPage.isPageDisplayed());
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    @Description("При нажатии на кнопку Конструктор происходит переход к конструктору бургеров")
    public void goToConstructor() {
        mainPage.personalAccountClick();
        Assert.assertTrue(mainPage.isConstructorDisplayed());
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers")
    @Description("При нажатии на логотип происходит переход на главную страницу")
    public void goToLogo() {
        mainPage.personalAccountClick();
        Assert.assertTrue(mainPage.isLogoWork());
    }

    @Test
    @DisplayName("Переход к разделу «Булки»")
    @Description("При нажатии на раздел «Булки» отображаются доступные булочки")
    public void goToBuns() {
        mainPage.fillingClick();
        Assert.assertTrue(mainPage.isBunsElementDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    @Description("При нажатии на раздел «Соусы» отображаются доступные соусы")
    public void goToSauce() {
        mainPage.fillingClick();
        Assert.assertTrue(mainPage.isSauceElementDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    @Description("При нажатии на раздел «Начинки» отображаются доступные начинки")
    public void goToFilling() {
        mainPage.fillingClick();
        Assert.assertTrue(mainPage.isFillingElementDisplayed());
    }

    @After
    public void after() {
        driver.quit();
    }
}
