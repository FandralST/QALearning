package tasks.task3;

import Core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task3.pagesAndActions.ChoicePageDemoQA;
import tasks.task3.pagesAndActions.MainPageDemoQA;
import tasks.task3.pagesAndActions.WebTablesDemoQA;

import static org.assertj.core.api.Assertions.assertThat;


public class TasksDropDownLists extends BaseTest {
    MainPageDemoQA mainPageDemoQA = new MainPageDemoQA();
    ChoicePageDemoQA choicePageDemoQA = new ChoicePageDemoQA();
    WebTablesDemoQA webTablesDemoQA = new WebTablesDemoQA();
    DropDownLists dropDownLists = new DropDownLists();

    @BeforeEach
    void precondition() {
        mainPageDemoQA.widgetsHeader.click();
        choicePageDemoQA.performSubMenuClick("Select Menu");
        dropDownLists.checkHeader("Select Menu");
    }//IT'S WORKING

    @Test
    void taskDropDownList_SelectValue() {
        dropDownLists.performDropDownListClick("withOptGroup");
        dropDownLists.checkValue("Group 2, option 2");
        dropDownLists.clickValue("Group 2, option 2");
        dropDownLists.checkSelectedValue("Group 2, option 2");
        System.out.println(1);
    }

    @Test
    void taskDropDownList_MultiSelect() {
        dropDownLists.performMultiSelectListClick("Select...");
        dropDownLists.checkValueMultiSelect("Blue");
        dropDownLists.clickValueMultiSelect("Green");
        dropDownLists.clickValueMultiSelect("Blue");
        dropDownLists.checkSelectedValueMultiSelect("Green");
        dropDownLists.checkSelectedValueMultiSelect("Blue");
        dropDownLists.deleteValueMultiSelect("Green");
        dropDownLists.deleteValueMultiSelect("Blue");
        dropDownLists.selectFourValues("Blue", "Green", "Red", "Black");//через лист
        dropDownLists.checkFourValues();
        System.out.println(1);
    }
}