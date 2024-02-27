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
    String firstName = faker.name().firstName();


    public void addRow() {
        webTablesDemoQA.webTablesAdd.click();
        assertThat(webTablesDemoQA.webTablesRegistrationForm.should(Condition.visible).isDisplayed()).isTrue();
        fieldsAndButtonsDemoQA.inputFirstNameField.sendKeys(firstName);
        fieldsAndButtonsDemoQA.inputLastNameField.sendKeys(faker.name().lastName());
        fieldsAndButtonsDemoQA.inputMailField.sendKeys(faker.internet().emailAddress());
        fieldsAndButtonsDemoQA.inputAgeField.sendKeys(String.valueOf(faker.number().numberBetween(25, 50)));
        fieldsAndButtonsDemoQA.inputSalaryField.sendKeys(String.valueOf(faker.number().numberBetween(10000, 65000)));
        fieldsAndButtonsDemoQA.inputDepartmentField.sendKeys("Legal");
        webTablesDemoQA.submitButton.click();
    }

    public void editRow(String firstName) {
        String anotherFirstName = faker.name().firstName();
        webTablesDemoQA.clickEditRow(firstName);
        fieldsAndButtonsDemoQA.inputFirstNameField.clear();
        fieldsAndButtonsDemoQA.inputFirstNameField.sendKeys(anotherFirstName);
        webTablesDemoQA.submitButton.click();
    }


}
