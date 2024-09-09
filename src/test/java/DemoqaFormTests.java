import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaFormTests {

    @BeforeAll
    static void setUP() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterAll
    static void setDown() {
        WebDriverRunner.closeWindow();
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Mihail");
        $("#lastName").setValue("Zubenko");
        $("#userEmail").setValue("mafia@sobaka.ru");
        $("#userNumber").setValue("8999665533");
        $("#genterWrapper").find(".custom-control-label").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").find("option[value='6']").click();
        $(".react-datepicker__year-select").find("option[value='1995']").click();
        $(".react-datepicker__week").find(".react-datepicker__day--025").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFromClasspath("images/avva.jpg");
        $("#currentAddress").setValue("Vladimirskiy Central 12/3");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Mihail Zubenko"));
        $(".table-responsive").shouldHave(text("mafia@sobaka.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8999665533"));
        $(".table-responsive").shouldHave(text("25 June,1995"));
        $(".table-responsive").shouldHave(text("Arts"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("avva.jpg"));
        $(".table-responsive").shouldHave(text("Vladimirskiy Central 12/3"));
        $(".table-responsive").shouldHave(text("NCR Gurgaon"));
    }
}
