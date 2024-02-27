package tasks.task3;

import Core.BaseSelenideTest;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task3.pagesAndActions.ChoicePageDemoQA;
import tasks.task3.pagesAndActions.MainPageDemoQA;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;


public class TasksCalendar extends BaseSelenideTest {
    MainPageDemoQA mainPageDemoQA = new MainPageDemoQA();
    Calendar calendar = new Calendar();
    ChoicePageDemoQA choicePageDemoQA = new ChoicePageDemoQA();

    @BeforeEach
    void precondition() {
        mainPageDemoQA.widgetsHeader.click();
        choicePageDemoQA.performSubMenuClick( "Date Picker");
        assertThat(calendar.getSelectDateField("Select Date").should(Condition.visible).isDisplayed()).isTrue();
    }

    @Test
    void taskCalendar_selectDate() {
        int days = 59;
        LocalDate dateMinusNDays = LocalDate.now().minusDays(days);
        calendar.selectDate("Select Date", dateMinusNDays);
        calendar.checkSelectDate("Select Date", dateMinusNDays);
    }

    @Test
    void taskCalendar_dateAndTime() {
        int months = 65;
        LocalDateTime dateMinusNMonths = LocalDateTime.now().minusMonths(months);
        calendar.dateAndTime("Date And Time", dateMinusNMonths);
        calendar.checkDateAndTime("Date And Time", dateMinusNMonths);
        System.out.println(1);
    }

    @Test
    public void testDummy() {

    }
}

