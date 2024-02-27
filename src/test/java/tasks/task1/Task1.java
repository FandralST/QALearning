package tasks.task1;

import Core.BaseSelenideTest;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import tasks.task1.pages.SearchResultPage;
import tasks.task1.steps.HhSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1 extends BaseSelenideTest {

    public HhSteps hhSteps = new HhSteps();
    SearchResultPage searchResultPage = new SearchResultPage();

    @Test
    void task1(){
        hhSteps.findVacancies("QA ENGINEER");
        assertThat(searchResultPage.mapButton.should(Condition.visible).isDisplayed()).isTrue();
    }
}
