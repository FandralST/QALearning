package tasks.task3;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import tasks.task3.pagesAndActions.FieldsAndButtonsDemoQA;
import tasks.task3.pagesAndActions.WebTablesDemoQA;

import static org.assertj.core.api.Assertions.assertThat;

public class StepsSpreadsheet {
    WebTablesDemoQA webTablesDemoQA = new WebTablesDemoQA();
    FieldsAndButtonsDemoQA fieldsAndButtonsDemoQA = new FieldsAndButtonsDemoQA();
    Faker faker = new Faker();

    public void addRow(String firstName) {
        webTablesDemoQA.webTablesAdd.click();
        assertThat(webTablesDemoQA.webTablesRegistrationForm.should(Condition.visible).isDisplayed()).isTrue();
        fieldsAndButtonsDemoQA.inputValueByElementName("First Name", firstName);
        fieldsAndButtonsDemoQA.inputValueByElementName("Last Name", faker.name().lastName());
        fieldsAndButtonsDemoQA.inputValueByElementName("name@example.com", faker.internet().emailAddress());
        fieldsAndButtonsDemoQA.inputValueByElementName("Age", String.valueOf(faker.number().numberBetween(25, 50)));
        fieldsAndButtonsDemoQA.inputValueByElementName("Salary", String.valueOf(faker.number().numberBetween(10000, 65000)));
        fieldsAndButtonsDemoQA.inputValueByElementName("Department", "Legal");
        webTablesDemoQA.submitButton.click();
    }

    public void editRow(String firstName) {
        String anotherFirstName = faker.name().firstName();
        webTablesDemoQA.clickEditRow(firstName);
        fieldsAndButtonsDemoQA.inputValueByElementName("First Name", anotherFirstName);
        webTablesDemoQA.submitButton.click();
    }


}
