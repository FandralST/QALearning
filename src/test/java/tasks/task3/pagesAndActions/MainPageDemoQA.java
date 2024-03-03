package tasks.task3.pagesAndActions;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPageDemoQA {
    public  SelenideElement bookStoreApplicationHeader = $x(".//h5[text()='Book Store Application']");
    public  SelenideElement elementsHeader = $x(".//h5[text()='Elements']");
    public  SelenideElement widgetsHeader = $x(".//h5[text()='Widgets']");
    //TODO: Перейти в проекте на использование этого метода
    public void clickOnWidget(String widgetName){
       $x( String.format(".//h5[text()='%s']",widgetName))
               .should(visible, Duration.ofSeconds(15))
               .click();
    }
}
