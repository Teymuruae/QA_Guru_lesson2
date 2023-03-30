import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DemoQaTest {

    private SelenideElement firstNameField = $("#firstName");
    private SelenideElement lastNameField = $(By.id("lastName"));
    private SelenideElement emailField = $(By.id("userEmail"));
    private SelenideElement genderMaleRadio = $(By.id("gender-radio-1"));
    private SelenideElement phoneNumberField = $x("//input[@id = 'userNumber']");

    private SelenideElement birthDateField = $(By.id("dateOfBirthInput"));
    private SelenideElement month = $x("//select[@class = 'react-datepicker__month-select']");
    private SelenideElement year = $x("//select[@class = 'react-datepicker__year-select']");
    private SelenideElement day = $x("//div[@role = 'option' and text() = 20]");
    private SelenideElement subject = $(By.id("subjectsInput"));
    private SelenideElement textArea = $x("//textarea");
    private SelenideElement state = $(By.id("state"));
    private SelenideElement city = $(By.id("city"));
    private SelenideElement stateHarnaya = $(By.id("react-select-3-option-2"));

    @BeforeEach
    public void setUp() {
        Configuration.browser = "fireFox";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void fillFormTest() {
        firstNameField.setValue("Ivan");
        lastNameField.setValue("Ivanov");
        emailField.setValue("IvIvan@test.ru");
        phoneNumberField.setValue("8-800-555-35-35");
        birthDateField.click();
        month.selectOption("September");
        year.selectOption("2005");
        day.click();
        subject.setValue("English").pressEnter();
        textArea.setValue("test address");
        state.click();
        stateHarnaya.click();
        city.click();
        $(By.id("react-select-4-option-1")).click();
//        genderMaleRadio.click();
    }

}