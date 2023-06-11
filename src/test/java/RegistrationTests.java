import data.RegistrationTestsData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@Tag("UI")
public class RegistrationTests extends BaseTest{
    @Feature("Форма регистрации")
    @Story("Заполнение формы регистрации")
    @Owner("Александр Соловьев")
    @DisplayName("Проверка заполения формы регистрации")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value ="Form", url = "https://demoqa.com/automation-practice-form")
    @Test
    public void checkStudentRegistrationForm() {
        RegistrationTestsData data = new RegistrationTestsData();

        new RegistrationPage()
                .setFirstName(data.getFirstName())
                .setLastName(data.getLastName())
                .setEmail(data.getEmail())
                .setNumberMobile(data.getNumberMobile())
                .selectGender(data.getGender())
                .setSubjects(data.getSubjects())
                .setDate(data.getDay(), data.getMonth(), data.getYear())
                .selectHobbies(data.getHobbies())
                .upLoadFile(data.getPath())
                .setCurrentAddress(data.getCurrentAddress())
                .selectState(data.getState())
                .selectCity(data.getCity())
                .clickSubmit()
                .verificationResultModal(data.getFirstName() + " " + data.getLastName(), data.getEmail(),
                        data.getGender(), data.getDay() + " " + data.getMonth() + "," + data.getYear(),
                        data.getSubjects(), data.getHobbies(), data.getNamePictures(), data.getCurrentAddress(),
                        data.getState()  + " " + data.getCity(), data.getNumberMobile());

    }



}
