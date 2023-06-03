package pages;

import com.codeborne.selenide.Selectors;
import pages.components.CalendarComponent;
import pages.components.ModalComponent;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private CalendarComponent calendarComponent;
    private ModalComponent modalComponent;
    public RegistrationPage() {
        open("/");
        modalComponent = new ModalComponent();
        calendarComponent = new CalendarComponent();
    }

    public RegistrationPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        $("[value='{SUBSTRING}']".replace("{SUBSTRING}", gender)).parent().click();
        return this;
    }

    public  RegistrationPage setNumberMobile(String number) {
        $("#userNumber").setValue(number);
        return this;
    }

    public RegistrationPage setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setMonth(month);
        calendarComponent.setYear(year);
        calendarComponent.setDay(day);
        return this;
    }

    public RegistrationPage setSubjects(String subjects) {
        $("#subjectsContainer input").setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage selectHobbies(String hobbies) {
        $(Selectors.byText(hobbies)).closest("div").click();
        return this;
    }

    public RegistrationPage upLoadFile(String path) {
        $("#uploadPicture").uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    public RegistrationPage selectState(String state) {
        $("#state").click();
        $("#stateCity-wrapper").$(Selectors.byText(state)).click();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(Selectors.byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        $("#submit").click();
        return this;
    }

    public RegistrationPage verificationResultModal(String studentName, String email, String gender,
                                                    String date, String subjects, String hobbies, String pictures,
                                                    String address, String stateCity, String mobile) {
        modalComponent.verificationModal();
        Map<String, String> result = new HashMap<>();
        {
              result.put("Student Name", studentName);
              result.put("Student Email", email);
              result.put("Gender",gender);
              result.put("Mobile", mobile);
              result.put("Date of Birth", date);
              result.put("Subjects", subjects);
              result.put("Hobbies", hobbies);
              result.put("Picture", pictures);
              result.put("Address", address);
              result.put("State and City", stateCity);
        }
        for (String key:result.keySet()) {
            modalComponent.verificationResult(key, result.get(key));
        }
        return this;
    }



}
