package tasks.task3.pagesAndActions;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ChoicePageDemoQA {
    SelenideElement row = $x(".//div[@class='row']");
    public void performMenuClick(String chapter){
        SelenideElement chapterElement  = $x(String.format(".//div[@class='header-text' and text()='%s']", chapter));
        chapterElement.click();
    }
    public void performSubMenuClick( String subChapter){
        SelenideElement subChapterElement = $x(String.format(".//ancestor::div[2]//span[text()='%s']", subChapter));
        subChapterElement.scrollIntoView(true);
        subChapterElement.click();
    }


}
