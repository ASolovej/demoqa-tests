package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;
import pages.RegistrationPage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class ModalComponent {

    @Step("Проверить появление модального окна")
    public void verificationModal() {
        $(".modal-dialog.modal-lg").should(Condition.appear);
    }

    @Step("Проверить, что в поле {key} введено {value}")
    public void verificationResult(String key, String value) {
        $(".table-responsive").$(Selectors.byText(key)).parent()
                .shouldHave(Condition.text(value));
    }

    public void verificationResultModal(String studentName, String email, String gender,
                                                    String date, String subjects, String hobbies, String pictures,
                                                    String address, String stateCity, String mobile) {
        verificationModal();
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
            verificationResult(key, result.get(key));
        }
    }

}
