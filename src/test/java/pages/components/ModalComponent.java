package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;

public class ModalComponent {

    public void verificationModal() {
        $(".modal-dialog.modal-lg").should(Condition.appear);
    }

    public void verificationResult(String key, String value) {
        $(".table-responsive").$(Selectors.byText(key)).parent()
                .shouldHave(Condition.text(value));
    }

}
