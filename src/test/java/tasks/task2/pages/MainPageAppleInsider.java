package tasks.task2.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class MainPageAppleInsider {

    public ElementsCollection primaryMenuHeaders = $$x(".//ul[@id='menu-primary']//li[contains(@class, 'menu-item-type-taxonomy')]");
}
