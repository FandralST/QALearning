package tasks.task1.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultPage {
    public SelenideElement mapButton = $x(".//span[@class='bloko-button__icon bloko-button__icon_left']");
    public SelenideElement filterButton = $x(".//a[@class='bloko-button bloko-button_icon-only']");
}
