package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;

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

}
