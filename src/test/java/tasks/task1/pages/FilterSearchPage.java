package tasks.task1.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FilterSearchPage {
    public SelenideElement textFilterInput = $x(".//input[@data-qa='advanced-search-salary']");
    public SelenideElement filterFindButton = $x(".//button[@data-qa='advanced-search-submit-button']");
}
