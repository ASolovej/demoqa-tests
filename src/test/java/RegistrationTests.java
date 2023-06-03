import data.RegistrationTestsData;
import org.junit.jupiter.api.RepeatedTest;
import pages.RegistrationPage;

public class RegistrationTests extends BaseTest{
    @RepeatedTest(200)
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
