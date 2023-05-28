import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests extends BaseTest{

    @Test
    public void checkStudentRegistrationForm() {
        String firstName = "Alexandr";
        String lastName = "Solovyov";
        String email = "alex@gmail.com";
        String gender = "Male";
        String numberMobile = "8920458145";
        String subjects = "Math";
        String hobbies = "Sports";
        String currentAddress = "Olimp 12";
        String path = "C:\\Users\\Professional\\Pictures";
        String state = "NCR";
        String city = "Delhi";
        String day = "28";
        String month = "April";
        String year = "2020";
        String namePictures = path.split("\\\\")[path.split("\\\\").length-1];

        new RegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setNumberMobile(numberMobile)
                .selectGender(gender)
                .setSubjects(subjects)
                .setDate(day, month, year)
                .selectHobbies(hobbies).upLoadFile(path)
                .setCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .clickSubmit()
                .verificationResultModal(firstName + " " + lastName, email, gender,
                        day + " " + month + "," + year, subjects, hobbies, namePictures,
                        currentAddress, state  + " " + city, numberMobile);

    }



}
