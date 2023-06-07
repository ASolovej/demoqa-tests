import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "none";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
//        Configuration.holdBrowserOpen = true;
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
