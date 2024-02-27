package tasks.task3.pagesAndActions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class WebTablesDemoQA {
    public SelenideElement webTablesMainTable = $x(".//div[@class='rt-table']");
    public SelenideElement webTablesAdd = $x(".//button[@id='addNewRecordButton']");
    public SelenideElement webTablesRegistrationForm = $x(".//div[@id='registration-form-modal']");
    public SelenideElement submitButton = $x(".//button[@id='submit']");

    public void clickDeleteRow(String firstName) {
        SelenideElement row = $x(".//div[@class='rt-td' and text()='" + firstName + "']/ancestor::div[1]");
        row.$x(".//span[@title='Delete']").click();
    }

    public void clickEditRow(String firstName){
        SelenideElement row = $x(".//div[@class='rt-td' and text()='" + firstName + "']/ancestor::div[1]");
        row.$x(".//span[@title='Edit']").click();
    }

    public void checkIsDisplayed(String firstName) {
        SelenideElement tableAgeField = $x(".//div[@class='rt-td' and text()='" + firstName + "']");
        assertThat(tableAgeField.should(Condition.visible).isDisplayed()).isTrue();
    }

    public void checkIsNotDisplayed(String firstName) {
        SelenideElement tableAgeField = $x(".//div[@class='rt-td' and text()='" + firstName + "']");
        assertThat(tableAgeField.shouldNot(Condition.visible).isDisplayed()).isFalse();
    }
    //clickEditRecord
}
