import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "none";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
//        Configuration.holdBrowserOpen = true;
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
