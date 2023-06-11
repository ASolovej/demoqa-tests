package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.ModalComponent;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private CalendarComponent calendarComponent;

    public RegistrationPage() {
//        open("/");
        open("https://demoqa.com/automation-practice-form");
        $("footer").should(Condition.visible, Duration.ofSeconds(5));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        calendarComponent = new CalendarComponent();
    }

    @Step("Ввести в поле First Name {firstName}")
    public RegistrationPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    @Step("Ввести в поле Last Name {lastName}")
    public RegistrationPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    @Step("Ввести Email {email}")
    public RegistrationPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    @Step("Выбрать пол {gender}")
    public RegistrationPage selectGender(String gender) {
        $("[value='{SUBSTRING}']".replace("{SUBSTRING}", gender)).parent().click();
        return this;
    }

    @Step("Ввести номер телефона {number}")
    public  RegistrationPage setNumberMobile(String number) {
        $("#userNumber").setValue(number);
        return this;
    }

    @Step("Установить дату {day}.{month}.{year}")
    public RegistrationPage setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setMonth(month);
        calendarComponent.setYear(year);
        calendarComponent.setDay(day);
        return this;
    }

    @Step("Ввести в поле Subjects {subjects}")
    public RegistrationPage setSubjects(String subjects) {
        $("#subjectsContainer input").setValue(subjects).pressEnter();
        return this;
    }

    @Step("Выбрать хобби {hobbies}")
    public RegistrationPage selectHobbies(String hobbies) {
        $(Selectors.byText(hobbies)).closest("div").click();
        return this;
    }

    @Step("Загрузить фалй {path}")
    public RegistrationPage upLoadFile(String path) {
        $("#uploadPicture").uploadFromClasspath(path);
        return this;
    }

    @Step("Ввести в поле Current Address {currentAddress}")
    public RegistrationPage setCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    @Step("Выбрать State {state}")
    public RegistrationPage selectState(String state) {
        $("#state").click();
        $("#stateCity-wrapper").$(Selectors.byText(state)).click();
        return this;
    }

    @Step("Выбрать City {city}")
    public RegistrationPage selectCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(Selectors.byText(city)).click();
        return this;
    }

    @Step("Нажать кнопку Submit")
    public ModalComponent clickSubmit() {
        $("#submit").click();
        return new ModalComponent();
    }


}
