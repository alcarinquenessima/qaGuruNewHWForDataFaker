package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class TestBox extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void fillFormTest() {
        registrationPage.openPage()
                        .setName("Ivan")
                        .setSurname("Ivanov")
                        .setEmail("ivanIvanov@gmail.com")
                        .setGender("Other")
                        .setNumber("8999888998")
                        .setDate("2", "August", "2000")
                        .setSubject("Chemistry")
                        .setHobbies("Reading")
                        .uploadPicture()
                        .setAddress("Russia")
                        .setState("Haryana")
                        .setCity("Karnal")
                        .submitInfo()
                        .checkResults ();
    }
}
