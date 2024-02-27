package tasks.task1;

import Core.BaseSelenideTest;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import tasks.task1.steps.HhSteps;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$$x;



public class Task1_1 extends BaseSelenideTest {

    public HhSteps hhSteps = new HhSteps();

    ElementsCollection vacancyList = $$x(".//some_xpath");

    public Task1_1() throws IOException {
    }

    @Test
    void task1_1(){
        Selenide.refresh();
        System.out.println("HELLO");
    }

    /*
    Задание 2.
    1.Выполнить поиск вакансий по названию "Qa engineer".
    2.Вывести в консоль названия всех вакансий на открывшейся странице
     */

    /*
    Задание 3.
    1.Выполнить поиск вакансий по названию "Qa engineer".
    2.Открыть окно фильтра
    3.В фильтре выбрать зп 150000р, "только с указанным уровнем дохода"
    4.Вывести в консоль названия всех вакансий на открывшейся странице
     */

}
