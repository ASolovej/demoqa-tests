package data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

public class RegistrationTestsData {
    private Faker faker = new Faker();
    private String[] date = randomDate();

    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String email = faker.internet().emailAddress();
    private String gender = randomValue("Male", "Female", "Other");
    private String numberMobile = faker.number().digits(10);
    private String subjects = randomValue("Math", "Chemistry", "Physics", "Computer Science", "English", "History");
    private String hobbies = randomValue("Sports", "Reading", "Music");
    private String currentAddress = faker.address().fullAddress();
    private String path ="img/prosvet11_prob.bmp";
    private String state = randomValue("NCR", "Haryana", "Rajasthan", "Uttar Pradesh");
    private String city = randomCity();
    private String day = date[0];
    private String month = date[1];
    private String year = date[2];
    private String namePictures = path.split("/")[1];

    private String randomValue(String ...value) {
        return faker.options().option(value);
    }

    private String[] randomDate() {
        LocalDate date = faker.date().birthday().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        return date.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy", Locale.ENGLISH)).split("/");



    }

    private String randomCity() {
        if (state.equals("NCR")) return randomValue("Delhi", "Gurgaon", "Noida");
        if (state.equals("Uttar Pradesh")) return randomValue("Agra", "Lucknow", "Merrut");
        if (state.equals("Rajasthan")) return randomValue("Jaipur", "Jaiselmer");
        if (state.equals("Haryana")) return randomValue("Karnal", "Panipat");
        else throw new RuntimeException("Cities not found");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getNumberMobile() {
        return numberMobile;
    }

    public String getSubjects() {
        return subjects;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getPath() {
        return path;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getNamePictures() {
        return namePictures;
    }
}
