package tasks.task1.steps;

import tasks.task1.pages.FilterSearchPage;
import tasks.task1.pages.MainPage;
import tasks.task1.pages.SearchResultPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class HhSteps{
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    FilterSearchPage filterSearchPage = new FilterSearchPage();

    public void findVacancies(String vacancy){
        /*mainPage.wishPopUp.click();
        mainPage.geoPopUp.click();*/
        mainPage.searchInput.should(visible).sendKeys(vacancy);
        mainPage.searchButton.click();
        searchResultPage.filterButton.should(visible, Duration.ofSeconds(5)).click();
        filterSearchPage.textFilterInput.sendKeys("150000");
        filterSearchPage.textFilterInput.should(visible, Duration.ofSeconds(5)).pressEnter();

    }
}
