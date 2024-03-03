package tasks.task3;

import Core.BaseTest;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task3.pagesAndActions.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskSpreadsheet extends BaseTest {

    MainPageDemoQA mainPageDemoQA = new MainPageDemoQA();
    StepsSpreadsheet stepsSpreadsheet = new StepsSpreadsheet();
    ChoicePageDemoQA choicePageDemoQA = new ChoicePageDemoQA();
    WebTablesDemoQA webTablesDemoQA = new WebTablesDemoQA();
    Faker faker = new Faker();
    String firstName;

    @BeforeEach
    void precondition(){
        firstName =  faker.name().firstName();
        mainPageDemoQA.elementsHeader.click();
        choicePageDemoQA.performSubMenuClick("Web Tables");
        assertThat(webTablesDemoQA.webTablesMainTable.should(Condition.visible).isDisplayed()).isTrue();
    }

    @Test
    void taskSpreadsheet_AddRow() {
        stepsSpreadsheet.addRow();
        webTablesDemoQA.checkIsDisplayed(firstName);
    }

    @Test
    void taskSpreadsheet_DeleteRow() {
        stepsSpreadsheet.addRow();
        webTablesDemoQA.clickDeleteRow(firstName);
        webTablesDemoQA.checkIsNotDisplayed(firstName);
    }

    @Test
    void taskSpreadsheet_EditRow() {
        stepsSpreadsheet.addRow();
        stepsSpreadsheet.editRow(firstName);
        webTablesDemoQA.checkIsNotDisplayed(firstName);
    }

}