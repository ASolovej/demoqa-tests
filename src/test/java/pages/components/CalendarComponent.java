package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setMonth(String month) {
        $(".react-datepicker__month-select").selectOption(month);
    }

    public  void setYear(String year) {
        $(".react-datepicker__year-select").selectOption(year);
    }

    public void setDay(String day) {
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month").click();
    }

}
