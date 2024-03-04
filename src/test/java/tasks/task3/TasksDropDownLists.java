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
        mainPageDemoQA.clickOnWidget("Widgets");
        choicePageDemoQA.performSubMenuClick("Select Menu");
        dropDownLists.checkHeader("Select Menu");
    }//IT'S WORKING

    @Test
    void taskDropDownList_SelectValue() {
        dropDownLists.performDropDownListClick("Select Option", "withOptGroup");
        dropDownLists.checkValue("Select Option","Group 2, option 2");
        dropDownLists.clickValue("Select Option","Group 2, option 2");
        dropDownLists.checkSelectedValue("Select Option","Group 2, option 2");
        System.out.println(1);
    }

    @Test
    void taskDropDownList_MultiSelect() {
        dropDownLists.performMultiSelectListClick("Select...","Select...");
        dropDownLists.checkValueMultiSelect("Select...","Blue");
        dropDownLists.clickValueMultiSelect("Select...","Green");
        dropDownLists.clickValueMultiSelect("Select...","Blue");
        dropDownLists.checkSelectedValueMultiSelect("Select...","Green");
        dropDownLists.checkSelectedValueMultiSelect("Select...","Blue");
        dropDownLists.deleteValueMultiSelect("Select...","Green");
        dropDownLists.deleteValueMultiSelect("Select...","Blue");
        dropDownLists.selectFourValues("Select...","Blue", "Green", "Red", "Black");//через лист
        dropDownLists.checkFourValues();
        System.out.println(1);
    }
}