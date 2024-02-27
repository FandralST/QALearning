package tasks.task1.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement wishPopUp = $x(".//div[@class='bloko-notification__close-button']");
    public SelenideElement geoPopUp = $x(".//div[@class='bloko-icon bloko-icon_initial-gray-80']");
    public SelenideElement searchInput = $x(".//input[@id='a11y-search-input']");

    public SelenideElement searchButton = $x(".//span[@class='supernova-search-submit-text']");

}