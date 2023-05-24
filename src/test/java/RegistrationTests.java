import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "none";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.holdBrowserOpen = true;
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void checkStudentRegistrationForm() {
        String firstName = "Alexandr";
        String lastName = "Solovyov";
        String email = "alex@gmail.com";
        String gender = "Male";
        String numberMobile = "89204581458";
        String subjects = "Math";
        String hobbies = "Sports";
        String currentAddress = "Olimp 12";

        open("/");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
//        $("[value='{SUBSTRING}']".replace("{SUBSTRING}", gender)).closest("div").click();
        $("[value='{SUBSTRING}']".replace("{SUBSTRING}", gender)).parent().click();
        $("#userNumber").setValue(numberMobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("2020");
        $(".react-datepicker__day--015:not(react-datepicker__day--outside-month)").click();
        $("#subjectsContainer input").setValue(subjects).pressEnter();
        $(Selectors.byText(hobbies)).closest("div").click();
        $("#uploadPicture").uploadFile(new File("C:\\Users\\Professional\\Pictures"));
//        $("#uploadPicture").uploadFromClasspath("src/test/resources/img/prosvet11_prob.bmp");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(Selectors.byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(Selectors.byText("Delhi")).click();
        $("#submit").click();
        $(".modal-dialog.modal-lg").should(Condition.appear);
        $(".modal-dialog.modal-lg").shouldHave(Condition.text(firstName), Condition.text(lastName), Condition.text(email));

    }



}
