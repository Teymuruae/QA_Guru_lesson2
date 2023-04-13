import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DemoQaTest {

    private SelenideElement firstNameField = $("#firstName");
    private SelenideElement lastNameField = $("#lastName");
    private SelenideElement emailField = $("#userEmail");

    private SelenideElement genderMaleRadio = $(Selectors.byTagAndText("label", "Male"));
    private SelenideElement phoneNumberField = $("#userNumber");
    private SelenideElement birthDateField = $("#dateOfBirthInput");
    private SelenideElement month = $(".react-datepicker__month-select");
    private SelenideElement year = $(".react-datepicker__year-select");
    private SelenideElement day = $x("//div[@role = 'option' and text() = 20]");
    private SelenideElement subject = $("#subjectsInput");
    private SelenideElement textArea = $("#currentAddress");
    private SelenideElement state = $("#state");
    private SelenideElement cityButton = $("#city");
//    private SelenideElement stateHarnaya = $("#react-select-3-option-2");
    private SelenideElement stateHarnaya = $(Selectors.byTagAndText("div", "Haryana"));
    private SelenideElement hobbyCheckBox = $x("//label[text() = 'Sports']");
//    private SelenideElement city = $("#react-select-4-option-1");
    private SelenideElement city = $(Selectors.byTagAndText("div", "Karnal"));
    private SelenideElement submitButton = $("#submit");
    private SelenideElement uploadPictureButton = $("#uploadPicture");
    private SelenideElement textToWaitForOnPage = $("h5");
    private SelenideElement textToWaitForAfterSubmit = $(".modal-title");
    private SelenideElement modalDialog = $(".modal-dialog.modal-lg");
    private SelenideElement modalBody = $(".modal-body");

    @BeforeEach
    public void setUp() {
        Configuration.browser = "fireFox";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void fillFormTest() {
       textToWaitForOnPage.shouldHave(Condition.text("Student Registration Form"));
        firstNameField.setValue("Ivan");
        lastNameField.setValue("Ivanov");
        emailField.setValue("IvIvan@test.ru");
        phoneNumberField.setValue("88005553535");
        birthDateField.click();
        month.selectOption("September");
        year.selectOption("2005");
        day.click();
        subject.setValue("English").pressEnter();
        textArea.setValue("test address");
        state.click();
        stateHarnaya.click();
        cityButton.click();
        city.click();
        hobbyCheckBox.click();
        genderMaleRadio.parent().click();
        uploadPictureButton.uploadFile(new File("src/test/resources/img/test.png"));
        submitButton.click();

        modalDialog.should(Condition.appear);
        textToWaitForAfterSubmit.shouldHave(Condition.text("Thanks for submitting the form"));
        modalBody.shouldHave(Condition.text("Ivan"),Condition.text("Ivanov"),Condition.text("IvIvan@test.ru"),
                Condition.text("8800555353"), Condition.text("September"), Condition.text("2005"),
                 Condition.text("English"),Condition.text("Sports"), Condition.text("test.png"),
                Condition.text("Haryana Karnal"), Condition.text("test address"));

    }



}
