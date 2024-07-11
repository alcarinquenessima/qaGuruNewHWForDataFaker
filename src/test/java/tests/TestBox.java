package tests;

import java.io.File;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBox {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.pageLoadTimeout = 6000000;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test

    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanIvanov@gmail.com");
        $("label[for = 'gender-radio-1']").click();
        $("#userNumber").setValue("89991112233");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("2010")).click();
        $(".react-datepicker__month-select").$(byText("August")).click();
        $(".react-datepicker__day--010").click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/mushroom.jpg"));

        $("#subjectsInput").setValue("Chem").pressEnter();
        $( "label[for = 'hobbies-checkbox-2']").click();


        $("#currentAddress").setValue("Russia");
        $("#stateCity-wrapper").click();
        $("#state").$(byText("Haryana")).click();

        $("#city").click();
        $("#city").$(byText("Karnal")).click();

        $("#submit").click();

        $(".table-hover").shouldHave(text ("Ivan Ivanov"));
        $(".table-hover").shouldHave(text ("ivanIvanov@gmail.com"));
        $(".table-hover").shouldHave(text ("Male"));
        $(".table-hover").shouldHave(text ("8999111223"));
        $(".table-hover").shouldHave(text ("10 August,2010"));
        $(".table-hover").shouldHave(text ("Chemistry"));
        $(".table-hover").shouldHave(text ("Reading"));
        $(".table-hover").shouldHave(text ("mushroom.jpg"));
        $(".table-hover").shouldHave(text ("Russia"));
        $(".table-hover").shouldHave(text ("Haryana Karnal"));



    }
}